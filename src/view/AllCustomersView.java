package view;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AllCustomersView {
	
	private Frame allCustomersInfoFrame;
    public void  showAllCustomersWindow (String customers){
    	allCustomersInfoFrame = new Frame();
    	allCustomersInfoFrame.setSize(800,600);
    	allCustomersInfoFrame.setLayout(new GridLayout(5, 2));
    	allCustomersInfoFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
               allCustomersInfoFrame.setVisible(false);
               allCustomersInfoFrame.dispose();
            }        
         }); 
    	
    	String [] customersArray = customers.split("&");
    	for (String customer : customersArray){
    		Panel viewPanel = new Panel(new FlowLayout());
        	allCustomersInfoFrame.add(viewPanel);
    		String [] customerProperties = customer.split(";");
        	Label title = new Label("Customer #" + customerProperties[0]);
        	title.setFont(new Font("Serif", Font.BOLD, 20));
        	viewPanel.add(title);
    		Label firstName = new Label("First name", Label.LEFT);
        	Label lastName = new Label("Last name", Label.LEFT);
        	Label id = new Label("Id",Label.LEFT);
        	TextField cFirstName = new TextField(customerProperties[1],34);
        	TextField cLastName = new TextField(customerProperties[2],34);
        	TextField cId = new TextField(customerProperties[0],20);
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
    	//viewPanel.add(closeBtn);
    	allCustomersInfoFrame.setVisible(true);
    	
    }
    
    
	

}
