// Guessing game (graphical version)
// This game serves as a first introduction to objects and an example of a "real" Java program
// Note that you do not need to understand how the graphics are coded, but you 
// do know enough to follow the FIX MEs in order to complete the program.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class guessingGame {
    
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel1, statusLabel2, bottomLabel;
   private JPanel userInputPanel;
   private JButton guessButton;
   private JButton newButton;
   private JLabel  numlabel; 
   private JTextField userText;

   private int number, num_guesses;
   
   public guessingGame(){	  
	  
	   Random randGen = new Random();
	  
	  // FIX ME: Modify the statement below to generate a random number between 1-100, 
	  // and assign the value to 'number'
	  
	  number = 4;
	 
	  // number of guesses for player
	  num_guesses = 0;
	  
	  // FIX ME: comment this output to play the game
	  System.out.println("number = " + number);
	  
      prepareGUI();
   } // end Launch game

   public static void main(String[] args){
      guessingGame g = new guessingGame();      
      g.start();
   }

   private void prepareGUI(){
	
	  // initialize header label
	  headerLabel = new JLabel("Please guess a number between 1-100", JLabel.CENTER);

      // set up the userInput panel, which includes label, text box and buttons
      userInputPanel = new JPanel();
      userInputPanel.setLayout(new FlowLayout());

      // set up components of userInput panel
      numlabel= new JLabel("Number: ", JLabel.RIGHT);
	  userText = new JTextField(6);
	  guessButton = new JButton("Guess");
	  newButton = new JButton("New Game");
	  
      // add the components to the panel
      userInputPanel.add(numlabel);
      userInputPanel.add(userText);
      userInputPanel.add(guessButton);
      userInputPanel.add(newButton);


      // set up the status (feedback) labels
      statusLabel1 = new JLabel("",JLabel.CENTER);    
      statusLabel2 = new JLabel("",JLabel.CENTER);
      
      // set up a blank label for the bottom of the frame
      bottomLabel = new JLabel("", JLabel.CENTER);
      
	  // set up the mainFrame (mainPanel)
      mainFrame = new JFrame("Guessing Game");
      mainFrame.setSize(400,300);
      mainFrame.setLayout(new GridLayout(5, 1));
      mainFrame.setResizable(false);
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    

      // add labels and control panel to the mainFrame
      mainFrame.add(headerLabel);
      mainFrame.add(userInputPanel);
      mainFrame.add(statusLabel1);
      mainFrame.add(statusLabel2);
      mainFrame.add(statusLabel2);
      mainFrame.add(bottomLabel);
      mainFrame.setVisible(true);
               
   }

   // method that starts the game
   private void start(){
	           
      // GUESS BUTTON - the code below is executed when the 'Guess' button is clicked
      guessButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {     

        	 // get the user's guess; if not a number, display message and return
        	 String str = userText.getText();
        	 int guess;
        	 try {
        		  guess = Integer.parseInt(str);
        	 } catch (NumberFormatException err) {        		    
        		    statusLabel1.setText("Please enter a number");
        		    statusLabel1.setForeground(Color.red);
        		    statusLabel2.setText("");
        		    return;
        	 }
        	 
        	 // FIX ME: increase the value of num_guesses by 1
        	 
        	 
        	 // FIX ME: Set the 'guessStr' string to store information about the user's guess,
        	 // in the following form: "Guess #1 is 3  
        	 String guessStr = "User guess goes here";
        	 
        	 statusLabel1.setText(guessStr);
        	 statusLabel1.setForeground(Color.BLUE);
        	 
        	 // FIX ME: Set the 'feedbackStr' string to store feedback for the user, of the form
        	 // "Your guess is too low". Optionally, you may change the text color appropriately.
        	 String feedbackStr = "Modify this to give appropriate feedback.";     
        	  
        	 statusLabel2.setText(feedbackStr);        	 
        	 statusLabel2.setForeground(Color.MAGENTA);
                       
         }
      }); // end of GUESS code


      // NEW GAME - the code below is executed when the "New Game" button is clicked
      newButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {

        	 Random randGen = new Random();
			 // FIX ME: set number to a random number between 1-100 
        	 // (use the randGen object already created)        	 
        	
        	 
        	 // FIX ME: set num_guesses to 0
        		         	         	 
        	 // reset values
        	 userText.setText("");
        	 statusLabel1.setText("");
        	 statusLabel2.setText("");
         }
      }); // end of NEW GAME code

   }
}
