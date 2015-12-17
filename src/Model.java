import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;


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
	
	public String getAllCustomers(){
		String customers="";
		Collection<Customer> c = Customers.values();
		Iterator<Customer> itr = c.iterator();
		while(itr.hasNext()){
			 Customer customer = (Customer) itr.next();
			  customers += customer.getCustomer()+"&" ;
		}
	
		System.out.println(customers);
		return customers;
		
	}
		
}
