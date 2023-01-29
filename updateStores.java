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

public class updateStores {

	JFrame updateStores;
	String path;
	String path1;
	JFrame frame = new JFrame("Error");
	private JTextField locationTextField;
	private JTextField openingHoursTextField;
	private JTextField closingHoursTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateStores window = new updateStores();
					window.updateStores.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public updateStores() {
		initialize();
	}
	
	public void remove() {
		 boolean storeExists = false;
			
			MaintainStore obj = new MaintainStore();
			
			MaintainItem obj1 = new MaintainItem();
			
			
			path = "/Users/suryam/Desktop/store.csv";
			
			path1 = "/Users/suryam/Desktop/item.csv";
			
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
			
			if(managerLogin.currentManager != null) {
				JOptionPane.showMessageDialog(frame, "Only an Admin can Remove A Store."); 
			}
			
			else {
				

				for(int i = 0; i < obj.stores.size(); i++) {
					if(obj.stores.get(i).getLocation().equalsIgnoreCase(locationTextField.getText())) {
						storeExists = true;
						obj.stores.remove(i);
						break;
					}
				}
				
				if(storeExists == true) {
					JOptionPane.showMessageDialog(frame, "Store removed succesfully."); 
					
					try {
						obj.update(path);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					for(int i = 0; i < obj1.items.size(); i++) {
						if(obj1.items.get(i).getLocation().equalsIgnoreCase(locationTextField.getText())) {
							obj1.items.remove(i);
						}
					}
					
					try {
						obj1.update(path1);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
				
				else {
					JOptionPane.showMessageDialog(frame, "Store does not exist."); 
				}
				
			}
	}
	
	public void update() {
		 boolean storeExists = false;
			
			MaintainStore obj = new MaintainStore();
			
			path = "/Users/suryam/Desktop/store.csv";
			
			try {
				obj.load(path);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			if(managerLogin.currentManager == null) {
            for(int i = 0; i < obj.stores.size(); i++) {
					
					if(obj.stores.get(i).getLocation().equalsIgnoreCase(locationTextField.getText())) {
						storeExists = true;
						
						if(closingHoursTextField.getText().isBlank() == false) {
							obj.stores.get(i).setClosingHours(closingHoursTextField.getText());
						}
						
						if(openingHoursTextField.getText().isBlank() == false) {
							obj.stores.get(i).setOpeningHours(openingHoursTextField.getText());
						}
						
					}
					
					
				}
				
				if(storeExists == true) {
					JOptionPane.showMessageDialog(frame, "Store info updated succesfully."); 
					
					try {
						obj.update(path);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				else {
					JOptionPane.showMessageDialog(frame, "Store does not exist."); 
				}
			}
			
			else if(managerLogin.currentManagerLocation.equalsIgnoreCase(locationTextField.getText())) {
                   for(int i = 0; i < obj.stores.size(); i++) {
					
					if(obj.stores.get(i).getLocation().equalsIgnoreCase(locationTextField.getText())) {
						storeExists = true;
						
						if(closingHoursTextField.getText().isBlank() == false) {
							obj.stores.get(i).setClosingHours(closingHoursTextField.getText());
						}
						
						if(openingHoursTextField.getText().isBlank() == false) {
							obj.stores.get(i).setOpeningHours(openingHoursTextField.getText());
						}
						
					}
					
					
				}
				
				if(storeExists == true) {
					JOptionPane.showMessageDialog(frame, "Store info updated succesfully."); 
					
					try {
						obj.update(path);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				else {
					JOptionPane.showMessageDialog(frame, "Store does not exist."); 
				}
				
			
			}
			
			else {
				JOptionPane.showMessageDialog(frame, "A Manager Can Only Update Their Assigned Store's Hours"); 
			}
	}
	
	public void add() {
		boolean storeExists = false;
		
		MaintainStore obj = new MaintainStore();
		
		path = "/Users/suryam/Desktop/store.csv";
		
		try {
			obj.load(path);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(managerLogin.currentManager != null) {
			JOptionPane.showMessageDialog(frame, "Only an Admin can Add A Store."); 
		}
		
		else {
			
			for(int i = 0; i < obj.stores.size(); i++) {
				if(obj.stores.get(i).getLocation().equalsIgnoreCase(locationTextField.getText())) {
					storeExists = true;
					break;
				}
			}
			
			if(storeExists == false) {
				Store store = new Store();
				store.setLocation(locationTextField.getText());
				store.setOpeningHours(openingHoursTextField.getText());
				store.setClosingHours(closingHoursTextField.getText());
				obj.stores.add(store);
				

				try {
					obj.update(path);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(frame, "Store added succesfully."); 
			}
			
			else {
				JOptionPane.showMessageDialog(frame, "Store already Exists."); 
			}
			
		}
		
	}
	
	public void mainSystem() {
		updateStores.dispose();
		mainSystem mS = new mainSystem();
		mS.mainSystem.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		updateStores = new JFrame();
		updateStores.getContentPane().setBackground(new Color(51, 0, 102));
		updateStores.setBounds(100, 100, 450, 300);
		updateStores.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		updateStores.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Store Location");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(86, 89, 90, 16);
		updateStores.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Store Opening Hours");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(86, 115, 131, 16);
		updateStores.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Store Closing Hours");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(86, 143, 131, 16);
		updateStores.getContentPane().add(lblNewLabel_3);
		
		locationTextField = new JTextField();
		locationTextField.setBounds(229, 79, 130, 26);
		updateStores.getContentPane().add(locationTextField);
		locationTextField.setColumns(10);
		
		openingHoursTextField = new JTextField();
		openingHoursTextField.setBounds(229, 110, 130, 26);
		updateStores.getContentPane().add(openingHoursTextField);
		openingHoursTextField.setColumns(10);
		
		closingHoursTextField = new JTextField();
		closingHoursTextField.setBounds(229, 138, 130, 26);
		updateStores.getContentPane().add(closingHoursTextField);
		closingHoursTextField.setColumns(10);
		
		JButton removeButton = new JButton("Remove");
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			remove();
              
				
			}
		});
		removeButton.setBounds(17, 184, 117, 29);
		updateStores.getContentPane().add(removeButton);
		
		JButton updateButton = new JButton("Update");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
              
				
				update();
				
			}
		});
		updateButton.setBounds(174, 184, 117, 29);
		updateStores.getContentPane().add(updateButton);
		
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				add();
				
				
			}
		});
		addButton.setBounds(327, 184, 117, 29);
		updateStores.getContentPane().add(addButton);
		
		JButton mainSystemButton = new JButton("Main System");
		mainSystemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			mainSystem();
				
			}
		});
		mainSystemButton.setBounds(333, 39, 117, 24);
		updateStores.getContentPane().add(mainSystemButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(0, 0, 450, 40);
		updateStores.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Updates Stores");
		lblNewLabel.setBounds(181, 6, 105, 16);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 51));
		panel_1.setBounds(0, 232, 450, 40);
		updateStores.getContentPane().add(panel_1);
		panel_1.setLayout(null);
	}

}
