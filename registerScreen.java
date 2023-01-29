import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;  // Import the File class
import java.io.IOException;
import java.awt.Color;
import javax.swing.JPanel;


public class registerScreen {
	
	public String path;
	
	JFrame frame = new JFrame("Error");
	

	JFrame registerScreen;
	private JTextField userNameTextField;
	private JTextField passwordTextField;
	private JTextField emailTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registerScreen window = new registerScreen();
					window.registerScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public registerScreen() {
		initialize();
	}
	
	public void register() {
		
		path = "/Users/suryam/Desktop/user.csv";
		MaintainUser obj = new MaintainUser();
		
		try {
			obj.load(path);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		boolean usernameExists = false;
		boolean emailExists = false;
		
		
		for(int i = 0; i < obj.users.size(); i++) {
			
			if(obj.users.get(i).getName().equalsIgnoreCase(userNameTextField.getText())) {
				usernameExists = true;
				break;
			}
			
			if(obj.users.get(i).getEmail().equalsIgnoreCase(emailTextField.getText())) {
				emailExists = true;
				break;
			}
			
		}
		
		if(usernameExists == true) {
			JOptionPane.showMessageDialog(frame, "Username already exists. Please pick a different one.", "Error", JOptionPane.PLAIN_MESSAGE);
			
			
		}
		
		if(emailExists == true) {
			JOptionPane.showMessageDialog(frame, "An account with this email already exists.", "Error", JOptionPane.PLAIN_MESSAGE);
			
		
		}
		
		else {
			String userName = userNameTextField.getText();
			String pathName = "/Users/suryam/Desktop/" + userName + ".csv";
			File file = new File(pathName);
			try {
				file.createNewFile();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			User user = new User();
			user.setName(userNameTextField.getText());
			user.setEmail(emailTextField.getText());
			user.setPassword(passwordTextField.getText());
			user.setId(obj.users.size()+1);
			user.setPath(pathName);
			
			
			obj.users.add(user);
		
			try {
				obj.update(path);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(frame, "Account created Sucessfully.", "Sucess", JOptionPane.PLAIN_MESSAGE);
			
			
			registerScreen.dispose();
			startUpScreen s = new startUpScreen();
			s.startUpScreen.setVisible(true);
			
		}
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		registerScreen = new JFrame();
		registerScreen.getContentPane().setBackground(new Color(51, 0, 102));
		registerScreen.setBounds(100, 100, 450, 300);
		registerScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		registerScreen.getContentPane().setLayout(null);
		
		JLabel registerLabel = new JLabel("Registration");
		registerLabel.setForeground(Color.WHITE);
		registerLabel.setBounds(183, 0, 85, 16);
		registerScreen.getContentPane().add(registerLabel);
		
		JLabel userNameLabel = new JLabel("Enter Username: ");
		userNameLabel.setForeground(Color.WHITE);
		userNameLabel.setBounds(79, 62, 106, 16);
		registerScreen.getContentPane().add(userNameLabel);
		
		JLabel passwordLabel = new JLabel("Enter Password: ");
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setBounds(79, 103, 106, 16);
		registerScreen.getContentPane().add(passwordLabel);
		
		userNameTextField = new JTextField();
		userNameTextField.setBounds(197, 57, 130, 26);
		registerScreen.getContentPane().add(userNameTextField);
		userNameTextField.setColumns(10);
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(197, 98, 130, 26);
		registerScreen.getContentPane().add(passwordTextField);
		passwordTextField.setColumns(10);
		
		JLabel accountCreatedLabel = new JLabel("");
		accountCreatedLabel.setBounds(105, 241, 280, 16);
		registerScreen.getContentPane().add(accountCreatedLabel);
		
		JButton registerButton = new JButton("Create Account");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				register();
				
			}
		});
		registerButton.setBounds(157, 169, 130, 29);
		registerScreen.getContentPane().add(registerButton);
		
		JLabel emailLabel = new JLabel("Enter Email: ");
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setBounds(79, 141, 106, 16);
		registerScreen.getContentPane().add(emailLabel);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(197, 136, 130, 26);
		registerScreen.getContentPane().add(emailTextField);
		emailTextField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(0, 0, 450, 40);
		registerScreen.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 51));
		panel_1.setBounds(0, 232, 450, 40);
		registerScreen.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		
	}

}
