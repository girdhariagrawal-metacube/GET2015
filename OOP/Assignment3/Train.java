/**
 * @author Girdhari
 * Implement the scenario of Train Reservation System
 * Class Train will provide all the method related to train list 
 */
package trainreservation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Train {
	
	private BufferedReader bufferReaderObj;
	List<TrainDetail> trainList = new ArrayList<TrainDetail>();
	List<String> trainListSingleRow = new ArrayList<String>();
	final String TRAIN_LIST_FILE = new File("src/trainList.csv").getAbsolutePath();// will contain the address of file that contain list of train
	final String STRING_DELIMITER = ",";
	private List<TrainDetail> filteredTrainList;
	
	/*starting of listTrain method*/
	/*This method will list up all the train according to their type i.e. Passenger or Goods*/
	public List<TrainDetail> listTrain(int type) throws IOException{
		String temp = "";
		
		try{
			bufferReaderObj = new BufferedReader(new FileReader(TRAIN_LIST_FILE));
			while((temp = bufferReaderObj.readLine()) != null){
				String trainData[] = temp.split(STRING_DELIMITER);
				insertDetails(trainData, type);
			}
		}
		catch(FileNotFoundException exception){
			exception.printStackTrace();
		}
		catch(IOException exception){
			exception.printStackTrace();
		}
		catch(Exception exception){
			System.out.print("Unhandled Error Occured!!");
		}
		return trainList;
	}
	/*End of listTrain method*/

	/*Starting of filterList function According to start and end*/
	List<TrainDetail> filterList(List<TrainDetail>trainList, String source, String destination){
		List<TrainDetail> filteredTrainList = new ArrayList<TrainDetail>();
		for(int counter=0 ; counter < trainList.size() ; counter++){
			TrainDetail tempTrainDetail = trainList.get(counter);
			if(tempTrainDetail.getSource().equalsIgnoreCase(source) && tempTrainDetail.getDestination().equalsIgnoreCase(destination)){
				filteredTrainList.add(tempTrainDetail);
			}
		}
		return filteredTrainList;
		
	}
	/*End of filterList function (According to start and end)  */
	
	/*Starting of filterList function According to availability of seat */
	List<TrainDetail> filterList(List<TrainDetail> trainList, int numberOfSeat){
		filteredTrainList = new ArrayList<TrainDetail>();
		for(int counter=0 ; counter < trainList.size() ; counter++){
			if(Integer.parseInt(trainList.get(counter).getSeatAvailable()) > numberOfSeat){
				filteredTrainList.add(trainList.get(counter));
			}
		}
		return filteredTrainList;
		
	}
	/*End of filterList function (According to availability of seat) */
	/* Starting of insertDetails function */
	public  void	insertDetails(String input[],int trainType) //Will insert train details
	{
		int index = 0;
		String typeOTrain="P";
		TrainDetail trainDetail = null; 
		if(trainType==2)
			typeOTrain="G";//means goods  train
		if(input[2].equalsIgnoreCase(typeOTrain))
		{
			trainDetail = new TrainDetail();
			trainDetail.setTrainNumber(input[index++]); // set train number
			trainDetail.setTrainName(input[index++]); // set train name
			trainDetail.setTypeTrain(input[index++]); // set train type
			trainDetail.setSource(input[index++]); // set train source
			trainDetail.setDestination(input[index++]); // set train destination
			trainDetail.setDuration(input[index++]); // set train duration
			trainDetail.setSeatAvailable(input[index]); // set train seat availability
		}
		if (trainDetail != null)
			trainList.add(trainDetail);
		
	}
	/*End of insertDetails function*/
}
/* End of Train class */
