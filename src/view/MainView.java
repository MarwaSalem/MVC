package view;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

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
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		mainFrame.setTitle("MVC Example");
		mainFrame.setMaximumSize(new Dimension(1000, 600));
		mainFrame.setMinimumSize(new Dimension(400, 400));

		addNewCustomerBtn.setFont(new java.awt.Font("Tahoma", 1, 14));
		addNewCustomerBtn.setText("Add Customer");

		getCustomerInfoBtn.setFont(new java.awt.Font("Tahoma", 1, 14));
		getCustomerInfoBtn.setText("Get Customer Info");

		viewAllBtn.setFont(new java.awt.Font("Tahoma", 1, 14));
		viewAllBtn.setText("View all customers");

		dbSyncBtn.setText("Sync with DB");
		closeBtn.setText("Close");

		GroupLayout controlPanelLayout = new GroupLayout(controlPanel);
		controlPanel.setLayout(controlPanelLayout);
		controlPanelLayout
				.setHorizontalGroup(controlPanelLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								GroupLayout.Alignment.TRAILING,
								controlPanelLayout
										.createSequentialGroup()
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(dbSyncBtn)
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(closeBtn)
										.addGap(26, 26, 26))
						.addGroup(
								controlPanelLayout
										.createSequentialGroup()
										.addGap(86, 86, 86)
										.addGroup(
												controlPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																addNewCustomerBtn,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																getCustomerInfoBtn,
																GroupLayout.DEFAULT_SIZE,
																220,
																Short.MAX_VALUE)
														.addComponent(
																viewAllBtn,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addContainerGap(94, Short.MAX_VALUE)));
		controlPanelLayout
				.setVerticalGroup(controlPanelLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								controlPanelLayout
										.createSequentialGroup()
										.addGap(30, 30, 30)
										.addComponent(addNewCustomerBtn,
												GroupLayout.PREFERRED_SIZE, 37,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(getCustomerInfoBtn,
												GroupLayout.PREFERRED_SIZE, 37,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(viewAllBtn,
												GroupLayout.PREFERRED_SIZE, 37,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED,
												55, Short.MAX_VALUE)
										.addGroup(
												controlPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																dbSyncBtn,
																GroupLayout.PREFERRED_SIZE,
																32,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																closeBtn,
																GroupLayout.PREFERRED_SIZE,
																32,
																GroupLayout.PREFERRED_SIZE))
										.addGap(25, 25, 25)));

		JLabel header = new JLabel("Welcome!!");
		header.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36));
		mainFrame.add(header);

		GroupLayout layout = new GroupLayout(mainFrame.getContentPane());
		mainFrame.getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(controlPanel, GroupLayout.Alignment.TRAILING,
						GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(header, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING)
				.addGroup(
						GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(header, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(controlPanel,
										GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)));

		addNewCustomerBtn.setActionCommand("Add");
		getCustomerInfoBtn.setActionCommand("View");
		viewAllBtn.setActionCommand("ViewAll");
		dbSyncBtn.setActionCommand("Sync");
		closeBtn.setActionCommand("Close");
	}

	public void viewMainFrame() {

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
