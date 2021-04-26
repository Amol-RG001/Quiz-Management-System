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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

//import com.mysql.cj.xdevapi.Column;

import getsqlconnection.ConnectionProvider;
import loginsystem.DatabasePage;
//import net.proteanit.sql.DbUtils;

public class AllStudentResult extends JFrame {
	
	
	JFrame allQFrame = new JFrame();
	JButton exitButton = new JButton("Exit");
	JButton deleteAllButton = new JButton("Delete All");
	JButton removeSelectedRow = new JButton("Remove Selected Row");
	JLabel titleLabel = new JLabel();
	JTable table;
	
	ResultSet rs;
	Statement st;
	Object data1[][];
	
	public AllStudentResult() {
		
/************************************removeSelectedRowButton*********************************/
	removeSelectedRow.setBounds(700, 615, 200, 35);
	removeSelectedRow.setFocusable(false);
	removeSelectedRow.setVerticalAlignment(JButton.CENTER);
	removeSelectedRow.setHorizontalAlignment(JButton.CENTER);
	removeSelectedRow.setFont(new Font("Arial", Font.BOLD, 15));
	removeSelectedRow.setBackground(Color.ORANGE);
	removeSelectedRow.requestFocus();

	removeSelectedRow.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			removeSelectedRowActionPerformed(e); 
		}

		private void removeSelectedRowActionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			
			int value = JOptionPane.showConfirmDialog(null, "Do you want remove selected row?" , "select" , JOptionPane.YES_NO_OPTION);
			if(value == 0) { 
				
				int row = table.getSelectedRow();
				String cell = table.getModel().getValueAt(row, 1).toString();
				String sql = "delete from student where contact= "+cell;
	
			try {
				

				Connection connection = ConnectionProvider.getCon();
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.execute();
				
				
				
				JFrame jf1 = new JFrame();
				jf1.setAlwaysOnTop(true);
				JOptionPane.showMessageDialog(jf1, "selected row remove successfully");
			}
			catch(Exception ex) {
				
				JFrame jf1 = new JFrame();
				jf1.setAlwaysOnTop(true);
				
				JOptionPane.showMessageDialog(jf1, ex);
			}
		}}});
		
/************************************deleteAllButton*********************************/
		deleteAllButton.setBounds(405, 615, 125, 35);
		deleteAllButton.setFocusable(false);
		deleteAllButton.setVerticalAlignment(JButton.CENTER);
		deleteAllButton.setHorizontalAlignment(JButton.CENTER);
		deleteAllButton.setFont(new Font("Arial", Font.BOLD, 17));
		deleteAllButton.setBackground(Color.RED);
		deleteAllButton.requestFocus();
		
		deleteAllButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				deleteAllButtonActionPerformed(e); 
			}

			public void deleteAllButtonActionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		
	int value = JOptionPane.showConfirmDialog(null, "Do you really want to DELETE ALL data?" , "select" , JOptionPane.YES_NO_OPTION);
				
				if(value == 0) { // if Yes=0
					DatabasePage.open=0;
					/*truncate code here*/
					 try {
							
							
				        	Connection con = ConnectionProvider.getCon();

							 PreparedStatement ps = con.prepareStatement("truncate table student");
							
							 ps.executeUpdate();
							 
							 	JFrame jf = new JFrame();
								jf.setAlwaysOnTop(true);
								JOptionPane.showMessageDialog(jf, "ALL DATA DELETED!!");
				            
					 }
					 catch (Exception ex) {
				        	
				        	JFrame jf = new JFrame();
							jf.setAlwaysOnTop(true);
							JOptionPane.showMessageDialog(jf, ex);
					
				        }
				
				}
					
			}
		});
/************************************end of delete all button****************************/

		
/************************************exitButton*********************************/
		exitButton.setBounds(580, 615, 75, 35);
		exitButton.setFocusable(false);
		exitButton.setVerticalAlignment(JButton.CENTER);
		exitButton.setHorizontalAlignment(JButton.CENTER);
		exitButton.setFont(new Font("Arial", Font.BOLD, 20));
		exitButton.setBackground(Color.GREEN);
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
		allQFrame.setTitle("All Student Result");
		allQFrame.setForeground(Color.ORANGE);
		
		allQFrame.add(exitButton);
		allQFrame.add(deleteAllButton);
		allQFrame.add(removeSelectedRow);
/****************************try and catch******************************/
		 try {
	        	Connection con = ConnectionProvider.getCon();
	        	st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	            rs = st.executeQuery("select *from student");

	            // Counting rows
	            rs.last();
	            int rows = rs.getRow();
	            rs.beforeFirst();


	            ResultSetMetaData metaData = rs.getMetaData();
	            int column = metaData.getColumnCount();
	          

	            Object[] Colheads = {"Name", "Contact", "Email-ID", "Marks"};

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
	
	/*public static void main(String agrs[]) {
		AllStudentResult aq = new AllStudentResult();
		
	}*/
}
