

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import getsqlconnection.ConnectionProvider;
import loginsystem.DatabasePage;
import quizsystem.OptionsPage;


	public class MultiUserLogin implements ActionListener {
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			MultiUserLogin o = new MultiUserLogin();

		}

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
		
		
		
		public MultiUserLogin (){
			//logininfo  = logininfoReal;
		
			userIDLabel.setBounds(50, 100, 75, 25);
			userPasswordLabel.setBounds(50, 150, 75, 25);
			
			messageLabel.setBounds(75,320,325,35);
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

		@SuppressWarnings("unlikely-arg-type")
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==resetButton) {
				userIDField.setText("");
				userPasswordField.setText("");
				messageLabel.setText("");
			}
			
			if(e.getSource()==loginButton) {
			  	
			  
				try{
					String userID = userIDField.getText();
					String password = String.valueOf(userPasswordField.getPassword());
					
				String query = "select * from multiuserlogin where username like '%"+userID+"%'";
				Connection con = ConnectionProvider.getCon();
				PreparedStatement pst = con.prepareStatement(query);
				
				ResultSet rs = pst.executeQuery();
			
				if(rs.next()) {
					
					String dbasePassword = rs.getString("password").toString().trim();
					String enteredPassword = userPasswordField.getText().trim();
					
					if(dbasePassword.equals(enteredPassword)) {
						messageLabel.setForeground(Color.green);
						messageLabel.setText("Login sucessful");
						frame.dispose();
						DatabasePage welcomePage = new DatabasePage(userID);
					
					}
					else {
						messageLabel.setForeground(Color.red);
						messageLabel.setText("sorry you are unauthorized");
					}
				}
				else {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("user not registered");
				}
				}
				catch(Exception ex){
				JOptionPane.showMessageDialog(null, ex);
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
			
		}}

	
	


