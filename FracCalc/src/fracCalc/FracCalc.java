/* 
 * 
 * CHECKPOINTS 1 & 2 are DONE
 * 
 * 
 * PPSUDOCODE
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
    	char operator;
    	cutInput = input;
    	String numberInQuestion = "";
    	
    	//////////////////////////////////////////////////////////////
    	
    		
    		numberInQuestion = cutInput.substring(0, cutInput.indexOf(' ') + 3);
    		
    		
    		if (numberInQuestion.indexOf('_') == -1) {
    			if (numberInQuestion.indexOf('/') != -1) {  // the number is a FRACTION, change later to account for dividing operators
    				numerators[0] = Integer.parseInt(numberInQuestion.substring(0, numberInQuestion.indexOf('/'))); // put the numerator into the array
    				denominators[0] = Integer.parseInt(numberInQuestion.substring(numberInQuestion.indexOf('/') + 1, numberInQuestion.indexOf(' '))); // find the denominator and put it into the array
    				wholeNumbers[0] = 0;
    			} else {					// or else, the number is a WHOLE NUMBER
    				numerators[0] = 0;
    				denominators[0] = 1;
    				wholeNumbers[0] = Integer.parseInt(numberInQuestion.substring(0, numberInQuestion.indexOf(' ')));
    			}
    		} else { // the number is a regular MIXED NUMBER
    			wholeNumbers[0] = Integer.parseInt(numberInQuestion.substring(0, numberInQuestion.indexOf('_')));
    			numerators[0] = Integer.parseInt(numberInQuestion.substring(numberInQuestion.indexOf('_') + 1, numberInQuestion.indexOf('/')));
    			denominators[0] = Integer.parseInt(numberInQuestion.substring(numberInQuestion.indexOf('/') + 1, numberInQuestion.indexOf(' ')));
    		}
    		operator = numberInQuestion.charAt(numberInQuestion.indexOf(' ') + 1); // finally, find the operator

    		
    		// MAKE A NEW NUMBER TO WORK WITH
    		numberInQuestion = cutInput.substring(cutInput.indexOf(' ') + 3, cutInput.length());
    		
    		
    		if (numberInQuestion.indexOf('_') == -1) {
    			if (numberInQuestion.indexOf('/') != -1) {  // the number is a FRACTION, change later to account for dividing operators
    				numerators[1] = Integer.parseInt(numberInQuestion.substring(0, numberInQuestion.indexOf('/'))); // put the numerator into the array
    				denominators[1] = Integer.parseInt(numberInQuestion.substring(numberInQuestion.indexOf('/') + 1, numberInQuestion.length())); // find the denominator and put it into the array
    				wholeNumbers[1] = 0;
    			} else {					// or else, the number is a WHOLE NUMBER
    				numerators[1] = 0;
    				denominators[1] = 1;
    				wholeNumbers[1] = Integer.parseInt(numberInQuestion.substring(0, numberInQuestion.length()));
    			}
    		} else { // the number is a regular MIXED NUMBER
    			wholeNumbers[1] = Integer.parseInt(numberInQuestion.substring(0, numberInQuestion.indexOf('_')));
    			numerators[1] = Integer.parseInt(numberInQuestion.substring(numberInQuestion.indexOf('_') + 1, numberInQuestion.indexOf('/')));
    			denominators[1] = Integer.parseInt(numberInQuestion.substring(numberInQuestion.indexOf('/') + 1, numberInQuestion.length()));
    		}
    		
    		// if the whole is negative, than make the numerator negative also
    		for (int i = 0; i <= 1; i++) {
    			if (wholeNumbers[i] < 0) {
    				numerators[i] = -numerators[i];
    			}
    		}
    		
    		System.out.println(wholeNumbers[0] + ", " + wholeNumbers[1]);
    		System.out.println(numerators[0] + ", " + numerators[1]);
    		System.out.println(denominators[0] + ", " + denominators[1]);
    		System.out.println(operator);
    		/*
    		System.out.println("whole: " + wholeNumbers[1]);
    		System.out.println("num: " + numerators[1]);
    		System.out.println("denom: " + denominators[1]);
    		System.out.println("operator: " + operator);
    		
    		//5_3/4 + 6_5/8
    		
    		
    		// NOW FOR CALCULATIONS
    		*/
    		
    		int resultNumorator = 0;
    		int resultDenominator = 0;
    		if (operator == '+') {
    			
    			int leastCommonMultiple = lcm(denominators[0], denominators[1]);
    			resultDenominator = leastCommonMultiple;
    			for (int i = 0; i <= 1; i++) {
    				numerators[i] += (wholeNumbers[i] * denominators[i]); // multiply the whole number by the denom and add to numorator, creating an improper fraction
    				numerators[i] *= (leastCommonMultiple / denominators[i]); // multiply the numorators by the amount of times it's denom goes into both denoms' lcm
    			System.out.println("num = " + numerators[i]);
    			}
    			resultNumorator = numerators[0] + numerators[1];
    			
    			
    		} else if (operator == '-') {
    			int leastCommonMultiple = lcm(denominators[0], denominators[1]);
    			resultDenominator = leastCommonMultiple;
    			for (int i = 0; i <= 1; i++) {
    				numerators[i] += (wholeNumbers[i] * denominators[i]); // multiply the whole number by the denom and add to numorator, creating an improper fraction
    				numerators[i] *= (leastCommonMultiple / denominators[i]); // multiply the numorators by the amount of times it's denom goes into both denoms' lcm
    			System.out.println("num = " + numerators[i]);
    			}
    			resultNumorator = numerators[0] - numerators[1];
    			
    		} else if (operator == '*') {
    			for (int i = 0; i <= 1; i++) {
    				numerators[i] += (wholeNumbers[i] * denominators[i]); // multiply the whole number by the denom and add to numorator, creating an improper fraction
    			}
    			resultNumorator = numerators[0] * numerators[1];
    			resultDenominator = denominators[0] * denominators[1];
    		
    		} else if (operator == '/') {
    			for (int i = 0; i <= 1; i++) {
    				numerators[i] += (wholeNumbers[i] * denominators[i]); // multiply the whole number by the denom and add to numorator, creating an improper fraction
    			}
    			// make the second fraction a reciprical
    			int num = numerators[1];
    			numerators[1] = denominators[1];
    			denominators[1] = num;
    			
    			resultNumorator = numerators[0] * numerators[1];
    			resultDenominator = denominators[0] * denominators[1];
    			
    		}
    		
    		// -3_3/4 - -2_2/4
    		// -15/4 - -10/4
    		// -5/4
    		
    		// -3_3/4 + -2_2/4
    		// -15/4 + -10/4
    		// -25/4
    		
    		
    		
    		
/*    		RE-DID CODE, THIS IS WAY TO CONFUSING
 * 
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

		return resultNumorator + "/" + resultDenominator;
	}
	public static int lcm(int number1, int number2) {
	    if (number1 == 0 || number2 == 0) {
	        return 0;
	    }
	    int absNumber1 = Math.abs(number1);
	    int absNumber2 = Math.abs(number2);
	    int absHigherNumber = Math.max(absNumber1, absNumber2);
	    int absLowerNumber = Math.min(absNumber1, absNumber2);
	    int lcm = absHigherNumber;
	    while (lcm % absLowerNumber != 0) {
	        lcm += absHigherNumber;
	    }
	    return lcm;
	}	

}

