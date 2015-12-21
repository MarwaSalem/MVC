package view;

import java.awt.*;
import java.awt.event.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.*;
import static helper.Constants.*;

public class AllCustomersView {
	
	private JFrame allCustomersInfoFrame;
	private JButton closeBtn;
	private JTable customersTable;
	private JScrollPane scroller;
	private DefaultTableModel model;
	
	public AllCustomersView (){
		initComponents();
	}
	                         
    private void initComponents() {
    	allCustomersInfoFrame = new JFrame();
		closeBtn = new JButton();
        scroller = new JScrollPane();
        customersTable = new JTable();
        closeBtn = new JButton("Close");
        closeBtn.setActionCommand("Close");

        allCustomersInfoFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        allCustomersInfoFrame.setPreferredSize(new Dimension(ALL_CUSTOMERS_VIEW_WIDTH,ALL_CUSTOMERS_VIEW_HEIGHT));
        allCustomersInfoFrame.setMaximumSize(new Dimension(ALL_CUSTOMERS_VIEW_WIDTH,ALL_CUSTOMERS_VIEW_HEIGHT));
        allCustomersInfoFrame.setMinimumSize(new Dimension(ALL_CUSTOMERS_VIEW_WIDTH,ALL_CUSTOMERS_VIEW_HEIGHT));

        customersTable.setFont(new Font("Tahoma", 1, 14)); 
        model = new DefaultTableModel(
                new Object [][] {
                        {}
                    },
                    new String [] {
                        "Id", "First name", "Last name"
                    }
                );
        customersTable.setModel(model);
        scroller.setViewportView(customersTable);

        JLabel title = new JLabel("Customers List");
        title.setFont(new java.awt.Font("Tahoma", 1, 14));
       
        GroupLayout layout = new GroupLayout(allCustomersInfoFrame.getContentPane());
        allCustomersInfoFrame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(title)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(closeBtn)
                    .addComponent(scroller,GroupLayout.PREFERRED_SIZE, 764,GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scroller, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addComponent(closeBtn)
                .addContainerGap())
        );

    }  
	public void showEmptyDBWindow(){
    	warningMessageView.showErrorMessage("Empty Database !!");
    }
	
    public void  showAllCustomersWindow (HashMap<String, CustomerModel> customersList){
  
		Collection<CustomerModel> c = customersList.values();
		Iterator<CustomerModel> itr = c.iterator();
		while (itr.hasNext()) {
			CustomerModel customer = itr.next();
			addCustomerToTable(customer);
		}
		
    	allCustomersInfoFrame.setVisible(true);
    	
    }
    
    private void addCustomerToTable(CustomerModel customer){
        Object [] rowData = {customer.getId(),customer.getFirstName(),customer.getLastName()};
        model.addRow(rowData);	
    }
    
    public void addActionObserver(ActionListener onClick) {
		 closeBtn.addActionListener(onClick);
	}
    
    
	

}
