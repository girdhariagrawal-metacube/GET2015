/**
 * @author Girdhari
 * Implement the scenario of Train Reservation System
 * Class Payment it will handle payment related task if payment is successful then seat will be reduced 
 */
package trainreservation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Payment {

	void checkout(TrainDetail trainNumber, int totalSeats) throws IOException{
		BufferedReader bufferReaderObj = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Your Name: ");
		String name = bufferReaderObj.readLine();
		System.out.println("Enter mode of payment: ");
		System.out.println("1 for Credit Card");
		System.out.println("2 for Wallet");
		System.out.println("3 for Net Banking");
		try{
			int paymentChoice = Integer.parseInt(bufferReaderObj.readLine());
			if(paymentChoice == 1 ){
				payByCreditCard(name, trainNumber, totalSeats);
			}
			else if(paymentChoice == 2){
				payByWallet(name, trainNumber, totalSeats);
			}
			else if(paymentChoice == 3){
				payByNetBanking(name, trainNumber, totalSeats);
			}
		}
		catch(NumberFormatException exception){
			exception.printStackTrace();
		}
	}
	
	void payByCreditCard(String name, TrainDetail trainDetail , int totalSeats){
		Scanner scanObject = new Scanner(System.in);
		System.out.print("Enter Your Card Number: ");
		String cardNumber = scanObject.nextLine();
		System.out.print("Enter CVV Number: ");
		String cvvNumber = scanObject.nextLine();
		ticketOutput("Hii "+name+" your payment through card number "+cardNumber+" has been received.", trainDetail, totalSeats);
	}
	
	void payByWallet(String name, TrainDetail trainDetail, int totalSeats){
		ticketOutput("Hii "+name+" your payment through E-Wallet has been received.", trainDetail, totalSeats);
	}
	
	void payByNetBanking(String name, TrainDetail trainDetail, int totalSeats){
		Scanner scanObject = new Scanner(System.in);
		System.out.print("Enter Bank Name: ");
		String bankName = scanObject.nextLine();
		System.out.print("Enter User Name: ");
		String userName = scanObject.nextLine();
		System.out.print("Enter Password: ");
		String passwd = scanObject.nextLine();
		ticketOutput("Hii "+name+" your payment through NetBanking's Username "+userName+" has been received.", 
						trainDetail, totalSeats);
		scanObject.close();
	}
	
	void ticketOutput(String userDetail, TrainDetail trainDetail, int totalSeats){
		System.out.println(userDetail);
		System.out.println("Train Number: "+trainDetail.getTrainNumber());
		System.out.println("Train Name: "+trainDetail.getTrainName());
		System.out.println("Source: "+trainDetail.getSource());
		System.out.println("Destination: "+trainDetail.getDestination());
		System.out.println("Total Reservation Quantity: "+totalSeats);
		
	}
}
