package loginsystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import getsqlconnection.ConnectionProvider;
public class Registration implements ActionListener {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Registration k = new Registration();
	}
	
	JFrame frame = new JFrame("Registration Form");
	JButton submitButton = new JButton("Register");
	
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("Username");
	JLabel userPasswordLabel = new JLabel("Password");
	JLabel messageLabel = new JLabel();
	JCheckBox showPassword = new JCheckBox("Show Password");
	
	
	
	 public Registration(){
		//logininfo  = logininfoReal;
	
		userIDLabel.setBounds(50, 100, 75, 25);
		userPasswordLabel.setBounds(50, 150, 75, 25);
		
		messageLabel.setBounds(125,275,250,35);
		messageLabel.setFont(new Font(null, Font.ITALIC, 25));
		
		userIDField.setBounds(125, 100, 200, 25);
		userPasswordField.setBounds(125, 150, 200, 25);
		
		///button
		submitButton.setBounds(125, 275, 125, 30);
		submitButton.setBackground(Color.GREEN);
		submitButton.setForeground(Color.WHITE);
		submitButton.setFont(new Font("Arial Black", Font.BOLD, 16));
		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				submitButtonActionPerformed(e);
			}

			private void submitButtonActionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//REGISTRATION BUTTON
				if(e.getSource()==submitButton) {
				  	
				  	String userID = userIDField.getText();
					String password = String.valueOf(userPasswordField.getPassword());
					
				 
					try{
					String query = "INSERT INTO multiuserlogin values(?,?)";
					Connection con = ConnectionProvider.getCon();
					
					PreparedStatement pst = con.prepareStatement(query);
					pst.setString(1, userID);
					pst.setString(2, password);
					pst.executeUpdate();
					}
					
					catch(Exception ex){
					JOptionPane.showMessageDialog(null, ex);
					}
					
					frame.dispose();
					new LoginPage();
					
			}
		}});
		
		showPassword.setBounds(125, 200, 125, 25);
		showPassword.setBackground(new Color(127,0,255));
		showPassword.setFocusable(false);
		showPassword.addActionListener(this);
		
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(showPassword);
		frame.add(messageLabel);
		frame.add(submitButton);
	
		frame.getContentPane().setBackground(new Color(127,0,255));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		

	
		
		 //show password
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                userPasswordField.setEchoChar((char) 0);
            } else {
                userPasswordField.setEchoChar('*');
            }


        }
		
	}}








