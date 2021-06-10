package loginsystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import database.AddNewQuestions;
import database.AllQuestions;
import database.AllStudentResult;
import database.DeleteQuestions;
import database.UpdateQuestions;
import quizsystem.AdminLogin;

public class DatabasePage implements ActionListener {

	public static int open=0;
	JFrame dataBaseFrame = new JFrame("Database Page");
	JLabel label = new JLabel();
	JLabel iconLabel = new JLabel();
JLabel imagePanel = new JLabel();
	public DatabasePage ( String userID){
		//C:\Users\Rohit\git\Quizer\APNA GROUP PROJECT\src\Images
		ImageIcon addQueIcon = new ImageIcon("C:\\Users\\Rohit\\git\\APNA GROUP PROJECT\\src\\Images\\plus.png");
		ImageIcon updateQueIcon = new ImageIcon("C:\\Users\\Rohit\\git\\APNA GROUP PROJECT\\src\\Images\\exchange.png");
		ImageIcon allQueIcon = new ImageIcon("C:\\Users\\Rohit\\git\\APNA GROUP PROJECT\\src\\Images\\select-all.png");
		ImageIcon deleteQueIcon = new ImageIcon("C:\\Users\\Rohit\\git\\APNA GROUP PROJECT\\src\\Images\\remove.png");
		ImageIcon logoutIcon = new ImageIcon("C:\\Users\\Rohit\\git\\APNA GROUP PROJECT\\src\\Images\\logout.png");
		ImageIcon exitIcon = new ImageIcon("C:\\Users\\Rohit\\git\\APNA GROUP PROJECT\\src\\Images\\exit.png");
		ImageIcon studentResultIcon = new ImageIcon("C:\\Users\\Rohit\\git\\APNA GROUP PROJECT\\src\\Images\\exam.png");
		ImageIcon image = new ImageIcon("C:\\Users\\Rohit\\Desktop\\New Folder\\three.jpg");//C:\Users\Rohit\Desktop\New Folder
	/*************************************label*******************************/
		label.setText("Add new Questions");
		label.setFont(new Font(null, Font.PLAIN , 25));
		
		/*************************menuBar***********************************/
		JMenuBar menuBar = new JMenuBar();
		Font myFont = new Font("Arial", Font.BOLD, 18);
		/*********************************ImagePanel*************************************/
		//iconLabel.setVerticalAlignment(JLabel.CENTER);
		//iconLabel.setHorizontalTextPosition(JLabel.RIGHT);
		Image scaleImage = image.getImage().getScaledInstance(1300, 630, Image.SCALE_DEFAULT);
		image = new ImageIcon(scaleImage);
		//iconLabel.setBounds(0, 100, 500, 500);
		iconLabel.setIcon(image);
		
		
		
		//*******************
		
/**************************Add new Questions**********************************/
	
		JMenu addQue = new JMenu("Add new Questions");
		addQue.setFont(myFont);
		addQue.setBackground(Color.BLUE);
		addQue.setOpaque(true);
		addQue.setIcon(addQueIcon);
		addQue.setIconTextGap(8);
		
		addQue.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				if(open==0) {
					new AddNewQuestions().setVisible(true);
					open=1;
				}
				else {
					JFrame jf = new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, "One form is already open");
				}
			}
		
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		
		});
		
/******************************************Update Questions***********************************************/
		
		JMenu updateQue = new JMenu("Update Questions");
		updateQue.setFont(myFont);
		updateQue.setBackground(Color.BLUE);
		updateQue.setOpaque(true);
		updateQue.setIcon(updateQueIcon);
		updateQue.setIconTextGap(8);
		
		updateQue.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			
				if(open==0) {
					 new UpdateQuestions().setVisible(true);
					open=1;
				}
				else {
					JFrame jf = new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, "One form is already open");
				}
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		
		
/******************************************All Questions***********************************************/
		
		JMenu allQue = new JMenu("All Questions");
		allQue.setFont(myFont);
		allQue.setBackground(Color.BLUE);
		allQue.setOpaque(true);
		allQue.setIcon(allQueIcon);
		allQue.setIconTextGap(8);
		allQue.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(open==0) {
					 new AllQuestions().setVisible(true);
					 open=1;
				}
				else {
					JFrame jf = new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, "One form is already open");
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});

		
/************************************Delete Questions*****************************************************/

		JMenu deleteQue = new JMenu("Delete Questions");
		deleteQue.setFont(myFont);
		deleteQue.setBackground(Color.BLUE);
		deleteQue.setOpaque(true);
		deleteQue.setIcon(deleteQueIcon);
		deleteQue.setIconTextGap(8);
		deleteQue.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

				if(open==0) {
					 new DeleteQuestions().setVisible(true);
					 open=1;
				}
				else {
					JFrame jf = new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, "One form is already open");
				}
			
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
/*****************************************All Student Result************************************************/
		
		JMenu studentResult = new JMenu("All Student Result");
		studentResult.setFont(myFont);
		studentResult.setBackground(Color.BLUE);
		studentResult.setOpaque(true);
		studentResult.setIcon(studentResultIcon);
		studentResult.setIconTextGap(9);
		studentResult.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(open==0) {
					 new AllStudentResult().setVisible(true);
					 open=1;
				}
				else {
					JFrame jf = new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, "One form is already open");
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
/**************************************Logout***************************************************/
		
		JMenu logOut = new JMenu("Logout");
		logOut.setFont(myFont);
		logOut.setBackground(Color.BLUE);
		logOut.setOpaque(true);
		logOut.setIcon(logoutIcon);
		logOut.setIconTextGap(9);
		
		logOut.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int value = JOptionPane.showConfirmDialog(null, "Do You really want to logout?" , "select" , JOptionPane.YES_NO_OPTION);
				
				if(value == 0) { 
					
					dataBaseFrame.dispose();
					new AdminLogin();
				}
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
			});
			

		
/**********************************Exit******************************************************/
		
		JMenu exit = new JMenu("Exit");
		exit.setFont(myFont);
		exit.setBackground(Color.BLUE);
		exit.setOpaque(true);
		exit.setIcon(exitIcon);
		exit.setIconTextGap(10);
		exit.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int value = JOptionPane.showConfirmDialog(null, "Do You really want to exit the Application?" , "select" , JOptionPane.YES_NO_OPTION);
				
				if(value == 0) { // if Yes=0
					
					System.exit(0);
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
			});
			
		/***********************  menuBar added*********************************/
		
		menuBar.add(addQue);
		menuBar.add(updateQue);
		menuBar.add(allQue);
		menuBar.add(deleteQue);
		menuBar.add(studentResult);
		menuBar.add(logOut);
		menuBar.add(exit);
		
	

		
		/*************************dataBaseFrame*************************************/
		dataBaseFrame.setJMenuBar(menuBar);
		dataBaseFrame.add(iconLabel);
		
		dataBaseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dataBaseFrame.setSize(1300, 700);
		dataBaseFrame.setLocationRelativeTo(null);
		dataBaseFrame.setUndecorated(true);//remove title bar
		dataBaseFrame.setLocationRelativeTo(null);//used for center a window
		dataBaseFrame.setResizable(true);
		dataBaseFrame.setLayout(new FlowLayout());
		dataBaseFrame.setVisible(true);
	}//constructor ends


	public DatabasePage() {
		// TODO Auto-generated constructor stub
	}


	public static void main(String args[]) {
		String userID ="";
		new DatabasePage(userID);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
