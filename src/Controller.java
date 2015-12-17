
public class Controller {
	
	 private  Model model;
	 private View view;
	
	public Controller(Model model , View view){
		this.model = model;
		this.view = view;
		this.view.controllerCall(this);
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
	 		
}
