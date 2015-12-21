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
	public static  NewCustomerView newCustomerView;
	private AllCustomersView allCustomersView;
	private Reader reader;
	private Writer writer;
	private HashMap<String, CustomerModel> customersList;

	public CustomerController() {
		mainView = new MainView();
		newCustomerView = new NewCustomerView();
		allCustomersView = new AllCustomersView();
		reader = new Reader();
		writer = new Writer();
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

	public class ButtonClickListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			System.out.println("Button clicked: " + command);
			if (command.equals("ViewAll")) {
				System.out.println("view all customers");
				if (customersList.isEmpty()) {
					allCustomersView.showEmptyDBWindow();
				} else {
					allCustomersView.showAllCustomersWindow(customersList);
				}
			} else if (command.equals("Submit")) {
				String customer = newCustomerView.getDataEntries();
				addNewCustomer(customer);
				System.out.println("Submit new Customer Data:" + customer);
				newCustomerView.onSubmit();
			}else if (command.equals("Add")){
    			System.out.println("add new customer");
    			newCustomerView.showAddNewCustomerWindow();
    		}else if(command.equals("View")) {
    			System.out.println("view Customer");  
    			//showCustomerInfoWindow(controller.getCustomerInfo(id));
    		}else  if(command.equals("Close")){
    			Component comp = ((Component) e.getSource()).getParent().getParent();
    			System.out.println(comp);
    			comp.setVisible(false); 
    		}
		}
	}

}
