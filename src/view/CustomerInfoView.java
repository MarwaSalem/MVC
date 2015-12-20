package view;

import java.awt.*;
import java.awt.event.*;

public class CustomerInfoView {
	private Frame customerInfoFrame;
	private Button closeBtn;

    public void showCustomerInfoWindow (String customer){
    	String [] customerProperties = customer.split(";");
    	customerInfoFrame = new Frame(customerProperties[0]);
    	customerInfoFrame.setSize(600, 400);
    	customerInfoFrame.setLayout(new GridLayout(5, 2));
    	customerInfoFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
               customerInfoFrame.setVisible(false);
               customerInfoFrame.dispose();
            }        
         }); 
    	Panel viewPanel = new Panel(new FlowLayout(0,10, 10));
    	customerInfoFrame.add(viewPanel);
    	Label firstName = new Label("First name", Label.LEFT);
    	Label lastName = new Label("Last name", Label.LEFT);
    	Label id = new Label("Id",Label.LEFT);
    	TextField cFirstName = new TextField(customerProperties[1],34);
    	TextField cLastName = new TextField(customerProperties[2],34);
    	TextField cId = new TextField(customerProperties[0],20);
    	cFirstName.setEditable(false);
    	cLastName.setEditable(false);
    	cId.setEditable(false);
    	closeBtn = new Button("Close");
    	closeBtn.setActionCommand("Close");
    	closeBtn.addActionListener(new ButtonClickListener());
    	viewPanel.add(id);
    	viewPanel.add(cId);
    	viewPanel.add(firstName);
    	viewPanel.add(cFirstName);
    	viewPanel.add(lastName);
    	viewPanel.add(cLastName);
    	viewPanel.add(closeBtn);
    	customerInfoFrame.setVisible(true);
 
    }
    private class ButtonClickListener implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		String command = e.getActionCommand();
    		 if(command.equals("Close")){
    			Component comp = ((Component) e.getSource()).getParent().getParent();
    			System.out.println(comp);
    			comp.setVisible(false); 
    		}
    	}    	
    }

}
