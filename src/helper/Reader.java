package helper;

import static helper.Constants.DB_FILE_NAME;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import model.Customer;

public class Reader {

	private String dbString;

	public Reader() {
		dbString = "";
	}

	public HashMap<String, Customer> retrieveDBCopy() {
		String line = null;
		HashMap<String, Customer> customersList = new HashMap<String, Customer>();
		dbString = "";
		try {
			FileReader fileReader = new FileReader(DB_FILE_NAME);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while ((line = bufferedReader.readLine()) != null) {
				dbString += line;
				System.out.println(line);
				String[] customers = line.split("&");
				for (String customer : customers) {
					String[] customerInfo = customer.split(";");
					// id;firstName;lastName;
					Customer customerModel = new Customer(customerInfo[0],
							customerInfo[1], customerInfo[2]);
					customersList.put(customerModel.getId(), customerModel);
				}
			}
			bufferedReader.close();

		} catch (FileNotFoundException ex) {
			System.out.println("unable to open file");

		} catch (IOException e) {
			System.out.println("Error reading file");
			e.printStackTrace();
		}
		return customersList;
	}

	public String getdbString() {
		return dbString;
	}

}
