import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;

public class userHome {

	JFrame userHome;
	String path;
	JFrame frame = new JFrame("Sale Items For this Week");
	private JLabel homeLabel;
	private JButton searchStoresButton;
	private JButton searchItemsButton;
	private JButton saleItemsButton;
	private JButton cartButton;
	private JPanel panel;
	private JPanel panel_1;
	private JButton logoutButton;
	private JButton suggestedButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userHome window = new userHome();
					window.userHome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public userHome() {
		initialize();
	}
	
	public void searchStores() {
		userHome.dispose();
		searchStores sS = new searchStores();
		sS.searchStores.setVisible(true);
	}
	
	public void searchItems() {
		userHome.dispose();
		searchItems sI = new searchItems();
		sI.searchItems.setVisible(true);
	}
	
	public void saleItems() {
		MaintainItem obj = new MaintainItem();
		
		boolean atLeastOneSaleItem = false;
		
		 path = "/Users/suryam/Desktop/item.csv";
			
			try {
				obj.load(path);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			String saleItems = "";
			
			for(int i = 0; i < obj.items.size(); i++) {
				if(obj.items.get(i).getLocation().equalsIgnoreCase(startUpScreen.currentUserLocation) && obj.items.get(i).getOnSale() == true) {
					atLeastOneSaleItem = true;
					saleItems += obj.items.get(i).getName();
					saleItems += "\n";
;						}
			}
			
			if(atLeastOneSaleItem == true) {
				JOptionPane.showMessageDialog(frame, saleItems, "Sale Items For This Week", JOptionPane.PLAIN_MESSAGE);
			}
			
			else {
				JOptionPane.showMessageDialog(frame, "No Sale Items This Week", "Sale Items For This Week", JOptionPane.PLAIN_MESSAGE);
				
			}
	}
	
	public void settings() {
		userHome.dispose();
		settings s = new settings();
		s.settings.setVisible(true);
	}
	
	public void densityCheck() {
		userHome.dispose();
		densityCheck dC = new densityCheck();
		dC.densityCheck.setVisible(true);
	}
	
	public void viewCart() {
		MaintainItem obj = new MaintainItem();
		path = startUpScreen.currentUserPath;
		
	
		
		String cart = "";
		double cartTotal = 0;
		double itemTotal = 0;
		
		try {
			obj.load(path);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(obj.items.size() > 0) {
			
			for(int i = 0; i < obj.items.size(); i++) {
				cartTotal += obj.items.get(i).getAvailability() * obj.items.get(i).getPrice();
				itemTotal = obj.items.get(i).getAvailability() * obj.items.get(i).getPrice();
				cart += obj.items.get(i).getName().toUpperCase();
				cart +=  " (" + obj.items.get(i).getAvailability() + ")" + " - $" +itemTotal;
				cart += "\n";
			}
			
			JOptionPane.showMessageDialog(frame, cart + "\n" + "Total: $" + cartTotal, " Cart", JOptionPane.PLAIN_MESSAGE);
			
		}
	
		
		else {
			JOptionPane.showMessageDialog(frame, "Cart Empty", "Cart", JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	public void logOut() {
		userHome.dispose();
		startUpScreen sU = new startUpScreen();
		sU.startUpScreen.setVisible(true);
	}
	
	public int suggestedItems( ) {
		
		MaintainItem item = new MaintainItem();
		path = "/Users/suryam/Desktop/item.csv";
		try {
			item.load(path);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		MaintainItem cart = new MaintainItem();
		try {
			cart.load(startUpScreen.currentUserPath);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ArrayList<String> items = new ArrayList<String>();
		
		String suggestedItems = "";
		
		for(int i = 0; i < item.items.size(); i++) {
			if(item.items.get(i).getLocation().equalsIgnoreCase(startUpScreen.currentUserLocation)) {
				items.add(item.items.get(i).getName());
			}
		}
		
		for(int i = 0; i < cart.items.size(); i++) {
			for(int j = 0; j < items.size(); j++) {
				if(cart.items.get(i).getName().equalsIgnoreCase(items.get(j))) {
					items.remove(items.get(j));
				}
			}
		}
		
		if (items.size() != 0) {
			for(int i = 0; i < items.size(); i++) {
				suggestedItems += items.get(i);
				suggestedItems += "\n";
			}
			
			JOptionPane.showMessageDialog(frame, suggestedItems, "Suggested Items", JOptionPane.PLAIN_MESSAGE);
		}
		
		else {
			JOptionPane.showMessageDialog(frame, "No Suggested Items At The Moment", "Suggested Items", JOptionPane.PLAIN_MESSAGE);
		}
		
		
		return 0;
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		userHome = new JFrame();
		userHome.getContentPane().setBackground(new Color(51, 0, 102));
		userHome.setBounds(100, 100, 450, 300);
		userHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		userHome.getContentPane().setLayout(null);
		
		homeLabel = new JLabel("Welcome To Smart Shoppers");
		homeLabel.setForeground(Color.WHITE);
		homeLabel.setBounds(137, 0, 197, 16);
		userHome.getContentPane().add(homeLabel);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(0, 0, 135, 272);
		userHome.getContentPane().add(panel);
		panel.setLayout(null);
		
		searchStoresButton = new JButton("Search Stores");
		searchStoresButton.setBounds(0, 22, 135, 29);
		panel.add(searchStoresButton);
		searchStoresButton.setBackground(new Color(0, 0, 51));
		
		searchItemsButton = new JButton("Search Items");
		searchItemsButton.setBounds(0, 90, 135, 29);
		panel.add(searchItemsButton);
		
		saleItemsButton = new JButton("Sale Items");
		saleItemsButton.setBounds(0, 221, 135, 29);
		panel.add(saleItemsButton);
		
		suggestedButton = new JButton("Suggested Items");
		suggestedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				suggestedItems();
			
				
 			}
		});
		suggestedButton.setBounds(0, 157, 135, 29);
		panel.add(suggestedButton);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 51));
		panel_1.setBounds(315, 0, 135, 272);
		userHome.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		
		JButton settingsButton = new JButton();
		settingsButton.setBounds(0, 17, 135, 29);
		panel_1.add(settingsButton);
		settingsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				settings();
			}
		});
		settingsButton.setText("Settings");
		
		JButton densityButton = new JButton("Density Check");
		densityButton.setBounds(0, 85, 135, 29);
		panel_1.add(densityButton);
		
		cartButton = new JButton("View Cart");
		cartButton.setBounds(0, 155, 135, 29);
		panel_1.add(cartButton);
		
		logoutButton = new JButton("Logout");
		logoutButton.setBounds(0, 222, 135, 29);
		panel_1.add(logoutButton);
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logOut();
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/SS.png")).getImage();
		
		JLabel imageLabel = new JLabel("");
		imageLabel.setBounds(129, 28, 192, 197);
		userHome.getContentPane().add(imageLabel);
		imageLabel.setIcon(new ImageIcon(img));
		cartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewCart();
				
			}
		});
		densityButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				densityCheck();
			}
		});
		saleItemsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saleItems();
				
			}
		});
		searchItemsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchItems();
				
			}
		});
		searchStoresButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchStores();
			}
		});
	}
}
