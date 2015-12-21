package view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import static helper.Constants.*;


public class MainView {
	private JFrame mainFrame;
 	private JPanel controlPanel;
 	private JButton viewAllBtn;
 	private JButton addNewCustomerBtn;
 	private JButton getCustomerInfoBtn;
 	private JButton dbSyncBtn;
 	private JButton closeBtn;
 	
 	public MainView() {
 		mainFrame = new JFrame("MVC Example");
 		controlPanel = new JPanel();
 		viewAllBtn = new JButton();
 		addNewCustomerBtn = new JButton();
    	getCustomerInfoBtn = new JButton();
    	dbSyncBtn = new JButton();
    	closeBtn = new JButton();
    	initComponents();
 	}
 	
 	 private void initComponents() {

 		mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
               System.exit(0);
            }        
         }); 
 		  mainFrame.setTitle("MVC Example");
 		 mainFrame.setMaximumSize(new Dimension(1000, 600));
         mainFrame.setMinimumSize(new Dimension(400,400));

         addNewCustomerBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); 
         addNewCustomerBtn.setText("Add Customer");
         //Action listener

         getCustomerInfoBtn.setFont(new java.awt.Font("Tahoma", 1, 14));
         getCustomerInfoBtn.setText("Get Customer Info");

         viewAllBtn.setFont(new java.awt.Font("Tahoma", 1, 14));
         viewAllBtn.setText("View all customers");

         dbSyncBtn.setText("Sync with DB");
        //action listener

         closeBtn.setText("Close");

         GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
         controlPanel.setLayout(controlPanelLayout);
         controlPanelLayout.setHorizontalGroup(
             controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlPanelLayout.createSequentialGroup()
                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                 .addComponent(dbSyncBtn)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addComponent(closeBtn)
                 .addGap(26, 26, 26))
             .addGroup(controlPanelLayout.createSequentialGroup()
                 .addGap(86, 86, 86)
                 .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addComponent(addNewCustomerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     .addComponent(getCustomerInfoBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                     .addComponent(viewAllBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                 .addContainerGap(94, Short.MAX_VALUE))
         );
         controlPanelLayout.setVerticalGroup(
             controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(controlPanelLayout.createSequentialGroup()
                 .addGap(30, 30, 30)
                 .addComponent(addNewCustomerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addComponent(getCustomerInfoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addComponent(viewAllBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                 .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(dbSyncBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addGap(25, 25, 25))
         );

         JLabel header = new JLabel("Welcome!!");
         header.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); 
         mainFrame.add(header);
  

         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(mainFrame.getContentPane());
         mainFrame.getContentPane().setLayout(layout);
         layout.setHorizontalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addComponent(controlPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
             .addGroup(layout.createSequentialGroup()
                 .addContainerGap()
                 .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                 .addContainerGap())
         );
         layout.setVerticalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                 .addContainerGap()
                 .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
         );
         
     	addNewCustomerBtn.setActionCommand("Add");
    	getCustomerInfoBtn.setActionCommand("View");
    	viewAllBtn.setActionCommand("ViewAll");
    	dbSyncBtn.setActionCommand("Sync");
    	closeBtn.setActionCommand("Close");
    	mainFrame.add(controlPanel);
    	controlPanel.add(addNewCustomerBtn);
    	controlPanel.add(getCustomerInfoBtn);
    	controlPanel.add(viewAllBtn);
    	controlPanel.add(dbSyncBtn);
    	controlPanel.add(closeBtn);

     }
 	
	public void viewMainFrame(){
    	
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
