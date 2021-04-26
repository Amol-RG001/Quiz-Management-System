
package quizsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.text.html.HTMLEditorKit;


public class QuizInstructionPage implements ActionListener {

	JFrame instructionFrame = new JFrame();
	
	JButton startButton = new JButton("Start Quiz");
	JEditorPane instructionArea = new JEditorPane();
	String name;
	String email;
	String contact;
	HTMLEditorKit kit=new HTMLEditorKit();	
	
	String htmlString = "<html>\n"
    + "<body>\n"
    + "<h2>1. The Students may not use his/her textbook and course notes.</h2>\n"
    + "<h2>2. Students must complete the 10-question  MCQ exam within <br>the 10-minute time frame alloted for the exam.</h2>\n"
    + "<h2>3. Students must not stop the session and then return to it.</h2>\n"
    + "<h2>Number of Questions: 10</h2>"
    + "<h2>Exam Duration: 10 min</h2>"
    + "<h2>All the Best !</h2>"
    + "</body>\n";
	
	//create constructor
	public QuizInstructionPage(String name, String contact, String email) {
		
		this.name = name;
		this.contact = contact;
		this.email = email;
		
		/***************************************instructionArea*********************************/	
		instructionArea.setBounds(100, 50, 525, 300);
		instructionArea.setFont(new Font("Arial", Font.PLAIN, 15));
		instructionArea.setEditorKit(kit);
		instructionArea.setText(htmlString);
		instructionArea.setEditable(false);


		
		/***************************************startButton*********************************/
		startButton.setBounds(275, 385, 150, 50);
		startButton.setFocusable(false);
		startButton.setHorizontalAlignment(JButton.CENTER);
		startButton.setFont(new Font("Arial", Font.BOLD, 20));
		startButton.setBackground(Color.WHITE);
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				startButtonActionPerformed(e);
			}
		});
		
		/***************************************instructionFrame*********************************/
		instructionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		instructionFrame.setSize(750, 500);
		instructionFrame.setResizable(false);
		instructionFrame.setLayout(null);
		instructionFrame.setLocationRelativeTo(null);
		instructionFrame.getContentPane().setBackground(Color.GRAY);
		instructionFrame.add(instructionArea);
		instructionFrame.add(startButton);
		instructionFrame.setVisible(true);
		

	}
	
	
	private void startButtonActionPerformed(ActionEvent e) {
		
		
		
		if(e.getSource()==startButton) {
			
			instructionFrame.dispose();
			new QuizExamStudent(this.name, this.contact, this.email);// call QuizApp class by passing argument
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	
	
}
