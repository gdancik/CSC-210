/************************************************************
 * CSC-210 Rock, Paper, Scissors Game
 * Group Members: (list names here)
 * 
 * Directions: Complete the ten FIX ME directions below
 *    to get a working Rock, Paper, Scissors game
 *    
 *    Note that the code that you add must appear below
 *    the FIX ME in the appropriate place to receive full 
 *  	  credit. Make sure to add your group member names at
 *    the top of the program. When you are finished, one
 *    person from your group should submit the program 
 *    through Blackboard
 ***********************************************************/

import java.util.Scanner;
import java.util.Random;

public class RPS {

	public static void main(String[] args) {

		// create the scanner
		Scanner scnr = new Scanner(System.in);
		
		// create the random number generator
		Random randGen = new Random();
			
		char player = 'R', computer = 'P';		// what the player and computer play ('R','P', or 'S')		
		int player_score = 0, computer_score = 0; // the current scores
		String name = "Player"; 			// the player's name
		String inputAgain; // player's response when asked to play again
		boolean again = true;	// true if the player wants to play again; false otherwise
		
		// (1) FIX ME: prompt the user to enter his/her name, 
		// and store the name in the String variable 
		// (allow the user to enter a full name, which can contain multiple words)
		
		
		// we will keep repeating while the user wants to play again
		while (again) {
			
			// (2) FIX ME: prompt the user to enter an R,P, or S,
			// and store the letter in a character variable
		
			
			// This line converts the character to uppercase
			player = Character.toUpperCase(player);
	
			// if the player enters an invalid character, go back to the beginning
			// of the while loop
			if (player != 'R' && player!= 'P' && player != 'S') {
				continue;
			}
							
			// (3) FIX ME: the computer will randomly play an 'R', 'P', or 'S'
			// randomly select an 'R', 'P', or 'S' and store the letter in
			// the variable 'computer'
			
			
			// (4) FIX ME: output a new line
			
			
			
			// (5) FIX ME: output a description for the player's and computer's move
			// Example format:  Player ---> R      P <--- CPU
			
			
			// (6) FIX ME: determine who has the winning hand, or if there is a tie,
			// and update player_score or computer_score accordingly
			// Output should follow the format below, using the player's
			// name if the player wins.
			//		Rock crushes scissors -- Joe Smith wins
			// 		Paper covers rock -- CPU wins
			// 		It's a tie
			 
		
			// (7) FIX ME: output the current score in the form:
			// Joe Smith has 1 point(s) and the CPU has 0 point(s)
			
			// skip a line
			System.out.println();
			
			// (8) FIX ME: prompt the user to Play again (Y/N)?
			// Store the player's response in a String 

			// skip a line
			System.out.println();
			
			// (9) FIX ME: The code below sets the variable 'again' to false. Modify 
			// this code so that if the player enters "Y" or "Yes", the variable
			// 'again' is set to true; otherwise, set the variable 'again' to false. 
			// Your program should not care whether the user's response 
			// is in lowercase or uppercase.
			
			again = false; 	
						
		}
		
		// output final score
		System.out.print("Final score =====> ");
		System.out.print(name + ":" + player_score + "     ");
		System.out.println("CPU: " + computer_score);
		
		// (10) FIX ME: output who the winner is, based on the player's and computer's 
		// scores. Don't forget that there might be a tie!
		

		
		System.out.println("Thanks for playing!");
		
		// close the scanner
		scnr.close();
		
		return;
	}

}
