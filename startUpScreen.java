import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;



public class startUpScreen {
	
	JFrame frame = new JFrame("Error");
    String path;
	JFrame startUpScreen;
	static String currentUser;
	static String currentUserLocation;
	static String currentUserPath;
	JTextField userNameTextField;
	JTextField passwordTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					startUpScreen window = new startUpScreen();
					window.startUpScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public startUpScreen() {
		initialize();
	}
	
	
	public void logIn () {
		path = "/Users/suryam/Desktop/user.csv";
		boolean userExists = false;
		MaintainUser obj = new MaintainUser();
		
		
		
		try {
			obj.load(path);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(int i = 0; i < obj.users.size(); i++) {
			
			if(obj.users.get(i).getName().equalsIgnoreCase(userNameTextField.getText()) && obj.users.get(i).getPassword().equalsIgnoreCase(passwordTextField.getText())) {
				currentUser = userNameTextField.getText();
				currentUserLocation = obj.users.get(i).getLocation();
				currentUserPath = obj.users.get(i).getPath();
				userExists = true;
				break;
			}
			
		}
		
		if(userExists == true) {
			startUpScreen.dispose();
			userHome uH = new userHome();
			uH.userHome.setVisible(true);
			
		}
		
		else {
			JOptionPane.showMessageDialog(frame, "Incorrect username/password. Please try again."); 
		
			
		}
	}
	
	public void goToRegisterScreen() {
		
		startUpScreen.dispose();
		registerScreen regscreen = new registerScreen();
		regscreen.registerScreen.setVisible(true);
		
	}
	
	public void goToAdminScreen() {
		startUpScreen.dispose();
		adminLogin aL = new adminLogin();
		aL.adminLogin.setVisible(true);
	}
	
	public void goToSystemScreen() {
		startUpScreen.dispose();
		systemLogin sL = new systemLogin();
		sL.systemLogin.setVisible(true);
	}
	
	public void goToManagerScreen() {
		startUpScreen.dispose();
		managerLogin mS = new managerLogin();
		mS.managerLogin.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		startUpScreen = new JFrame();
		startUpScreen.getContentPane().setBackground(new Color(51, 0, 102));
		startUpScreen.setBounds(100, 100, 450, 300);
		startUpScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		userNameTextField = new JTextField();
		userNameTextField.setBounds(217, 66, 93, 26);
		userNameTextField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(144, 109, 61, 16);
		passwordLabel.setForeground(Color.WHITE);
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(217, 104, 93, 26);
		passwordTextField.setColumns(10);
		
		JButton LoginButton = new JButton("Login");
		LoginButton.setBounds(170, 128, 117, 29);
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				logIn();
				
			
			}
		});
		
		JLabel registerLabel = new JLabel("Don't have an account? Click the Register button to make an account.");
		registerLabel.setBounds(6, 157, 438, 16);
		registerLabel.setForeground(Color.WHITE);
		
		JLabel displayText = new JLabel("User Login");
		displayText.setBounds(184, 0, 82, 16);
		displayText.setForeground(Color.WHITE);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 125, 95);
		panel.setBackground(new Color(0, 0, 51));
		
		JButton ManagerLogin = new JButton("Manager Login");
		ManagerLogin.setBounds(0, 28, 125, 29);
		ManagerLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToManagerScreen();
			}
		});
		
		JLabel userNameLabel = new JLabel("Username");
		userNameLabel.setBounds(143, 71, 62, 16);
		userNameLabel.setForeground(Color.WHITE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(325, 0, 125, 98);
		panel_1.setBackground(new Color(0, 0, 51));
		
		JButton adminButton = new JButton("Admin Login");
		adminButton.setBounds(0, 32, 125, 29);
		adminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToAdminScreen();
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 177, 125, 95);
		panel_2.setBackground(new Color(0, 0, 51));
		
		JButton systemLogin = new JButton("System Login");
		systemLogin.setBounds(0, 30, 125, 29);
		systemLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToSystemScreen();
			}
		});
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(325, 177, 125, 95);
		panel_3.setBackground(new Color(0, 0, 51));
		
		JButton registerButton = new JButton("Register");
		registerButton.setBounds(0, 32, 125, 29);
		startUpScreen.getContentPane().setLayout(null);
		panel.setLayout(null);
		panel.add(ManagerLogin);
		startUpScreen.getContentPane().add(panel);
		startUpScreen.getContentPane().add(displayText);
		startUpScreen.getContentPane().add(userNameLabel);
		startUpScreen.getContentPane().add(userNameTextField);
		startUpScreen.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.add(adminButton);
		startUpScreen.getContentPane().add(passwordLabel);
		startUpScreen.getContentPane().add(passwordTextField);
		startUpScreen.getContentPane().add(LoginButton);
		startUpScreen.getContentPane().add(registerLabel);
		startUpScreen.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		panel_3.add(registerButton);
		startUpScreen.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		panel_2.add(systemLogin);
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				goToRegisterScreen();
				
				
			}
		});
		
		
	}
}
