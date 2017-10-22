// Tic-Tac-Toe: Complete the FIX-ME's to have a working version of Tic-Tac-Toe.
// Note: the game is based on a 2D 'board' array, with 3 rows and 3 columns
// A value of +1 indicates an 'X' on the board; and a value of -1 indicates an 'O'

// Group Members: 

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.*;  
  
public class TicTacToe implements ActionListener{  
	
	// FIX ME #5: set CPU_PAUSE to true when ready to play 
	final boolean CPU_PAUSE = false; // does the CPU pause to think?
	
	JButton [][] buttons = new JButton[3][3];
	int [][] board = new int[3][3];
			
	JLabel status = new JLabel("Player's turn", JLabel.CENTER);	
	JFrame frame = new JFrame();
	JPanel buttonPanel = new JPanel();
	JPanel labelPanel = new JPanel();
	Timer timer = null;	
	int numTest = 0;
	Random randGen = new Random();
	
	// draw X or O depending on 'x' values
	void refresh(int [][] x) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {								
				if (x[i][j] == 1) {
					buttons[i][j].setForeground(Color.blue);
					buttons[i][j].setText("X");			    	
				} else if (x[i][j] == -1) {
					buttons[i][j].setForeground(Color.pink);
					buttons[i][j].setText("O");		    		
				} else {
					buttons[i][j].setText(" ");
				}
			}
			
		}
	}
	
	
	boolean have_winner() {			
		boolean gameOver = false;
		
		// FIX ME #1: if there are either three +1s or three -1s in-a-row across, 
		// then set 'gameOver' to true. Hint: in other words, if the sum of any row is +3 or -3,
		// then set 'gameOver' to true
		
		
		// FIX ME #2: if there are either three +1s or three -1s in-a-row vertically, 
		// then set 'gameOver' to true. Hint: in other words, if the sum of any column is +3 or -3,
		// then set 'gameOver' to true.

		
		// FIX ME #3: if there are either three +1s or three -1s in-a-row diagonally, 
		// then set 'gameOver' to true

		return gameOver;						
	}

	boolean playerMove(ActionEvent e) {	
	
		JButton btn = (JButton) e.getSource();    
		for (int i = 0; i < 3; i++) {    	
			for (int j = 0; j < 3; j++) {    		
				if (btn.equals(buttons[i][j])) {			    			
					if (board[i][j] != 0) {
						return false;
					}    		
    			
					board[i][j] = 1;					
					refresh(board);
					return true;    		
				}    	
			}    
		}
		return false;
	}

// returns true if the board is full; or returns false otherwise
boolean board_is_full() {
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			if (board[i][j] == 0) return false;			
		}
	}
	return true;
}



ActionListener refreshListener = new ActionListener(){
	int delayCount = 0;
    public void actionPerformed(ActionEvent event){    	
    	delayCount++;    	
    	if (delayCount > 5) {
    		delayCount = 0;
    		timer.stop();
    	}
    	if (delayCount % 2 == 0) {
    		refresh(board);
    	} else {
    		int [][] x = new int[3][3];
        	refresh(x);    		
    	}

    }
};

// enables/disables buttons
void enableButtons(boolean enable, boolean changeOccupied) {	
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			if (changeOccupied || board[i][j] == 0) {
				buttons[i][j].setEnabled(enable);
			}
		}
	}
}


ActionListener computerMove = new ActionListener(){
    public void actionPerformed(ActionEvent event){
    	
    	System.out.println("The computer's move...");
    	
    	/* FIX ME #4: The computer moves by placing an 'O' on the board
    	 * (i.e.), assigning a -1 to a valid element of the board array
    	 * The computer can play randomly, by randomly selecting a 
    	 * row and column to play in, and repeating until a valid (empty)
    	 * spot on the board is found. Optionally, the computer can
    	 * play strategically, though this is more challenging.  
    	 */

    	int row = 0, col = 0;
    	
    	// Recommended algorithm for computer: 
    	// 1. Generate a random row index, using  (fix the code below)
    	
 	  row = randGen.nextInt(10) + 1; // generate a number between 1-10

 	// 2. Generate a random column index (fix the code below)
 	  
 	 col = randGen.nextInt(10) + 1; // generate a number between 1-10
 	  
    	// 3. Based on the row and column index above, if the corresponding spot on the board 
    	//    is occupied, repeat steps 1-2
 	 
 	 
    	// 4. Change the corresponding spot on the board to -1
        
    	      
    	// refresh board and set up for player's move
   	// DO NOT CHANGE THESE STATEMENTS!
 	 
   	refresh(board);        
   
	 // check if there is a winner
   	 if (have_winner()) {			
			winning_board(-1);			 
   	 } else {   	 		 	
   	 	status.setText("Player's Move");
   	 	enableButtons(true,true);
   	 }

    }
};



// User selects New Game
ActionListener newGame = new ActionListener() {

	public void actionPerformed(ActionEvent e)
    {
		
		
		System.out.println("newGame");
		// FIX ME #6: a new game clears the board -- set each value of the 'board' to 0
		
		
		// refresh and finish resetting game (do not change these statements)
		refresh(board);
		enableButtons(true, true);
		status.setText("Player's turn");
		status.setForeground(Color.black);
		
    }
	
};

void winning_board(int winner)  {

	if (winner == 1) {
		status.setText("PLAYER WINS!");		
		status.setForeground(Color.blue);
		enableButtons(false, false);
	} else if (winner == -1) {
		status.setText("COMPUTER WINS!");
		status.setForeground(Color.pink);
		enableButtons(false, false);
	}
	
		
    timer = new Timer(500, refreshListener);
	timer.setRepeats(true);
 	timer.start();		 	
 	
}



ActionListener onClick = new ActionListener() {

	public void actionPerformed(ActionEvent e)
    {
		if (timer != null && timer.isRunning()) {
			timer.stop();
		}
	
		int delay = 100;
		if (CPU_PAUSE) delay = 1000;
		
		boolean player = playerMove(e);
		if (player) {
	
			if (have_winner()) {			
				winning_board(1);
				return;
			}
			
			else if (board_is_full()) {
				status.setText("IT'S A TIE!");
				return;			
			}
				
			status.setText("Computer is thinking...");			
			enableButtons(false, true);
			Timer timer = new Timer(delay, computerMove);
			timer.setRepeats(false);			
			timer.start();											
		} else {
			System.out.println("No move\n");
		}
     }
};

TicTacToe(){
	
		// NOTE: change board values here to change initial board
		
		labelPanel.setLayout(new GridLayout(2,3));
		for (int i = 0; i < 6; i++) {
			if (i!=1) {
				labelPanel.add(new JLabel());
			} else {
				status.setText("Player's move...");						
				labelPanel.add(status);					
			}			
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				buttons[i][j] = new JButton(" ");
				buttons[i][j].setFont(new Font("Arial", Font.BOLD, 50));
				buttons[i][j].addActionListener(onClick);
				buttonPanel.add(buttons[i][j]);
			}
		    
		}
	    	   	    
	    buttonPanel.setLayout(new GridLayout(3,3));   	 
	    frame.setSize(700,300);  
	    
	    frame.add(labelPanel, BorderLayout.SOUTH);        
        frame.add(buttonPanel, BorderLayout.NORTH);	    
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    
	    // Creates a menubar for a JFrame
        JMenuBar menuBar = new JMenuBar();
                  
        // Define and add two drop down menu to the menubar
        JMenu fileMenu = new JMenu("File");
        JMenuItem newGameItem = new JMenuItem("New Game");   
        newGameItem.addActionListener(newGame);
        fileMenu.add(newGameItem);        
        menuBar.add(fileMenu);
                       
        // Add the menubar to the frame
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
	    refresh(board);
	    
	    
	}


  public static void main(String[] args) {  
    new TicTacToe();    
  }


  @Override
  public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub	
  }


}  
