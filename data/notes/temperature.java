/*********************************************************
* Advice for writing code and debugging
* - Create a program using "baby steps".  
*   - For example, for a program that prompts the user to
*     enter two numbers and adds them, do the following:
*        - write code to get the first number, and output it
*        - add code to get the second number, and output it
*        - add code to find the sum, and output it
*    - This way, if there is an error in your code, it is
*        - easier to identify the cause
* - Eclipse will identify syntax errors for you 
* 	 - Use Eclipse to take advantage of this
* - You can identify errors in your code by systematically 
*   commenting out code and running it. In Eclipse, you
*   can comment/uncomment code by highlighting code and
*   selecting Source -> Toggle Comment
* - Print statements are your friend! When writing code,
*   I often add print statements to that I can check that
*   the code is doing what it is supposed to be doing.
*   Print statements make it easy to see the value of
*   variables or to check whether if/else clauses are being
*   executed. 
***********************************************************/

import java.util.Scanner;

public class temperature {

	public static void main(String[] args) {
		
		// Setup scanner to get input from keyboard	
		Scanner scnr = new Scanner(System.in); 
		
		double C;
		
		System.out.print("Enter a temperature in degrees Celsius: ");
		C = scnr.nextDouble();		
		
		// convert from Celsius to Fahrenheit, using F = 9/5C + 32
		F = 9/5 * C + 32;
		
		if (F <= 32) {
			System.out.println("Water at this temperature will freeze");
		} else if (F >= 212) {
			System.out.println("Water at this temperature will boil");
		} else {
			System.out.println("Water at this temperature will be a liquid");
		}
		
		scnr.close();
		
	}

}
