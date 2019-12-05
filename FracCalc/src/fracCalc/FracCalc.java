/* PSUDOCODE
 * 
 * IN MAIN
 * get input from user
 * pass it to a method which does the calculations (simple!)
 * output that answer to the console
 * 
 * IN PRODUCE ANSWER
 * split the input by the operator(s) and put parts into strings
 * 		find the operator by scanning for spaces on each side of the operator (to distinguish it from a fraction)
 * 		put operators into a char array
 * 		count the number of values in question and make a string array of that size,
 * 		input the mixed numbers into it
 * 
 * make an array of the same size for the numerators, and another for the denoms
 * 
 * do this for each part, till all parts are used up
 * 		split the parts (mixed numbers) into whole number, numerator, and denominator
 *		save these into their respective arrays (if no fraction, put 0)
 * find the greatest common denominator by calling a method gcm, passing in the array of denominators
 * change each fraction accordingly, based on gcm's return value
 * do calculations on whole numbers
 * add all numerators, and make the fraction proper by dividing by the (now common) denom, adding result to whole number and num % denom for the new num
 * 
 * output the result!
 * 
 * 
 * 
 * IN GCM
 * 
 * 
 */


package fracCalc;
import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner userJunk = new Scanner(System.in);
    	System.out.println("Enter equation to calculate, or type \"quit\" to quit.");
    	System.out.println("Seperate fractions with \"/\", whole numbers from fractions with \"_\", and numbers from operators with a space.");
    	String initialInput = userJunk.nextLine();
    	
    	while (initialInput.toLowerCase() != "quit") {  //if the user didn't want to quit, go on with the calculator
    		System.out.println(produceAnswer(initialInput)); // print the answer!
    	}

    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
        
        return "";
    }
    
 // TODO: Fill in the space below with any helper methods that you think you will need
    
    public static int gcd(int a, int b) {
    	if (b == 0) {
    		return a;
    	}
    	return Math.abs(gcd(b, a%b));
    }

    
}
