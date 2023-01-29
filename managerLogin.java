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

public class managerLogin {

	JFrame managerLogin;
	JFrame frame = new JFrame("Error");
	String path;
	static String currentManager;
	static String currentManagerLocation;
	private JTextField usernameTextField;
	private JTextField passwordTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					managerLogin window = new managerLogin();
					window.managerLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public managerLogin() {
		initialize();
	}
	
	public void logIn() {
		MaintainManager obj = new MaintainManager();
		
		path = "/Users/suryam/Desktop/manager.csv";
		boolean userExists = false;
		
		try {
			obj.load(path);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(int i = 0; i < obj.managers.size(); i++) {
			if(obj.managers.get(i).getName().equalsIgnoreCase(usernameTextField.getText()) && obj.managers.get(i).getPassword().equalsIgnoreCase(passwordTextField.getText())) {
				currentManager = usernameTextField.getText();
				currentManagerLocation = obj.managers.get(i).getLocation();
				userExists = true;
				break;
	}
			
		}
		

		if(userExists == true) {
			managerLogin.dispose();
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
		managerLogin = new JFrame();
		managerLogin.getContentPane().setBackground(new Color(51, 0, 102));
		managerLogin.setBounds(100, 100, 450, 300);
		managerLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		managerLogin.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manager Login");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(166, 0, 106, 16);
		managerLogin.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Manager Username");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(81, 103, 119, 16);
		managerLogin.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Manager Password");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(81, 136, 119, 16);
		managerLogin.getContentPane().add(lblNewLabel_2);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(212, 98, 130, 26);
		managerLogin.getContentPane().add(usernameTextField);
		usernameTextField.setColumns(10);
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(212, 131, 130, 26);
		managerLogin.getContentPane().add(passwordTextField);
		passwordTextField.setColumns(10);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				logIn();
			}
		});
		loginButton.setBounds(155, 172, 117, 29);
		managerLogin.getContentPane().add(loginButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(0, 0, 450, 40);
		managerLogin.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 51));
		panel_1.setBounds(0, 232, 450, 40);
		managerLogin.getContentPane().add(panel_1);
		panel_1.setLayout(null);
	}

}
