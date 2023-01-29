import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import java.awt.Color;

public class security {

	JFrame security;
	JFrame frame = new JFrame();
	String path;
	private JTextField questionTextField;
	private JTextField answerTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					security window = new security();
					window.security.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public security() {
		initialize();
	}
	
	public void Set() {
		
		 MaintainUser obj = new MaintainUser();
			
         path = "/Users/suryam/Desktop/user.csv";
			
			try {
				obj.load(path);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			for(int i = 0; i < obj.users.size(); i++) {
				if(obj.users.get(i).getName().equalsIgnoreCase(startUpScreen.currentUser)) {
					obj.users.get(i).setQuestion(questionTextField.getText());
					obj.users.get(i).setAnswer(answerTextField.getText());
					JOptionPane.showMessageDialog(security, "Security Fields Set.");
				}
			}
			
			try {
				obj.update(path);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
	
	public void View() {
		
		  MaintainUser obj = new MaintainUser();
			
          path = "/Users/suryam/Desktop/user.csv";
			
			try {
				obj.load(path);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			for(int i = 0; i < obj.users.size(); i++) {
				if(obj.users.get(i).getName().equalsIgnoreCase(startUpScreen.currentUser)) {
					JOptionPane.showMessageDialog(security, "Question: " + obj.users.get(i).getQuestion() + "\n" + "Answer: " + obj.users.get(i).getAnswer());
				}
			}
	}
	
	public void Settings() {
		security.dispose();
		settings s = new settings();
		s.settings.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		security = new JFrame();
		security.getContentPane().setBackground(new Color(51, 0, 102));
		security.setBounds(100, 100, 450, 300);
		security.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		security.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("View/Set Security Q&A");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(159, 0, 151, 16);
		security.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Question: ");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(95, 95, 71, 16);
		security.getContentPane().add(lblNewLabel_1);
		
		questionTextField = new JTextField();
		questionTextField.setBounds(168, 90, 130, 26);
		security.getContentPane().add(questionTextField);
		questionTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Answer: ");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(95, 123, 61, 16);
		security.getContentPane().add(lblNewLabel_2);
		
		answerTextField = new JTextField();
		answerTextField.setBounds(168, 118, 130, 26);
		security.getContentPane().add(answerTextField);
		answerTextField.setColumns(10);
		
		JButton setButton = new JButton("Set");
		setButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
               Set();
				
			}
		});
		setButton.setBounds(168, 156, 117, 29);
		security.getContentPane().add(setButton);
		
		JButton viewButton = new JButton("View");
		viewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
              View();
			}
		});
		viewButton.setBounds(168, 187, 117, 29);
		security.getContentPane().add(viewButton);
		
		JButton settingsButton = new JButton("Settings");
		settingsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings();
			}
		});
		settingsButton.setBounds(333, 38, 117, 29);
		security.getContentPane().add(settingsButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(0, 0, 450, 40);
		security.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 51));
		panel_1.setBounds(0, 232, 450, 40);
		security.getContentPane().add(panel_1);
		panel_1.setLayout(null);
	}
}
