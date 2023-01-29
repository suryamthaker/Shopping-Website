import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;

public class mainSystem {

	JFrame mainSystem;
	String path;
	JFrame frame = new JFrame("Error");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainSystem window = new mainSystem();
					window.mainSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainSystem() {
		initialize();
	}
	
	public void adminPage() {
		
		 MaintainAdmin obj = new MaintainAdmin();
		 boolean adminClickedButton = false;
			
			path = "/Users/suryam/Desktop/admin.csv";
			
			try {
				obj.load(path);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			for(int i = 0; i < obj.admins.size(); i++) {
				if(obj.admins.get(i).getName().equalsIgnoreCase(adminLogin.currentAdmin)) {
					adminClickedButton = true;
					break;
				}
				
			}
			
			if(adminClickedButton == true) {
				mainSystem.dispose();
				adminPage aP = new adminPage();
				aP.adminPage.setVisible(true);
			}
			
			else {
				
				JOptionPane.showMessageDialog(frame, "Only an Admin is allowed access to Admin Page.", "Error", JOptionPane.PLAIN_MESSAGE);
			}
	}
	
	public void updateAdmins() {
		 if(systemLogin.system == "suryam") {
			  mainSystem.dispose();
			  updateAdmins uA = new updateAdmins();
			  uA.updateAdmins.setVisible(true);
		  }
		  
		  else if(systemLogin.system == null) {
			 
			  JOptionPane.showMessageDialog(frame, "Only the system is allowed access to update Admins.", "Error", JOptionPane.PLAIN_MESSAGE);
		  }
	}
	
	public void updateItems() {
		
		mainSystem.dispose();
		updateItems uI = new updateItems();
		uI.updateItems.setVisible(true);
	}
	
	public void updateStores() {
		mainSystem.dispose();
		updateStores uS = new updateStores();
		uS.updateStores.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainSystem = new JFrame();
		mainSystem.getContentPane().setBackground(new Color(51, 0, 102));
		mainSystem.setBounds(100, 100, 485, 300);
		mainSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainSystem.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Main System");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(204, 0, 91, 16);
		mainSystem.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(0, 0, 160, 272);
		mainSystem.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Admin Page");
		btnNewButton.setBounds(6, 16, 148, 29);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update Admins");
		btnNewButton_1.setBounds(6, 84, 148, 29);
		panel.add(btnNewButton_1);
		
		JButton updateItemsButton = new JButton("Update Items");
		updateItemsButton.setBounds(6, 154, 148, 29);
		panel.add(updateItemsButton);
		
		JButton updateStoresButton = new JButton("Update Stores");
		updateStoresButton.setBounds(6, 223, 148, 29);
		panel.add(updateStoresButton);
		
		JLabel imageLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/SS.png")).getImage();
		imageLabel.setIcon(new ImageIcon(img));
		
		imageLabel.setBounds(225, 49, 174, 166);
		mainSystem.getContentPane().add(imageLabel);
		
		JButton logOutButton = new JButton("Logout");
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mainSystem.dispose();
				startUpScreen sU = new startUpScreen();
				sU.startUpScreen.setVisible(true);
			}
		});
		logOutButton.setBounds(368, 0, 117, 29);
		mainSystem.getContentPane().add(logOutButton);
		updateStoresButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updateStores();
			}
		});
		updateItemsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updateItems();
				
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateAdmins();
			 
			
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				adminPage();
					
				
			}
		});
	}
}
