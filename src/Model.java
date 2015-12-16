import java.util.HashMap;


public class Model {
	
	private HashMap <String, Customer> Customers;
	
	public Model (){
		Customers = new HashMap <String, Customer>();
	}
	
	public void addCustomer(Customer customer){
		Customers.put(customer.getId() , customer);
	}
	
	public Customer getCustomer(String id){
		return Customers.get(id);
	}
	
	public HashMap <String, Customer> getAllCustomers(){
		return Customers;
		
	}
	
	
}
