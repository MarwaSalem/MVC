package model;

public class Customer {

	private String firstName;
	private String lastName;
	private String id;

	public Customer(String id) {
		this.id = id;
	}

	public Customer(String id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCustomer() {
		return id + ";" + firstName + ";" + lastName + ";";
	}

}
