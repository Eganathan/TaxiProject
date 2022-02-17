import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NewCustomerGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField inpNewCustomer;
	private JTextField inpNewCustomerPassword;
	private JTextField inpLoadCash;
	private JTextField textField_3;

	public NewCustomerGUI() {
		setTitle("Create Your Account ");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(72, 61, 139));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		inpNewCustomer = new JTextField();
		inpNewCustomer.setBounds(229, 42, 166, 20);
		contentPanel.add(inpNewCustomer);
		inpNewCustomer.setColumns(10);
		
		inpNewCustomerPassword = new JTextField();
		inpNewCustomerPassword.setColumns(10);
		inpNewCustomerPassword.setBounds(229, 82, 166, 20);
		contentPanel.add(inpNewCustomerPassword);
		
		inpLoadCash = new JTextField();
		inpLoadCash.setColumns(10);
		inpLoadCash.setBounds(229, 127, 166, 20);
		contentPanel.add(inpLoadCash);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(229, 174, 166, 20);
		contentPanel.add(textField_3);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(20, 45, 199, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(20, 85, 199, 14);
		contentPanel.add(lblPassword);
		
		JLabel lblNewLabel_1_1 = new JLabel("Load Cash");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(20, 130, 199, 14);
		contentPanel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("XBNX5");
		lblNewLabel_1_1_1.setOpaque(true);
		lblNewLabel_1_1_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(new Color(75, 0, 130));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 52));
		lblNewLabel_1_1_1.setBounds(10, 177, 199, 14);
		contentPanel.add(lblNewLabel_1_1_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						boolean b = Data.newCustomer(inpNewCustomer.getText(),Integer.valueOf(inpLoadCash.getText()), inpNewCustomerPassword.getText()); 
						
						if(b)
						{
							JOptionPane.showMessageDialog(Main.cGUI, "Created Succesfully, please login to continue. ", "Sucessfull ", JOptionPane.INFORMATION_MESSAGE);
							inpNewCustomer.setText(""); inpLoadCash.setText(""); inpNewCustomerPassword.setText("");
						}else {
							JOptionPane.showMessageDialog(Main.cGUI, "Please Check your credentials! \n User may already exist please try again with other name. ", "Invalid Details", JOptionPane.ERROR_MESSAGE);
							inpNewCustomer.setText(""); inpLoadCash.setText(""); inpNewCustomerPassword.setText("");
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
