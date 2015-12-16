import java.awt.*;
import java.awt.event.*;

public class View {
	
	private Frame mainFrame;
	private Frame newCustomerFrame;
	private Frame customerInfoFrame;
	private Frame allCustomersInfoFrame;
	private Panel controlPanel;
    public View (){
    	viewMainFrame();
    }
    
    private void viewMainFrame(){
    	mainFrame = new Frame("MVC Example");
    	mainFrame.setSize(600,300);
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
    	controlPanel = new Panel();
    	controlPanel.setLayout(new FlowLayout());
    	mainFrame.add(controlPanel);
    	Button addBtn = new Button("Add Customer");
    	Button getBtn = new Button("Get Customer Info");
    	Button viewAllBtn = new Button("View all Customers");
    	
    	addBtn.setActionCommand("Add");
    	getBtn.setActionCommand("View");
    	viewAllBtn.setActionCommand("ViewAll");
    	addBtn.addActionListener(new ButtonClickListener());
    	getBtn.addActionListener(new ButtonClickListener());
    	viewAllBtn.addActionListener(new ButtonClickListener());
    	
    	controlPanel.add(addBtn);
    	controlPanel.add(getBtn);
    	controlPanel.add(viewAllBtn);
    	mainFrame.setVisible(true);
    	
    }
    
    private void showAddNewCustomerWindow (){
    	newCustomerFrame = new Frame();
    	newCustomerFrame.setSize(600, 600);
    	newCustomerFrame.setLayout(new GridLayout(5, 2));
    	newCustomerFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
               System.exit(0);
            }        
         }); 
    	
    	Label header = new Label("Please fill the following entries !", Label.LEFT);
    	header.setFont(new Font("Serif", Font.BOLD, 16));
    	newCustomerFrame.add(header);
    	
    	
    	
    }
    
    private void showGetCustomerInfoWindow (){
    	
    }
    
    private void  showViewAllCustomersWindow (){
    	
    }
    
    private class ButtonClickListener implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		String command = e.getActionCommand();
    		if (command.equals("Add")){
    			System.out.println("add new customer");
    		}else if(command.equals("View")) {
    			System.out.println("view Customer");    			
    		}else if(command.equals("ViewAll")){
    			System.out.println("view all customers");
    		}
    	}    	
    }
    
    
    
    public static void main(String[] args) {
    	
    	View theView = new View();
	}
	

}
