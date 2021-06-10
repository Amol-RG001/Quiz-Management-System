package quizsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.TileObserver;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

public class OptionsPage implements ActionListener {

	JFrame optionsFrame = new JFrame("Select Options");
	JButton adminButton = new JButton("Admin");
	JButton studentButton = new JButton("Student");
	
	JButton exitButton = new JButton("Exit");
	//C:\Users\Rohit\git\Quizer\APNA GROUP PROJECT\src\Images
	ImageIcon adminIcon = new ImageIcon("C:\\Users\\Rohit\\git\\APNA GROUP PROJECT\\src\\Images\\admin.png");
	ImageIcon studentIcon = new ImageIcon("C:\\Users\\Rohit\\git\\APNA GROUP PROJECT\\src\\Images\\student.png");
	ImageIcon exitIcon = new ImageIcon("C:\\Users\\Rohit\\git\\APNA GROUP PROJECT\\src\\Images\\exit01.png");

	Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
	Border frameBorder = BorderFactory.createLineBorder(Color.BLACK, 2);
	Border progressBorder = BorderFactory.createLineBorder(Color.DARK_GRAY , 7);
	
	//create constructor
	public OptionsPage(){
		
		/**********************************************optionsFrame***************************************/
		optionsFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		optionsFrame.setSize(750, 500);
		optionsFrame.setResizable(false);
		optionsFrame.setLayout(null);
		optionsFrame.getContentPane().setBackground(Color.GRAY);
		((JComponent) optionsFrame.getContentPane()).setBorder(frameBorder);
		optionsFrame.setUndecorated(false);
		optionsFrame.setLocationRelativeTo(null);

		optionsFrame.add(adminButton);
		optionsFrame.add(studentButton);
		optionsFrame.add(exitButton);
		optionsFrame.setVisible(true);
		
		/**********************************adminButton***********************************/
		adminButton.setBounds(275, 100, 250, 50);
		adminButton.setFocusable(false);
		adminButton.setVerticalAlignment(JButton.CENTER);
		adminButton.setHorizontalAlignment(JButton.LEFT);
		adminButton.setFont(new Font("Arial", Font.BOLD, 25));
		adminButton.setBackground(Color.WHITE);
		adminButton.setBorder(border);
		adminButton.setIcon(adminIcon);
		adminButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				adminButtonActionPerformed();
			}
		});
		
		/**********************************studentButton***********************************/
		studentButton.setBounds(275, 200, 250, 50);
		studentButton.setFocusable(false);
		studentButton.setVerticalAlignment(JButton.CENTER);
		studentButton.setHorizontalAlignment(JButton.LEFT);
		studentButton.setFont(new Font("Arial", Font.BOLD, 25));
		studentButton.setBackground(Color.WHITE);
		studentButton.setBorder(border);
		studentButton.setIcon(studentIcon);
		studentButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				studentButtonActionPerformed();
			}
		});
		
		/************************************exitButton*********************************/
		exitButton.setBounds(275, 300, 250, 50);
		exitButton.setFocusable(false);
		exitButton.setVerticalAlignment(JButton.CENTER);
		exitButton.setHorizontalAlignment(JButton.LEFT);
		exitButton.setFont(new Font("Arial", Font.BOLD, 25));
		exitButton.setBackground(Color.WHITE);
		exitButton.setBorder(border);
		exitButton.setIcon(exitIcon);
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				exitButtonActionPerformed(e); 
			}
		});
		
		
		
	}//constructor end


	private void adminButtonActionPerformed() {
		
		optionsFrame.dispose();//destroy frame
		new AdminLogin();//invoked class
	}


	private void studentButtonActionPerformed() {
	
		optionsFrame.dispose();//destroy frame
		new StudentDetails();//invoked class
	}


	private void exitButtonActionPerformed(ActionEvent e) {
	
		
		int value = JOptionPane.showConfirmDialog(null, "Do You really want to exit the Application?" , "select" , JOptionPane.YES_NO_OPTION);
		
		if(value == 0) { // if Yes=0
			
			System.exit(0);
		}
			
	
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String agrs[]) {
		new OptionsPage();
	}

}
