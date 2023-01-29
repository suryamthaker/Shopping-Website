import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class deleteAccount {

	JFrame deleteAccount;
	String path;
	String path2;
	String path3;
	String filePath;
	JFrame frame = new JFrame();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteAccount window = new deleteAccount();
					window.deleteAccount.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public deleteAccount() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		deleteAccount = new JFrame();
		deleteAccount.setBounds(100, 100, 450, 300);
		deleteAccount.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		deleteAccount.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete Account");
		lblNewLabel.setBounds(188, 6, 102, 16);
		deleteAccount.getContentPane().add(lblNewLabel);
		
		JButton deleteButton = new JButton("Delete Account");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaintainUser obj = new MaintainUser();
				
				MaintainItem cart = new MaintainItem();
				
				MaintainItem itemList = new MaintainItem();
				
                path = "/Users/suryam/Desktop/user.csv";
                
                path2 = startUpScreen.currentUserPath;
        		
        		path3 = "/Users/suryam/Desktop/item.csv";
               
        		
        		int newAvailability = 0;
               
				try {
					obj.load(path);
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
				
				
					
				if(cart.items.size() != 0) {
					
					for(int i = 0; i < itemList.items.size(); i++) {
						for(int j = 0; j < cart.items.size(); j++) {
							if(itemList.items.get(i).getName().equalsIgnoreCase(cart.items.get(j).getName()) && itemList.items.get(i).getLocation().equalsIgnoreCase(cart.items.get(j).getLocation())) {
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
				
				deleteAccount.dispose();
				startUpScreen sU = new startUpScreen();
				sU.startUpScreen.setVisible(true);
				
			}
		});
		deleteButton.setBounds(146, 115, 163, 29);
		deleteAccount.getContentPane().add(deleteButton);
	}

}
