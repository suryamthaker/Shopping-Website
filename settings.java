import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;

public class settings {

	JFrame settings;
	String filePath;
	JFrame frame = new JFrame("Error");
	String path;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					settings window = new settings();
					window.settings.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public settings() {
		initialize();
	}

	
	public void changeUserName() {
		
		settings.dispose();
		changeUserName c = new changeUserName();
		c.changeUserName.setVisible(true);
	}
	
	public void Security() {
		settings.dispose();
		security s = new security();
		s.security.setVisible(true);
	}
	
	public void storeLocation() {
		settings.dispose();
		setLocation sL = new setLocation();
	    sL.setLocation.setVisible(true);
	}
	
	public void requestPI() {
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
				JOptionPane.showMessageDialog(frame, "Username: " + obj.users.get(i).getName() + "\n" + "Password: " + obj.users.get(i).getPassword() + "\n" + "Email: " + obj.users.get(i).getEmail()); 						 
			}
		}
	}
	
	public void deleteAccount() {

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
					filePath = obj.users.get(i).getPath();
					obj.users.remove(obj.users.get(i));
					
					
					
				}
			}
			
			File file = new File(filePath);
			file.delete();
			
			
			try {
				obj.update(path);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			JOptionPane.showMessageDialog(frame, "Account Deleted", "Sucess", JOptionPane.PLAIN_MESSAGE);
			
			settings.dispose();
			startUpScreen sU = new startUpScreen();
			sU.startUpScreen.setVisible(true);
	}
	
	public void Home() {
		settings.dispose();
		userHome uH = new userHome();
		uH.userHome.setVisible(true);
	}
	
	public void changePassword() {
		settings.dispose();
		changePassword cP = new changePassword();
		cP.changePassword.setVisible(true);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		settings = new JFrame();
		settings.getContentPane().setBackground(new Color(51, 0, 102));
		settings.setBounds(100, 100, 450, 300);
		settings.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		settings.getContentPane().setLayout(null);
		
		JLabel settingsLabel = new JLabel("Settings");
		settingsLabel.setForeground(Color.WHITE);
		settingsLabel.setBounds(215, 0, 61, 16);
		settings.getContentPane().add(settingsLabel);
		
		JButton homelabel = new JButton("Home");
		homelabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home();
			}
		});
		homelabel.setBounds(333, 6, 117, 29);
		settings.getContentPane().add(homelabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(0, 0, 214, 272);
		settings.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton deleteButton = new JButton("Delete Account");
		deleteButton.setBounds(10, 222, 202, 29);
		panel.add(deleteButton);
		
		JButton requestButton = new JButton("Request Personal Information");
		requestButton.setBounds(0, 181, 214, 29);
		panel.add(requestButton);
		
		JButton storeButton = new JButton("Store Location");
		storeButton.setBounds(6, 144, 202, 29);
		panel.add(storeButton);
		
		JButton securityButton = new JButton("Security");
		securityButton.setBounds(6, 103, 202, 29);
		panel.add(securityButton);
		
		JButton changePasswordButton = new JButton("Change Password");
		changePasswordButton.setBounds(6, 60, 202, 29);
		panel.add(changePasswordButton);
		
		JButton updateButton = new JButton("Change Username");
		updateButton.setBounds(6, 19, 202, 29);
		panel.add(updateButton);
		
		JLabel imageLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/SS.png")).getImage();
		imageLabel.setIcon(new ImageIcon(img));
		
		imageLabel.setBounds(233, 63, 165, 154);
		settings.getContentPane().add(imageLabel);
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeUserName();
			}
		});
		changePasswordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				changePassword();
			}
		});
		securityButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Security();
			}
		});
		storeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				storeLocation();
			}
		});
		requestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				requestPI();
				
			}
		});
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				deleteAccount();
				
			}
		});
	}

}
