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

	public static void main(String[] args) {
		// TODO: Read the input from the user and call produceAnswer with an equation
		Scanner userJunk = new Scanner(System.in);
		String initialInput = "";
		while (!initialInput.toLowerCase().equals("quit")) { // if the user didn't want to quit, go on with the
																// calculator
			System.out.println("Enter equation to calculate, or type \"quit\" to quit.");
			System.out.println(
					"Seperate fractions with \"/\", whole numbers from fractions with \"_\", and numbers from operators with a space.");
			initialInput = userJunk.nextLine();
			if(!initialInput.toLowerCase().equals("quit")) {
			System.out.println(produceAnswer(initialInput)); // print the answer!
			}
		}

		System.out.println("Goodbye!");

	}

	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION. This function will be used to
	// test your code
	// This function takes a String 'input' and produces the result
	//
	// input is a fraction string that needs to be evaluated. For your program, this
	// will be the user input.
	// e.g. input ==> "1/2 + 3/4"
	//
	// The function should return the result of the fraction after it has been
	// calculated
	// e.g. return ==> "1_1/4"
	public static String produceAnswer(String input) { 
        // TODO: Implement this function to produce the solution to the input
    	
    	int numberOfValues = 1;
    	String cutInput = input;
    	while (cutInput.indexOf(' ') != -1) { //finds the length of the whole string by searching for operators
    		cutInput = cutInput.substring(cutInput.indexOf(' ') + 3, cutInput.length()); //cut out a smaller string to search next time
    		numberOfValues++;
    	}
    	
    	int wholeNumbers[] = new int[numberOfValues];
    	int numerators[] = new int[numberOfValues];
    	int denominators[] = new int[numberOfValues];
    	char operators[] = new char[numberOfValues - 1];
    	
    	
    	//  1_2/3 + 44_54/64 + 7_8/9 + 10_11/12
    	
    	cutInput = input;
    	while (cutInput.length() > 0) {
    		String numberInQuestion = cutInput.substring(0, cutInput.indexOf(' ') + 3); //make a small string with one mixed number including the operator after it
    		
    		String whole = numberInQuestion.substring(0, numberInQuestion.indexOf('_'));
    		String num = numberInQuestion.substring(numberInQuestion.indexOf('_') + 1, numberInQuestion.indexOf('/'));
    		String denom = numberInQuestion.substring(numberInQuestion.indexOf('/') + 1, numberInQuestion.indexOf(' '));
    		
    		cutInput = cutInput.substring(cutInput.indexOf(' ') + 3, cutInput.length()); //cut the string down, make shorter
    		
    		System.out.println(cutInput);
    		System.out.println("whole = " + whole);
    		System.out.println("num = " + num);
    		System.out.println("denom = " + denom);
    		System.out.println();
    	}
    	return "";
    	

      /*
     public static int gcd(int a, int b) {
       if (b == 0) {
        	return a;
       	}
        return Math.abs(gcd(b, a%b));
     } 

    
 // TODO: Fill in the space below with any helper methods that you think you will need
    
    public static int gcd(int a, int b) {
    	if (b == 0) {
    		return a;
    	}
    	return Math.abs(gcd(b, a%b));
    }
    */
}
}
