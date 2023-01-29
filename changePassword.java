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

public class changePassword {

	String path;
	JFrame changePassword;
	JFrame frame = new JFrame();
	private JTextField passwordTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					changePassword window = new changePassword();
					window.changePassword.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public changePassword() {
		initialize();
	}
	
	public void changeUserPassword() {
		
		boolean userExists = false;
		MaintainUser obj = new MaintainUser();
		
		
		
        path = "/Users/suryam/Desktop/user.csv";
		
		try {
			obj.load(path);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(int i = 0; i < obj.users.size(); i++) {
			if(obj.users.get(i).getName().equalsIgnoreCase(startUpScreen.currentUser)) {
				userExists = true;
			}
		}
		
		if(userExists == true) {
			for(int i = 0; i < obj.users.size(); i++) {
				if(obj.users.get(i).getName().equalsIgnoreCase(startUpScreen.currentUser)) {
					obj.users.get(i).password = passwordTextField.getText();
				}
			}
			
			
			try {
				obj.update(path);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(frame, "Password Changed Successfully. Please Log Back In With New Password", "Sucess", JOptionPane.PLAIN_MESSAGE);
			
			
			
			
			changePassword.dispose();
			startUpScreen s = new startUpScreen();
			s.startUpScreen.setVisible(true);
		}
		
		else {
			JOptionPane.showMessageDialog(frame, "User does not exist.", "Error", JOptionPane.PLAIN_MESSAGE);
			
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		changePassword = new JFrame();
		changePassword.getContentPane().setBackground(new Color(51, 0, 102));
		changePassword.setBounds(100, 100, 450, 300);
		changePassword.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		changePassword.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("New Password");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(105, 100, 91, 16);
		changePassword.getContentPane().add(lblNewLabel_2);
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(232, 95, 130, 26);
		changePassword.getContentPane().add(passwordTextField);
		passwordTextField.setColumns(10);
		
		JLabel notifyLabel = new JLabel("");
		notifyLabel.setBounds(176, 224, 61, 16);
		changePassword.getContentPane().add(notifyLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(0, 0, 450, 44);
		changePassword.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Change Password");
		lblNewLabel.setBounds(168, 6, 110, 16);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 51));
		panel_1.setBounds(0, 224, 450, 48);
		changePassword.getContentPane().add(panel_1);
		
		JButton updateButton = new JButton("Update");
		updateButton.setBounds(189, 148, 88, 29);
		changePassword.getContentPane().add(updateButton);
		updateButton.setForeground(Color.BLACK);
		updateButton.setBackground(Color.WHITE);
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				changeUserPassword();
				
			}
		});
		
		
	}

}
