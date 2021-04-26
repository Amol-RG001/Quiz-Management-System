package quizsystem;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import database.AddNewQuestions;
import database.AllStudentResult;
import getsqlconnection.ConnectionProvider;


public class StudentDetails extends JFrame implements ActionListener{
	
	JPanel panel = new JPanel(new FlowLayout());
	JButton saveandnextButton = new JButton("Save");
	JButton resetButton = new JButton("Reset");
	JButton backButton = new JButton("back");
	
	JFrame studentFrame = new  JFrame("Student Details");
	
	JLabel label = new JLabel();
	JLabel nameLabel = new JLabel();
	JLabel contactLabel = new JLabel();
	JLabel emailLabel = new JLabel();
	
	JTextField nameTextField = new JTextField();
	JTextField contactTextField = new JTextField();
	JTextField emailTextField = new JTextField();

	ImageIcon saveIcon = new ImageIcon("C:\\Users\\Rohit\\Desktop\\Apna Group Project\\floppy-disk.png");
	ImageIcon resetIcon = new ImageIcon("C:\\Users\\Rohit\\Desktop\\Apna Group Project\\icons8-reset-32.png");
	Border border = BorderFactory.createLineBorder(Color.CYAN, 1);
	Font myFont = new Font("Arial", Font.PLAIN, 15);
	
	
	//create constructor
		StudentDetails() {
			
			/***********************************frame*************************************/
			studentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			studentFrame.setSize(750, 500);
			studentFrame.setResizable(true);
			studentFrame.setLayout(null);
			studentFrame.getContentPane().setBackground(Color.GRAY);
			studentFrame.setLocationRelativeTo(null);
			studentFrame.add(label);
			studentFrame.add(nameLabel);
			studentFrame.add(contactLabel);
			studentFrame.add(emailLabel);
			studentFrame.add(nameTextField);
			studentFrame.add(contactTextField);
			studentFrame.add(emailTextField);
			studentFrame.add(saveandnextButton);
			studentFrame.add(resetButton);
			studentFrame.add(backButton);
			studentFrame.setVisible(true);
			
			/***********************nameLabel**************************/
			nameLabel.setText("Name");
			nameLabel.setHorizontalTextPosition(JLabel.LEFT);
			nameLabel.setFont(new Font("Arial",Font.BOLD ,20));
			nameLabel.setBounds(150, 100, 75, 50);
		
			/****************************nameTextField**********************/
			nameTextField.setBounds(350, 105, 250, 30);
			nameTextField.setFont(myFont);
			nameTextField.setBorder(border);
			nameTextField.requestFocus();
			nameTextField.transferFocus();
			
			/***********************contactLabel***************************/
			contactLabel.setText("Contact");
			contactLabel.setLayout(new BorderLayout());
			contactLabel.setHorizontalTextPosition(JLabel.LEFT);
			contactLabel.setFont(new Font("Arial",Font.BOLD ,20));
			contactLabel.setBounds(150, 150, 75, 50);
			
			/**********************contactTextField******************************/
			contactTextField.setBounds(350, 155, 250, 30);
			contactTextField.setFont(myFont);
			contactTextField.setBorder(border);
			contactTextField.setLayout(null);
			contactTextField.requestFocus();
			contactTextField.transferFocus();
		
			
		/*ONLY NUMBERS LOGIC*/
			contactTextField.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent k) {
					
					String value = contactTextField.getText();
					int numberLength = value.length();
					
					if(k.getKeyChar()>='0' && k.getKeyChar()<='9') {
						contactTextField.setEditable(true);
						
						if(numberLength<10) {
							contactTextField.setEditable(true);
						}else {
							contactTextField.setEditable(false);
						}

					}
					else {
						contactTextField.setEditable(false);
						if(k.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE||k.getExtendedKeyCode()==KeyEvent.VK_DELETE) {
							contactTextField.setEditable(true);
						}
						else {
							contactTextField.setEditable(false);
						}
					}
				}
				
			});/*END OF LOGIC*/
			
			/*******************************emailLabel****************************/
			emailLabel.setText("Email-ID");
			emailLabel.setHorizontalTextPosition(JLabel.LEFT);
			emailLabel.setFont(new Font("Arial",Font.BOLD ,20));
			emailLabel.setBounds(150, 200, 100, 50);

			/************************emailTextField******************************/
			emailTextField.setBounds(350, 205, 250, 30);
			emailTextField.setFont(myFont);
			emailTextField.setBorder(border);
			emailTextField.requestFocus();
			emailTextField.transferFocus();
		
			
			/*************************saveandnextButton***********************************/
			saveandnextButton.setBounds(150, 350, 150, 50);
			saveandnextButton.setFocusable(false);
			saveandnextButton.setHorizontalAlignment(JButton.CENTER);
			saveandnextButton.setFont(new Font("Arial", Font.BOLD, 25));
			saveandnextButton.setBackground(Color.WHITE);
			saveandnextButton.setIcon(saveIcon);
			saveandnextButton.setBorder(border);

			saveandnextButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					saveandnextButtonActionPerformed(e);
				}

			});
			
			/***********************************resetButton*************************************/
			resetButton.setBounds(450, 350, 150, 50);
			resetButton.setFocusable(false);
			resetButton.setHorizontalAlignment(JButton.CENTER);
			resetButton.setFont(new Font("Arial", Font.BOLD, 25));
			resetButton.setBackground(Color.WHITE);
			resetButton.setIcon(resetIcon);
			
			resetButton.setBorder(border);
			resetButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					resetButtonActionPerformed(e);
				}
			});
			
			/***********************************backButton*************************************/
			backButton.setBounds(25, 25, 60, 25);
			backButton.setFocusable(false);
			backButton.setHorizontalAlignment(JButton.CENTER);
			backButton.setFont(new Font("Arial", Font.PLAIN, 12));
			backButton.setBackground(Color.WHITE);
		
			backButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					backButtonActionPerformed(e);
				}
			});
			
	
		
	}//end of constructor

	

	
		private void backButtonActionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==backButton) {
				studentFrame.dispose();
				new OptionsPage();
			}
		}



		private void resetButtonActionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()== resetButton) {
				nameTextField.setText("");
				contactTextField.setText("");
				emailTextField.setText("");
			}
		}



		private void saveandnextButtonActionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
	
			
			
			if(e.getSource()==saveandnextButton) {
				
				if(nameTextField.getText().trim().isEmpty() && emailTextField.getText().trim().isEmpty()) {
					  JOptionPane.showMessageDialog(null, "Please enter your details!!" , "Please Fill", JOptionPane.OK_OPTION);
					
				}
				else if(nameTextField.getText().trim().isEmpty()) {
					  JOptionPane.showMessageDialog(null, "Please enter your name !!" , "Please Fill", JOptionPane.OK_OPTION);
					
				}
				
				else if(contactTextField.getText().trim().isEmpty()) {
					  JOptionPane.showMessageDialog(null, "Please enter your Contact  !!" , "Please Fill", JOptionPane.OK_OPTION);
					
				}
				else if(emailTextField.getText().trim().isEmpty()) {
					  JOptionPane.showMessageDialog(null, "Please enter your Email !!" , "Please Fill", JOptionPane.OK_OPTION);
					
				}
				else {
					studentFrame.dispose();
					String getName =  nameTextField.getText();
					String getContact = contactTextField.getText();
					String getEmail = emailTextField.getText();
					
					/********************************************database part*****************************/
					
						String name = nameTextField.getText();
						String contact = contactTextField.getText();
						String email = emailTextField.getText();
						String marks ="0";
					
						
					//$$$$$$$$$$$$$$$$$$$$$
					try {
						Connection connection = ConnectionProvider.getCon();
						PreparedStatement ps = connection.prepareStatement("insert into student values(?,?,?,?)");
					
				
						ps.setString(1, name);
						ps.setString(2, contact);
						ps.setString(3, email);
						ps.setString(4, marks);
						
						ps.executeUpdate();
						
						
						JFrame jf = new JFrame();
						jf.setAlwaysOnTop(true);
						JOptionPane.showMessageDialog(jf, "Student details is Saved!!");
						
						new QuizInstructionPage(getName, getContact, getEmail);
						
						
						
					} catch (Exception e2) {
						JFrame jf = new JFrame();
						jf.setAlwaysOnTop(true);
						JOptionPane.showMessageDialog(jf, e2);
					}
				}
				
			
				
			}

				/***************************************end of database part******************************/
			
			
		
		}



		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			/*if(e.getSource()== contactTextField) {
				
				String mobileNo = contactTextField.getText(); 
				new AllStudentResult(mobileNo);
			}*/
		}
		
		
}
