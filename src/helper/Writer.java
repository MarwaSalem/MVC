package helper;

import static helper.Constants.DB_FILE_NAME;

import java.io.*;

public class Writer {
	
	
	public void writeToDB(String updatedDBEntries){
		try {
			FileWriter fileWriter = new FileWriter(DB_FILE_NAME);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(updatedDBEntries);    
            bufferedWriter.close();
		} catch (IOException e) {
			System.out.println("Error writing to a file !");
			e.printStackTrace();
		}
		
	}
	
	

}
