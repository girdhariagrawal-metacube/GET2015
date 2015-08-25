package socialnetwork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

	private static final String RECORD_LIST = new File("src/records.csv").getAbsolutePath(); 
	private static final String STRING_DELIMITER = ",";
	List<Entity> getRecords()  {
		BufferedReader bufferReaderObj = new BufferedReader(new FileReader(RECORD_LIST));
		String record;
		while((record = bufferReaderObj.readLine()) != null){
			String userData[] = record.split(STRING_DELIMITER);
			
		List<Entity> recordList = new ArrayList<Entity>();
		
		while(fileObject.r)
		return recordList;
	}

}
