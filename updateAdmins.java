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

public class updateAdmins {

	JFrame updateAdmins;
	String path;
	private JTextField usernameTextField;
	private JTextField passwordTextField;
	JFrame frame = new JFrame("Error");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateAdmins window = new updateAdmins();
					window.updateAdmins.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public updateAdmins() {
		initialize();
	}
	
	public void add() {
		boolean userExists = false;
		
		MaintainAdmin obj = new MaintainAdmin();
		path = "/Users/suryam/Desktop/admin.csv";
		
		try {
			obj.load(path);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(int i = 0; i < obj.admins.size(); i++) {
			if(obj.admins.get(i).getName().equalsIgnoreCase(usernameTextField.getText())) {
				userExists = true;
				break;
			}
		}
		
		if(userExists == false) {
			Admin admin = new Admin();
			admin.setName(usernameTextField.getText());
			admin.setPassword(passwordTextField.getText());
			admin.setId(obj.admins.size()+1);
			obj.admins.add(admin);
			
			try {
				obj.update(path);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(frame, "Admin added succesfully.", "Sucess", JOptionPane.PLAIN_MESSAGE);
			
		}
		
		else {
			JOptionPane.showMessageDialog(frame, "Admin already exists.", "Error", JOptionPane.PLAIN_MESSAGE);
			
		}
	}
	
	public void remove() {
		 boolean userExists = false;
			
			MaintainAdmin obj = new MaintainAdmin();
			path = "/Users/suryam/Desktop/admin.csv";
			
			try {
				obj.load(path);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			for(int i = 0; i < obj.admins.size(); i++) {
				if(obj.admins.get(i).getName().equalsIgnoreCase(usernameTextField.getText())) {
					userExists = true;
					obj.admins.remove(i);
					break;
				}
			}
			
			if(userExists == true) {
				
				try {
					obj.update(path);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(frame, "Admin removed succesfully.", "Sucess", JOptionPane.PLAIN_MESSAGE);
				
				
			}
			
			else {
				
				JOptionPane.showMessageDialog(frame, "Admin does not exist.", "Error", JOptionPane.PLAIN_MESSAGE);
			}
			
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		updateAdmins = new JFrame();
		updateAdmins.getContentPane().setBackground(new Color(51, 0, 102));
		updateAdmins.setBounds(100, 100, 450, 300);
		updateAdmins.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		updateAdmins.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Admin Name");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(84, 102, 81, 16);
		updateAdmins.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Admins Password");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(83, 140, 111, 16);
		updateAdmins.getContentPane().add(lblNewLabel_2);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(206, 97, 130, 26);
		updateAdmins.getContentPane().add(usernameTextField);
		usernameTextField.setColumns(10);
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(206, 135, 130, 26);
		updateAdmins.getContentPane().add(passwordTextField);
		passwordTextField.setColumns(10);
		
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				add();
				
			}
		});
		addButton.setBounds(232, 173, 117, 29);
		updateAdmins.getContentPane().add(addButton);
		
		JButton removeButton = new JButton("Remove");
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
               remove();
				
			}
		});
		removeButton.setBounds(103, 173, 117, 29);
		updateAdmins.getContentPane().add(removeButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(0, 0, 450, 38);
		updateAdmins.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Admins");
		lblNewLabel.setBounds(173, 0, 96, 16);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 51));
		panel_1.setBounds(0, 234, 450, 38);
		updateAdmins.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton mainSystemButton = new JButton("Main System");
		mainSystemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updateAdmins.dispose();
				mainSystem mS = new mainSystem();
				mS.mainSystem.setVisible(true);
			}
		});
		mainSystemButton.setBounds(333, 39, 117, 29);
		updateAdmins.getContentPane().add(mainSystemButton);
	}

}
