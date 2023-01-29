import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;

public class systemLogin {

	JFrame systemLogin;
	static String system;
	JFrame frame = new JFrame("Error");
	private JTextField keyTextField;
	private JTextField passwordTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					systemLogin window = new systemLogin();
					window.systemLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public systemLogin() {
		initialize();
	}
	
	public void logIn() {
		
		if(keyTextField.getText().equalsIgnoreCase("suryam") && passwordTextField.getText().equalsIgnoreCase("pass")) {
			system = "suryam";
			systemLogin.dispose();
			mainSystem mS = new mainSystem();
			mS.mainSystem.setVisible(true);
		}
		
		else {
			JOptionPane.showMessageDialog(frame, "Incorrect username/password. Please try again."); 
		}
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		systemLogin = new JFrame();
		systemLogin.getContentPane().setBackground(new Color(51, 0, 102));
		systemLogin.setBounds(100, 100, 450, 300);
		systemLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		systemLogin.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("System Login");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(183, 0, 91, 16);
		systemLogin.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Master Key:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(88, 101, 83, 16);
		systemLogin.getContentPane().add(lblNewLabel_1);
		
		keyTextField = new JTextField();
		keyTextField.setBounds(212, 96, 130, 26);
		systemLogin.getContentPane().add(keyTextField);
		keyTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Master Password");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(88, 139, 117, 16);
		systemLogin.getContentPane().add(lblNewLabel_2);
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(212, 134, 130, 26);
		systemLogin.getContentPane().add(passwordTextField);
		passwordTextField.setColumns(10);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				logIn();
				
			}
		});
		loginButton.setBounds(157, 167, 117, 29);
		systemLogin.getContentPane().add(loginButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(0, 0, 450, 40);
		systemLogin.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 51));
		panel_1.setBounds(0, 232, 450, 40);
		systemLogin.getContentPane().add(panel_1);
		panel_1.setLayout(null);
	}

}
