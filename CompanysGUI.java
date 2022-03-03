
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListModel;
import java.awt.Point;
import java.awt.Cursor;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class CompanysGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, pnlLog;
	private JLabel lblTaxesAndCess, lblTripCounts, lblBnkBal, lblLog, lblCustomerCount, lblRouteCount, lblCarCount;
	private JTextField inpRName;
	private JTextField inpRAddress;
	private JTextField inpRDistance;
	private JTextField inpCarName;
	private JTextField inpCapacity;
	private JTextField inpMilage;
	private JTextField inpAvgSpeed;
	private DefaultListModel<String> tripsDashList, rRouteListDetailsDML, listCarDetailsListDLM;
	private JList<String> rRouteListDetails, listCarDetailsList;
	private JButton btnAddRoute, btnNewCar;

	public CompanysGUI() {
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setLocation(new Point(726, 110));
		setTitle("ZGS-TaxiLand- Company GUI");
		setResizable(false);
		setAutoRequestFocus(false);

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 653, 432);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(72, 61, 139));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(150, 10));
		panel.setMinimumSize(new Dimension(150, 10));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(5, 1, 0, 0));

		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1);

		JTabbedPane pnlTab = new JTabbedPane(JTabbedPane.TOP);
		pnlTab.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(pnlTab, BorderLayout.CENTER);

		JPanel pnlDash = new JPanel();
		pnlDash.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e){
				reloadDashCompanyGUI();
			}
		});
		pnlDash.setBackground(new Color(75, 0, 130));
		pnlTab.addTab("Home", null, pnlDash, null);
		pnlDash.setLayout(null);

		JLabel lblT = new JLabel("Trip Counts");
		lblT.setFont(new Font("Dialog", Font.ITALIC, 13));
		lblT.setForeground(new Color(255, 255, 255));
		lblT.setEnabled(true);
		lblT.setHorizontalAlignment(SwingConstants.CENTER);
		lblT.setBounds(207, 0, 190, 29);
		pnlDash.add(lblT);

		lblTripCounts = new JLabel("000");
		lblTripCounts.setForeground(new Color(255, 255, 255));
		lblTripCounts.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblTripCounts.setHorizontalAlignment(SwingConstants.CENTER);
		lblTripCounts.setBounds(217, 20, 181, 54);
		pnlDash.add(lblTripCounts);

		JLabel lblNewLabel_1 = new JLabel("Current Earnings");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Dialog", Font.ITALIC, 13));
		lblNewLabel_1.setEnabled(true);
		lblNewLabel_1.setBounds(430, 0, 190, 29);
		pnlDash.add(lblNewLabel_1);

		lblBnkBal = new JLabel("000");
		lblBnkBal.setHorizontalAlignment(SwingConstants.CENTER);
		lblBnkBal.setForeground(Color.WHITE);
		lblBnkBal.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblBnkBal.setBounds(440, 20, 181, 54);
		pnlDash.add(lblBnkBal);

		JLabel lblNewLabel_1_1 = new JLabel("Taxes and others");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.ITALIC, 13));
		lblNewLabel_1_1.setEnabled(true);
		lblNewLabel_1_1.setBounds(429, 82, 190, 29);
		pnlDash.add(lblNewLabel_1_1);

		lblTaxesAndCess = new JLabel("000");
		lblTaxesAndCess.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaxesAndCess.setForeground(Color.WHITE);
		lblTaxesAndCess.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTaxesAndCess.setBounds(439, 102, 181, 54);
		pnlDash.add(lblTaxesAndCess);

		JLabel lblNewLabel_1_2 = new JLabel("No. Routes");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Dialog", Font.ITALIC, 13));
		lblNewLabel_1_2.setEnabled(true);
		lblNewLabel_1_2.setBounds(143, 82, 190, 29);
		pnlDash.add(lblNewLabel_1_2);

		lblRouteCount = new JLabel("00");
		lblRouteCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblRouteCount.setForeground(Color.WHITE);
		lblRouteCount.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblRouteCount.setBounds(153, 102, 181, 54);
		pnlDash.add(lblRouteCount);

		JLabel lblNewLabel_1_2_1 = new JLabel("No. Cars");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Dialog", Font.ITALIC, 13));
		lblNewLabel_1_2_1.setEnabled(true);
		lblNewLabel_1_2_1.setBounds(258, 82, 190, 29);
		pnlDash.add(lblNewLabel_1_2_1);

		lblCarCount = new JLabel("00");
		lblCarCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarCount.setForeground(Color.WHITE);
		lblCarCount.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblCarCount.setBounds(268, 102, 181, 54);
		pnlDash.add(lblCarCount);

		lblCustomerCount = new JLabel("000");
		lblCustomerCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerCount.setForeground(Color.WHITE);
		lblCustomerCount.setFont(new Font("Yu Gothic UI", Font.BOLD, 78));
		lblCustomerCount.setBounds(0, 32, 140, 96);
		pnlDash.add(lblCustomerCount);

		JLabel lblNewLabel_1_2_2 = new JLabel("Customer Count");
		lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2.setForeground(Color.WHITE);
		lblNewLabel_1_2_2.setFont(new Font("Dialog", Font.ITALIC, 13));
		lblNewLabel_1_2_2.setEnabled(true);
		lblNewLabel_1_2_2.setBounds(0, 20, 140, 29);
		pnlDash.add(lblNewLabel_1_2_2);

		tripsDashList = new DefaultListModel<String>();
		tripsDashList.addAll(Data.getTripsInfoAsList());

		JList<String> list = new JList<String>(tripsDashList);
		list.setBounds(0, 167, 620, 173);
		pnlDash.add(list);

		JPanel pnlRoutes = new JPanel();
		pnlRoutes.setBackground(new Color(72, 61, 139));
		pnlTab.addTab("Add New Route", null, pnlRoutes, null);
		pnlRoutes.setLayout(null);

		inpRName = new JTextField();
		inpRName.setBounds(278, 46, 245, 37);
		pnlRoutes.add(inpRName);
		inpRName.setColumns(10);

		inpRAddress = new JTextField();
		inpRAddress.setColumns(10);
		inpRAddress.setBounds(278, 108, 245, 37);
		pnlRoutes.add(inpRAddress);

		inpRDistance = new JTextField();
		inpRDistance.setColumns(10);
		inpRDistance.setBounds(278, 187, 245, 37);
		pnlRoutes.add(inpRDistance);

		JLabel lblNewLabel = new JLabel("Route Name:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(55, 46, 177, 37);
		pnlRoutes.add(lblNewLabel);

		JLabel lblFullAddress = new JLabel("Full Address : ");
		lblFullAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFullAddress.setForeground(new Color(255, 255, 255));
		lblFullAddress.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblFullAddress.setBounds(55, 108, 177, 37);
		pnlRoutes.add(lblFullAddress);

		JLabel lblNewLabel_2_1 = new JLabel("Distance in Km:");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2_1.setBounds(55, 198, 177, 37);
		pnlRoutes.add(lblNewLabel_2_1);

		btnAddRoute = new JButton("New Route");
		btnAddRoute.addActionListener(this);

		btnAddRoute.setBounds(177, 267, 198, 59);
		pnlRoutes.add(btnAddRoute);

		JPanel pnlNewCar = new JPanel();
		pnlNewCar.setBackground(new Color(72, 61, 139));
		pnlTab.addTab("Add New Car", null, pnlNewCar, null);
		pnlNewCar.setLayout(null);

		inpCarName = new JTextField();
		inpCarName.setBounds(306, 30, 230, 44);
		pnlNewCar.add(inpCarName);
		inpCarName.setColumns(10);

		inpCapacity = new JTextField();
		inpCapacity.setColumns(10);
		inpCapacity.setBounds(306, 85, 230, 44);
		pnlNewCar.add(inpCapacity);

		inpMilage = new JTextField();
		inpMilage.setColumns(10);
		inpMilage.setBounds(306, 140, 230, 44);
		pnlNewCar.add(inpMilage);

		inpAvgSpeed = new JTextField();
		inpAvgSpeed.setColumns(10);
		inpAvgSpeed.setBounds(306, 195, 230, 44);
		pnlNewCar.add(inpAvgSpeed);

		JLabel lblNewLabel_2 = new JLabel("Car Number  ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2.setBounds(87, 31, 177, 37);
		pnlNewCar.add(lblNewLabel_2);

		JLabel lblNewLabel_2_2 = new JLabel("Capacity  ");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2_2.setBounds(87, 92, 177, 37);
		pnlNewCar.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_2_1 = new JLabel("Milage  ");
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2_2_1.setBounds(87, 147, 177, 37);
		pnlNewCar.add(lblNewLabel_2_2_1);

		JLabel lblNewLabel_2_2_1_1 = new JLabel("Average Speed  ");
		lblNewLabel_2_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2_2_1_1.setBounds(87, 210, 177, 37);
		pnlNewCar.add(lblNewLabel_2_2_1_1);

		btnNewCar = new JButton("ADD CAR");
		btnNewCar.setBounds(327, 267, 198, 59);
		btnNewCar.addActionListener(this);
		pnlNewCar.add(btnNewCar);

		JButton btnClear = new JButton("CLEAR");
		btnClear.setBounds(82, 267, 198, 59);
		pnlNewCar.add(btnClear);

		JPanel pnlRouteDel = new JPanel();
		pnlTab.addTab("Route Details", null, pnlRouteDel, null);
		pnlRouteDel.setLayout(new BorderLayout(0, 0));

		rRouteListDetailsDML = new DefaultListModel<>();
		rRouteListDetails = new JList<String>(rRouteListDetailsDML);
		pnlRouteDel.add(rRouteListDetails);

		JPanel panel_1 = new JPanel();
		pnlRouteDel.add(panel_1, BorderLayout.SOUTH);

		JButton btnDelRoute = new JButton("Delete Route");
		btnDelRoute.setFont(new Font("Tahoma", Font.ITALIC, 15));
		panel_1.add(btnDelRoute);

		JButton btnViewRoutesInfo = new JButton("View details");
		btnViewRoutesInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// System.out.println("clicked" +
				// Data.getRoute( rRouteListDetails.getSelectedValue()).getFullAddress() +" ");

				JOptionPane.showMessageDialog(new JFrame(),
						"\n " + " Route Name :\n  " + Data.getRoute(rRouteListDetails.getSelectedValue()).getRouteName()
								+ " \n" + "\n " + " Full Address :\n  "
								+ Data.getRoute(rRouteListDetails.getSelectedValue()).getFullAddress() + " \n" + "\n "
								+ " Distance in KM :\n  "
								+ Data.getRoute(rRouteListDetails.getSelectedValue()).getDistanceInKm() + " Kms  \n"
								+ "\n " + " Earnings :\n  "
								+ Finanance.getTripCoast(
										Data.getRoute(rRouteListDetails.getSelectedValue()).getDistanceInKm())[0]
								+ "  \n" + "-----------------------------------------------------------",
						"Details on Selected Route .... ", JOptionPane.INFORMATION_MESSAGE);

			}
		});
		btnViewRoutesInfo.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(btnViewRoutesInfo);

		JButton btnModifyRoute = new JButton("Modify Route");
		btnModifyRoute.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				Data.getRoute( list .getSelectedValue() );
				JOptionPane.showInputDialog(btnModifyRoute, e, getTitle(), ABORT);
			}
		});
		btnModifyRoute.setFont(new Font("Tahoma", Font.ITALIC, 15));
		panel_1.add(btnModifyRoute);

		JPanel pnlCarDetails = new JPanel();
		pnlTab.addTab("Car Details", null, pnlCarDetails, null);
		pnlCarDetails.setLayout(new BorderLayout(0, 0));

		listCarDetailsListDLM = new DefaultListModel<String>();
		listCarDetailsList = new JList<String>(listCarDetailsListDLM);
		pnlCarDetails.add(listCarDetailsList);

		JPanel panel_1_1 = new JPanel();
		pnlCarDetails.add(panel_1_1, BorderLayout.SOUTH);

		JButton btnDelCar = new JButton("Delete Car");
		btnDelCar.setFont(new Font("Tahoma", Font.ITALIC, 15));
		panel_1_1.add(btnDelCar);

		JButton btnViewCar = new JButton("View Car details");
		btnViewCar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Car c = Data.getCarNumber(listCarDetailsList.getSelectedValue());
				JOptionPane.showMessageDialog(new JFrame(),
						"\n " + " Car Number Plate:\n  " + c.getNumberPlate() + " \n" + "\n " + " Capacity :\n  "
								+ c.getCapacity() + " \n" + "\n " + " Milage :\n  " + c.getMailage() + " Km/ltr  \n"
								+ "\n " + " TripCounts :\n  " + c.tripCount() + "  \n"
								+ "-----------------------------------------------------------",
						"Car No. " + c.getNumberPlate() + " Details .... ", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnViewCar.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1_1.add(btnViewCar);

		JButton btnModifyCar = new JButton("Modify Car");
		btnModifyCar.setFont(new Font("Tahoma", Font.ITALIC, 15));
		panel_1_1.add(btnModifyCar);

		JPanel pnlMoneyPanel = new JPanel();
		pnlMoneyPanel.setBackground(new Color(72, 61, 139));
		pnlTab.addTab("Finance Tab", null, pnlMoneyPanel, null);

		pnlLog = new JPanel();
		pnlLog.setBackground(new Color(152, 251, 152));
		contentPane.add(pnlLog, BorderLayout.SOUTH);
		pnlLog.setLayout(new BorderLayout(0, 0));

		lblLog = new JLabel("Good Buisnes :)         ");
		lblLog.setForeground(new Color(72, 61, 139));
		lblLog.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLog.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pnlLog.add(lblLog, BorderLayout.CENTER);

		reloadDashCompanyGUI();
	}

	public void loadTripsListDash() {

		tripsDashList.clear();
		tripsDashList.addAll(Data.getTripsInfoAsList());

	}

	void reloadDashCompanyGUI() {
		reloadRouteListView();
		reloadCarListView();
		loadTripsListDash();
		lblTripCounts.setText(Trip.tripCount + "");
		lblTaxesAndCess.setText(String.valueOf(Finanance.getTAX() + Finanance.getCESS()));
		lblBnkBal.setText(String.valueOf(Finanance.getBANKBALANCE()));
		lblCustomerCount.setText(String.valueOf(Customer.getCustomerCount()));
		lblRouteCount.setText(String.valueOf(Route.getRouteCount()));
		lblCarCount.setText(String.valueOf(String.valueOf(Car.carCount())));
		this.repaint();
	}
	

	void reloadRouteListView() {
		rRouteListDetailsDML.removeAllElements();
		rRouteListDetailsDML.addAll(Data.getRouteNameList());
	}

	void reloadCarListView() {
		listCarDetailsListDLM.removeAllElements();
		listCarDetailsListDLM.addAll(Data.getCarNumberAsList());
	}

	private void logManager(String s, boolean b) {
		if (b) {
			lblLog.setText(s + "  ");
			pnlLog.setBackground(Color.green);
		} else {
			lblLog.setText(s + "  ");
			pnlLog.setBackground(Color.red);
		}
	}

	private boolean isValidRoute() {
		if (inpRName.getText().trim().equals("") || inpRAddress.getText().trim().equals("")
				|| inpRDistance.getText().trim().equals(""))
			return false;
		
		if(DataBaseFunctions.RouteExists(inpRName.getText().trim()))
			return false;

		if (Integer.valueOf(inpRDistance.getText().trim()) < 1)
			return false;

		if (Data.routeExists(inpRName.getText()))
			return false;

		return true;

	}

	private boolean isValidCar() {

		if (inpCarName.getText().trim().equals("") || inpCapacity.getText().trim().equals("")
				|| inpMilage.getText().trim().equals("") || inpAvgSpeed.getText().trim().equals(""))
			return false;

		if (Integer.valueOf(inpCapacity.getText().trim()) < 1 || Integer.valueOf(inpMilage.getText().trim()) < 1
				|| Integer.valueOf(inpAvgSpeed.getText().trim()) < 1)
			return false;

		if (Data.carExists(inpCarName.getText()))
			return false;

		return true;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnAddRoute) {
			
			if (isValidRoute()) {
				Data.newRouteDB(inpRName.getText(), inpRAddress.getText(), Integer.valueOf(inpRDistance.getText()));
				inpRName.setText("");
				inpRAddress.setText("");
				inpRDistance.setText("");
				logManager("Added SucessFully..", true);
			} else {
				logManager("Invalid Input or The route already exits!", false);
				// invalid route JDilog
			}

		} else if (e.getSource() == btnNewCar) {
			if (isValidCar()) {
				Data.newCar(Integer.valueOf(inpCapacity.getText().trim()), inpCarName.getText(),
						Integer.valueOf(inpMilage.getText().trim()), Integer.valueOf(inpAvgSpeed.getText().trim()));
				logManager("New Car Addedd Sucessfully..", true);
			} else {
				logManager("Invalid Input or The car already exits!", false);
			}

		}
	}

}
