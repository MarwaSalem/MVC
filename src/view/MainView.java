package view;

import java.awt.*;
import java.awt.event.*;
import static helper.Constants.*;


public class MainView {
	private Frame mainFrame;
 	private Panel controlPanel;
 	private Button viewAllBtn;
 	private Button addNewCustomerBtn;
 	private Button getCustomerInfoBtn;
 	private Button dbSyncBtn;
 	private Button closeBtn;
 	
 	public MainView() {
 		mainFrame = new Frame("MVC Example");
 		controlPanel = new Panel(new FlowLayout());
 		viewAllBtn = new Button("View all Customers");
 		addNewCustomerBtn = new Button("Add Customer");
    	getCustomerInfoBtn = new Button("Get Customer Info");
    	dbSyncBtn = new Button("Sync with DB");
    	closeBtn = new Button("Close");
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
 
    	addNewCustomerBtn.setActionCommand("Add");
    	getCustomerInfoBtn.setActionCommand("View");
    	viewAllBtn.setActionCommand("ViewAll");
    	dbSyncBtn.setActionCommand("Sync");
    	closeBtn.setActionCommand("Close");
    	controlPanel.add(addNewCustomerBtn);
    	controlPanel.add(getCustomerInfoBtn);
    	controlPanel.add(viewAllBtn);
    	controlPanel.add(dbSyncBtn);
    	controlPanel.add(closeBtn);
    	mainFrame.setVisible(true);
	    	
	    }
	
	
	public void addActionObserver(ActionListener onClick) {
		 viewAllBtn.addActionListener(onClick);
		 addNewCustomerBtn.addActionListener(onClick);
	     getCustomerInfoBtn.addActionListener(onClick);
	     dbSyncBtn.addActionListener(onClick);
	     closeBtn.addActionListener(onClick);
	}
	
	

}
