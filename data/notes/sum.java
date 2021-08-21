// An example program that gets two integers from the user, 
// calculates the sum, and outputs it

import java.util.Scanner; // Enables user input from the keyboard

public class sum {

  public static void main(String [] args) {

	// Setup scanner to get input from keyboard	
	Scanner scnr = new Scanner(System.in); 
	
	// declare variables for storing values
	int num1, num2, total;
	  
    // prompt the user to enter the first number, and get this number from the user
    System.out.print("Enter an integer: ");
    num1 = scnr.nextInt();  // Read next integer from scanner

    // prompt the user to enter the second number, and get this number from the user
    System.out.print("Enter another integer: ");
    num2 = scnr.nextInt();  // Read next integer from scanner

    // calculate the sum and store the answer in the variable 'total'
    total = num1 + num2;
       
    // output the total
    System.out.print("The sum of " + num1 + " and ");
    System.out.println(num2 + " is " + total + ".");
      
    // close the scanner 
    scnr.close(); 
  }
}
