package quizsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.border.Border;



public class WelcomePage {

	JFrame welcomeFrame = new JFrame();

	
	JLabel quizAppLabel = new JLabel();
	JLabel label = new JLabel();
	JLabel apnaGroupLabel = new JLabel();
	
	Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
	Border frameBorder = BorderFactory.createLineBorder(Color.BLACK, 2);
	Border progressBorder = BorderFactory.createLineBorder(Color.DARK_GRAY , 7);
	
	JProgressBar bar = new JProgressBar();
	
	//create constructor
	WelcomePage(){
		
		/************************************frame*******************************/
		welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		welcomeFrame.setSize(750, 415);
		welcomeFrame.setResizable(true);
		welcomeFrame.setLayout(null);
		welcomeFrame.setUndecorated(true);//remove title bar
		welcomeFrame.setLocationRelativeTo(null);//used for center a window
		welcomeFrame.add(bar);
		welcomeFrame.add(quizAppLabel);
		welcomeFrame.add(label);
		welcomeFrame.add(apnaGroupLabel);
		welcomeFrame.setAlwaysOnTop(true);
		welcomeFrame.getContentPane().setBackground(Color.GRAY);
		((JComponent) welcomeFrame.getContentPane()).setBorder(frameBorder);
		welcomeFrame.setVisible(true);
		
		/************************************ QUIZ APP label****************************/
		quizAppLabel.setText("Quiz App");
		quizAppLabel.setHorizontalAlignment(JLabel.CENTER);
		quizAppLabel.setVerticalAlignment(JLabel.CENTER);
		quizAppLabel.setBounds(200, 25, 350, 75);
		quizAppLabel.setFont(new Font("Arial", Font.BOLD, 50));
		quizAppLabel.setBorder(border);
		quizAppLabel.setBackground(Color.WHITE);
		quizAppLabel.setOpaque(true);
		
		/****************************** Design And Developed By label****************************/
		label.setText("Design And Developed By");
		label.setBounds(20, 50, 700, 250);
		label.setFont(new Font("Arial", Font.BOLD, 55));
		label.setForeground(Color.ORANGE);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		
		/************************** Apna Group label**********************************/
		apnaGroupLabel.setText("Apna Group");
		apnaGroupLabel.setBounds(200, 150, 350, 250);
		apnaGroupLabel.setFont(new Font ("Arial", Font.BOLD, 55));
		apnaGroupLabel.setForeground(Color.RED);
		apnaGroupLabel.setHorizontalAlignment(JLabel.CENTER);
		apnaGroupLabel.setVerticalAlignment(JLabel.CENTER);
		
		
		/**************************progressBar******************************/
		bar.setValue(0);
		bar.setBounds(100, 350, 525, 40);
		bar.setStringPainted(true); // showing percent on bar
		bar.setBackground(Color.BLACK);
		bar.setBorder(progressBorder);
		
		fillBar();//invoked method
		
		/************************visible proceedButton after some time*********************************/
		try {
			
			Thread.sleep(500);//get sleep for 5 seconds
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}//constructor ends


	// create fillBar method to FILL THE PROGRESS BAR
	 void fillBar() {
	
		int count = 0;
		
		while(count<=100) {
			bar.setValue(count);
			try {
				Thread.sleep(100);
				
				if(count==100) {
					
					Thread.sleep(500);
					welcomeFrame.dispose(); //destroy the welcomePage frame
					
					new OptionsPage();//invoked OptionsPage Class
				}
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
			bar.setString("Loading Progress "+count++ +"%");	
		}
		
		
		
		
	}
	 
		
}//END OF CLASS
