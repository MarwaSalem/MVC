package helper;

import static helper.Constants.DB_FILE_NAME;

import java.io.*;
import java.util.HashMap;

import model.*;

public class Reader {
	
	public HashMap<String,CustomerModel> retrieveDBCopy (){
		String line = null; 
		HashMap<String,CustomerModel>customersList = new HashMap<String, CustomerModel>();
		try{
			FileReader fileReader = new FileReader(DB_FILE_NAME);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while((line = bufferedReader.readLine()) != null){
				System.out.println(line);
				String[] customers =line.split("&");
				for (String customer : customers){
					String [] customerInfo = customer.split(";");
					//id;firstName;lastName;
					CustomerModel customerModel = new CustomerModel(customerInfo[0],
							customerInfo[1], customerInfo[2]);
					customersList.put(customerModel.getId(), customerModel);
				}
			}
			bufferedReader.close();
			
		}catch(FileNotFoundException ex){
			System.out.println("unable to open file");
			
		} catch (IOException e) {
			System.out.println("Error reading file");
			e.printStackTrace();
		}
		return customersList;
	}
	
}
