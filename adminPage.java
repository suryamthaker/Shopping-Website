import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;

public class adminPage {

	JFrame adminPage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminPage window = new adminPage();
					window.adminPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public adminPage() {
		initialize();
	}
	
	public void updateManagers() {
		adminPage.dispose();
		updateManagers uM = new updateManagers();
		uM.updateManagers.setVisible(true);
	}
	
	public void mainSystem() {
		
		adminPage.dispose();
		mainSystem mS = new mainSystem();
		mS.mainSystem.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		adminPage = new JFrame();
		adminPage.getContentPane().setBackground(new Color(51, 0, 102));
		adminPage.setBounds(100, 100, 450, 300);
		adminPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminPage.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Page");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(189, 0, 88, 16);
		adminPage.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(0, 0, 140, 272);
		adminPage.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Main System");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBounds(0, 22, 140, 29);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Update Managers");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(0, 64, 140, 29);
		panel.add(btnNewButton);
		
		JLabel imageLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/SS.png")).getImage();
		imageLabel.setIcon(new ImageIcon(img));
		
		imageLabel.setBounds(194, 49, 173, 160);
		adminPage.getContentPane().add(imageLabel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updateManagers();
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mainSystem();
			}
		});
	}

}
