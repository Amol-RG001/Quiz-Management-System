package quizsystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

public class MarksPage {
	
	JFrame marksFrame = new JFrame();
	JLabel marksObtain = new JLabel();
	JButton logOut = new JButton("Logout");
	String marksPoint;
	Border border = BorderFactory.createLineBorder(Color.orange, 2);
	public MarksPage(String marks01) {
		// TODO Auto-generated constructor stub
		marksFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marksFrame.setSize(750, 415);
		marksFrame.setResizable(true);
		marksFrame.setLayout(null);
		marksFrame.getContentPane().setBackground(Color.black);
		marksFrame.add(marksObtain);
		marksFrame.add(logOut);
		marksFrame.setUndecorated(true);//remove title bar
		marksFrame.setLocationRelativeTo(null);//used for center a window
		((JComponent) marksFrame.getContentPane()).setBorder(border);
		marksFrame.setVisible(true);
		
		marksPoint = marks01;
		
		marksObtain.setText("Marks Obtained: "+marksPoint);
		
		marksObtain.setBounds(20, 50, 700, 250);
		marksObtain.setFont(new Font("MV Boli", Font.ITALIC , 50 ));
		marksObtain.setForeground(Color.ORANGE);
		marksObtain.setHorizontalAlignment(JLabel.CENTER);
		marksObtain.setVerticalAlignment(JLabel.CENTER);
	
		/************************************logoutButton*********************************/
		logOut.setBounds(330, 250, 95, 40);
		logOut.setFocusable(false);
		logOut.setVerticalAlignment(JButton.CENTER);
		logOut.setHorizontalAlignment(JButton.CENTER);
		logOut.setFont(new Font("Arial Black", Font.BOLD, 15));
		logOut.setBackground(Color.green);
		logOut.setBorder(border);
		//logOut.setIcon(exitIcon);
		logOut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				logOutButtonActionPerformed(e); 
			}

			private void logOutButtonActionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int value = JOptionPane.showConfirmDialog(null, "Do You really want to Logout ?" , "select" , JOptionPane.YES_NO_OPTION);
				
				if(value == 0) { // if Yes=0
					
					
					marksFrame.dispose();
					new OptionsPage();
				}
					
			
			}
		});
		

		
		
		

			

	}
	
/*	//MAIN METHOD
 	public static void main(String args[]) {
		String marks01 = "10";
		new MarksPage(marks01);
	}
	
*/
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
