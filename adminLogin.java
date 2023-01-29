import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;

public class adminLogin {

	JFrame adminLogin;
   String path;
	JFrame frame = new JFrame("Error");
	static String currentAdmin;
	private JTextField usernameTextField;
	private JTextField passwordTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminLogin window = new adminLogin();
					window.adminLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public adminLogin() {
		initialize();
	}
	
	public void logIn() {
		
		 MaintainAdmin obj = new MaintainAdmin();
			
			path = "/Users/suryam/Desktop/admin.csv";
			boolean userExists = false;
			
			try {
				obj.load(path);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			for(int i = 0; i < obj.admins.size(); i++) {
				if(obj.admins.get(i).getName().equalsIgnoreCase(usernameTextField.getText()) && obj.admins.get(i).getPassword().equalsIgnoreCase(passwordTextField.getText())) {
					currentAdmin = usernameTextField.getText();
					userExists = true;
					break;
		}
				
			}
			

			if(userExists == true) {
				adminLogin.dispose();
				mainSystem mS = new mainSystem();
				mS.mainSystem.setVisible(true);
			
			}
			
			else {
				JOptionPane.showMessageDialog(frame, "Incorrect username/password. Please try again.", "Error", JOptionPane.PLAIN_MESSAGE);
			
				
			}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		adminLogin = new JFrame();
		adminLogin.getContentPane().setForeground(new Color(51, 0, 102));
		adminLogin.getContentPane().setBackground(new Color(51, 0, 102));
		adminLogin.setBounds(100, 100, 450, 300);
		adminLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminLogin.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Login");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(178, 0, 88, 16);
		adminLogin.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Admin Username");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(79, 81, 107, 16);
		adminLogin.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Admin Password");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(79, 135, 107, 16);
		adminLogin.getContentPane().add(lblNewLabel_2);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(198, 76, 130, 26);
		adminLogin.getContentPane().add(usernameTextField);
		usernameTextField.setColumns(10);
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(198, 130, 130, 26);
		adminLogin.getContentPane().add(passwordTextField);
		passwordTextField.setColumns(10);
		
		JButton loginButton = new JButton("Login");
		loginButton.setForeground(Color.BLACK);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
              
				logIn();
             
				
			}
		});
		loginButton.setBounds(162, 175, 117, 29);
		adminLogin.getContentPane().add(loginButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(0, 0, 450, 40);
		adminLogin.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 51));
		panel_1.setBounds(0, 232, 450, 40);
		adminLogin.getContentPane().add(panel_1);
		panel_1.setLayout(null);
	}

}
