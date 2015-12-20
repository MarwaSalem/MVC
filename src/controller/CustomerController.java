package controller;

import model.*;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class CustomerController {
	 private  CustomerModel customerModel;
	 private HashMap <String, CustomerModel> customersList;
	 private  MainView mainView;
	
	public CustomerController(){
		
	}
	
	public void initCustomerController(){
		mainView = new MainView();
		mainView.addActionObserver(new ButtonClickListener());
	}
	
	 public void addNewCustomer(String customer){
		String[] properties = customer.split(";"); 
		CustomerModel  customerModel = new CustomerModel(properties[0], properties[1], properties[2]); 
		customersList.put(customerModel.getId() , customerModel);
	}
	
	 public String  getCustomerInfo (String id){
		CustomerModel customer =  customersList.get(id);
		return customer.getId()+";"+customer.getFirstName()+";"+customer.getLastName()+";";
	}
	
	 public String getAllCustomersInfo (){
		 String customers="";
			Collection<CustomerModel> c = customersList.values();
			Iterator<CustomerModel> itr = c.iterator();
			while(itr.hasNext()){
				 CustomerModel customer = (CustomerModel) itr.next();
				  customers += customer.getCustomer()+"&" ;
			}
		
			System.out.println(customers);
			return customers;
	}
	 
	 public class ButtonClickListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				String command = e.getActionCommand();
				if(command.equals("ViewAll")){
					System.out.println("view all customers");
					 String customers = getAllCustomersInfo();
					 if (customers.equals("")){
						 EmptyDBView emptyDBView = new EmptyDBView();
						 emptyDBView.showEmptyDBWindow();
					 }else{
						 AllCustomersView allCustomersView = new AllCustomersView();
						 allCustomersView.showAllCustomersWindow(customers);
					 }
				}else if(command.equals("Submit")){
					NewCustomerView newCustomerView = new NewCustomerView();
					String customer = newCustomerView.getDataEntries();
					addNewCustomer(customer);
					System.out.println("Submit new Customer Data:" + customer);
					newCustomerView.onSubmit();
				}
			}
	 }

}
