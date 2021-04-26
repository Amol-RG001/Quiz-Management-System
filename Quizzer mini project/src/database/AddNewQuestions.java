package database;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import getsqlconnection.ConnectionProvider;
import loginsystem.DatabasePage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddNewQuestions extends JFrame {
	
	JFrame addQFrame = new JFrame();
	JButton exitButton = new JButton("Exit");
	JButton saveButton = new JButton("Save");
	JButton resetButton = new JButton("Reset");
	JLabel ID_label = new JLabel();
	JLabel ID = new JLabel();
	JLabel que_label = new JLabel();
	JLabel opt1_label = new JLabel();
	JLabel opt2_label = new JLabel();
	JLabel opt3_label = new JLabel();
	JLabel opt4_label = new JLabel();
	JLabel ans_label = new JLabel();
	JLabel titleLabel = new JLabel();
	JTextField que_field = new JTextField();
	JTextField opt1_field = new JTextField();
	JTextField opt2_field = new JTextField();
	JTextField opt3_field = new JTextField();
	JTextField opt4_field = new JTextField();
	JTextField ans_field = new JTextField();
	int Qid;
	Font myFont = new Font("Tahoma", Font.PLAIN, 20);//Font for JTextField
	
	public AddNewQuestions() {
		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	
		try {
			
			Connection connection = ConnectionProvider.getCon();
			Statement stmnt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmnt.executeQuery("select count(id) from question");
			if(rs.first()) {
				
				Qid = rs.getInt(1);
				Qid = Qid+1;
				String str = String.valueOf(Qid);
				
				ID_label.setText(str);
			}
			else {
				ID_label.setText("1");
			}
		}
		catch (Exception e1) {

			JFrame jf = new JFrame();
			jf.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(jf, e1);
		}   
		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		
	
		
		/***************************title_label************************************/
		titleLabel.setText("ADD NEW QUESTION");
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
		titleLabel.setBounds(50, 30, 650, 35);
		
		/***************************id_label************************************/
		
		ID.setText("Question ID: ");
		ID.setForeground(Color.RED);
		ID.setFont(new Font("Arial", Font.BOLD, 30));
		ID.setBounds(50, 120, 250, 35);
		
		ID_label.setText(""+Qid);
		ID_label.setBounds(250, 120, 250, 35);
		ID_label.setForeground(Color.RED);
		ID_label.setFont(new Font("Arial", Font.BOLD, 30));
		
	
		/***************************que_label************************************/
		que_label.setText("Question:");
		que_label.setFont(new Font("Arial", Font.BOLD, 30));
		que_label.setBounds(50, 190, 210, 35);

		/***************************option_label************************************/
		opt1_label.setText("Option 1:");
		opt1_label.setFont(new Font("Arial", Font.BOLD, 30));
		opt1_label.setBounds(50, 250, 210, 35);

		opt2_label.setText("Option 2:");
		opt2_label.setFont(new Font("Arial", Font.BOLD, 30));
		opt2_label.setBounds(50, 310, 210, 35);
		
		opt3_label.setText("Option 3:");
		opt3_label.setFont(new Font("Arial", Font.BOLD, 30));
		opt3_label.setBounds(50, 370, 210, 35);
	
		opt4_label.setText("Option 4:");
		opt4_label.setFont(new Font("Arial", Font.BOLD, 30));
		opt4_label.setBounds(50, 430, 210, 35);

		/***************************ans_label************************************/
		ans_label.setText("Answer:");
		ans_label.setFont(new Font("Arial", Font.BOLD, 30));
		ans_label.setBounds(50, 490, 210, 35);

		/****************************JtextField******************************/
		que_field.setBounds(270, 190, 650, 35);
		que_field.setFont(myFont);
		
		opt1_field.setBounds(270, 250, 650, 35);
		opt1_field.setFont(myFont);
		
		opt2_field.setBounds(270, 310, 650, 35);
		opt2_field.setFont(myFont);
		
		opt3_field.setBounds(270, 370, 650, 35);
		opt3_field.setFont(myFont);
		
		opt4_field.setBounds(270, 430, 650, 35);
		opt4_field.setFont(myFont);
		
		ans_field.setBounds(270, 490, 650, 35);
		ans_field.setFont(myFont);
		
/************************************exitButton*********************************/
		exitButton.setBounds(850, 30, 75, 35);
		exitButton.setFocusable(false);
		exitButton.setVerticalAlignment(JButton.CENTER);
		exitButton.setHorizontalAlignment(JButton.CENTER);
		exitButton.setFont(new Font("Arial", Font.BOLD, 20));
		exitButton.setBackground(Color.RED);
		exitButton.requestFocus();
		
		exitButton.addActionListener(new ActionListener() {
			
		

			@Override
			public void actionPerformed(ActionEvent e) {
				
				exitButtonActionPerformed(e); 
			}

			private void exitButtonActionPerformed(ActionEvent e) {
				
				int value = JOptionPane.showConfirmDialog(null, "Do You really want to exit the Application?" , "select" , JOptionPane.YES_NO_OPTION);
				
				if(value == 0) { // if Yes=0
					DatabasePage.open=0;
					addQFrame.dispose();
				
					
				}
					
			}
		});
		
		
/************************************saveButton*********************************/		
		saveButton.setBounds(270, 575, 150, 50);
		saveButton.setFocusable(false);
		saveButton.setHorizontalAlignment(JButton.CENTER);
		saveButton.setFont(new Font("Arial", Font.BOLD, 25));
		saveButton.setBackground(Color.WHITE);
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				saveButtonActionPerformed(e);
			}
		});
		
		
/************************************resetButton*********************************/	
		resetButton.setBounds(470, 575, 150, 50);
		resetButton.setFocusable(false);
		resetButton.setHorizontalAlignment(JButton.CENTER);
		resetButton.setFont(new Font("Arial", Font.BOLD, 25));
		resetButton.setBackground(Color.WHITE);
		resetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				resetButtonActionPerformed(e);
			}
		});
		
		
		
		
/*********************************addQFrame********************************/
		
		addQFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addQFrame.setSize(950, 650);
		addQFrame.setResizable(true);
		
		addQFrame.setLayout(null);
		addQFrame.setUndecorated(false);//remove title bar
		addQFrame.setLocationRelativeTo(null);
		addQFrame.getContentPane().setBackground(Color.ORANGE);
		addQFrame.add(titleLabel);
		addQFrame.add(ID);
		addQFrame.add(ID_label);
		addQFrame.add(que_label);
		addQFrame.add(opt1_label);
		addQFrame.add(opt2_label);
		addQFrame.add(opt3_label);
		addQFrame.add(opt4_label);
		addQFrame.add(ans_label);
		addQFrame.add(exitButton);
		addQFrame.add(que_field);
		addQFrame.add(opt1_field);
		addQFrame.add(opt2_field);
		addQFrame.add(opt3_field);
		addQFrame.add(opt4_field);
		addQFrame.add(ans_field);
		
		addQFrame.add(saveButton);
		addQFrame.add(resetButton);
		addQFrame.setVisible(true);
		
	}//ends of constructor

	
	private void resetButtonActionPerformed(ActionEvent e) {
		
		 que_field.setText("");
		 opt1_field.setText("");
		 opt2_field.setText("");
		 opt3_field.setText("");
		 opt4_field.setText("");
		 ans_field.setText("");
	}


	private void saveButtonActionPerformed(ActionEvent e) {
		
		String id = ID_label.getText();
		String name = que_field.getText();
		String opt1 = opt1_field.getText();
		String opt2 = opt2_field.getText();
		String opt3 = opt3_field.getText();
		String opt4 = opt4_field.getText();
		String answer = ans_field.getText();
		
		try {
			Connection connection = ConnectionProvider.getCon();
			PreparedStatement ps = connection.prepareStatement("insert into question values(?,?,?,?,?,?,?)");
		
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, opt1);
			ps.setString(4, opt2);
			ps.setString(5, opt3);
			ps.setString(6, opt4);
			ps.setString(7, answer);
			ps.executeUpdate();
			
			
			JFrame jf = new JFrame();
			jf.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(jf, "New Question Added ");
			addQFrame.setVisible(false);
			new AddNewQuestions().setVisible(true);
			
			
			
		} catch (Exception e2) {
			JFrame jf = new JFrame();
			jf.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(jf, e2);
		}
	}


public void setVisible(boolean b) {

	
}
	public static void main(String args[]) {
		new AddNewQuestions();
	}
	
}


