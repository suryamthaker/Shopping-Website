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

public class searchStores {

	JFrame searchStores;
	String path;
	JFrame frame = new JFrame("Error");
	private JTextField cityTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchStores window = new searchStores();
					window.searchStores.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public searchStores() {
		initialize();
	}
	
	public void Search() {

        MaintainStore obj = new MaintainStore();
        Boolean storeExists = false;
		
		path = "/Users/suryam/Desktop/store.csv";
		
		try {
			obj.load(path);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(int i = 0; i < obj.stores.size(); i++) {
			
			if(obj.stores.get(i).getLocation().equalsIgnoreCase(cityTextField.getText())) {
				storeExists = true;
				break;
				
			}
		}
		
		if(storeExists == true) {
			JOptionPane.showMessageDialog(frame, "There is an available store in the city of " + cityTextField.getText().toUpperCase()); 
		}
		
		else {
			JOptionPane.showMessageDialog(frame, "There is no available store in the city of " + cityTextField.getText().toUpperCase()); 
		}
	}
	
	public void Home() {
		searchStores.dispose();
		userHome uH = new userHome();
		uH.userHome.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		searchStores = new JFrame();
		searchStores.getContentPane().setBackground(new Color(51, 0, 102));
		searchStores.setBounds(100, 100, 450, 300);
		searchStores.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		searchStores.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search For A Store");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(167, 0, 137, 16);
		searchStores.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Your City Name");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(83, 112, 134, 16);
		searchStores.getContentPane().add(lblNewLabel_1);
		
		cityTextField = new JTextField();
		cityTextField.setBounds(229, 107, 130, 26);
		searchStores.getContentPane().add(cityTextField);
		cityTextField.setColumns(10);
		
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Search();
				
				
			}
		});
		searchButton.setBounds(153, 159, 117, 29);
		searchStores.getContentPane().add(searchButton);
		
		JButton homeButton = new JButton("Home");
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Home();
			}
		});
		homeButton.setBounds(333, 40, 117, 29);
		searchStores.getContentPane().add(homeButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(0, 0, 450, 40);
		searchStores.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 51));
		panel_1.setBounds(0, 232, 450, 40);
		searchStores.getContentPane().add(panel_1);
		panel_1.setLayout(null);
	}

}
