import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Fram extends JFrame implements ActionListener{
	private static final long serialVersionUID = 7488079262518628223L;
	private JPanel contentPane ,loginPane ,mainPanel;
	private JTextField userNameInput;
	private JPasswordField passwordInput;
	
	private JButton clear,loginBtn ;

	/**
	 * Create the frame.
	 */
	public Fram() {
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
		
		JLabel titleLabel = new JLabel("ZGS Taxi Service");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		titleLabel.setForeground(SystemColor.text);
		mainPanel.add(titleLabel, BorderLayout.NORTH);
		
		
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
		
		clear = new JButton("Clear");
		loginPane.add(clear);
		clear.addActionListener(this);
		
		loginBtn = new JButton("Login");
		loginBtn.addActionListener(this);
		loginPane.add(loginBtn);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == clear)
		{
			passwordInput.setText("");
			userNameInput.setText("");
			System.out.println("Cleard!");
			
		}else if(e.getSource() == loginBtn)
		{
			@SuppressWarnings("deprecation")
			Customer curCustomer = Data.getCustomer(userNameInput.getText(), passwordInput.getText());
			if(curCustomer != null)
			{
				new CustomerApp(curCustomer).setVisible(true);
				super.setVisible(false);
			}

		}
		
	}

}
