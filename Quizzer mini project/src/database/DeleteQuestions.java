
package database;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;


import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import getsqlconnection.ConnectionProvider;
import loginsystem.DatabasePage;

public class DeleteQuestions {
	
	

	JLabel titleLabel = new JLabel();
	JFrame deleteQFrame = new JFrame();
	JButton searchButton = new JButton("Search");
	JButton deleteButton = new JButton("Delete");
	JButton resetButton = new JButton("Reset");
	JButton exitButton = new JButton("Exit");
	JLabel ID_label = new JLabel();
	JLabel que_label = new JLabel();
	JLabel opt1_label = new JLabel();
	JLabel opt2_label = new JLabel();
	JLabel opt3_label = new JLabel();
	JLabel opt4_label = new JLabel();
	JLabel ans_label = new JLabel();
	JTextField id_field = new JTextField();
	JTextField que_field = new JTextField();
	JTextField opt1_field = new JTextField();
	JTextField opt2_field = new JTextField();
	JTextField opt3_field = new JTextField();
	JTextField opt4_field = new JTextField();
	JTextField ans_field = new JTextField();
	Font myFont = new Font("Tahoma", Font.PLAIN, 20);//Font for JTextField
	
	public DeleteQuestions() {
		
		/***************************label************************************/
		titleLabel.setText("DELETE QUESTION");
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
		titleLabel.setBounds(50, 30, 450, 35);
		
		
		ID_label.setText("Question ID:");
		ID_label.setForeground(Color.RED);
		ID_label.setFont(new Font("Arial", Font.BOLD, 30));
		ID_label.setBounds(50, 130, 250, 35);

		
		que_label.setText("Question:");
		que_label.setFont(new Font("Arial", Font.BOLD, 30));
		que_label.setBounds(50, 190, 210, 35);
	
		
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
	
		
		ans_label.setText("Answer:");
		ans_label.setFont(new Font("Arial", Font.BOLD, 30));
		ans_label.setBounds(50, 490, 210, 35);
	
		
		/****************************textField******************************/
		
		id_field.setBounds(270, 130, 250, 35);
		id_field.setFont(myFont);
		
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
				// TODO Auto-generated method stub
				exitButtonActionPerformed(e); 
			}

			public void exitButtonActionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		
	int value = JOptionPane.showConfirmDialog(null, "Do You really want to exit the Application?" , "select" , JOptionPane.YES_NO_OPTION);
				
				if(value == 0) { // if Yes=0
					DatabasePage.open=0;
					deleteQFrame.dispose();
				
				}
					
			}
		});
		
		
		
		
		deleteButton.setBounds(270, 575, 150, 50);
		deleteButton.setFocusable(false);
		deleteButton.setHorizontalAlignment(JButton.CENTER);
		deleteButton.setFont(new Font("Arial", Font.BOLD, 25));
		deleteButton.setBackground(Color.WHITE);
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			deleteButtonActionPerformed(e);
			}
		});
		
		
		
		
		
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
		
		
		
		
		
		
		searchButton.setBounds(550, 120, 150, 50);
		searchButton.setFocusable(false);
		searchButton.setHorizontalAlignment(JButton.CENTER);
		searchButton.setFont(new Font("Arial", Font.BOLD, 25));
		searchButton.setBackground(Color.WHITE);
		searchButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e ) {
				// TODO Auto-generated method stub
				searchButtonActionPerformed(e);
			}
		});
		
		
		
		/*********************************updateQFrame********************************/
		
		deleteQFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		deleteQFrame.setSize(950, 650);
		deleteQFrame.setResizable(true);
		deleteQFrame.setLayout(null);
		deleteQFrame.setUndecorated(false);//remove title bar
		deleteQFrame.setLocationRelativeTo(null);
		deleteQFrame.getContentPane().setBackground(Color.ORANGE);
		
		deleteQFrame.add(titleLabel);
		deleteQFrame.add(ID_label);
		deleteQFrame.add(que_label);
		deleteQFrame.add(opt1_label);
		deleteQFrame.add(opt2_label);
		deleteQFrame.add(opt3_label);
		deleteQFrame.add(opt4_label);
		deleteQFrame.add(ans_label);
		
		deleteQFrame.add(id_field);
		deleteQFrame.add(que_field);
		deleteQFrame.add(opt1_field);
		deleteQFrame.add(opt2_field);
		deleteQFrame.add(opt3_field);
		deleteQFrame.add(opt4_field);
		deleteQFrame.add(ans_field);
		deleteQFrame.add(exitButton);
		deleteQFrame.add(searchButton);
		deleteQFrame.add(deleteButton);
		deleteQFrame.add(resetButton);
		deleteQFrame.setVisible(true);
		
	}//ends of constructor

	/*$$$$$$$$$$$$$$$$$$$$$$$$$$  main connection logic is here  $$$$$$$$$$$$$$$$$$$$$$*/
	private void searchButtonActionPerformed(ActionEvent e ) {
		
		String id = id_field.getText();
		
		try {
			Connection connection = ConnectionProvider.getCon();
			Statement stmnt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmnt.executeQuery("select *from question where id ='"+id+"'");//'"+id+"'
			if(rs.first()) {
				
				 que_field.setText(rs.getString(2));
				 opt1_field.setText(rs.getString(3));
				 opt2_field.setText(rs.getString(4));
				 opt3_field.setText(rs.getString(5));
				 opt4_field.setText(rs.getString(6));
				 ans_field.setText(rs.getString(7));
				 id_field.setEditable(false);
			}
			else {
				JFrame jf = new JFrame();
				jf.setAlwaysOnTop(true);
				JOptionPane.showMessageDialog(jf, "Question ID does not exist!");
				}
		} 
		catch (Exception e1) {

			JFrame jf = new JFrame();
			jf.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(jf, e1);
		}   

	}


	private void resetButtonActionPerformed(ActionEvent e) {
		
		 que_field.setText("");
		 opt1_field.setText("");
		 opt2_field.setText("");
		 opt3_field.setText("");
		 opt4_field.setText("");
		 ans_field.setText("");
		 que_field.setEditable(true);
	}


	private void deleteButtonActionPerformed(ActionEvent e) {
		
		String id = id_field.getText();

		try {
			Connection connection = ConnectionProvider.getCon();
			PreparedStatement ps = connection.prepareStatement("delete from question where id=?");
			
			ps.setString(1, id);
			ps.executeUpdate();
			
			JFrame jf = new JFrame();
			jf.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(jf, "Successfully Deleted");
			deleteQFrame.dispose();
			new DeleteQuestions().setVisible(true);
				
		} catch (Exception e2) {
			JFrame jf = new JFrame();
			jf.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(jf, e2);
		}
	}




public void setVisible(boolean b) {

	
}
	

}
