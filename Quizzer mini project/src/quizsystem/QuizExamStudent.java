package quizsystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.text.SimpleDateFormat;

import getsqlconnection.ConnectionProvider;
import loginsystem.DatabasePage;

import javax.swing.*;
import javax.swing.border.Border;

import database.AllStudentResult;



public class QuizExamStudent extends JFrame implements ActionListener{
	
	public String questionId="1";
	public String answer;
	public int marks= 0;
	public int min = 0;
	public int sec = 0;
	Timer timer;
	JFrame quizAppFrame = new JFrame();
	JPanel redPanel = new JPanel(); //top
	JPanel bluePanel = new JPanel(); //left
	JPanel quePanel = new JPanel();
	JPanel optionsPanel = new JPanel();
	JLabel iconLabel = new JLabel();
	JLabel tTime = new JLabel();
	JLabel timeLabel = new JLabel();
	JLabel lable = new JLabel();
	JLabel secondLabel = new JLabel();
	JLabel minLabel =  new JLabel();
	JLabel redLabel = new JLabel();
	JLabel gmailLabel = new JLabel();
	JLabel blueLabel = new JLabel();
	JLabel totalQLabel = new JLabel();
	JLabel marksLabel = new JLabel();
	JLabel pointLabel = new JLabel();
	JLabel queLabel = new JLabel();
	JLabel optionsLabel = new JLabel();
	JLabel welcomeLabel = new JLabel();
	ImageIcon studentIcon = new ImageIcon("C:\\Users\\Rohit\\git\\Quizer\\APNA GROUP PROJECT\\src\\Images\\graduated.png");
	

	
	JButton submitButton = new JButton("submit");
	JButton nextButton = new JButton("Next");
	JRadioButton jRadioButton1= new JRadioButton();
	JRadioButton jRadioButton2= new JRadioButton();
	JRadioButton jRadioButton3= new JRadioButton();
	JRadioButton jRadioButton4= new JRadioButton();
	JLabel dateLabel = new JLabel();


 String getContact1;


	QuizExamStudent(String getName , String getContact ,String getEmail){
		
		getContact1 = getContact;
		
/********************************try catch block********************************/
		
		try {
			Connection connection = ConnectionProvider.getCon();
			Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rsl = st.executeQuery("select *from question where id='"+questionId+"'");
			while(rsl.next()) {
				
				blueLabel.setText(rsl.getString(1));
				queLabel.setText(rsl.getString(2));
				jRadioButton1.setText(rsl.getString(3));
				jRadioButton2.setText(rsl.getString(4));
				jRadioButton3.setText(rsl.getString(5));
				jRadioButton4.setText(rsl.getString(6));
				answer=rsl.getString(7);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		
/********************************end of try catch block********************************/
		
/*************************************************redPanel**************************************/
	redPanel.setBounds(0, 0, 1280, 100);
	redPanel.setBackground(Color.RED);
	redPanel.setLayout(new BorderLayout());
	
	/******************************************Date Format**************************/
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	Date date = new Date();
	dateLabel.setText("DATE: "+dateFormat.format(date));
	
	dateLabel.setVerticalAlignment(JLabel.CENTER);
	dateLabel.setHorizontalTextPosition(JLabel.RIGHT);
	dateLabel.setBounds(700, 30, 200, 35);
	
	dateLabel.setFont(new Font("MV Boli",Font.BOLD, 15));
	dateLabel.setForeground(Color.WHITE);
	redPanel.add(dateLabel);
/***************************TIME LABLE 0:0*****************************************************************************/	
	
	
	
	tTime.setVerticalAlignment(JLabel.CENTER);
	tTime.setHorizontalTextPosition(JLabel.RIGHT);
	tTime.setBounds(1080, 10, 200, 35);
	tTime.setText("Max Time: 10 min");
	tTime.setFont(new Font("MV Boli",Font.BOLD, 18));
	tTime.setForeground(Color.WHITE);
	redPanel.add(tTime);
	
	timeLabel.setVerticalAlignment(JLabel.CENTER);
	timeLabel.setHorizontalTextPosition(JLabel.RIGHT);
	timeLabel.setBounds(1080, 50, 150, 35);
	timeLabel.setText("Time Taken:- ");
	timeLabel.setFont(new Font("MV Boli",Font.BOLD, 18));
	timeLabel.setForeground(Color.BLUE);
	redPanel.add(timeLabel);
	
	
	minLabel.setVerticalAlignment(JLabel.CENTER);
	minLabel.setHorizontalTextPosition(JLabel.RIGHT);
	minLabel.setBounds(1200, 50, 150, 35);
	minLabel.setFont(new Font("MV Boli",Font.BOLD, 20));
	minLabel.setForeground(Color.BLUE);
	redPanel.add(minLabel);
	
	lable.setBounds(1215, 50, 150, 35);
	lable.setVerticalAlignment(JLabel.CENTER);
	lable.setHorizontalTextPosition(JLabel.RIGHT);
	lable.setFont(new Font("MV Boli",Font.BOLD, 20));
	lable.setForeground(Color.BLUE);
	lable.setText(":");
	redPanel.add(lable);
	
	secondLabel.setVerticalAlignment(JLabel.CENTER);
	secondLabel.setHorizontalTextPosition(JLabel.RIGHT);
	secondLabel.setBounds(1230, 50, 150, 35);
	secondLabel.setFont(new Font("MV Boli",Font.BOLD, 20));
	secondLabel.setForeground(Color.BLUE);
	redPanel.add(secondLabel);
	
	
	
/************************************************\/\/\/******************************************************/	
	
	welcomeLabel.setVerticalAlignment(JLabel.TOP);
	welcomeLabel.setHorizontalTextPosition(JLabel.RIGHT);
	welcomeLabel.setText("Welcome "+getName+"!!");
	welcomeLabel.setFont(new Font("MV Boli",Font.BOLD, 25));
	welcomeLabel.setBounds(75, 10, 350, 35);
	welcomeLabel.setForeground(Color.WHITE);
	redPanel.add(welcomeLabel);
	
	gmailLabel.setVerticalAlignment(JLabel.BOTTOM);
	gmailLabel.setHorizontalTextPosition(JLabel.RIGHT);
	gmailLabel.setBounds(75, 45, 450, 35);
	gmailLabel.setFont(new Font("MV Boli",Font.BOLD, 20));
	gmailLabel.setForeground(Color.WHITE);
	gmailLabel.setText("Gmail: "+getEmail);
	redPanel.add(gmailLabel);
	
	iconLabel.setVerticalAlignment(JLabel.CENTER);
	iconLabel.setHorizontalTextPosition(JLabel.RIGHT);
	iconLabel.setBounds(0, 15, 70, 70);
	iconLabel.setIcon(studentIcon);
	redPanel.add(iconLabel);
	
	
/*************************************************end of redPanel**************************************/

	
/******************************************blue panel*******************************************/
	totalQLabel.setText("Total Question: 10");
	totalQLabel.setBounds(10, 10, 150, 25);
	totalQLabel.setVerticalAlignment(JLabel.TOP);
	totalQLabel.setHorizontalTextPosition(JLabel.LEFT);
	totalQLabel.setFont(new Font("MV Boli",Font.BOLD, 15));
	totalQLabel.setForeground(Color.WHITE); 
	bluePanel.add(totalQLabel);
	
	marksLabel.setText("Your Marks: 0");
	marksLabel.setBounds(10, 90, 125, 25);
	marksLabel.setVerticalAlignment(JLabel.TOP);
	marksLabel.setHorizontalTextPosition(JLabel.LEFT);
	marksLabel.setFont(new Font("MV Boli",Font.BOLD, 15));
	marksLabel.setForeground(Color.WHITE); 
	bluePanel.add(marksLabel);
	
	
	pointLabel.setBounds(115, 90, 125, 25);
	pointLabel.setVerticalAlignment(JLabel.TOP);
	pointLabel.setHorizontalTextPosition(JLabel.LEFT);
	pointLabel.setFont(new Font("MV Boli",Font.BOLD, 15));
	pointLabel.setForeground(Color.WHITE); 
	bluePanel.add(pointLabel);
	
	blueLabel.setBounds(10, 50, 150, 25);
	blueLabel.setVerticalAlignment(JLabel.TOP);
	blueLabel.setHorizontalTextPosition(JLabel.LEFT);
	blueLabel.setFont(new Font("MV Boli",Font.BOLD, 15));
	blueLabel.setForeground(Color.WHITE);
	bluePanel.add(blueLabel);
	
	
	bluePanel.setBounds(0, 105, 185, 555);
	bluePanel.setBackground(Color.BLUE);
	bluePanel.setLayout(new BorderLayout());
	
	
/*************************************************end blue Panel**************************************/

	
	
/**********************************quePanel****************************/
	quePanel.setBounds(190, 105, 1130, 100);
	quePanel.setBackground(Color.CYAN);
	quePanel.setLayout(new BorderLayout());
	queLabel.setVerticalAlignment(JLabel.CENTER);
	queLabel.setHorizontalTextPosition(JLabel.LEFT);
	queLabel.setFont(new Font ("MV Boli", Font.PLAIN, 27));
	quePanel.add(queLabel);
	
	
	
	
/**********************************next button****************************/
		nextButton.setSize(100, 50);
		nextButton.setBounds(200, 350, 150, 50);
		nextButton.setHorizontalAlignment(JButton.CENTER);
		nextButton.setVerticalAlignment(JButton.CENTER);
		nextButton.setFont(new Font("MV Boli", Font.BOLD , 25));
		nextButton.setFocusable(false);
		optionsLabel.add(nextButton);
	nextButton.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 nextButtonActionPerformed(e);
	
	}
});

	question();//invoked method
	
		

		
		
/**********************************submit button****************************/
		submitButton.setSize(100, 50);
		submitButton.setBounds(700, 350, 150, 50);
		submitButton.setHorizontalAlignment(JButton.CENTER);
		submitButton.setVerticalAlignment(JButton.CENTER);
		submitButton.setEnabled(true);
		submitButton.setFont(new Font("MV Boli", Font.BOLD , 25));
		submitButton.setFocusable(false);
		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 submitButtonActionPerformed(e);
			}
		});

	
		
		
	optionsPanel.setBounds(190, 210, 1130, 450);
	optionsPanel.setBackground(Color.ORANGE);
	optionsPanel.setLayout(new BorderLayout());
	

/**********************************JRadio Button****************************/
	jRadioButton1.setBounds(50, 50, 400, 50);
	jRadioButton1.setBackground(Color.LIGHT_GRAY);
	jRadioButton1.setFont(new Font("MV Boli", Font.PLAIN, 25));
	jRadioButton1.setFocusable(false);
jRadioButton1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			jRadioButton1ActionPerformed(e);
		}

		private void jRadioButton1ActionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(jRadioButton1.isSelected()) {
				
				jRadioButton2.setSelected(false);
				jRadioButton3.setSelected(false);
				jRadioButton4.setSelected(false);
			}
		}
	});
	
	jRadioButton2.setBounds(50, 50+70, 400, 50);
	jRadioButton2.setBackground(Color.LIGHT_GRAY);
	jRadioButton2.setFont(new Font("MV Boli", Font.PLAIN, 25));
	jRadioButton2.setFocusable(false);
jRadioButton2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			jRadioButton2ActionPerformed(e);
		}

		private void jRadioButton2ActionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(jRadioButton2.isSelected()) {
				
				jRadioButton1.setSelected(false);
				jRadioButton3.setSelected(false);
				jRadioButton4.setSelected(false);
			}
		}
	});

	jRadioButton3.setBounds(50, 120+70, 400, 50);
	jRadioButton3.setBackground(Color.LIGHT_GRAY);
	jRadioButton3.setFont(new Font("MV Boli", Font.PLAIN, 25));
	jRadioButton3.setFocusable(false);
jRadioButton3.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			jRadioButton3ActionPerformed(e);
		}

		private void jRadioButton3ActionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(jRadioButton3.isSelected()) {
				
				jRadioButton1.setSelected(false);
				jRadioButton2.setSelected(false);
				jRadioButton4.setSelected(false);
			}
		}
	});

	jRadioButton4.setBounds(50, 190+70, 400, 50);
	jRadioButton4.setBackground(Color.LIGHT_GRAY);
	jRadioButton4.setFont(new Font("MV Boli", Font.PLAIN, 25));
	jRadioButton4.setFocusable(false);
jRadioButton4.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			jRadioButton4ActionPerformed(e);
		}

		private void jRadioButton4ActionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(jRadioButton4.isSelected()) {
				
				jRadioButton1.setSelected(false);
				jRadioButton2.setSelected(false);
				jRadioButton3.setSelected(false);
			}
		}
	});



	optionsLabel.add(jRadioButton1);
	optionsLabel.add(jRadioButton2);
	optionsLabel.add(jRadioButton3);
	optionsLabel.add(jRadioButton4);
	optionsLabel.add(submitButton);
	
	optionsPanel.add(optionsLabel);
	optionsLabel.setVerticalAlignment(JLabel.CENTER);
	optionsLabel.setHorizontalTextPosition(JLabel.LEFT);
	

/**********************************end of Radio Button****************************/
	
/***********************************Frame*****************************************/
		
	
		quizAppFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		quizAppFrame.setSize(1300, 850);
		quizAppFrame.setResizable(true);
		quizAppFrame.setBackground(Color.WHITE);
		quizAppFrame.setLayout(null);
		
		
		quizAppFrame.add(optionsPanel);
		quizAppFrame.add(redPanel);
		quizAppFrame.add(bluePanel);
		quizAppFrame.add(quePanel);
		quizAppFrame.setLocationRelativeTo(null);
		quizAppFrame.setVisible(true);
	
	}

private void submitButtonActionPerformed(ActionEvent e) {

		int value = JOptionPane.showConfirmDialog(null,  "Do you want sumbit the Quiz?" , "select", JOptionPane.YES_NO_OPTION);
		
		if(value==0) {	
			
			answerCheck();
			submit();
			
			
		}
		
	

	}//end of constructor

/******************************answerCheck method***************************************/
	
	public boolean answerCheck() {
		
		
		String studentAnswer ="";
		if(jRadioButton1.isSelected()) {
			 studentAnswer=jRadioButton1.getText();
			
		}
		if(jRadioButton2.isSelected()) {
			studentAnswer=jRadioButton2.getText();
		}
		if(jRadioButton3.isSelected()) {
			studentAnswer=jRadioButton3.getText();
		}
		if (jRadioButton4.isSelected()) {
			studentAnswer=jRadioButton4.getText();
		}
		
		
		if (studentAnswer.equals(answer)) {
		
			marks = marks+1;
			String marks1 = String.valueOf(marks);
			pointLabel.setText(""+marks1);
			
		}
		
		//que no. change
		int questionId1 =Integer.parseInt(questionId);
		questionId1 = questionId1+1;
		questionId = String.valueOf(questionId1);
		

		if(questionId.equals("10")) {
			
			nextButton.setVisible(false);
		}
		
		//clear jRadioButton
		jRadioButton1.setSelected(false);
		jRadioButton2.setSelected(false);
		jRadioButton3.setSelected(false);
		jRadioButton4.setSelected(false);
				
		return false;
		
		
	}
	
	/********************************question method***************************************/
	public void question() {
	
		
		try {
			Connection connection = ConnectionProvider.getCon();
			Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rsl = st.executeQuery("select *from question where id='"+questionId+"'");
			while(rsl.next()) {
				blueLabel.setText("Question Number: "+rsl.getString(1));
				queLabel.setText("  "+rsl.getString(2));
				jRadioButton1.setText(rsl.getString(3));
				jRadioButton2.setText(rsl.getString(4));
				jRadioButton3.setText(rsl.getString(5));
				jRadioButton4.setText(rsl.getString(6));
				answer=rsl.getString(7);
			}
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, e);
		}
		
		//timer
		quizAppFrame.setLocationRelativeTo(this);
		timer  = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				secondLabel.setText(String.valueOf(sec));
				minLabel.setText(String.valueOf(min));
				
				
				if(sec==60) 
				{
					sec=0;
					min++;
					
					if(min==10) 
					{
						timer.stop();
						answerCheck();
						submit();
						
						
					}
				}
				sec++;
			}
		});
		
		timer.start();

	}
	
	/**********************************submit method****************************************/
	private void submit() {
		
		answerCheck();
		try {
			
			Connection con = ConnectionProvider.getCon();
			Statement stmnt = con.createStatement();
			
			stmnt.executeUpdate("update student set marks='"+ marks +"'where contact='"+getContact1+"'");//where contact='"+getContact+"'
			String marks1 = String.valueOf(marks);
			/**/
			quizAppFrame.setVisible(false);
			marksPage(marks1);
			
		} 
		
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
 	/**********************marksPage****************************************/
	public void marksPage(String marks1) {
		JFrame marksFrame = new JFrame();
		JLabel marksObtain = new JLabel();
		JButton logOut = new JButton("Logout");
		String marksPoint;
		Border border = BorderFactory.createLineBorder(Color.orange, 2);
		//*******************************
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
		
		marksPoint = marks1;
		
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
	/***************************marksPage method******************/
	/*******************************Buttons Functionality************************************/
	private void nextButtonActionPerformed(ActionEvent e) {
		
		
		answerCheck();
		question();
	
		}
		
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
 	
}//END CLASS