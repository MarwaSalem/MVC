package controller;

import model.*;
import view.*;
import helper.*;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class CustomerController {
	private MainView mainView;
	private  NewCustomerView newCustomerView;
	private AllCustomersView allCustomersView;
	private Reader reader;
	private Writer writer;
	private HashMap<String, CustomerModel> customersList;
	private String dbNewEntries;

	public CustomerController() {
		mainView = new MainView();
		newCustomerView = new NewCustomerView();
		allCustomersView = new AllCustomersView();
		reader = new Reader();
		writer = new Writer();
		dbNewEntries = "";
	}

	public void initCustomerController() {
		mainView.addActionObserver(new ButtonClickListener());
		newCustomerView.addActionObserver(new ButtonClickListener());
		allCustomersView.addActionObserver(new ButtonClickListener());
		customersList = reader.retrieveDBCopy();
		mainView.viewMainFrame();
	}

	public void addNewCustomer(String customer) {
		String[] properties = customer.split(";");
		CustomerModel customerModel = new CustomerModel(properties[0],
				properties[1], properties[2]);
		customersList.put(customerModel.getId(), customerModel);
	}

	public String getCustomerInfo(String id) {
		CustomerModel customer = customersList.get(id);
		return customer.getId() + ";" + customer.getFirstName() + ";"
				+ customer.getLastName() + ";";
	}

	public String getAllCustomersInfo() {
		String customers = "";
		Collection<CustomerModel> c = customersList.values();
		Iterator<CustomerModel> itr = c.iterator();
		while (itr.hasNext()) {
			CustomerModel customer = (CustomerModel) itr.next();
			customers += customer.getCustomer() + "&";
		}

		System.out.println(customers);
		return customers;
	}
	
	
	private void viewAllCustomers (){
		if (customersList.isEmpty()) {
			allCustomersView.showEmptyDBWindow();
		} else {
			allCustomersView.showAllCustomersWindow(customersList);
		}
	}
	private void submitNewCustomer(){
		// to be modified
		String customer = newCustomerView.getDataEntries();
		addNewCustomer(customer);
		dbNewEntries +=customer;
		System.out.println("Submit new Customer Data:" + customer);
		newCustomerView.onSubmit();
		
	}
	
	private void syncWithDB(){
		String updatedDBEntries = reader.getdbString() + dbNewEntries;
		writer.writeToDB(updatedDBEntries);
		customersList = reader.retrieveDBCopy();
	}
	
	private void closeCurrentWindow(Component component){
		Component parentWindow = component.getParent().getParent();
		parentWindow.setVisible(false);
	}

	public class ButtonClickListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
	        switch (command){
		        case "Add":
		        	newCustomerView.showAddNewCustomerWindow();
		        	break;
		        case "ViewAll":
		        	viewAllCustomers();
		        	break;
		        case "Submit":
		        	submitNewCustomer();
		        	break;
		        case "View":
		        	System.out.println("view Customer");  
	    			//showCustomerInfoWindow(controller.getCustomerInfo(id));
		        	break;
		        case "Sync" :
		        	syncWithDB();
		        case "Close":
		        	closeCurrentWindow((Component) e.getSource());
		        	break;
		        default:
	        		System.out.println("Invalid Buttom Click Action Command !");
	        }
		}
	}

}
