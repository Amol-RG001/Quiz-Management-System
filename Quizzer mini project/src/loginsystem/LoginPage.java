package loginsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import quizsystem.OptionsPage;

public class LoginPage implements ActionListener {

	JFrame frame = new JFrame("Admin Login");
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JButton backButton = new JButton("back");
	
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("Username");
	JLabel userPasswordLabel = new JLabel("Password");
	JLabel messageLabel = new JLabel();
	JCheckBox showPassword = new JCheckBox("Show Password");
	
	HashMap<String, String> logininfo = new HashMap<String, String>();
	
	public LoginPage(HashMap<String,String> logininfoReal){
		logininfo  = logininfoReal;
	
		userIDLabel.setBounds(50, 100, 75, 25);
		userPasswordLabel.setBounds(50, 150, 75, 25);
		
		messageLabel.setBounds(125,275,250,35);
		messageLabel.setFont(new Font(null, Font.ITALIC, 25));
		
		userIDField.setBounds(125, 100, 200, 25);
		userPasswordField.setBounds(125, 150, 200, 25);
		
		loginButton.setBounds(125, 250, 100, 25);
		loginButton.addActionListener(this);
		resetButton.setBounds(225, 250, 100, 25);
		resetButton.addActionListener(this);
		
		/***********************************backButton*************************************/
		backButton.setBounds(10, 10, 57, 16);
		backButton.setFocusable(false);
		backButton.setVerticalAlignment(JButton.CENTER);
		backButton.setHorizontalAlignment(JButton.CENTER);
		backButton.setFont(new Font("Arial", Font.PLAIN, 11));
		backButton.setBackground(Color.WHITE);
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				backButtonActionPerformed(e);
			}
		});
		
		
		showPassword.setBounds(125, 180, 125, 25);
		showPassword.setBackground(Color.CYAN);
		showPassword.setFocusable(false);
		showPassword.addActionListener(this);
		
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(showPassword);
		frame.add(messageLabel);
		frame.add(loginButton);
		frame.add(resetButton);
		frame.add(backButton);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	protected void backButtonActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==backButton) {
			frame.dispose();
			new OptionsPage();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==resetButton) {
			userIDField.setText("");
			userPasswordField.setText("");
			messageLabel.setText("");
		}
		
		if(e.getSource()==loginButton) {
			
			String userID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			
			if(logininfo.containsKey(userID)) {
				if(logininfo.get(userID).equals(password)) {
					messageLabel.setForeground(Color.green);
					messageLabel.setText("Login sucessful");
					frame.dispose();
					DatabasePage welcomePage = new DatabasePage(userID);
				}
				else {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("wrong password");
				}
			}
			else {
				messageLabel.setForeground(Color.red);
				messageLabel.setText("username not found");
			}
		}
		
		 //show password
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                userPasswordField.setEchoChar((char) 0);
            } else {
                userPasswordField.setEchoChar('*');
            }


        }
		
	}
}
