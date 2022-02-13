package playground;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class CustomerGUI extends JFrame{
	
	private JPanel view;
	private String userName;
	private String userPassword;
	
	CustomerGUI(){
		
	
		
		
		
		JPanel login = new JPanel();
		JTextPane userInput = new JTextPane();
	
		
		JLabel title = new JLabel("Something");
		login.add(userInput);
		
		super.setVisible(true);
		super.add(userInput);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}
	

}
