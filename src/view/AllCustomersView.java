package view;

import static helper.Constants.ALL_CUSTOMERS_VIEW_HEIGHT;
import static helper.Constants.ALL_CUSTOMERS_VIEW_WIDTH;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

import model.Customer;

public class AllCustomersView {

	private JFrame allCustomersInfoFrame;
	private JButton closeBtn;
	private JTable customersTable;
	private JScrollPane scroller;
	private DefaultTableModel model;

	public AllCustomersView() {
		initComponents();
	}

	private void initComponents() {
		allCustomersInfoFrame = new JFrame();
		closeBtn = new JButton();
		scroller = new JScrollPane();
		customersTable = new JTable();
		closeBtn = new JButton("Close");
		closeBtn.setActionCommand("Close");
		allCustomersInfoFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				allCustomersInfoFrame.setVisible(false);
				allCustomersInfoFrame.dispose();
			}
		});
		allCustomersInfoFrame.setPreferredSize(new Dimension(
				ALL_CUSTOMERS_VIEW_WIDTH, ALL_CUSTOMERS_VIEW_HEIGHT));
		allCustomersInfoFrame.setMaximumSize(new Dimension(
				ALL_CUSTOMERS_VIEW_WIDTH, ALL_CUSTOMERS_VIEW_HEIGHT));
		allCustomersInfoFrame.setMinimumSize(new Dimension(
				ALL_CUSTOMERS_VIEW_WIDTH, ALL_CUSTOMERS_VIEW_HEIGHT));

		customersTable.setFont(new Font("Tahoma", 1, 14));
		model = new DefaultTableModel(new Object[][] { {} }, new String[] {
				"Id", "First name", "Last name" });
		customersTable.setModel(model);
		scroller.setViewportView(customersTable);

		JLabel title = new JLabel("Customers List");
		title.setFont(new java.awt.Font("Tahoma", 1, 14));

		GroupLayout layout = new GroupLayout(
				allCustomersInfoFrame.getContentPane());
		allCustomersInfoFrame.getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(title)
								.addContainerGap(GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
				.addGroup(
						GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(20, Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.TRAILING)
												.addComponent(closeBtn)
												.addComponent(
														scroller,
														GroupLayout.PREFERRED_SIZE,
														764,
														GroupLayout.PREFERRED_SIZE))
								.addGap(20, 20, 20)));
		layout.setVerticalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(title, GroupLayout.PREFERRED_SIZE, 31,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(
								LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(scroller, GroupLayout.DEFAULT_SIZE, 425,
								Short.MAX_VALUE).addGap(27, 27, 27)
						.addComponent(closeBtn).addContainerGap()));

	}

	public void showEmptyDBWindow() {
		warningMessageView.showErrorMessage("Empty Database !!");
	}

	public void showAllCustomersWindow(HashMap<String, Customer> customersList) {
		clearCustomersTable();
		Collection<Customer> c = customersList.values();
		Iterator<Customer> itr = c.iterator();
		while (itr.hasNext()) {
			Customer customer = itr.next();
			addCustomerToTable(customer);
		}

		allCustomersInfoFrame.setVisible(true);

	}

	private void addCustomerToTable(Customer customer) {
		Object[] rowData = { customer.getId(), customer.getFirstName(),
				customer.getLastName() };
		model.addRow(rowData);
	}

	public void addActionObserver(ActionListener onClick) {
		closeBtn.addActionListener(onClick);
	}

	private void clearCustomersTable() {
		int rowCount = model.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}

	}

}
