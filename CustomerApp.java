
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.DefaultListModel;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Component;

public class CustomerApp extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private Customer cUser;
	private JPanel contentPane;
	private JTextField inputSearchBar, inpCapacity;
	private JButton btnRequesTrip, btnStartOrStop;
	private JList<String> list, travelList;
	private JLabel lblCarNumberPlate, lblGTotal, lblRouteName, lblTravellerCapacity, lblDistance, tripCountLbl, balLbl,
			balanceInfoLabel, lblDistanceDash, lblRouteCount, lblTripCount;
	private JTextField loadInput;
	private JLabel lblMSG;
	private String[] titlesArr;
	private String[][] dataArr;

	private Route r;
	private Trip holdedTrip;
	private DefaultTableModel model;
	private DefaultListModel<String> dlm;
	private JList listPrev;

	private int passengers;

	public CustomerApp(Customer cCustomer) {
		cUser = cCustomer;
		setTitle("ZGS Taxi Land");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 526);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(75, 0, 130));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel topPanel = new JPanel();
		contentPane.add(topPanel, BorderLayout.NORTH);
		topPanel.setLayout(new BorderLayout(0, 0));

		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(new Color(75, 0, 130));
		topPanel.add(titlePanel, BorderLayout.NORTH);

		JLabel titleLabel = new JLabel("ZGS Taxi Land");
		titleLabel.setForeground(new Color(255, 255, 255));
		titleLabel.setFont(new Font("Snap ITC", Font.BOLD, 20));
		titlePanel.add(titleLabel);

		JPanel topUserPane = new JPanel();
		topUserPane.setBackground(new Color(230, 230, 250));
		topPanel.add(topUserPane, BorderLayout.SOUTH);
		topUserPane.setLayout(new GridLayout(0, 4, 0, 0));

		JLabel customerNameLabel = new JLabel("Hi! " + cUser.getCustomerName());
		customerNameLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		customerNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		topUserPane.add(customerNameLabel);

		tripCountLbl = new JLabel("No. Trips:" + cUser.getTripCount());
		tripCountLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		topUserPane.add(tripCountLbl);

		balLbl = new JLabel("");
		balLbl.setFont(new Font("Tahoma", Font.ITALIC, 17));
		balLbl.setHorizontalAlignment(SwingConstants.LEFT);
		topUserPane.add(balLbl);

		balanceInfoLabel = new JLabel("Cash: " + String.valueOf(cUser.getBalanceCash()));
		balanceInfoLabel.setFont(new Font("Tahoma", Font.ITALIC, 17));
		balanceInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		topUserPane.add(balanceInfoLabel);

		JPanel btmPanel = new JPanel();
		contentPane.add(btmPanel, BorderLayout.SOUTH);

		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(new Color(72, 61, 139));
		centerPanel.setForeground(new Color(72, 61, 139));
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(72, 61, 139));
		tabbedPane.setBounds(0, -29, 444, 448);
		centerPanel.add(tabbedPane);

		JPanel pnlNewTrip = new JPanel();
		pnlNewTrip.setBackground(new Color(72, 61, 139));
		tabbedPane.addTab("New tab", null, pnlNewTrip, null);
		pnlNewTrip.setLayout(new BorderLayout(5, 0));

		JPanel pnlNewTripTop = new JPanel();
		pnlNewTripTop.setBackground(new Color(72, 61, 139));
		pnlNewTrip.add(pnlNewTripTop, BorderLayout.NORTH);
		pnlNewTripTop.setLayout(new BorderLayout(0, 0));

		inputSearchBar = new JTextField();
		inputSearchBar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				inputSearchBar.setText("");
			}
		});
		inputSearchBar.setText("Search Here..");
		inputSearchBar.setBackground(new Color(255, 255, 255));
		inputSearchBar.setHorizontalAlignment(SwingConstants.LEFT);
		inputSearchBar.setFont(new Font("Tahoma", Font.ITALIC, 17));
		pnlNewTripTop.add(inputSearchBar, BorderLayout.NORTH);
		inputSearchBar.setColumns(10);

		DefaultListModel<String> lm = new DefaultListModel<String>();
		lm.addAll(Data.getRouteNameList());

		list = new JList<String>(lm);
		list.setValueIsAdjusting(true);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectionForeground(Color.WHITE);
		list.setSelectionBackground(new Color(75, 0, 130));
		list.setForeground(Color.WHITE);
		list.setFont(new Font("Verdana", Font.ITALIC, 14));
		list.setBackground(new Color(72, 61, 139));
		pnlNewTripTop.add(list, BorderLayout.CENTER);

		JPanel pnlCapacity = new JPanel();
		pnlCapacity.setBounds(new Rectangle(0, 0, 7, 100));
		pnlCapacity.setSize(new Dimension(0, 200));
		pnlCapacity.setForeground(new Color(255, 255, 255));
		pnlCapacity.setBackground(new Color(72, 61, 139));
		pnlCapacity.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_2 = new JLabel("No. Travellers :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		pnlCapacity.add(lblNewLabel_2, BorderLayout.CENTER);

		inpCapacity = new JTextField();
		inpCapacity.setFont(new Font("Tahoma", Font.BOLD, 20));
		inpCapacity.setColumns(4);
		pnlCapacity.add(inpCapacity, BorderLayout.EAST);

		pnlNewTripTop.add(pnlCapacity, BorderLayout.SOUTH);

		btnRequesTrip = new JButton("Request Trip");
		btnRequesTrip.addActionListener(this);
		btnRequesTrip.setForeground(new Color(0, 0, 0));
		btnRequesTrip.setFont(new Font("Segoe UI Historic", Font.BOLD, 15));
		btnRequesTrip.setBackground(new Color(154, 205, 50));
		pnlCapacity.add(btnRequesTrip, BorderLayout.SOUTH);

		JPanel pnlNewTripEast = new JPanel();
		pnlNewTripEast.setMinimumSize(new Dimension(25, 25));
		pnlNewTripEast.setBackground(new Color(255, 255, 255));
		pnlNewTrip.add(pnlNewTripEast, BorderLayout.WEST);
		pnlNewTripEast.setLayout(new BorderLayout(5, 5));

		JPanel panel = new JPanel();
		pnlNewTripEast.add(panel, BorderLayout.NORTH);

		JLabel lblCarDetails = new JLabel("Trip Details :");
		lblCarDetails.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblCarDetails);

		JPanel pnlCarDetails = new JPanel();
		pnlCarDetails.setAutoscrolls(true);
		pnlCarDetails.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnlCarDetails.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pnlCarDetails.setBackground(new Color(255, 255, 255));
		pnlNewTripEast.add(pnlCarDetails, BorderLayout.CENTER);
		pnlCarDetails.setLayout(new GridLayout(5, 2, 0, 0));

		JLabel lblTaxiPlate = new JLabel("Car Number :");
		lblTaxiPlate.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblTaxiPlate.setHorizontalAlignment(SwingConstants.LEFT);
		pnlCarDetails.add(lblTaxiPlate);

		lblCarNumberPlate = new JLabel("0");
		lblCarNumberPlate.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarNumberPlate.setFont(new Font("Tahoma", Font.BOLD, 10));
		pnlCarDetails.add(lblCarNumberPlate);

		JLabel lblNewLabel_4 = new JLabel("Route Name :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		pnlCarDetails.add(lblNewLabel_4);

		lblRouteName = new JLabel("0");
		lblRouteName.setHorizontalAlignment(SwingConstants.CENTER);
		lblRouteName.setFont(new Font("Tahoma", Font.BOLD, 10));
		pnlCarDetails.add(lblRouteName);

		JLabel lblNewLabel_7 = new JLabel("Distance  :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
		pnlCarDetails.add(lblNewLabel_7);

		lblDistance = new JLabel("0");
		lblDistance.setHorizontalAlignment(SwingConstants.CENTER);
		lblDistance.setFont(new Font("Tahoma", Font.BOLD, 10));
		pnlCarDetails.add(lblDistance);

		JLabel lblNewLabel_7_1 = new JLabel("No. Travellers :");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.LEFT);
		pnlCarDetails.add(lblNewLabel_7_1);

		lblTravellerCapacity = new JLabel("0");
		lblTravellerCapacity.setHorizontalAlignment(SwingConstants.CENTER);
		lblTravellerCapacity.setFont(new Font("Tahoma", Font.BOLD, 10));
		pnlCarDetails.add(lblTravellerCapacity);

		JLabel lblNewLabel_7_1_1 = new JLabel("Total Cost :");
		lblNewLabel_7_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		pnlCarDetails.add(lblNewLabel_7_1_1);

		lblGTotal = new JLabel("0");
		lblGTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblGTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnlCarDetails.add(lblGTotal);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(72, 61, 139));
		pnlNewTrip.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		btnStartOrStop = new JButton("Start ");
		panel_1.add(btnStartOrStop, BorderLayout.SOUTH);
		btnStartOrStop.setEnabled(false);
		btnStartOrStop.setBackground(new Color(154, 205, 99));
		btnStartOrStop.addActionListener(this);

		JPanel pnlLoadCash = new JPanel();
		pnlLoadCash.setBackground(new Color(72, 61, 139));
		tabbedPane.addTab("New tab", null, pnlLoadCash, null);
		pnlLoadCash.setLayout(null);

		loadInput = new JTextField();
		loadInput.setHorizontalAlignment(SwingConstants.CENTER);
		loadInput.setFont(new Font("Tahoma", Font.BOLD, 18));
		loadInput.setBounds(132, 102, 169, 61);
		pnlLoadCash.add(loadInput);
		loadInput.setColumns(10);

		JButton btnNewButton = new JButton("Add Amount");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Integer.valueOf(loadInput.getText()) > 0) {
					addMoney(Integer.valueOf(loadInput.getText()));
					updateLog("Amount lodded sucessfully...", true);
				} else {
					updateLog("Something Wrong..Please Try again..", false);
					negtaiveValueDLG();
					loadInput.setText("");
				}
			}
		});
		btnNewButton.setBounds(164, 185, 113, 40);
		pnlLoadCash.add(btnNewButton);

		JLabel lblNewLabel_3 = new JLabel("Load Cash");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3.setBounds(132, 59, 169, 21);
		pnlLoadCash.add(lblNewLabel_3);

		JPanel pnlPrevTrips = new JPanel();
		pnlPrevTrips.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("New tab", null, pnlPrevTrips, null);

		model = new DefaultTableModel(dataArr, titlesArr);
		pnlPrevTrips.setLayout(new BorderLayout(0, 0));
		
		listPrev = new JList();
		pnlPrevTrips.add(listPrev, BorderLayout.CENTER);

		JPanel pnsSettings = new JPanel();
		pnsSettings.setBackground(new Color(72, 61, 139));
		tabbedPane.addTab("New tab", null, pnsSettings, null);
		pnsSettings.setLayout(null);
		
		JList listTrips = new JList();
		listTrips.setVisibleRowCount(10);
		listTrips.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listTrips.setBounds(0, 0, 1, 1);
		pnsSettings.add(listTrips);

		JPanel pnlDashBoard = new JPanel();
		pnlDashBoard.setBackground(new Color(72, 61, 139));
		tabbedPane.addTab("New tab", null, pnlDashBoard, null);
		pnlDashBoard.setLayout(null);

		lblDistanceDash = new JLabel("*****");
		lblDistanceDash.setForeground(new Color(255, 255, 255));
		lblDistanceDash.setHorizontalAlignment(SwingConstants.CENTER);
		lblDistanceDash.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 30));
		lblDistanceDash.setBounds(133, 81, 188, 67);
		pnlDashBoard.add(lblDistanceDash);

		JLabel lblDistanceDiscription = new JLabel("Distance Travel with us");
		lblDistanceDiscription.setForeground(Color.WHITE);
		lblDistanceDiscription.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblDistanceDiscription.setHorizontalAlignment(SwingConstants.CENTER);
		lblDistanceDiscription.setBounds(133, 67, 188, 22);
		pnlDashBoard.add(lblDistanceDiscription);

		lblRouteCount = new JLabel("00");
		lblRouteCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblRouteCount.setForeground(Color.WHITE);
		lblRouteCount.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 30));
		lblRouteCount.setBounds(304, 81, 113, 67);
		pnlDashBoard.add(lblRouteCount);

		lblTripCount = new JLabel("00");
		lblTripCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblTripCount.setForeground(Color.WHITE);
		lblTripCount.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 30));
		lblTripCount.setBounds(31, 81, 113, 67);
		pnlDashBoard.add(lblTripCount);

		JLabel lblTripCountDashDes = new JLabel("Travell Count");
		lblTripCountDashDes.setHorizontalAlignment(SwingConstants.CENTER);
		lblTripCountDashDes.setForeground(Color.WHITE);
		lblTripCountDashDes.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblTripCountDashDes.setBounds(10, 133, 136, 22);
		pnlDashBoard.add(lblTripCountDashDes);

		JLabel lblRouteDashDiscription = new JLabel("Available Routes");
		lblRouteDashDiscription.setHorizontalAlignment(SwingConstants.CENTER);
		lblRouteDashDiscription.setForeground(Color.WHITE);
		lblRouteDashDiscription.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblRouteDashDiscription.setBounds(293, 133, 136, 22);
		pnlDashBoard.add(lblRouteDashDiscription);

		dlm = new DefaultListModel<String>();

		travelList = new JList<String>(dlm);
		travelList.setBounds(0, 195, 439, 225);
		pnlDashBoard.add(travelList);

		tabbedPane.setSelectedIndex(4);

		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(new Color(75, 0, 130));
		leftPanel.setForeground(new Color(255, 255, 255));
		contentPane.add(leftPanel, BorderLayout.WEST);
		leftPanel.setLayout(new GridLayout(7, 1, 0, 0));

		JLabel lblNewLabel_1 = new JLabel("");
		leftPanel.add(lblNewLabel_1);

		JButton newTripBtn = new JButton("New Trip");
		newTripBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
				lm.removeAllElements();
				lm.addAll(Data.getRouteNameList());
			}
		});

		JButton btnHome = new JButton("Home");
		btnHome.setForeground(Color.WHITE);
		btnHome.setBackground(new Color(75, 0, 130));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(4);

				loadPastTripTable();
			}
		});
		leftPanel.add(btnHome);
		newTripBtn.setBackground(new Color(75, 0, 130));
		newTripBtn.setForeground(new Color(255, 255, 255));
		leftPanel.add(newTripBtn);

		JButton loadCashBtn = new JButton("Load Cash");
		loadCashBtn.setBackground(new Color(75, 0, 130));
		loadCashBtn.setForeground(Color.WHITE);
		loadCashBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		leftPanel.add(loadCashBtn);

		JButton btnPreviousTrips = new JButton("Previous Trips");
		btnPreviousTrips.setForeground(Color.WHITE);
		btnPreviousTrips.setBackground(new Color(75, 0, 130));
		btnPreviousTrips.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		leftPanel.add(btnPreviousTrips);

		JButton btnLogOut = new JButton("LogOut");
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setBackground(new Color(75, 0, 130));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logoff();
			}
		});
		leftPanel.add(btnLogOut);

		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(new Color(75, 0, 130));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		leftPanel.add(btnExit);

		lblMSG = new JLabel("Welcome Back ...");
		lblMSG.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblMSG.setOpaque(true);
		lblMSG.setHorizontalAlignment(SwingConstants.CENTER);
		lblMSG.setForeground(new Color(75, 0, 130));
		lblMSG.setBackground(new Color(60, 179, 113));
		contentPane.add(lblMSG, BorderLayout.SOUTH);
		
		reload() ;
	}

	void updateLog(String s, boolean r) {
		if (r) {
			lblMSG.setBackground(new Color(154, 205, 50));
		} else {
			lblMSG.setBackground(new Color(255, 160, 122));
		}

		lblMSG.setText(s);

	}

	void loadPastTripTable() {
		// tblPastTrips
		// titlesArr;
		// private String[][] dataArr;

		titlesArr = new String[] { "Destination", "Start", "End", "Distance", "Cost" };
		dataArr = new String[22][10];
		if (cUser.pastTrips != null) {
			int counter = 0;
			for (Trip t : cUser.pastTrips) {
				// System.out.println( t.getRoute().getRouteName());
				dataArr[counter][0] = t.getRoute().getRouteName();
				// dataArr[counter][1] = t.getStartTime().toString();
				// dataArr[counter][2] = t.getEndTime().toString();
				dataArr[counter][3] = String.valueOf(t.getRoute().getDistanceInKm());
				dataArr[counter][4] = String.valueOf(Finanance.getTripCoast(t.getRoute().getDistanceInKm())[0]);

				model.addRow(dataArr[counter]);
				counter++;
			}

			// addRow(dataArr[counter]);
		}

	}

	void pastListload() {
		// for Dash Board

		for (Trip t : cUser.pastTrips) {

			dlm.addElement(t.getRoute().getRouteName().toString() + " -  "
					+ String.valueOf(t.getRoute().getDistanceInKm()) + ".Km -  Rs."
					+ String.valueOf(Finanance.getTripCoast(t.getRoute().getDistanceInKm())[0]) + " ----");
		}

	}

	void reload() {
		tripCountLbl.setText("No. Trips " + cUser.getTripCount());
		balanceInfoLabel.setText("Cash :" + cUser.getBalanceCash());
		lblDistanceDash.setText("" + cUser.getKmTravelled());
		lblRouteCount.setText("" + Data.getRouteCount());
		lblTripCount.setText("" + cUser.getTripCount());
		pastListload();

	}

	void generateBill(Route r) {

		updateLog("WoW You have enough cash....", true);
		lblCarNumberPlate.setText("XXXXXX");
		updateLog("Getting car details....", true);
		lblGTotal.setText(String.valueOf(Finanance.getTripCoast(r.getDistanceInKm())[0]));
		updateLog("Loading Base Price....", true);
		lblRouteName.setText(r.getRouteName());
		updateLog(" Alloting your taxi....", true);
		lblTravellerCapacity.setText(String.valueOf(inpCapacity.getText()));
		lblDistance.setText(String.valueOf(r.getDistanceInKm()));
		updateLog("Please Wait....", true);
		updateLog("Estimate bill generated....", true);
		btnStartOrStop.setEnabled(true);
	}

	void start(Route r) {
		holdedTrip = Data.newTrip(r, cUser, Data.nextAvailableCar(passengers), passengers);
		btnRequesTrip.setEnabled(false);
		btnRequesTrip.setText(" In Transit...");
		btnStartOrStop.setBackground(new Color(255, 160, 122));
		btnStartOrStop.setText("End Transit");
		btnStartOrStop.setEnabled(true);

	}

	void end(){
		Data.stopTrip(holdedTrip);

		holdedTrip.getCustomer().payBill(Finanance.getTripCoast(holdedTrip.getRoute().getDistanceInKm())[0],
				holdedTrip);
		Data.stopTrip(holdedTrip);
		holdedTrip = null;
		btnStartOrStop.setText("Start");
		btnRequesTrip.setText("Request Trip");
		btnStartOrStop.setBackground(new Color(154, 205, 99));
		btnStartOrStop.setEnabled(false);
		reload();
		holdedTrip = null;
		btnRequesTrip.setEnabled(true);
	}

	void addMoney(int val) {
		cUser.loadCash(val);
		loadInput.setText("");
		reload();

	}

	void logoff() {
		cUser = null;
		CustomerGUILogin frame = new CustomerGUILogin();
		frame.setVisible(true);
		super.setVisible(false);
		super.dispose();

	}
	
	private void negtaiveValueDLG() {
		JOptionPane.showMessageDialog(this, "Unable to process your transaction due to negative value. \n Please re-try with a valid input.\n  Thank You!", "Negative Value Found ", JOptionPane.ERROR_MESSAGE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnRequesTrip) {

			if(list.getSelectedValue() != null)
			{
				updateLog("Requesting......", true);
				if (inpCapacity.getText().equals("")) {

					passengers = 1;
				} else {
					passengers = Integer.valueOf(inpCapacity.getText());
				}

				Car nextAvailableCar = Data.nextAvailableCar(passengers);

				if (nextAvailableCar != null) {
					updateLog("Car is available....", true);
					r = Data.getRoute(list.getSelectedValue());
					generateBill(r);
					// System.out.println(r.getRouteName());
				} else {
					updateLog("Sorry Currently we have no cars available..", true);
				}
			}else {
				JOptionPane.showMessageDialog(this, "Please select atleast one route and request again... \n Thank You!", "No Selection Found", JOptionPane.ERROR_MESSAGE);
			}
			
			//end of request button
		} else if (e.getSource() == btnStartOrStop) {

			if (holdedTrip == null) {

				if (cUser.getBalanceCash() >= Finanance
						.getTripCoast(Data.getRoute(list.getSelectedValue()).getDistanceInKm())[0]) {
					generateBill(Data.getRoute(list.getSelectedValue()));
					start(Data.getRoute(list.getSelectedValue()));

				} else {
					updateLog("Hi Sorry :( Insufficient funds in your account..", false);
					JOptionPane.showMessageDialog(this, "Kindly load the sufficient money before starting the journey... \n Thank You! \n Thank You!", "Insufficient Funds ", JOptionPane.ERROR_MESSAGE);
					holdedTrip = null;
				}

			} else {
				end();
			}
		}

	}
}
