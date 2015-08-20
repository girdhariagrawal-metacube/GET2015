/**
 * @author Girdhari
 * Implement the scenario of Train Reservation System
 * Class UserInterface will provide all the method related to user interaction
 */

package trainreservation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
/*Starting of UserInterface class*/
public class UserInterface {

	/*Starting of main function*/
	public static void main(String args[]) throws IOException {
		Payment paymentObj = new Payment();							//Object of Payment class
		UserInterface classObj = new UserInterface();				//object of current class
		BufferedReader bufferReaderObj = new BufferedReader(new InputStreamReader(System.in));// Reading input from keyboard
		List<TrainDetail> trainList = null;							//List of TrainDetail class objects
		int trainType = 1;
		List<TrainDetail> filteredTrainList=null;
		List<TrainDetail> filteredTrainListNew=null;
		Train trainObj = new Train();								//Object of train class
		boolean flag = false;
		String source = "";
		String destination = "";
		System.out.print("Enter Your name: ");
		try {
			String passengerName = bufferReaderObj.readLine();// read passenger																// name
			
			do {

				System.out.print("Enter Train Type:(1 for Passenger, 2 for Goods) ");	
				try {
					trainType = Integer.parseInt(bufferReaderObj.readLine());		//read for choice of train type
				} catch (NumberFormatException nf) {
					System.out.println("You have entered a wrong choice: ");
					continue;
				} catch (IOException io) {
					System.out.println("Error occured please enter again");
					continue;
				}
				if (trainType == 1 || trainType == 2)
					flag = true;
				else {
					System.out.println("You have entered a wrong choice: ");
					continue;
				}

			} while (!flag);

			if (flag) {
				trainList = trainObj.listTrain(trainType);
				classObj.printTrainList(trainList);
			}

			System.out.print("Enter Source station: ");
			source = bufferReaderObj.readLine();				//enter source station

			System.out.print("Enter destination station: ");
			destination = bufferReaderObj.readLine();			//enter destination station
		} catch (NumberFormatException exception) {
			System.out.println("You have entered a wrong choice: ");
			System.exit(1);
		} catch (IOException io) {
			System.out.println("You have entered a wrong choice: ");
			System.exit(1);
		}
		 filteredTrainList = trainObj.filterList(source, destination);
		classObj.printTrainList(filteredTrainList);
		
		boolean repeat = true;
		int seats;
		 do{
			 System.out.print("Enter Train Number: ");
			 String trainNumber = bufferReaderObj.readLine();				//enter train number
			 int trainExist=classObj.isTrainExist(filteredTrainList, trainNumber);
			 if(trainExist  == -1){
				 System.out.println("Wrong Train Number");
				 System.out.println("System will Halt Now....");
				 System.exit(1);
			 }
			 
			 else if(trainType == 1){
				 System.out.print("Enter total number of Passengers: ");
			 }
			 else{
				 System.out.print("Enter total weight: ");
			 }
			 seats = Integer.parseInt(bufferReaderObj.readLine());			//enter total number of passenger
			 filteredTrainListNew=filteredTrainList;
			 if(Integer.parseInt( filteredTrainListNew.get(trainExist).getSeatAvailable()) >= seats){
				 paymentObj.checkout( filteredTrainListNew.get(trainExist), seats);
				 repeat = false;
			 }
			 else{
				 filteredTrainList= trainObj.filterList(filteredTrainListNew,seats);
				 classObj.printTrainList(filteredTrainList);
				 repeat = true;
			 }
		 	}while(repeat);
	}
	/*End of main function*/
	/* Start of isTrainExist function */
 	public final int isTrainExist(List<TrainDetail>trainListCheck, String trainNumber) {	//check if selected train exist or not
 		for (int counter = 0; counter < trainListCheck.size(); counter++) {			//if not exist then return -1
 																					//otherwise return index
 			if (Integer.parseInt(trainListCheck.get(counter).getTrainNumber()) == Integer.parseInt(trainNumber)){
 				return counter;
 			}
 		}
 		return -1;
	 }
	/* End of isTrainExist function */

	/* Start of print train list function*/
	void printTrainList(List<TrainDetail> trainList) {		//print train list in a format
//		
		System.out.println("Train Number\tTrain Name\t\t\tTrain Type\tSource\t\tDestination\tDuration\tSeat Available");
		for (int rows = 0; rows < trainList.size(); rows++) {
			TrainDetail tempTrainList = trainList.get(rows);
			System.out.print(tempTrainList.getTrainNumber() + "\t\t");
			System.out.print(tempTrainList.getTrainName() + "\t\t");
			System.out.print(tempTrainList.getTypeTrain() + "\t\t");
			System.out.print(tempTrainList.getSource() + "\t");
			System.out.print(tempTrainList.getDestination() + "\t\t");
			System.out.print(tempTrainList.getDuration() + "\t\t\t");
			System.out.println(tempTrainList.getSeatAvailable());
			
		}
	}
	/* End of print train list function */
}
/*End of UserInterface class*/
