package view;

import java.awt.*;
import java.awt.event.*;
import static helper.Constants.*;


public class MainView {
	private Frame mainFrame;
 	private Panel controlPanel;
 	private Button viewAllBtn;
 	
 	public MainView() {
 		mainFrame = new Frame("MVC Example");
 		controlPanel = new Panel(new FlowLayout());
 		viewAllBtn = new Button("View all Customers");
 	}
 	
	public void viewMainFrame(){
    	mainFrame.setSize(MAIN_VIEW_WIDTH,MAIN_VIEW_HEIGHT);
    	mainFrame.setLayout(new GridLayout(2,3));
    	mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
               System.exit(0);
            }        
         }); 
    	Label header = new Label("Welcome!!",Label.LEFT);
    	mainFrame.add(header);
    	Font headerFont = new Font("Serif",Font.BOLD,32);
    	header.setFont(headerFont);
    	mainFrame.add(controlPanel);
    	Button addBtn = new Button("Add Customer");
    	Button getBtn = new Button("Get Customer Info");
    	addBtn.setActionCommand("Add");
    	getBtn.setActionCommand("View");
    	viewAllBtn.setActionCommand("ViewAll");
    	addBtn.addActionListener(new ButtonClickListener());
    	getBtn.addActionListener(new ButtonClickListener());
    	controlPanel.add(addBtn);
    	controlPanel.add(getBtn);
    	controlPanel.add(viewAllBtn);
    	mainFrame.setVisible(true);
	    	
	    }
	
	private class ButtonClickListener implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		String command = e.getActionCommand();
    		if (command.equals("Add")){
    			System.out.println("add new customer");
    			NewCustomerView newCustomerView = new NewCustomerView();
    			newCustomerView.showAddNewCustomerWindow();
    		}else if(command.equals("View")) {
    			System.out.println("view Customer");  
    			//showCustomerInfoWindow(controller.getCustomerInfo(id));
    		}else  if(command.equals("Close")){
    			Component comp = ((Component) e.getSource()).getParent().getParent();
    			System.out.println(comp);
    			comp.setVisible(false); 
    		}
    	}    	
    }

	public void addActionObserver(ActionListener onClick) {
		 viewAllBtn.addActionListener(onClick);
	}
	
	

}
