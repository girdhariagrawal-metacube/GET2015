package ServiceStation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author Girdhari
 * Program to implement scenario of car service station
 * This class will handle everything about Service Station 
 */
/* Starting of ServiceStation class*/
public class ServiceStation extends Persons
{  
	/* Starting of main function */
	public static void main(String args[])
	{
		int suv = 0, hatchback = 0, sedan = 0;
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap = Call();
		for (Map.Entry<String, String> map : hashMap.entrySet())
		{
			// System.out.println(m.getKey()+" "+m.getValue());
			if (map.getValue().equalsIgnoreCase("SUV")) // check for number of cars
			{
				suv++;
			} 
			else if (map.getValue().equalsIgnoreCase("Sedan")) //check for number of sedan
			{
				sedan++;
			} 
			else if (map.getValue().equalsIgnoreCase("hatchback"))//check for no of hatchback
			{
				hatchback++;
			}
		}
		System.out.println("\tTotal number of car Serviced");// printing of hashMap
		System.out.println("SUV = " + suv);
		System.out.println("Sedan = " + sedan);
		System.out.println("hatchback = " + hatchback);
		long totalEarning = suv * 5000 + sedan * 3000 + hatchback * 2000;
		System.out.println("Total Earning = " + totalEarning);

	}
	/*End of main function */
	
	/* Starting of Call method */
	public static HashMap<String, String> Call()
	{
		HashMap<String, String> hm = new HashMap<String, String>();
		List<String> carList = new ArrayList<String>();
		String COMMA_DELIMITER = " ";// separation based on this
		try
		{
			mechanic = ServiceStation.readCsvFilePersons();
			carList = Car.readCsvFile();
			String[] registrationnumber = new String[carList.size()];
			String[] cartype = new String[carList.size()];
			String[] carName = new String[mechanic.size()];
			String[] carTypeService = new String[mechanic.size()];
			String[] rate = new String[mechanic.size()];

			for (int counter = 0; counter < carList.size(); counter++) 
			{
				String[] tokens = carList.get(counter).split(COMMA_DELIMITER);// Initializing the value to the string array
				if (tokens.length > 0) {
					registrationnumber[counter] = tokens[0];
					cartype[counter] = tokens[1];
				}
			}
			for (int counter = 0; counter < mechanic.size(); counter++) 
			{
				String[] tokens = mechanic.get(counter).split(COMMA_DELIMITER);// Initializing the value to the string array
				if (tokens.length > 0) {
					carName[counter] = tokens[0];
					carTypeService[counter] = tokens[2];
					rate[counter] = tokens[3];

				}
			}

			int count = 0;
			for (int loopCount = 0; loopCount < car.size(); loopCount++) //Mapping car to mechanic
			{
				for (int machenicCounter = 0; machenicCounter < mechanic.size(); machenicCounter++)
				{

					if (cartype[loopCount].equalsIgnoreCase(carTypeService[machenicCounter]) && (count <= car.size()))
					{
						hm.put(carName[machenicCounter], cartype[loopCount]);
						carTypeService[machenicCounter] = " ";
						count++;
						break;
					}
				}
			}
		} 
		catch (IOException exception) 
		{
			exception.printStackTrace();
		}
		return hm;
	}
	/* End of call method */
}
/*End of ServiceStation class*/
