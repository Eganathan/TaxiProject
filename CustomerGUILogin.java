import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomerGUILogin extends JFrame implements ActionListener {
	private static final long serialVersionUID = 7488079262518628223L;
	private JPanel contentPane, loginPane, mainPanel;
	private JTextField userNameInput;
	private JPasswordField passwordInput;

	private JButton newCustomer, loginBtn;
	private JPanel pnl_IMG;
	private JLabel lblNewLabel;
	private JPanel pnl_TOP;
	private JLabel titleLabel;
	private JButton btnEmployeeLogin;

	public CustomerGUILogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(72, 61, 139));
		contentPane.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BorderLayout(0, 0));

		JPanel loginPane = new JPanel();
		loginPane.setBackground(new Color(72, 61, 139));
		mainPanel.add(loginPane, BorderLayout.SOUTH);
		loginPane.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel userNameLable = new JLabel("User Name :");
		userNameLable.setForeground(new Color(255, 255, 255));
		userNameLable.setHorizontalAlignment(SwingConstants.CENTER);
		userNameLable.setFont(new Font("Tahoma", Font.PLAIN, 17));
		loginPane.add(userNameLable);

		userNameInput = new JTextField();
		loginPane.add(userNameInput);
		userNameInput.setColumns(10);

		JLabel passwordLbl = new JLabel("Password :");
		passwordLbl.setFont(new Font("Tahoma", Font.PLAIN, 17));
		passwordLbl.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLbl.setForeground(new Color(255, 255, 255));
		loginPane.add(passwordLbl);

		passwordInput = new JPasswordField();
		loginPane.add(passwordInput);

		newCustomer = new JButton("Create Account");
		newCustomer.setForeground(Color.BLACK);
		newCustomer.setBackground(Color.LIGHT_GRAY);
		loginPane.add(newCustomer);
		newCustomer.addActionListener(this);

		loginBtn = new JButton("Login");
		loginBtn.setForeground(Color.BLACK);
		loginBtn.setBackground(Color.LIGHT_GRAY);
		loginBtn.addActionListener(this);
		loginPane.add(loginBtn);

		pnl_IMG = new JPanel();
		pnl_IMG.setBackground(new Color(0, 191, 255));
		pnl_IMG.setForeground(new Color(0, 191, 255));
		mainPanel.add(pnl_IMG, BorderLayout.CENTER);
		pnl_IMG.setLayout(null);

		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(CustomerGUILogin.class.getResource("/img/movingCar.gif")));
		lblNewLabel.setBounds(0, 0, 639, 293);
		pnl_IMG.add(lblNewLabel);

		pnl_TOP = new JPanel();
		pnl_TOP.setBackground(new Color(72, 61, 139));
		mainPanel.add(pnl_TOP, BorderLayout.NORTH);
		pnl_TOP.setLayout(new BorderLayout(0, 0));

		titleLabel = new JLabel("ZGS Taxi Service");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		pnl_TOP.add(titleLabel);

		btnEmployeeLogin = new JButton("Employee");
		btnEmployeeLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				new CompanysGUI().setVisible(true);
			}
		});
		btnEmployeeLogin.setOpaque(false);
		btnEmployeeLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEmployeeLogin.setForeground(new Color(255, 255, 255));
		btnEmployeeLogin.setBackground(new Color(147, 112, 219));
		btnEmployeeLogin.setFont(new Font("Tahoma", Font.ITALIC, 11));
		pnl_TOP.add(btnEmployeeLogin, BorderLayout.EAST);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == newCustomer) {
			NewCustomerGUI dialog = new NewCustomerGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);

		} else if (e.getSource() == loginBtn) {
			@SuppressWarnings("deprecation")
			Customer curCustomer = Data.getCustomer(userNameInput.getText(), passwordInput.getText());
			if (curCustomer != null) {
				new CustomerApp(curCustomer).setVisible(true);
				super.setVisible(false);
			} else {

				JOptionPane.showMessageDialog(this, "Please Check your credentials! ", "Invalid Details",
						JOptionPane.ERROR_MESSAGE);
				passwordInput.setText("");
				userNameInput.setText("");
			}

		}

	}

}
