package helper;

import static helper.Constants.DB_FILE_NAME;

import java.io.*;

public class Writer {
	
	
	public void writeToDB(){
		try {
			FileWriter fileWriter = new FileWriter(DB_FILE_NAME);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write("Hello There");
			bufferedWriter.write(" here is some text.");
            bufferedWriter.newLine();
            bufferedWriter.write("We are writing");
            bufferedWriter.write(" the text to the file.");
            
            bufferedWriter.close();
		} catch (IOException e) {
			System.out.println("Error writing to a file !");
			e.printStackTrace();
		}
		
	}
	
	

}
