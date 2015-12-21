package view;

import java.awt.*;
import java.awt.event.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import model.*;
import static helper.Constants.*;

public class AllCustomersView {
	
	private Frame allCustomersInfoFrame;
	private Button closeBtn;
	
	public AllCustomersView (){
		allCustomersInfoFrame = new Frame();
		closeBtn = new Button("Close");
	}
	
	public void showEmptyDBWindow(){
    	allCustomersInfoFrame.setSize(EMPTY_DB_VIEW_WIDTH,EMPTY_DB_VIEW_HEIGHT);
    	allCustomersInfoFrame.setLayout(new FlowLayout());
    	allCustomersInfoFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
               allCustomersInfoFrame.setVisible(false);
               allCustomersInfoFrame.dispose();
            }        
         }); 
    	Panel viewPanel = new Panel(new FlowLayout());
    	allCustomersInfoFrame.add(viewPanel);
    	Label title = new Label("DB is empty !!",Label.CENTER);
    	title.setFont(new Font("Serif", Font.BOLD, 32));
    	viewPanel.add(title);
    	closeBtn.setActionCommand("Close");
    	viewPanel.add(closeBtn);
    	allCustomersInfoFrame.setVisible(true);
    }
	
    public void  showAllCustomersWindow (HashMap<String, CustomerModel> customersList){
    	allCustomersInfoFrame.setSize(ALL_CUSTOMERS_VIEW_WIDTH,ALL_CUSTOMERS_VIEW_HEIGHT);
    	allCustomersInfoFrame.setLayout(new GridLayout(5, 2));
    	allCustomersInfoFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
               allCustomersInfoFrame.setVisible(false);
               allCustomersInfoFrame.dispose();
            }        
         }); 
		Collection<CustomerModel> c = customersList.values();
		Iterator<CustomerModel> itr = c.iterator();
		while (itr.hasNext()) {
			CustomerModel customer = itr.next();
			addCustomerPanel(customer);
		}
		Panel closeBtnPanel = new Panel(new FlowLayout());
		allCustomersInfoFrame.add(closeBtnPanel);
		closeBtn.setActionCommand("Close");
    	closeBtnPanel.add(closeBtn);
    	allCustomersInfoFrame.setVisible(true);
    	
    }
    
    public void addCustomerPanel(CustomerModel customer){
    	Panel viewPanel = new Panel(new FlowLayout());
    	allCustomersInfoFrame.add(viewPanel);
    	Label title = new Label("Customer #" + customer.getId());
    	title.setFont(new Font("Serif", Font.BOLD, 20));
    	viewPanel.add(title);
		Label firstName = new Label("First name", Label.LEFT);
    	Label lastName = new Label("Last name", Label.LEFT);
    	Label id = new Label("Id",Label.LEFT);
    	TextField cFirstName = new TextField(customer.getFirstName(),34);
    	TextField cLastName = new TextField(customer.getLastName(),34);
    	TextField cId = new TextField(customer.getId(),20);
    	cFirstName.setEditable(false);
    	cLastName.setEditable(false);
    	cId.setEditable(false);
    	viewPanel.add(id);
    	viewPanel.add(cId);
    	viewPanel.add(firstName);
    	viewPanel.add(cFirstName);
    	viewPanel.add(lastName);
    	viewPanel.add(cLastName);
    	
    }
    
    public void addActionObserver(ActionListener onClick) {
		 closeBtn.addActionListener(onClick);
	}
    
    
	

}
