import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import java.awt.Color;


public class updateItems {

	JFrame updateItems;
	private JTextField nameTextField;
	private JTextField descriptionTextField;
	private JTextField categoryTextField;
	private JTextField priceTextField;
	private JTextField sizeTextField;
	private JTextField availabilityTextField;
	String path;
	JFrame frame = new JFrame("Error");
	private JTextField locationTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateItems window = new updateItems();
					window.updateItems.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public updateItems() {
		initialize();
	}
	
	public void remove() {
		 boolean itemExists = false;
			
			MaintainItem obj = new MaintainItem();
			
         path = "/Users/suryam/Desktop/item.csv";
			
			try {
				obj.load(path);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			
			if(managerLogin.currentManager == null) {
				
				
				for(int i = 0; i < obj.items.size(); i++) {
					if(obj.items.get(i).getName().equalsIgnoreCase(nameTextField.getText()) && obj.items.get(i).getLocation().equalsIgnoreCase(locationTextField.getText())) {
						itemExists = true;
						obj.items.remove(i);
						break;

					}
				}
				if (itemExists == true) {
					
					try {
						obj.update(path);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(frame, "Item removed succesfully."); 
				}
				
				else {
					JOptionPane.showMessageDialog(frame, "Item does not exist."); 
				}
			}
			
			else if(managerLogin.currentManagerLocation.equalsIgnoreCase(locationTextField.getText())) {
				
				for(int i = 0; i < obj.items.size(); i++) {
					if(obj.items.get(i).getName().equalsIgnoreCase(nameTextField.getText()) && obj.items.get(i).getLocation().equalsIgnoreCase(locationTextField.getText())) {
						itemExists = true;
						obj.items.remove(i);
						break;

					}
				}
				if (itemExists == true) {
					
					try {
						obj.update(path);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(frame, "Item removed succesfully."); 
				}
				
				else {
					JOptionPane.showMessageDialog(frame, "Item does not exist."); 
				}
				
			}
			
			else {
				JOptionPane.showMessageDialog(frame, "A manager can only remove an item from their assigned store."); 
			}
			
	}
	
	
	public void mainSystem() {
		updateItems.dispose();
		mainSystem mS = new mainSystem();
		mS.mainSystem.setVisible(true);
	}
	
	public void saleItems() {
		String saleItems = "";
        boolean atLeastOneSaleItem = false;
		MaintainItem obj = new MaintainItem();
		
        path = "/Users/suryam/Desktop/item.csv";
		
		try {
			obj.load(path);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(managerLogin.currentManager == null) {
			
			for(int i = 0; i < obj.items.size(); i++) {
				if(obj.items.get(i).getOnSale() == true) {
					atLeastOneSaleItem = true;
					saleItems += obj.items.get(i).getName() + " (" + obj.items.get(i).getLocation() + ")";
					saleItems += "\n";
					
				}
				
			}
			
			if(atLeastOneSaleItem == true) {
				JOptionPane.showMessageDialog(frame, saleItems); 
			}
			
			if(atLeastOneSaleItem == false) {
				JOptionPane.showMessageDialog(frame, "No items in store on sale"); 
			}
			
		}
		
		else {
			for(int i = 0; i < obj.items.size(); i++) {
				if(obj.items.get(i).getOnSale() == true && managerLogin.currentManagerLocation.equalsIgnoreCase(obj.items.get(i).getLocation())) {
					atLeastOneSaleItem = true;
					saleItems += obj.items.get(i).getName();
					saleItems += "\n";
					
				}
				
			}
			
			if(atLeastOneSaleItem == true) {
				JOptionPane.showMessageDialog(frame, saleItems); 
			}
			
			if(atLeastOneSaleItem == false) {
				JOptionPane.showMessageDialog(frame, "No items in store on sale"); 
			}
		}
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		updateItems = new JFrame();
		updateItems.getContentPane().setBackground(new Color(51, 0, 102));
		updateItems.setBounds(100, 100, 450, 300);
		updateItems.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Update Items");
		lblNewLabel.setBounds(154, 0, 94, 16);
		lblNewLabel.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_1 = new JLabel("Item Name: ");
		lblNewLabel_1.setBounds(32, 40, 76, 16);
		lblNewLabel_1.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_2 = new JLabel("Item Description");
		lblNewLabel_2.setBounds(32, 96, 116, 16);
		lblNewLabel_2.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_3 = new JLabel("Item Category");
		lblNewLabel_3.setBounds(32, 124, 100, 16);
		lblNewLabel_3.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_4 = new JLabel("Item Price");
		lblNewLabel_4.setBounds(32, 152, 94, 16);
		lblNewLabel_4.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_5 = new JLabel("Item Size");
		lblNewLabel_5.setBounds(32, 180, 61, 16);
		lblNewLabel_5.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_6 = new JLabel("Item Availability");
		lblNewLabel_6.setBounds(32, 208, 116, 16);
		lblNewLabel_6.setForeground(Color.WHITE);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(180, 37, 130, 21);
		nameTextField.setColumns(10);
		
		descriptionTextField = new JTextField();
		descriptionTextField.setBounds(180, 91, 130, 26);
		descriptionTextField.setColumns(10);
		
		categoryTextField = new JTextField();
		categoryTextField.setBounds(180, 119, 130, 26);
		categoryTextField.setColumns(10);
		
		priceTextField = new JTextField();
		priceTextField.setBounds(180, 147, 130, 26);
		priceTextField.setColumns(10);
		
		sizeTextField = new JTextField();
		sizeTextField.setBounds(180, 175, 130, 26);
		sizeTextField.setColumns(10);
		
		availabilityTextField = new JTextField();
		availabilityTextField.setBounds(180, 208, 130, 16);
		availabilityTextField.setColumns(10);
		
		JCheckBox onSaleCheckBox = new JCheckBox("On Sale");
		onSaleCheckBox.setBounds(182, 232, 128, 23);
		onSaleCheckBox.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_7 = new JLabel("On Sale");
		lblNewLabel_7.setBounds(32, 236, 61, 16);
		lblNewLabel_7.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_8 = new JLabel("Item Location");
		lblNewLabel_8.setBounds(32, 68, 86, 16);
		lblNewLabel_8.setForeground(Color.WHITE);
		
		locationTextField = new JTextField();
		locationTextField.setBounds(180, 65, 130, 21);
		locationTextField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(322, 0, 128, 272);
		panel.setBackground(new Color(0, 0, 51));
		
		
		
		JButton mainSystemButton = new JButton("Main System");
		mainSystemButton.setBounds(0, 19, 128, 29);
		
		JButton saleItems = new JButton("Sale Items");
		saleItems.setBounds(0, 72, 128, 29);
		
		JButton removeButton = new JButton("Remove");
		removeButton.setBounds(0, 237, 128, 29);
		
	
		
		
		JButton addButton = new JButton("Add");
		addButton.setBounds(0, 130, 128, 29);
		
		JButton updateButton = new JButton("Update");
		updateButton.setBounds(0, 183, 128, 29);
		updateItems.getContentPane().setLayout(null);
		updateItems.getContentPane().add(lblNewLabel_1);
		updateItems.getContentPane().add(lblNewLabel_8);
		updateItems.getContentPane().add(lblNewLabel_2);
		updateItems.getContentPane().add(lblNewLabel_3);
		updateItems.getContentPane().add(lblNewLabel_4);
		updateItems.getContentPane().add(lblNewLabel_5);
		updateItems.getContentPane().add(lblNewLabel_6);
		updateItems.getContentPane().add(lblNewLabel_7);
		updateItems.getContentPane().add(lblNewLabel);
		updateItems.getContentPane().add(nameTextField);
		updateItems.getContentPane().add(locationTextField);
		updateItems.getContentPane().add(descriptionTextField);
		updateItems.getContentPane().add(categoryTextField);
		updateItems.getContentPane().add(priceTextField);
		updateItems.getContentPane().add(sizeTextField);
		updateItems.getContentPane().add(availabilityTextField);
		updateItems.getContentPane().add(onSaleCheckBox);
		updateItems.getContentPane().add(panel);
		panel.setLayout(null);
		panel.add(mainSystemButton);
		panel.add(saleItems);
		panel.add(addButton);
		panel.add(updateButton);
		panel.add(removeButton);
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 boolean itemExists = false;
					
					MaintainItem obj = new MaintainItem();
					
		           path = "/Users/suryam/Desktop/item.csv";
					
					try {
						obj.load(path);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}  
					
					if(managerLogin.currentManager == null) {
						
						for(int i = 0; i < obj.items.size(); i++) {
							if(obj.items.get(i).getName().equalsIgnoreCase(nameTextField.getText()) && obj.items.get(i).getLocation().equalsIgnoreCase(locationTextField.getText())) {
								itemExists = true;
								
								if(nameTextField.getText().isBlank() == false) {
									obj.items.get(i).setName(nameTextField.getText());
								
								}
								
								
								if(descriptionTextField.getText().isBlank() == false) {
									obj.items.get(i).setDescription(descriptionTextField.getText());
									
								}
								
								if(categoryTextField.getText().isBlank() == false) {
									obj.items.get(i).setCategory(categoryTextField.getText());
								}
								
								if(priceTextField.getText().isBlank() == false) {
									obj.items.get(i).setPrice(Double.valueOf(priceTextField.getText()));
								}
								
								if(sizeTextField.getText().isBlank() == false) {
									obj.items.get(i).setSize(Double.valueOf(sizeTextField.getText()));
								}
								
								if(availabilityTextField.getText().isBlank() == false) {
									obj.items.get(i).setAvailability(Integer.valueOf(availabilityTextField.getText()));
								}
								
								
								obj.items.get(i).setOnSale(Boolean.valueOf(onSaleCheckBox.isSelected()));
							
								
							}
						}
						
						if(itemExists == true && locationTextField.getText().isBlank() == false) {
							

							try {
								obj.update(path);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							JOptionPane.showMessageDialog(frame, "Item updated succesfully."); 
						}
						
					
				
						
						else {
							JOptionPane.showMessageDialog(frame, "Item does not exist."); 
						}
						
						
					}
					
					else if(managerLogin.currentManagerLocation.equalsIgnoreCase(locationTextField.getText())) {
						
							
							for(int i = 0; i < obj.items.size(); i++) {
								if(obj.items.get(i).getName().equalsIgnoreCase(nameTextField.getText()) && obj.items.get(i).getLocation().equalsIgnoreCase(locationTextField.getText())) {
									itemExists = true;
									
									if(nameTextField.getText().isBlank() == false) {
										obj.items.get(i).setName(nameTextField.getText());
									
									}
									
									
									if(descriptionTextField.getText().isBlank() == false) {
										obj.items.get(i).setDescription(descriptionTextField.getText());
										
									}
									
									if(categoryTextField.getText().isBlank() == false) {
										obj.items.get(i).setCategory(categoryTextField.getText());
									}
									
									if(priceTextField.getText().isBlank() == false) {
										obj.items.get(i).setPrice(Double.valueOf(priceTextField.getText()));
									}
									
									if(sizeTextField.getText().isBlank() == false) {
										obj.items.get(i).setSize(Double.valueOf(sizeTextField.getText()));
									}
									
									if(availabilityTextField.getText().isBlank() == false) {
										obj.items.get(i).setAvailability(Integer.valueOf(availabilityTextField.getText()));
									}
									
									
									obj.items.get(i).setOnSale(Boolean.valueOf(onSaleCheckBox.isSelected()));
								
									
								}
							}
							
							if(itemExists == true && locationTextField.getText().isBlank() == false) {
								

								try {
									obj.update(path);
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								JOptionPane.showMessageDialog(frame, "Item updated succesfully."); 
							}
							
							
							
							else {
								JOptionPane.showMessageDialog(frame, "Item does not exist."); 
							}
							
						
					}
					
					else if(locationTextField.getText().isBlank() == true) {
						JOptionPane.showMessageDialog(frame, "Item Location not specified."); 
					}
					
					
					else {
						JOptionPane.showMessageDialog(frame, "A Manager can only update Items To Their Assigned Store."); 
					}
					
					
			}
		});
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean itemExists = false;
				
				MaintainItem obj = new MaintainItem();
				
                path = "/Users/suryam/Desktop/item.csv";
				
				try {
					obj.load(path);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				for(int i = 0; i < obj.items.size(); i++) {
					if(obj.items.get(i).getName().equalsIgnoreCase(nameTextField.getText()) && obj.items.get(i).getLocation().equalsIgnoreCase(locationTextField.getText())) {
						itemExists = true;
						break;
					}
				}
				
				if(managerLogin.currentManager == null) {
					
					
					if(itemExists == false) {
						Item item = new Item();
						item.setName(nameTextField.getText());
						item.setLocation(locationTextField.getText());
						item.setDescription(descriptionTextField.getText());
						item.setCategory(categoryTextField.getText());
						item.setPrice(Double.valueOf(priceTextField.getText()));
						item.setSize(Double.valueOf(sizeTextField.getText()));
						item.setAvailability(Integer.valueOf(availabilityTextField.getText()));
						item.setOnSale(Boolean.valueOf(onSaleCheckBox.isSelected()));
						item.setFrequency(0);
						
						
						obj.items.add(item);
						
						try {
							obj.update(path);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						JOptionPane.showMessageDialog(frame, "Item added succesfully."); 
						
					}
					

					else {
						JOptionPane.showMessageDialog(frame, "Item already exists at " +locationTextField.getText() + " store."); 
					}
						
				}
				
				else if(managerLogin.currentManagerLocation.equalsIgnoreCase(locationTextField.getText())) {
					
					if(itemExists == false) {
						Item item = new Item();
						item.setName(nameTextField.getText());
						item.setLocation(locationTextField.getText());
						item.setDescription(descriptionTextField.getText());
						item.setCategory(categoryTextField.getText());
						item.setPrice(Double.valueOf(priceTextField.getText()));
						item.setSize(Double.valueOf(sizeTextField.getText()));
						item.setAvailability(Integer.valueOf(availabilityTextField.getText()));
						item.setOnSale(Boolean.valueOf(onSaleCheckBox.isSelected()));
						item.setFrequency(0);
						
						obj.items.add(item);
						
						try {
							obj.update(path);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						JOptionPane.showMessageDialog(frame, "Item added succesfully."); 
						
					}
					

					else {
						JOptionPane.showMessageDialog(frame, "Item already exists."); 
					}
					
				}
				
				else {
					JOptionPane.showMessageDialog(frame, "A Manager can only add items to their assigned store."); 
				}
				
				
					
			}
		});
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
               
				remove();
				
				
			}
		});
		saleItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saleItems();
			}
		});
		mainSystemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mainSystem();
			}
		});
		
	}
}
