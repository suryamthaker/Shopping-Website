import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;

public class changeUserName {
	
	String path;
	String path1;
	JFrame frame = new JFrame();
	JFrame changeUserName;
	private JTextField newUsernameTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					changeUserName window = new changeUserName();
					window.changeUserName.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public changeUserName() {
		initialize();
	}
	
	public void changeUN() {
		
		MaintainUser obj = new MaintainUser();
		
		
		path = "/Users/suryam/Desktop/user.csv";
		
		try {
			obj.load(path);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		boolean usernameExists = false;
		
		for(int i = 0; i < obj.users.size(); i++) {
			if(obj.users.get(i).getName().equalsIgnoreCase(newUsernameTextField.getText())) {
				usernameExists = true;
				break;
			}
		}
		if (usernameExists == false) {
			
			String newUserName = newUsernameTextField.getText();
			String newPath = "/Users/suryam/Desktop/";
			String csv = ".csv";
			String newFilePath = newPath + newUserName + csv;
			
			
			for(int i = 0; i < obj.users.size(); i++) {
				if(obj.users.get(i).getName().equalsIgnoreCase(startUpScreen.currentUser)) {
					obj.users.get(i).setName(newUsernameTextField.getText());;
					obj.users.get(i).setPath(newFilePath);
							}
			}
			
			
			
			
			File file = new File(startUpScreen.currentUserPath);
			
			 File rename = new File(newFilePath);
			 
			 file.renameTo(rename);
			 
			 
			
			JOptionPane.showMessageDialog(frame, "Username Changed Successfully. Please Log Back In With New Username.", "Sucess", JOptionPane.PLAIN_MESSAGE);
			try {
				obj.update(path);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			changeUserName.dispose();
			startUpScreen s = new startUpScreen();
			s.startUpScreen.setVisible(true);
			
		}
		
		else {
			JOptionPane.showMessageDialog(frame, "Username already exists.", "Error", JOptionPane.PLAIN_MESSAGE);
			
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		changeUserName = new JFrame();
		changeUserName.getContentPane().setBackground(new Color(51, 0, 102));
		changeUserName.setBounds(100, 100, 450, 300);
		changeUserName.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		changeUserName.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Change Username");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(176, 0, 134, 16);
		changeUserName.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("New Username");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(85, 93, 122, 16);
		changeUserName.getContentPane().add(lblNewLabel_2);
		
		newUsernameTextField = new JTextField();
		newUsernameTextField.setBounds(219, 88, 130, 26);
		changeUserName.getContentPane().add(newUsernameTextField);
		newUsernameTextField.setColumns(10);
		
		JLabel notifyLabel = new JLabel("");
		notifyLabel.setBounds(6, 210, 427, 16);
		changeUserName.getContentPane().add(notifyLabel);
		
		JButton updateButton = new JButton("Update");
		updateButton.setBackground(Color.WHITE);
		updateButton.setForeground(Color.BLACK);
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				changeUN();
			}
		});
		updateButton.setBounds(155, 154, 117, 29);
		changeUserName.getContentPane().add(updateButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(0, 0, 450, 40);
		changeUserName.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 51));
		panel_1.setBounds(0, 232, 450, 40);
		changeUserName.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		
	}

}
