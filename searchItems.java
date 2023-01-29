import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;

public class searchItems {

	JFrame searchItems;
	JFrame frame = new JFrame();
	private JTextField nameTextField;
	private JTextField categoryTextField;
	String path;
	String userPath;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchItems window = new searchItems();
					window.searchItems.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public searchItems() {
		initialize();
	}
	
	public void searchItem() {
		
		MaintainItem obj = new MaintainItem();
		
		boolean itemExists = false;
		
		String itemInfo = "";
		
		 path = "/Users/suryam/Desktop/item.csv";
		
		try {
			obj.load(path);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(int i = 0; i < obj.items.size(); i++) {
			if(obj.items.get(i).getLocation().equalsIgnoreCase(startUpScreen.currentUserLocation) && obj.items.get(i).getName().equalsIgnoreCase(nameTextField.getText())) {
				
				itemExists = true;
				obj.items.get(i).setFrequency(obj.items.get(i).getFrequency()+1);
				
				try {
					obj.update(path);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				itemInfo += "Item Name: " + obj.items.get(i).getName();
				itemInfo += "\n";
				itemInfo += "Item Description: " + obj.items.get(i).getDescription();
				itemInfo += "\n";
				itemInfo += "Item Price: $" + obj.items.get(i).getPrice();
				itemInfo += "\n";
				itemInfo += "Item Size: " +obj.items.get(i).getSize() + " lb(s)";
				itemInfo += "\n";
				itemInfo += "Item Availability: " +obj.items.get(i).getAvailability();
				itemInfo += "\n";
				itemInfo += "Item Search Frequency: " +obj.items.get(i).getFrequency();
				
				
			}
		}
		
		if(itemExists == true) {
			JOptionPane.showMessageDialog(frame, itemInfo, nameTextField.getText().substring(0, 1).toUpperCase() + nameTextField.getText().substring(1).toLowerCase() +" Information", JOptionPane.PLAIN_MESSAGE);
		}
		
		else {
			JOptionPane.showMessageDialog(frame, "Item does not exist.", "Error", JOptionPane.PLAIN_MESSAGE);
			
		}
	}
	
	public void searchCatergory() {
		
		 MaintainItem obj = new MaintainItem();
			
			boolean atLeastOneItemExists = false;
			
			String items = "";
			
			ArrayList<Item> itemsInCategory = new ArrayList<Item>();
			
			 path = "/Users/suryam/Desktop/item.csv";
			
			try {
				obj.load(path);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			for(int i = 0; i < obj.items.size(); i++) {
				if(obj.items.get(i).getLocation().equalsIgnoreCase(startUpScreen.currentUserLocation) && obj.items.get(i).getCategory().equalsIgnoreCase(categoryTextField.getText())) {
					itemsInCategory.add(obj.items.get(i));
					atLeastOneItemExists = true;
					
				}
			}
			
			if(atLeastOneItemExists == true) {
			   for(int i = 0; i < itemsInCategory.size(); i++) {
				   items += "Name: " + itemsInCategory.get(i).getName();
				   items += "\n";
			   }
			   JOptionPane.showMessageDialog(frame, items);
			}
			
			else {
				
				JOptionPane.showMessageDialog(frame, "Category Does not exist at your selected store location.");
			}
	}
	
	public void Home() {
		searchItems.dispose();
		userHome uH = new userHome();
		uH.userHome.setVisible(true);
	}
	

	
	

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		searchItems = new JFrame();
		searchItems.getContentPane().setBackground(new Color(51, 0, 102));
		searchItems.setBounds(100, 100, 450, 300);
		searchItems.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		searchItems.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search Items");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(173, 0, 80, 16);
		searchItems.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Item Name");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(21, 86, 91, 16);
		searchItems.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Item Category");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(21, 124, 91, 16);
		searchItems.getContentPane().add(lblNewLabel_2);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(111, 81, 130, 26);
		searchItems.getContentPane().add(nameTextField);
		nameTextField.setColumns(10);
		
		categoryTextField = new JTextField();
		categoryTextField.setBounds(111, 119, 130, 26);
		searchItems.getContentPane().add(categoryTextField);
		categoryTextField.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(242, 81, 48, 26);
		searchItems.getContentPane().add(spinner);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(296, 0, 154, 272);
		searchItems.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton categoryButton = new JButton("Search Category");
		categoryButton.setBounds(0, 118, 151, 29);
		panel.add(categoryButton);
		
		
		
		JButton nameButton = new JButton("Search Item");
		nameButton.setBounds(0, 58, 151, 29);
		panel.add(nameButton);
		
		JButton removeButton = new JButton("Remove From Cart");
		removeButton.setBounds(0, 178, 151, 29);
		panel.add(removeButton);
		
		JButton addButton = new JButton("Add To Cart");
		addButton.setBounds(0, 237, 154, 29);
		panel.add(addButton);
		
		JButton homeButton = new JButton("Home");
		homeButton.setBounds(0, 6, 154, 29);
		panel.add(homeButton);
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home();
			}
		});
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				MaintainItem obj = new MaintainItem();
				MaintainItem obj1 = new MaintainItem();
				
				
				userPath = startUpScreen.currentUserPath;
				path = "/Users/suryam/Desktop/item.csv";
				
				boolean notEnough = false;
				boolean itemExists = false;
				boolean zero = false;
				boolean inCart = false;
				
				try {
					obj.load(path);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					obj1.load(userPath);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				int value = (Integer) spinner.getValue();
				double price = 0;
				int newAvailability = 0;
				
			
				
				for(int i = 0; i < obj.items.size(); i++) {
					if(obj.items.get(i).getLocation().equalsIgnoreCase(startUpScreen.currentUserLocation) && obj.items.get(i).getName().equalsIgnoreCase(nameTextField.getText())) {
						itemExists = true;
						price = obj.items.get(i).getPrice();
								
						if (value > obj.items.get(i).getAvailability()) {
							notEnough = true;
							break;
						}
						
						if(value == 0) {
							zero = true;
							break;
						}
						
						else {
							newAvailability = obj.items.get(i).getAvailability() - value;
							obj.items.get(i).setAvailability(newAvailability);
							try {
								obj.update(path);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
						
						}
				}
				
				if(itemExists == true && notEnough == false && zero == false) {
					
					
					for(int i = 0; i < obj1.items.size(); i++) {
						if (obj1.items.get(i).getName().equalsIgnoreCase(nameTextField.getText())) {
							inCart = true;
							newAvailability = obj1.items.get(i).getAvailability() + (Integer) spinner.getValue();
							obj1.items.get(i).setAvailability(newAvailability);
						}
						
						
					}
					
					if(inCart == false) {
						Item item = new Item();
						item.setLocation(startUpScreen.currentUserLocation);
						item.setPrice(price);
						item.setAvailability((Integer)spinner.getValue());
						item.setName(nameTextField.getText());
						obj1.items.add(item);
						
					}
					
					try {
						obj1.update(userPath);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(frame, "Item added to Cart.", "Sucess", JOptionPane.PLAIN_MESSAGE);
					
					
				}
				
				else if(itemExists == false) {
					JOptionPane.showMessageDialog(frame, "Item does not exist.", "Error", JOptionPane.PLAIN_MESSAGE);
				}
				
				else if (notEnough == true) {
					JOptionPane.showMessageDialog(frame, "The Amount You're Trying to purchase is more than the amount available.", "Error", JOptionPane.PLAIN_MESSAGE);
				}
				
				else if (zero == true) {
					JOptionPane.showMessageDialog(frame, "Please pick an amount of at least one.", "Error", JOptionPane.PLAIN_MESSAGE);
				}
				
			}
		});
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MaintainItem obj = new MaintainItem();
				MaintainItem obj1 = new MaintainItem();
				
				
				
				userPath = startUpScreen.currentUserPath;
				path = "/Users/suryam/Desktop/item.csv";
				
				boolean itemExists = false;
				boolean tooMuch = false;
				boolean zero = false;
				int value = (Integer) spinner.getValue();
				int newAvailability = 0;
				
				

				try {
					obj.load(path);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					obj1.load(userPath);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				for(int i = 0; i < obj1.items.size(); i++) {
					if(obj1.items.get(i).getLocation().equalsIgnoreCase(startUpScreen.currentUserLocation) && obj1.items.get(i).getName().equalsIgnoreCase(nameTextField.getText())) {
						itemExists = true;
						
						if(value == 0) {
							zero = true;
							break;
						}
						
						else if(value > obj1.items.get(i).getAvailability()) {
							tooMuch = true;
							break;
						}
						
						else if(value < obj1.items.get(i).getAvailability()) {
							newAvailability = obj1.items.get(i).getAvailability() - (Integer) spinner.getValue();
							obj1.items.get(i).setAvailability(newAvailability);
							
							
							for(int j =0; j < obj.items.size(); j++) {
								if(obj.items.get(j).getLocation().equalsIgnoreCase(startUpScreen.currentUserLocation) && obj.items.get(j).getName().equalsIgnoreCase(nameTextField.getText())) {
									newAvailability = obj.items.get(j).getAvailability() + (Integer) spinner.getValue();
									obj.items.get(j).setAvailability(newAvailability);
								}
							}
							
							
							try {
								obj1.update(userPath);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							try {
								obj.update(path);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							
						}
						
						else if (value == obj1.items.get(i).getAvailability()) {
							obj1.items.remove(obj1.items.get(i));
							
							for(int j =0; j < obj.items.size(); j++) {
								if(obj.items.get(j).getLocation().equalsIgnoreCase(startUpScreen.currentUserLocation) && obj.items.get(j).getName().equalsIgnoreCase(nameTextField.getText())) {
									newAvailability = obj.items.get(j).getAvailability() + (Integer) spinner.getValue();
									obj.items.get(j).setAvailability(newAvailability);
								}
							}
							
							
							try {
								obj1.update(userPath);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							try {
								obj.update(path);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						
						
					}
				}
				
				if(itemExists == true && tooMuch == false && zero == false) {
					JOptionPane.showMessageDialog(frame, "Item removed from cart", "Success", JOptionPane.PLAIN_MESSAGE);
				}
				
				if(itemExists == false) {
					JOptionPane.showMessageDialog(frame, "Item doesn't exist in cart", "Error", JOptionPane.PLAIN_MESSAGE);
				}
				
				else if(tooMuch == true) {
					JOptionPane.showMessageDialog(frame, "Please pick an amount of either less than or equal to the amount present in your cart.", "Error", JOptionPane.PLAIN_MESSAGE);
				}
				
				if(zero == true) {
					JOptionPane.showMessageDialog(frame, "Please pick an amount of at least one.", "Error", JOptionPane.PLAIN_MESSAGE);
				}
				
			}
		});
		nameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				searchItem();
				
			}
		});
		categoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
               
				searchCatergory();
				

				
			}
		});
		
		
	}
}
