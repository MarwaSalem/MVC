import java.awt.Component;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller {
	
	 private  Model model;
	 private View view;
	
	public Controller(Model model , View view){
		this.model = model;
		this.view = view;
		this.view.addActionObserver(new ButtonClickListener());
	}
	
	 public void addNewCustomer(String customer){
		String[] properties = customer.split(";"); 
		model.addCustomer(new Customer(properties[0], properties[1], properties[2]));
	}
	
	 public String  getCustomerInfo (String id){
		Customer customer =  model.getCustomer(id);
		return customer.getId()+";"+customer.getFirstName()+";"+customer.getLastName()+";";
	}
	
	 public String getAllCustomersInfo (){
		return model.getAllCustomers();
	}
	 
	private class ButtonClickListener implements ActionListener{
	    	public void actionPerformed(ActionEvent e){
	    		String command = e.getActionCommand();
	    		if(command.equals("ViewAll")){
	    			System.out.println("view all customers");
	    			 String customers = getAllCustomersInfo();
	    			 if (customers.equals("")){
	    				 // show no customers found in data base
	    				 view.showEmptyDBWindow();
	    			 }else{
	    				 view.showAllCustomersWindow(customers);
	    			 }
	    		}else if(command.equals("Submit")){
	    			String customer = view.getDataEntries();
	    			addNewCustomer(customer);
	    			System.out.println("Submit new Customer Data:" + customer);
	    			view.onSubmit();
	    		}
	    	}    	
	    }
	 		
}
