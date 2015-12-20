package view;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NewCustomerView {
	private Frame newCustomerFrame;
	private Panel entriesPanel;
	private Button submitBtn;
	
	public void showAddNewCustomerWindow (){
    	newCustomerFrame = new Frame();
    	newCustomerFrame.setSize(600, 400);
    	newCustomerFrame.setLayout(new GridLayout(5, 2));
    	newCustomerFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
               newCustomerFrame.setVisible(false);
               newCustomerFrame.dispose();
            }        
         }); 
    	
    	Label header = new Label("Please fill the following entries !", Label.LEFT);
    	header.setFont(new Font("Serif", Font.BOLD, 16));
    	newCustomerFrame.add(header);
    	entriesPanel = new Panel(new FlowLayout(0,10, 10));
    	newCustomerFrame.add(entriesPanel);
    	Label firstName = new Label("First name", Label.LEFT);
    	Label lastName = new Label("Last name", Label.LEFT);
    	Label id = new Label("Id",Label.LEFT);
    	TextField cFirstName = new TextField(34);
    	TextField cLastName = new TextField(34);
    	TextField cId = new TextField(20);
    	entriesPanel.add(id);
    	entriesPanel.add(cId);
    	entriesPanel.add(firstName);
    	entriesPanel.add(cFirstName);
    	entriesPanel.add(lastName);
    	entriesPanel.add(cLastName);
    	submitBtn =  new Button("Submit");
    	submitBtn.setBounds(newCustomerFrame.getWidth()/2-20, newCustomerFrame.getHeight()/2-10, 20, 10);
    	submitBtn.setActionCommand("Submit");
    	entriesPanel.add(submitBtn);
    	newCustomerFrame.setVisible(true);
    	  	
    }
	
	public String getDataEntries(){
		Component [] components = entriesPanel.getComponents();
		String properties="";
		for (Component comp : components){
			if (comp instanceof TextField){
				properties += ((TextField) comp).getText()+";";
			}
		}
		return properties;
   }

	public void onSubmit(){
    	newCustomerFrame.setVisible(false);
    	newCustomerFrame.dispose();
    }
	

}
