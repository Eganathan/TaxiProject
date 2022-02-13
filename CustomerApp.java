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

public class CustomerApp extends JFrame {

	private Customer cUser;
	private JPanel contentPane;
	private JTable tblPastTrips;
	private JTextField inputSearchBar;
	
	public CustomerApp(Customer cCustomer)
	{
		cUser = cCustomer;
		setTitle("ZGS Taxi Land");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 491);
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
		
		JLabel customerNameLabel = new JLabel("Hi! "+cUser.getCustomerName());
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
		
		JLabel balanceInfoLabel = new JLabel("Cash: "+String.valueOf(cUser.getBalanceCash()));
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
		tabbedPane.setBounds(0, -29, 391, 413);
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
		pnlNewTripTop.add(inputSearchBar, BorderLayout.CENTER);
		inputSearchBar.setColumns(10);
		
		JPanel pnlBtmOfTop = new JPanel();
		pnlNewTripTop.add(pnlBtmOfTop, BorderLayout.SOUTH);
		pnlBtmOfTop.setLayout(new GridLayout(2, 1, 0, 0));
		
		DefaultListModel<String> lm = new DefaultListModel<String>();
		lm.addAll(Data.getRouteNameList());
		
		JList<String> list = new JList<String>(lm);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		pnlBtmOfTop.add(list);
		
		
		JButton btnRequesTrip = new JButton("Request Trip");
		btnRequesTrip.setForeground(new Color(0, 0, 0));
		btnRequesTrip.setFont(new Font("Segoe UI Historic", Font.BOLD, 15));
		btnRequesTrip.setBackground(new Color(154, 205, 50));
		pnlBtmOfTop.add(btnRequesTrip);
		
		JLabel lblNewLabel_3 = new JLabel("                                                                      ");
		pnlNewTripTop.add(lblNewLabel_3, BorderLayout.NORTH);
		
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
			public void actionPerformed(ActionEvent e){
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
			public void actionPerformed(ActionEvent e){
				tabbedPane.setSelectedIndex(2);
			}
		});
		leftPanel.add(loadCashBtn);
		
		JButton btnPreviousTrips = new JButton("Previous Trips");
		btnPreviousTrips.setForeground(Color.WHITE);
		btnPreviousTrips.setBackground(new Color(75, 0, 130));
		btnPreviousTrips.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				tabbedPane.setSelectedIndex(3);
			}
		});
		leftPanel.add(btnPreviousTrips);
		
		JButton btnAccSettings = new JButton("Account Settings");
		btnAccSettings.setForeground(Color.WHITE);
		btnAccSettings.setBackground(new Color(75, 0, 130));
		btnAccSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				tabbedPane.setSelectedIndex(4);
			}
		});
		leftPanel.add(btnAccSettings);
		
		JButton btnLogOut = new JButton("LogOut");
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setBackground(new Color(75, 0, 130));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				tabbedPane.setSelectedIndex(5);
			}
		});
		leftPanel.add(btnLogOut);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(new Color(75, 0, 130));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		leftPanel.add(btnExit);
	}
}
