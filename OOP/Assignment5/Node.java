package socialnetwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Node {
	
	
	public void createNode() {// user add
		List<String> nodeDetails = new ArrayList<String>();
		Entity profileObject = null;
		Scanner scannerObject = new Scanner(System.in);
		System.out.print("Enter Profile type (1. Individual\n2. Organisation)");
		int profileType = scannerObject.nextInt();
		if(profileType == 1) {
			profileObject = new Person();
		}
		else if(profileType == 2) {
			profileObject = new Organisation();
		}
		takeDetails(profileObject);
	}
	
	/*starting of function to take input of user detail */
	private Entity takeDetails(Entity profileObject){
		boolean emailAlreadyExist = false;
		String email;
		Scanner scannerObject = new Scanner(System.in);
		System.out.print("Enter Your Name: ");
		String name = scannerObject.nextLine();
		profileObject.setName(name);
		do{
			System.out.print("Enter Your Email");
			email = scannerObject.nextLine();
			emailAlreadyExist = isAlreadyExist(email);
			if(emailAlreadyExist){
				System.out.println("Email Already Exist! Try Another Email ID!!");
			}
		}while(emailAlreadyExist);
		profileObject.setEmail(email);
		System.out.print("Enter Your Interests");
		String interest = scannerObject.nextLine();
		profileObject.setInterest(interest);
		
		if(profileObject instanceof Person) {
			System.out.print("Enter Your Hobbies");
			String hobbies = scannerObject.nextLine();
			System.out.print("Your Gender");
			String gender = scannerObject.nextLine();
			System.out.print("Enter Your Age");
			int age = scannerObject.nextInt();
		}
		if(profileObject instanceof Organisation) {
			System.out.print("Enter Your Domain");
			String domain = scannerObject.nextLine();
			System.out.print("Enter Course Offered");
			String course = scannerObject.nextLine();
			System.out.print("Your organisation is working Since? ");
			int age = scannerObject.nextInt();
		}
		return profileObject;
	}
	/*end of function to take input of user detail */
//	delete node user delete

	private boolean isAlreadyExist(String email) {
		
		return false;
	}
	
}
