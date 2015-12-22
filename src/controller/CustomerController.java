package controller;

import static helper.Constants.EMPTY_ID_WARNING_MESSAGE;
import static helper.Constants.EXISTING_ID_WARNING_MESSAGE;
import static helper.Constants.NEW_ENTRY_SEPARATOR;
import helper.Reader;
import helper.Writer;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import model.Customer;
import view.AllCustomersView;
import view.MainView;
import view.NewCustomerView;
import view.warningMessageView;

public class CustomerController {
	private MainView mainView;
	private NewCustomerView newCustomerView;
	private AllCustomersView allCustomersView;
	private Reader reader;
	private Writer writer;
	private HashMap<String, Customer> customersList;
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

	public void addNewCustomer() {
		Customer customer = newCustomerView.getCustomer();
		String id = customer.getId();
		if (customersList.containsKey(id)) {
			warningMessageView.showErrorMessage(EXISTING_ID_WARNING_MESSAGE);
		} else {
			customersList.put(customer.getId(), customer);
			newCustomerView.onSubmit();
			System.out.println("Submit new Customer Data:" + customer);
		}
		addToDBEntryList(customer);
	}

	public void addToDBEntryList(Customer customer) {
		dbNewEntries += NEW_ENTRY_SEPARATOR + customer.getId() + ";"
				+ customer.getFirstName() + ";" + customer.getLastName() + ";";
	}

	public String getCustomerInfo(String id) {
		Customer customer = customersList.get(id);
		return customer.getId() + ";" + customer.getFirstName() + ";"
				+ customer.getLastName() + ";";
	}

	public String getAllCustomersInfo() {
		String customers = "";
		Collection<Customer> c = customersList.values();
		Iterator<Customer> itr = c.iterator();
		while (itr.hasNext()) {
			Customer customer = (Customer) itr.next();
			customers += customer.getCustomer() + "&";
		}

		System.out.println(customers);
		return customers;
	}

	private void viewAllCustomers() {
		if (customersList.isEmpty()) {
			allCustomersView.showEmptyDBWindow();
		} else {
			allCustomersView.showAllCustomersWindow(customersList);
		}
	}

	private void submitNewCustomer() {
		if (newCustomerView.verify()) {
			addNewCustomer();
		} else {
			warningMessageView.showErrorMessage(EMPTY_ID_WARNING_MESSAGE);
		}
	}

	private void syncWithDB() {
		String updatedDBEntries = reader.getdbString() + dbNewEntries;
		writer.writeToDB(updatedDBEntries);
		customersList = reader.retrieveDBCopy();
	}

	private void closeCurrentWindow(Component component) {
		JFrame frame = (JFrame) SwingUtilities.getRoot(component);
		frame.setVisible(false);
		frame.dispose();
	}

	public class ButtonClickListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			switch (command) {
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
				// showCustomerInfoWindow(controller.getCustomerInfo(id));
				break;
			case "Sync":
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
