package ServiceStation;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Girdhari
 * Program to implement scenario of car service station
 * This class will handle Persons
 */
public class Persons extends Car 
{
	
	static String COMMA_DELIMITER = ",";
	static String url = "C:/Project/Mechanic.csv";
	static List<String> mechanic = new ArrayList<String>();
	public static List<String> readCsvFilePersons() throws IOException
	{
		BufferedReader fileReader = null;
		try {
			String line = "";
			fileReader = new BufferedReader(new FileReader(url));//read from file;
			fileReader.readLine();
			while ((line = fileReader.readLine()) != null) 
			{
				String[] tokens = line.split(COMMA_DELIMITER);//Extracts the word
				if (tokens.length > 0) 
				{
					mechanic.add(tokens[0] + tokens[1] + tokens[2]);// add it to file
				}
			}
		} 
		catch (FileNotFoundException exception)
		{
			exception.printStackTrace();
		}
		catch (IOException exception) 
		{
			exception.printStackTrace();
		}
		finally 
		{
			fileReader.close();
		}
		return mechanic;

	}
}
