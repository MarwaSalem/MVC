package view;

import javax.swing.*;
 
public class warningMessageView {
	
	private static JFrame messageFrame;
	
	public static void showErrorMessage(String message){
		JOptionPane.showMessageDialog(messageFrame, message);
	}

}
