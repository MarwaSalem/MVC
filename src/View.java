import java.awt.*;
import java.awt.event.*;

public class View {
	
	private Frame mainFrame;
	private Frame newCustomerFrame;
	private Frame customerInfoFrame;
	private Frame allCustomersInfoFrame;
	private Panel controlPanel;
	private Panel entriesPanel;
	private Button submitBtn;
	private Button viewAllBtn;
	private Button closeBtn;

	
    public View (){
    	closeBtn = new Button("Close");
    	closeBtn.setActionCommand("Close");
    	closeBtn.addActionListener(new ButtonClickListener());
    	submitBtn =  new Button("Submit");
    	viewAllBtn = new Button("View all Customers");
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
    	controlPanel = new Panel(new FlowLayout());
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
    	submitBtn.setBounds(newCustomerFrame.getWidth()/2-20, newCustomerFrame.getHeight()/2-10, 20, 10);
    	submitBtn.setActionCommand("Submit");
    	entriesPanel.add(submitBtn);
    	newCustomerFrame.setVisible(true);
    	  	
    }
    
    public void showCustomerInfoWindow (String customer){
    	String [] customerProperties = customer.split(";");
    	customerInfoFrame = new Frame(customerProperties[0]);
    	customerInfoFrame.setSize(600, 400);
    	customerInfoFrame.setLayout(new GridLayout(5, 2));
    	customerInfoFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
               customerInfoFrame.setVisible(false);
               newCustomerFrame.dispose();
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
    	viewPanel.add(id);
    	viewPanel.add(cId);
    	viewPanel.add(firstName);
    	viewPanel.add(cFirstName);
    	viewPanel.add(lastName);
    	viewPanel.add(cLastName);
    	viewPanel.add(closeBtn);
    	customerInfoFrame.setVisible(true);
 
    }
    
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
    
    public void showEmptyDBWindow(){
    	
    	allCustomersInfoFrame = new Frame();
    	allCustomersInfoFrame.setSize(300,200);
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
    	viewPanel.add(closeBtn);
    	allCustomersInfoFrame.setVisible(true);
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
     

    public void addActionObserver(ActionListener onClick){
    	submitBtn.addActionListener(onClick);
    	viewAllBtn.addActionListener(onClick);
    }
    
    private class ButtonClickListener implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		String command = e.getActionCommand();
    		if (command.equals("Add")){
    			System.out.println("add new customer");
    			showAddNewCustomerWindow();
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
   
}
