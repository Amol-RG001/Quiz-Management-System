package database;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

//import com.mysql.cj.xdevapi.Column;

import getsqlconnection.ConnectionProvider;
import loginsystem.DatabasePage;
//import net.proteanit.sql.DbUtils;

public class AllQuestions extends JFrame {
	
	
	JFrame allQFrame = new JFrame();
	JButton exitButton = new JButton("Exit");
	JLabel titleLabel = new JLabel();
	JTable table;
	
	    ResultSet rs;
	    Statement st;
	    Object data1[][];
	 
	public AllQuestions() {
		
		
/************************************exitButton*********************************/
		exitButton.setBounds(580, 615, 75, 35);
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
					allQFrame.dispose();
				
				}
					
			}
		});
/************************************end of exit button****************************/
	/***************************JFrame****************************/	
		allQFrame.setSize(700, 300);
		allQFrame.setLocation(100, 100);
		allQFrame.setLayout(new BorderLayout());
		allQFrame.setTitle("All Questions");
		allQFrame.setForeground(Color.ORANGE);
		
		allQFrame.add(exitButton);
		
/****************************try and catch******************************/
		 try {
	        	Connection con = ConnectionProvider.getCon();
	        	st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	            rs = st.executeQuery("select *from question");

	            // Counting rows
	            rs.last();
	            int rows = rs.getRow();
	            rs.beforeFirst();


	            ResultSetMetaData metaData = rs.getMetaData();
	            int column = metaData.getColumnCount();
	          

	            Object[] Colheads = {"Id", "Questions", "Option1", "Option2", "Option3", "Option4", "Answer"};

	            if (Colheads.length != column) {
	                
	                JOptionPane.showMessageDialog(null, "Incorrect Column Headers quantity listed in array! The program will now exit.", "System Error", JOptionPane.ERROR_MESSAGE);
	                System.exit(0);
	            }

	            data1 = new Object[rows][Colheads.length];

	            for (int i = 0; i < rows; i++) {
	                rs.next();
	                
	                for (int j = 0; j < Colheads.length; j++) {
	                    data1[i][j] = rs.getString(j + 1);
	                }
	            }
	            
	            /**********************************JTable****************************************/
	          
	            table = new JTable(data1, Colheads);
	            table.setEnabled(true);
	          //  table.setBounds(0, 100, 500, 500);
	            table.setForeground(Color.blue);
	            table.setBackground(Color.LIGHT_GRAY);
	            table.setOpaque(true);
	            
	            JTableHeader tableHeader = table.getTableHeader();
	            tableHeader.setBackground(Color.DARK_GRAY);
	            tableHeader.setForeground(Color.WHITE);
	            /**********************************JScrollPane****************************************/
	            JScrollPane jsp = new JScrollPane(table);
	            allQFrame.getContentPane().add(jsp);

	        } catch (Exception ex) {
	        	
	        	JFrame jf = new JFrame();
				jf.setAlwaysOnTop(true);
				JOptionPane.showMessageDialog(jf, ex);
		
	        }

		 allQFrame.setVisible(true);
		 allQFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

	    }

		


public void setVisible(boolean b) {
	
}
	
	public static void main(String agrs[]) {
		AllQuestions aq = new AllQuestions();
		
	}
}
