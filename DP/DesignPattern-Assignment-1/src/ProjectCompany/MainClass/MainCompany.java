/**
 * @author Girdhari
 * MainCompany class
 */
package ProjectCompany.MainClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import ProjectCompany.Factory.DeveloperFactory;
import ProjectCompany.Factory.TesterFactory;
import ProjectCompany.Model.Company;
import ProjectCompany.Model.Engineer;
import ProjectCompany.Model.EngineerType;

/* Starting of MainCompany class */
public class MainCompany {

	/* Starting of main function */
	public static void main(String[] args) {
		Engineer engineer1 = null;
		String name;
		String proceed;
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(System.in));
		int choice;
		do {
			System.out.println("Enter Name:");
			name = readString(bufferedReader);
			System.out.println("Enter role : 1 for Developer and 2 for Tester");
			do {
				try {
					choice = Integer.parseInt(bufferedReader.readLine().trim());
				} catch (NumberFormatException e) {
					System.out.println("Please Enter numeric digit only!!");
					continue;
				} catch (IOException e) {
					System.out.println("Error Occured please input again");
					continue;
				}
				if (choice == 1 || choice == 2) {
					break;
				}
				System.out.println("Please Enter 1 and 2 only");
			} while (true);

			if (choice == 1) {
				DeveloperFactory developerFactory = DeveloperFactory
						.getInstance();
				engineer1 = developerFactory.createEngineerFactory(name,
						EngineerType.DEVELOPER);
			} else {
				TesterFactory testerFactory = TesterFactory.getInstance();
				engineer1 = testerFactory.createEngineerFactory(name,
						EngineerType.TESTER);
			}

			Company.getInstance().addEngineer(engineer1);

			System.out
					.println("Press Y or y for Continue add Engineer or exit for any other key");
			proceed = readString(bufferedReader);
			if (proceed.startsWith("Y") || proceed.startsWith("y"))
				continue;

			break;
		} while (true);
		List<Engineer> EngineerList = Company.getListOfEngineers();
		for (Engineer engineer : EngineerList) {
			System.out.println(engineer);
		}

	}
	/* Ending of main function */
	
	/* Starting of readString function */
	public static String readString(BufferedReader bufferedReader) {
		String name = "";
		boolean status = true;
		do {
			try {
				name = bufferedReader.readLine().trim();
			} catch (IOException io) {
				System.out.println("Error Occured Please input again");
				continue;
			}
			if (name.equals("")) {
				continue;
			}
			char[] array = name.toCharArray();
			for (char ch : array) {
				if ((!Character.isLetter(ch)) && !(ch == ' ')) {
					System.out.println("Enter a Valid Name");
					status = false;
					break;
				}
			}
			if (!status) {
				status = true;
				continue;
			}
			break;
		} while (true);
		return name;
	}
	/* Ending of readString function */
}
/* Ending of MainCompany class */