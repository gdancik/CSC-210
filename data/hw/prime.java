/**********************************************************************
* Prime Numbers - complete the FIX MEs to complete the program which
*   ultimately will print out all prime numbers between 2 and 100. A 
*   prime number is an integer that is only evenly divisible by 1 
*   and itself (i.e., it is not evenly divisible by any other integer.  
*   Note that you will have to declare more variables to complete this
*   program.
*   
*   Group Members: 
**********************************************************************/
 
import java.util.Scanner;

public class prime {
    
  
   public static void main(String[] args){
	   
	   Scanner scnr = new Scanner(System.in);
	   int number;
	   
	   // PART A: Prompt the user to enter an integer, and then output whether or not
	   // the integer is prime

	   do {
		   System.out.print("Please enter a positive integer greater than one: ");
		   number = scnr.nextInt();
	   } while (number <= 1);		   
	   scnr.close();
 
	   // FIX ME #1: Write code to determine whether or not the value of 'number' is
	   // prime. If so, output that the number is prime, otherwise, output that the number is 
	   // not prime. Hint: The algorithm for checking whether a number 'n' is prime is:
	   
	   // 		(A) for each number 'i' between 2 and 'number-1' (inclusive)
	   //			    if 'number' is evenly divisible by 'i', then 'number' is not prime
	   //			    and you are done.
	   
	   // 		(B) output whether or not the number is prime. Note that if 'number' was 
	   // 			evenly divisible by any of the above numbers, then 'number' is not 
	   // 			prime. Otherwise, 'number' is prime. 

	   // Check that the above code works correctly for a variety of numbers such as 13 
	   // (which is prime) and 4 (which is not). Show me when you are done with FIX ME #1.


	  
	   System.out.println();
	   	   
	  
	   // FIX ME #2: Output all of the prime numbers between 2 and 100, beginning with the message
	   // "The prime numbers between 2 and 100 are: ". Note that in FIX ME #1, your code that 
	   // outputs whether or not a specific number is prime. You now want do do this for each 
	   // number between 2 and 100 (although for this FIX ME, you will output
	   // the number if it is prime, and will not output anything if the number is not prime).
	   
	   
	  
	   System.out.println();
	   System.out.println("Thank you for running this program!"); 
	   
	   
	  
   }
}
