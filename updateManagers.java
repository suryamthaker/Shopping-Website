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

public class updateManagers {

	JFrame updateManagers;
	private JTextField usernameTextField;
	private JTextField passwordTextField;
	private JTextField emailTextField;
	private JTextField locationTextField;
	private JTextField idTextField;
	JFrame frame = new JFrame("Error");
	String path;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateManagers window = new updateManagers();
					window.updateManagers.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public updateManagers() {
		initialize();
	}
	
	public void add() {
		 MaintainManager obj = new MaintainManager();
			
			path = "/Users/suryam/Desktop/manager.csv";
			boolean userExists = false;
			
			try {
				obj.load(path);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			for(int i = 0; i < obj.managers.size(); i++) {
				if(obj.managers.get(i).getName().equalsIgnoreCase(usernameTextField.getText())) {
					userExists = true;
					break;
				}
			}
			
			if(userExists == false) {
				Manager manager = new Manager();
				manager.setName(usernameTextField.getText());
				manager.setPassword(passwordTextField.getText());
				manager.setEmail(emailTextField.getText());
				manager.setLocation(locationTextField.getText());
				manager.setId(obj.managers.size()+1);
				obj.managers.add(manager);
				
				try {
					obj.update(path);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				JOptionPane.showMessageDialog(frame, "Manager added succesfully.", "Sucess", JOptionPane.PLAIN_MESSAGE);
			}
			
			else {
				
				JOptionPane.showMessageDialog(frame, "Manager username already exists.", "Error", JOptionPane.PLAIN_MESSAGE);
				
			}
	}
	
	public void update() {

		MaintainManager obj = new MaintainManager();
		
		path = "/Users/suryam/Desktop/manager.csv";
		boolean sucessful = false;
		
		try {
			obj.load(path);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(int i = 0; i < obj.managers.size(); i++) {
			if(obj.managers.get(i).getName().equalsIgnoreCase(usernameTextField.getText())) {
				sucessful = true;
				
				if(passwordTextField.getText().isEmpty() == false) {
					obj.managers.get(i).setPassword(passwordTextField.getText());
				}
				
				if(emailTextField.getText().isBlank() == false) {
					obj.managers.get(i).setEmail(emailTextField.getText());
				}
				
				if(locationTextField.getText().isBlank() == false) {
					obj.managers.get(i).setLocation(locationTextField.getText());
				}
				
				
			}
		}
		
		if(sucessful == true) {
			
			JOptionPane.showMessageDialog(frame, "Manager info updated succesfully.", "Sucess", JOptionPane.PLAIN_MESSAGE);
			
			try {
				obj.update(path);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		else {
			
			JOptionPane.showMessageDialog(frame, "Update unsucessful", "Error", JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	public void remove() {
		 MaintainManager obj = new MaintainManager();
			
			path = "/Users/suryam/Desktop/manager.csv";
			boolean userExists = false;
			
			try {
				obj.load(path);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			for(int i = 0; i < obj.managers.size(); i++) {
				if(obj.managers.get(i).getName().equalsIgnoreCase(usernameTextField.getText())) {
					obj.managers.remove(i);
		
					
					userExists = true;
					
					JOptionPane.showMessageDialog(frame, "Manager removed succesfully.", "Sucess", JOptionPane.PLAIN_MESSAGE);
					break;
				}
			}
			
			if(userExists == false) {
				
				JOptionPane.showMessageDialog(frame, "Manager does not exist.", "Error", JOptionPane.PLAIN_MESSAGE);
			}
			
			else {
				try {
					obj.update(path);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		updateManagers = new JFrame();
		updateManagers.getContentPane().setBackground(new Color(51, 0, 102));
		updateManagers.setBounds(100, 100, 450, 300);
		updateManagers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		updateManagers.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Managers");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(161, 6, 123, 16);
		updateManagers.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(36, 73, 82, 16);
		updateManagers.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(36, 101, 61, 16);
		updateManagers.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(36, 129, 61, 16);
		updateManagers.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Location");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(36, 157, 61, 16);
		updateManagers.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("ID");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(36, 185, 61, 16);
		updateManagers.getContentPane().add(lblNewLabel_5);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(161, 68, 130, 26);
		updateManagers.getContentPane().add(usernameTextField);
		usernameTextField.setColumns(10);
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(161, 96, 130, 26);
		updateManagers.getContentPane().add(passwordTextField);
		passwordTextField.setColumns(10);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(161, 124, 130, 26);
		updateManagers.getContentPane().add(emailTextField);
		emailTextField.setColumns(10);
		
		locationTextField = new JTextField();
		locationTextField.setBounds(161, 152, 130, 26);
		updateManagers.getContentPane().add(locationTextField);
		locationTextField.setColumns(10);
		
		idTextField = new JTextField();
		idTextField.setBounds(161, 180, 130, 26);
		updateManagers.getContentPane().add(idTextField);
		idTextField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(317, 0, 133, 272);
		updateManagers.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton addButton = new JButton("Add");
		addButton.setBounds(6, 25, 121, 29);
		panel.add(addButton);
		
		JButton updatebutton = new JButton("Update");
		updatebutton.setBounds(6, 119, 121, 29);
		panel.add(updatebutton);
		
		JButton removeButton = new JButton("Remove");
		removeButton.setBounds(6, 216, 121, 29);
		panel.add(removeButton);
		
		JButton mainSystemButton = new JButton("Main System");
		mainSystemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updateManagers.dispose();
				mainSystem mS = new mainSystem();
				mS.mainSystem.setVisible(true);
			}
		});
		mainSystemButton.setBounds(1, 6, 117, 29);
		updateManagers.getContentPane().add(mainSystemButton);
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove();
				
			}
		});
		updatebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				update();
				
				
			}
		});
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
             add();
			}
		});
	}

}
