import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JPanel;

public class setLocation {

	JFrame setLocation;
	String path;
	String path1;
	String path2;
	String path3;
	JFrame frame = new JFrame();
	private JTextField storeLocationTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setLocation window = new setLocation();
					window.setLocation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public setLocation() {
		initialize();
	}
	
	public void Set() {
		
		MaintainUser obj = new MaintainUser();
		
		MaintainStore obj1 = new MaintainStore();
		
		MaintainItem cart = new MaintainItem();
		
		MaintainItem itemList = new MaintainItem();
		
		
		
		
		boolean storeExists = false;
		
		
        path = "/Users/suryam/Desktop/user.csv";
		
		path1 = "/Users/suryam/Desktop/store.csv";
		
		path2 = startUpScreen.currentUserPath;
		
		path3 = "/Users/suryam/Desktop/item.csv";
       
		
		try {
			obj.load(path);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			obj1.load(path1);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			cart.load(path2);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			itemList.load(path3);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		int newAvailability = 0;
		
		
		
		for(int i = 0; i < obj1.stores.size(); i++) {
			if(obj1.stores.get(i).getLocation().equalsIgnoreCase(storeLocationTextField.getText())) {
				storeExists = true;
				break;
			}
		}
		
		if(storeExists == true) {
			
			for(int i = 0; i < obj.users.size(); i++) {
				if(obj.users.get(i).getName().equalsIgnoreCase(startUpScreen.currentUser)) {
					obj.users.get(i).setLocation(storeLocationTextField.getText());
					
					try {
						obj.update(path);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(frame, "Store Location Set."); 
				}
			}
			
			
			if(cart.items.size() != 0) {
				
				for(int i = 0; i < itemList.items.size(); i++) {
					for(int j = 0; j < cart.items.size(); j++) {
						if(itemList.items.get(i).getName().equalsIgnoreCase(cart.items.get(j).getName()) && itemList.items.get(i).getLocation().equalsIgnoreCase(startUpScreen.currentUserLocation)) {
							newAvailability = cart.items.get(j).getAvailability() + itemList.items.get(i).getAvailability();
							itemList.items.get(i).setAvailability(newAvailability);
							cart.items.remove(cart.items.get(j));
							
							
							
						}
					}
				}
				
				
				try {
					cart.update(path2);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					itemList.update(path3);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
			
			
			setLocation.dispose();
			startUpScreen sS = new startUpScreen();
			sS.startUpScreen.setVisible(true);
			
		}
		
		else {
			JOptionPane.showMessageDialog(frame, "Store does not exist."); 
		}
		
	}
	
	public void Settings() {
		
		setLocation.dispose();
		settings s = new settings();
		s.settings.setVisible(true);
	}

	
	public void View() {
		
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
					JOptionPane.showMessageDialog(frame, "Current Location: " + obj.users.get(i).getLocation());
				}
			}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setLocation = new JFrame();
		setLocation.getContentPane().setForeground(Color.BLUE);
		setLocation.getContentPane().setBackground(new Color(51, 0, 102));
		setLocation.setBounds(100, 100, 450, 300);
		setLocation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Type Store Location");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(SystemColor.desktop);
		lblNewLabel_1.setBounds(95, 96, 124, 16);
		setLocation.getContentPane().add(lblNewLabel_1);
		
		storeLocationTextField = new JTextField();
		storeLocationTextField.setBackground(Color.WHITE);
		storeLocationTextField.setBounds(231, 91, 130, 26);
		setLocation.getContentPane().add(storeLocationTextField);
		storeLocationTextField.setColumns(10);
		
		JButton setButton = new JButton("Set");
		setButton.setBounds(155, 124, 117, 29);
		setButton.setBackground(Color.BLUE);
		setButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Set();
				
				
			}
		});
		setLocation.getContentPane().add(setButton);
		
		JButton settingsButton = new JButton("Settings");
		settingsButton.setBounds(333, 37, 117, 29);
		settingsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Settings();
				
			}
		});
		setLocation.getContentPane().add(settingsButton);
		
		JButton viewButton = new JButton("View ");
		viewButton.setBackground(SystemColor.desktop);
		viewButton.setBounds(155, 154, 117, 29);
		viewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
               View();
				
			}
		});
		setLocation.getContentPane().add(viewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(0, 0, 450, 40);
		setLocation.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("View/Set Store Location");
		lblNewLabel.setBounds(146, 0, 149, 16);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 51));
		panel_1.setBounds(0, 232, 450, 40);
		setLocation.getContentPane().add(panel_1);
		panel_1.setLayout(null);
	}
}
