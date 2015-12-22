package view;

import static helper.Constants.EMPTY_ID_WARNING_MESSAGE;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Customer;

public class NewCustomerView {
	private JFrame newCustomerFrame;
	private JPanel entriesPanel;
	private JButton submitBtn;
	private JTextField customerId;
	private JTextField customerFirstName;
	private JTextField customerLastName;

	public NewCustomerView() {
		initComponents();
	}

	private void initComponents() {
		newCustomerFrame = new JFrame();
		entriesPanel = new JPanel();
		submitBtn = new JButton("Submit");

		newCustomerFrame.setMaximumSize(new Dimension(400, 300));
		newCustomerFrame.setMinimumSize(new Dimension(400, 300));

		JLabel header = new JLabel("Please fill the following fields .");
		JLabel id = new JLabel("Id");
		JLabel firstName = new JLabel("First name");
		JLabel lastName = new JLabel("Last name");

		customerId = new JTextField();
		customerFirstName = new JTextField();
		customerLastName = new JTextField();

		newCustomerFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				newCustomerFrame.setVisible(false);
				newCustomerFrame.dispose();
			}
		});
		header.setFont(new Font("Tahoma", 1, 14));

		GroupLayout layoutPanel = new GroupLayout(entriesPanel);
		entriesPanel.setLayout(layoutPanel);
		layoutPanel
				.setHorizontalGroup(layoutPanel
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								layoutPanel
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												layoutPanel
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addGroup(
																layoutPanel
																		.createSequentialGroup()
																		.addComponent(
																				id)
																		.addGap(67,
																				67,
																				67)
																		.addComponent(
																				customerId,
																				GroupLayout.PREFERRED_SIZE,
																				115,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																layoutPanel
																		.createSequentialGroup()
																		.addGroup(
																				layoutPanel
																						.createParallelGroup(
																								GroupLayout.Alignment.LEADING)
																						.addComponent(
																								firstName)
																						.addComponent(
																								lastName))
																		.addGap(27,
																				27,
																				27)
																		.addGroup(
																				layoutPanel
																						.createParallelGroup(
																								GroupLayout.Alignment.LEADING,
																								false)
																						.addComponent(
																								customerFirstName)
																						.addComponent(
																								customerLastName,
																								GroupLayout.DEFAULT_SIZE,
																								215,
																								Short.MAX_VALUE))))
										.addContainerGap(52, Short.MAX_VALUE))
						.addGroup(
								GroupLayout.Alignment.TRAILING,
								layoutPanel
										.createSequentialGroup()
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(submitBtn)
										.addContainerGap()));
		layoutPanel.setVerticalGroup(layoutPanel.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				layoutPanel
						.createSequentialGroup()
						.addGap(29, 29, 29)
						.addGroup(
								layoutPanel
										.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
										.addComponent(id)
										.addComponent(customerId,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
						.addGap(25, 25, 25)
						.addGroup(
								layoutPanel
										.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
										.addComponent(firstName)
										.addComponent(customerFirstName,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
						.addGap(31, 31, 31)
						.addGroup(
								layoutPanel
										.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
										.addComponent(lastName)
										.addComponent(customerLastName,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
						.addGap(27, 27, 27).addComponent(submitBtn)
						.addContainerGap(41, Short.MAX_VALUE)));

		GroupLayout layout = new javax.swing.GroupLayout(
				newCustomerFrame.getContentPane());
		newCustomerFrame.getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(20, 20, 20)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING,
												false)
												.addComponent(
														header,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														entriesPanel,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE))
								.addContainerGap(26, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(header,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										36,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(entriesPanel,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE).addContainerGap()));
		submitBtn.setActionCommand("Submit");

	}

	public boolean verifyNotEmpty() {
		if (customerId.getText().equals("")) {
			warningMessageView.showErrorMessage(EMPTY_ID_WARNING_MESSAGE);
			return false;
		}
		return true;
	}

	public void showAddNewCustomerWindow() {
		resetFields();
		newCustomerFrame.setVisible(true);

	}

	public Customer getCustomer() {
		Customer customer = new Customer(customerId.getText(),
				customerFirstName.getText(), customerLastName.getText());
		return customer;
	}

	public void onSubmit() {
		newCustomerFrame.setVisible(false);
		newCustomerFrame.dispose();
	}

	public void addActionObserver(ActionListener onClick) {
		submitBtn.addActionListener(onClick);
	}

	private void resetFields() {
		customerId.setText("");
		customerFirstName.setText("");
		customerLastName.setText("");
	}

}
