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

import java.util.Arrays;
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
    	
    	String cutInput = input;
    	
    	
    	///////////////////////////////////////////////////////////////
    	
    	
    	int wholeNumbers[] = new int[2];
    	int numerators[] = new int[2];
    	int denominators[] = new int[2];
    	char operators[] = new char[1];
    	cutInput = input;
    	String numberInQuestion = "";
    	int arrayPosition = 0;
    	
    	//////////////////////////////////////////////////////////////
    	while (cutInput.length() > 0) {
    		
    		numberInQuestion = cutInput.substring(0, cutInput.indexOf(' ') + 3);
    		
    		System.out.println(numberInQuestion);
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
/*    		
    		if(cutInput.indexOf(' ') != -1) {
    		numberInQuestion = cutInput.substring(0, cutInput.indexOf(' ') + 3); //make a small string with one mixed number including the operator after it
   		} else {
    			numberInQuestion = cutInput;
    			cutInput = "";
  		}
    		
    		// System.out.println("Number in question = " + numberInQuestion);
    		
    		String denom;
    		String whole;
    		String num;
    		char operator = 'n';
  
    		if (numberInQuestion.indexOf('_') == -1 && numberInQuestion.indexOf('/') == -1) { // if test should be changed later, in order not to scan for a dividing operator
    			whole = numberInQuestion.substring(0, numberInQuestion.length());
    			num = "0";
    			denom = "1"; // This excecutes if there is only a whole number, no fraction
    			System.out.println("only whole number");
    		} else if (numberInQuestion.indexOf('_') == -1 && !(numberInQuestion.indexOf('/') == -1)) { // this executes if there is only a fraction
    			whole = "0";
    			num = numberInQuestion.substring(0, numberInQuestion.indexOf('/'));
    			denom = numberInQuestion.substring(numberInQuestion.indexOf('/') + 1, numberInQuestion.indexOf(' '));
    			operator = numberInQuestion.charAt(numberInQuestion.length() - 2);
    			System.out.println("only fraction");
    			
    			System.out.println(whole);
    			System.out.println(num);
    			System.out.println(denom);
    			
    			
    		} else {
    			whole = numberInQuestion.substring(0, numberInQuestion.indexOf('_'));
    			num = numberInQuestion.substring(numberInQuestion.indexOf('_') + 1, numberInQuestion.indexOf('/'));
        		if (numberInQuestion.indexOf(' ') != -1) {
        			denom = numberInQuestion.substring(numberInQuestion.indexOf('/') + 1, numberInQuestion.indexOf(' '));
        			cutInput = cutInput.substring(cutInput.indexOf(' ') + 3, cutInput.length());
        			operator = numberInQuestion.charAt(numberInQuestion.length() - 2);
        		} else {
        			denom = numberInQuestion.substring(numberInQuestion.indexOf('/') + 1, numberInQuestion.length());
        			operator = 'n';
        		}
    		}
    		
    		// now put all the gathered values into their respective arrays
    		denominators[arrayPosition] = Integer.parseInt(denom);
    		numerators[arrayPosition] = Integer.parseInt(num);
    		wholeNumbers[arrayPosition] = Integer.parseInt(whole);
    		operators[arrayPosition] = operator;

    		arrayPosition++;
    		
    		System.out.println("whole = " + whole);
    		System.out.println("num = " + num);
    		System.out.println("denom = " + denom);
    		System.out.println("operator = " + operator);

    		System.out.println();
    		System.out.println(Arrays.toString(wholeNumbers));
    		System.out.println(Arrays.toString(numerators));
    		System.out.println(Arrays.toString(denominators));
    		System.out.println(Arrays.toString(operators));
    		System.out.println("Remaining string = " + cutInput);
    		System.out.println("num in question = " + numberInQuestion);
    		System.out.println(numberInQuestion.charAt(numberInQuestion.length() - 1));
    		System.out.println("=======================");
    		
    		
    		//CUT DOWN CUTINPUT
    		if (numberInQuestion.indexOf(' ') != -1) {
    			cutInput = cutInput.substring(numberInQuestion.length(), cutInput.length() - 1);
    		} else {
    			cutInput = "";
    		}
    		
    	}
    	//////////////////////////////////////////////////////////////
    	
    	
    	System.out.println("whole:" + wholeNumbers[wholeNumbers.length - 1] + " numerator:" + numerators[wholeNumbers.length - 1] + " denominator:" + denominators[denominators.length - 1]);
    	return "whole:" + wholeNumbers[wholeNumbers.length - 1] + " numerator:" + numerators[wholeNumbers.length - 1] + " denominator:" + denominators[denominators.length - 1];
    	 

       
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
		return "";
	}}

