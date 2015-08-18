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
 * This class will handle all cars
 */
public class Car 
{
	static String COMMA_DELIMITER = ",";
	static String url = "C:/Project/Car.csv";
	static List<String> car = new ArrayList<String>();
	public static List<String> readCsvFile() throws IOException 
	{
		BufferedReader fileReader = null;
		try 
		{
			String line = "";
			fileReader = new BufferedReader(new FileReader(url));//file reading
			fileReader.readLine();
			while ((line = fileReader.readLine()) != null)
			{
				String[] tokens = line.split(COMMA_DELIMITER);//separator
				if (tokens.length > 0) 
				{
					car.add(tokens[0] + tokens[1]);//Adding to the list
				}
			}
		} 
		catch (FileNotFoundException exception) 
		{
			exception.printStackTrace();
		} catch (IOException exception) 
		{
			exception.printStackTrace();
		}
		finally 
		{
			fileReader.close();
		}
		return car;
	}
}