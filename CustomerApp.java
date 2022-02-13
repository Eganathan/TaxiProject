package playground;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import java.awt.CardLayout;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JList;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Cursor;
import java.awt.Component;

public class CustomerApp extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Customer cUser;
	private JPanel contentPane , pnlCarDetails;
	private JTable tblPastTrips;
	private JTextField inputSearchBar , inpCapacity;
	private JButton btnRequesTrip;
	private JList<String> list;
	private JLabel lblCarNumberPlate, lblGTotal, lblRouteName,lblTravellerCapacity ,lblDistance ;
	private JTextField textField;

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

		JLabel lblNewLabel = new JLabel("No. Trips:  ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		topUserPane.add(lblNewLabel);

		JLabel balLbl = new JLabel("0");
		balLbl.setFont(new Font("Tahoma", Font.ITALIC, 17));
		balLbl.setHorizontalAlignment(SwingConstants.LEFT);
		topUserPane.add(balLbl);

		JLabel balanceInfoLabel = new JLabel("Cash: " + String.valueOf(cUser.getBalanceCash()));
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

		JPanel pnlDashBoard = new JPanel();
		pnlDashBoard.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("New tab", null, pnlDashBoard, null);
		pnlDashBoard.setLayout(new BorderLayout(0, 0));

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

		
		
		JPanel pnlUpdate = new JPanel();
		pnlUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnlUpdate.setBackground(new Color(154, 205, 50));
		pnlNewTrip.add(pnlUpdate, BorderLayout.SOUTH);
		
		JLabel lblUpdateText = new JLabel("New label");
		pnlUpdate.add(lblUpdateText);

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
		pnlCarDetails.setBorder(new EmptyBorder(5,5,5,5));
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

		JLabel lblNewLabel_7_1_1 = new JLabel("Total Coast :");
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
		
		JButton btnStartOrStop = new JButton("Start ");
		panel_1.add(btnStartOrStop, BorderLayout.SOUTH);

		JPanel pnlLoadCash = new JPanel();
		tabbedPane.addTab("New tab", null, pnlLoadCash, null);

		JPanel pnlPrevTrips = new JPanel();
		tabbedPane.addTab("New tab", null, pnlPrevTrips, null);
		pnlPrevTrips.setLayout(new BorderLayout(0, 0));

		tblPastTrips = new JTable();
		tblPastTrips.setFont(new Font("Sitka Display", Font.ITALIC, 17));
		pnlPrevTrips.add(tblPastTrips, BorderLayout.CENTER);

		JPanel pnsSettings = new JPanel();
		tabbedPane.addTab("New tab", null, pnsSettings, null);

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
				tabbedPane.setSelectedIndex(1);
			}
		});
		newTripBtn.setBackground(new Color(75, 0, 130));
		newTripBtn.setForeground(new Color(255, 255, 255));
		leftPanel.add(newTripBtn);

		JButton loadCashBtn = new JButton("Load Cash");
		loadCashBtn.setBackground(new Color(75, 0, 130));
		loadCashBtn.setForeground(Color.WHITE);
		loadCashBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
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

		JButton btnAccSettings = new JButton("Account Settings");
		btnAccSettings.setForeground(Color.WHITE);
		btnAccSettings.setBackground(new Color(75, 0, 130));
		btnAccSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(4);
			}
		});
		leftPanel.add(btnAccSettings);

		JButton btnLogOut = new JButton("LogOut");
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setBackground(new Color(75, 0, 130));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(5);
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
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnRequesTrip) {
			
				int passengers;
				if (inpCapacity.getText().equals("")) {

					passengers = 1;
				} else {
					passengers =  Integer.valueOf(inpCapacity.getText());
				}
				
			Car nextAvailableCar = Data.nextAvailableCar(passengers);
			Trip cTrip = new Trip(Data.getRoute(list.getSelectedValue()), cUser,
					Data.nextAvailableCar(passengers),
					passengers);

			if (nextAvailableCar != null) 
			{
				 if(cUser.getBalanceCash() >= Finanance.getTripCoast(cTrip.getRoute().getDistanceInKm())[0])
				 {
					 lblCarNumberPlate.setText(cTrip.getCar().getNumberPlate());
					 lblGTotal.setText( String.valueOf(Finanance.getTripCoast(cTrip.getRoute().getDistanceInKm())[0]) );
					 lblRouteName.setText( cTrip.getRoute().getRouteName());
					 lblTravellerCapacity.setText( String.valueOf( cTrip.getTravellerCount() ));
					 lblDistance.setText( String.valueOf( cTrip.getRoute().getDistanceInKm()));

				 }
				cTrip.getRoute().getDistanceInKm();
				cTrip.getRoute().getRouteName();
				Finanance.getTripCoast(cTrip.getRoute().getDistanceInKm());
				//lblCarNumberPlate, lblGTotal, lblRouteName,lblTravellerCapacity ,lblDistance 

			} else {
				System.out.println("Not Available");
			}
		}

		}

	}

