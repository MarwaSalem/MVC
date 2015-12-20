package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class EmptyDBView {
	private Frame allCustomersInfoFrame;
	private Button closeBtn;
	
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
    	closeBtn = new Button("Close");
    	closeBtn.setActionCommand("Close");
    	closeBtn.addActionListener(new ButtonClickListener());
    	viewPanel.add(closeBtn);
    	allCustomersInfoFrame.setVisible(true);
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
