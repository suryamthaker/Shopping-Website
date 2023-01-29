import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;

public class densityCheck {

	JFrame densityCheck;
	private JTextField timeTextField;
	JFrame frame = new JFrame();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					densityCheck window = new densityCheck();
					window.densityCheck.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public densityCheck() {
		initialize();
	}
	
	public void check() {
		

		if(timeTextField.getText().charAt(0) == '0') {
			JOptionPane.showMessageDialog(frame, "Store is closed At " + timeTextField.getText(), "Density Check", JOptionPane.PLAIN_MESSAGE);
		}
		
		else if(timeTextField.getText().charAt(0) == '1' && timeTextField.getText().charAt(1) == '0' || timeTextField.getText().charAt(0) == '1' && timeTextField.getText().charAt(1) == '1' || timeTextField.getText().charAt(0) == '1' && timeTextField.getText().charAt(1) == '2' || timeTextField.getText().charAt(0) == '1' && timeTextField.getText().charAt(1) == '3') {
			JOptionPane.showMessageDialog(frame, "Store Is Not Busy At All " + timeTextField.getText() + ".", "Density Check", JOptionPane.PLAIN_MESSAGE);
		}
		
		else if(timeTextField.getText().charAt(0) == '1' && timeTextField.getText().charAt(1) == '4' || timeTextField.getText().charAt(0) == '1' && timeTextField.getText().charAt(1) == '5' || timeTextField.getText().charAt(0) == '1' && timeTextField.getText().charAt(1) == '6') {
			JOptionPane.showMessageDialog(frame, "Store Is Moderately Busy At " + timeTextField.getText() + ".", "Density Check", JOptionPane.PLAIN_MESSAGE);
		}
		
		else if(timeTextField.getText().charAt(0) == '1' && timeTextField.getText().charAt(1) == '7' || timeTextField.getText().charAt(0) == '1' && timeTextField.getText().charAt(1) == '8' || timeTextField.getText().charAt(0) == '1' && timeTextField.getText().charAt(1) == '9') {
			JOptionPane.showMessageDialog(frame, "Store Is Very Busy At " + timeTextField.getText() + ".", "Density Check", JOptionPane.PLAIN_MESSAGE);
		}
		
		else if(timeTextField.getText().charAt(0) == '2' && timeTextField.getText().charAt(1) == '0') {
			JOptionPane.showMessageDialog(frame, "Store Not Busy At All " + timeTextField.getText() + ".", "Density Check", JOptionPane.PLAIN_MESSAGE);
		}
		
		else if(timeTextField.getText().charAt(0) == '2' && timeTextField.getText().charAt(1) == '1' || timeTextField.getText().charAt(0) == '2' && timeTextField.getText().charAt(1) == '2' || timeTextField.getText().charAt(0) == '2' && timeTextField.getText().charAt(1) == '3') {
			JOptionPane.showMessageDialog(frame, "Store Is Closed At " + timeTextField.getText() + ".", "Density Check", JOptionPane.PLAIN_MESSAGE);
		}
		
		else {
			JOptionPane.showMessageDialog(frame, timeTextField.getText() + " is not valid.\n" + "Please Enter a valid 24 Hour Clock Format (00:00 - 23:59)" + ".", "Density Check", JOptionPane.PLAIN_MESSAGE);
		}
		
	}
	
	public void Home() {
		
		densityCheck.dispose();
		userHome uH = new userHome();
		uH.userHome.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		densityCheck = new JFrame();
		densityCheck.getContentPane().setBackground(new Color(51, 0, 102));
		densityCheck.setBounds(100, 100, 450, 300);
		densityCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		densityCheck.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Density Check");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(176, 0, 91, 16);
		densityCheck.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" Please Enter the time you want to visit the");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(85, 39, 268, 16);
		densityCheck.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Time");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(120, 119, 77, 16);
		densityCheck.getContentPane().add(lblNewLabel_2);
		
		timeTextField = new JTextField();
		timeTextField.setBounds(209, 114, 130, 26);
		densityCheck.getContentPane().add(timeTextField);
		timeTextField.setColumns(10);
		
		JButton checkButton = new JButton("Check");
		checkButton.setBackground(Color.WHITE);
		checkButton.setForeground(Color.BLACK);
		checkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				check();
				
				
				
			}
		});
		checkButton.setBounds(171, 169, 117, 29);
		densityCheck.getContentPane().add(checkButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(0, 0, 450, 41);
		densityCheck.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton homeButton = new JButton("Home");
		homeButton.setBackground(Color.WHITE);
		homeButton.setForeground(Color.BLACK);
		homeButton.setBounds(327, 6, 117, 29);
		panel.add(homeButton);
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Home();
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 51));
		panel_1.setBounds(0, 231, 450, 41);
		densityCheck.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("store in 24 Hour clock format.");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(119, 53, 193, 16);
		densityCheck.getContentPane().add(lblNewLabel_3);
	}
}
