/* 
  _   _  ____ _______ ______ 
 | \ | |/ __ \__   __|  ____|
 |  \| | |  | | | |  | |__   
 | . ` | |  | | | |  |  __|  
 | |\  | |__| | | |  | |____ 
 |_| \_|\____/  |_|  |______| --> This is not the psudocode for the code below. 
 							  -- This was for when I wanted to do math on more than 2 numbers
 							  -- Comments below help to fill in understanding.  
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

	public static String produceAnswer(String input) { 
        // TODO: Implement this function to produce the solution to the input
    	
    	String cutInput = input;
/*
         _           _                                  _       _     _           
        | |         | |                                (_)     | |   | |          
      __| | ___  ___| | __ _ _ __ ___  __   ____ _ _ __ _  __ _| |__ | | ___  ___ 
     / _` |/ _ \/ __| |/ _` | '__/ _ \ \ \ / / _` | '__| |/ _` | '_ \| |/ _ \/ __|
    | (_| |  __/ (__| | (_| | | |  __/  \ V / (_| | |  | | (_| | |_) | |  __/\__ \
     \__,_|\___|\___|_|\__,_|_|  \___|   \_/ \__,_|_|  |_|\__,_|_.__/|_|\___||___/
    	
    	///////////////////////////////////////////////////////////////
*/
    	
    	int wholeNumbers[] = new int[2];
    	int numerators[] = new int[2];
    	int denominators[] = new int[2];
    	char operator;
    	cutInput = input;
    	String numberInQuestion = "";
    	
    	//////////////////////////////////////////////////////////////
/*
 *                               _                          _       
                                | |                        | |      
  ___  ___ _ __   __ _ _ __ __ _| |_ ___   _ __   __ _ _ __| |_ ___ 
 / __|/ _ \ '_ \ / _` | '__/ _` | __/ _ \ | '_ \ / _` | '__| __/ __|
 \__ \  __/ |_) | (_| | | | (_| | ||  __/ | |_) | (_| | |  | |_\__ \
 |___/\___| .__/ \__,_|_|  \__,_|\__\___| | .__/ \__,_|_|   \__|___/
          | |                             | |                       
          |_|                             |_|
 */
    		
    		numberInQuestion = cutInput.substring(0, cutInput.indexOf(' ') + 3);
    		
    		operator = numberInQuestion.charAt(numberInQuestion.indexOf(' ') + 1); // find the operator
    		
    		
    		if (numberInQuestion.indexOf('_') == -1) {
    			if ((numberInQuestion.substring(0, numberInQuestion.length() - 3).indexOf('/') != -1)) {  // the number is a FRACTION
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
    			if (numberInQuestion.indexOf('/') != -1) {  // the number is a FRACTION
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
    		
    		
/*
            _            _       _       
           | |          | |     | |      
   ___ __ _| | ___ _   _| | __ _| |_ ___ 
  / __/ _` | |/ __| | | | |/ _` | __/ _ \
 | (_| (_| | | (__| |_| | | (_| | ||  __/
  \___\__,_|_|\___|\__,_|_|\__,_|\__\___|
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
    		
    		
    		
/*
      _                 _ _  __       
     (_)               | (_)/ _|      
  ___ _ _ __ ___  _ __ | |_| |_ _   _ 
 / __| | '_ ` _ \| '_ \| | |  _| | | |
 \__ \ | | | | | | |_) | | | | | |_| |
 |___/_|_| |_| |_| .__/|_|_|_|  \__, |
                 | |             __/ |
                 |_|            |___/ 
 */
    		
    		int wholeNumber = 0;
    		
    		if (Math.abs(resultNumorator) >= Math.abs(resultDenominator)) { 
    			wholeNumber = resultNumorator / resultDenominator; // form a whole number
    			resultNumorator = resultNumorator % resultDenominator; // make the fraction proper 
    		}
    		
    		int gcd = gcd(resultNumorator, resultDenominator);
    		resultNumorator = resultNumorator / gcd;
    		resultDenominator = resultDenominator / gcd; // simplify num and denom
    		
    		System.out.println(wholeNumber);
    		System.out.println(resultNumorator);
    		System.out.println(resultDenominator);


/*
                     _                  _      ___  _                       _                          _   _                
                    | |                | |    / _ \( )                     | |                        | | (_)               
 __      _____  _ __| | __   ___  _   _| |_  | | | |/ ___    __ _ _ __   __| |  _ __   ___  __ _  __ _| |_ ___   _____  ___ 
 \ \ /\ / / _ \| '__| |/ /  / _ \| | | | __| | | | | / __|  / _` | '_ \ / _` | | '_ \ / _ \/ _` |/ _` | __| \ \ / / _ \/ __|
  \ V  V / (_) | |  |   <  | (_) | |_| | |_  | |_| | \__ \ | (_| | | | | (_| | | | | |  __/ (_| | (_| | |_| |\ V /  __/\__ \
   \_/\_/ \___/|_|  |_|\_\  \___/ \__,_|\__|  \___/  |___/  \__,_|_| |_|\__,_| |_| |_|\___|\__, |\__,_|\__|_| \_/ \___||___/
                                                                                            __/ |                           
                                                                                           |___/                            
 */
    		
    		
    		if ((resultNumorator < 0 && resultDenominator < 0)) { // if both num and denom are negative, the number is positive
    			resultNumorator = Math.abs(resultNumorator);
    			resultDenominator = Math.abs(resultDenominator);
    			wholeNumber = Math.abs(wholeNumber);
    			System.out.println("ran 1st if");
    		} else if (resultNumorator < 0 && wholeNumber < 0) { // only the whole number needs to be negative
    			resultNumorator = Math.abs(resultNumorator);
    		} else if (resultDenominator < 0 && resultNumorator > 0) { // if only denom is negative...
    			resultDenominator = Math.abs(resultDenominator); // make it positive
    			if (wholeNumber != 0) { // and than make the whole number negative
    				if (wholeNumber > 0) {
    					wholeNumber = 0 - wholeNumber;
    				}
    			} else {
    				resultNumorator = 0 - resultNumorator; // or else make the numorator negative
    			}
    			System.out.println("ran 2nd if");
    			
    		}
    		
    		if (wholeNumber == 0 && resultNumorator == 0) { // if fraction and whole are zero, the answer is 0
    			return "0";
    		} else if (wholeNumber == 0) { // if no whole number, than just a fraction
    			return resultNumorator + "/" + resultDenominator;
    		} else if (resultNumorator == 0) { // if no fraction, only a whole number
    			return Integer.toString(wholeNumber);
    		} else { // if none of that, it's a mixed number
    			return wholeNumber + "_" + resultNumorator + "/" + resultDenominator;
    		}
	}
/*    	        _           _                                 _   _               _     
               | |    _    | |                               | | | |             | |    
   __ _  ___ __| |  _| |_  | | ___ _ __ ___    _ __ ___   ___| |_| |__   ___   __| |___ 
  / _` |/ __/ _` | |_   _| | |/ __| '_ ` _ \  | '_ ` _ \ / _ \ __| '_ \ / _ \ / _` / __|
 | (_| | (_| (_| |   |_|   | | (__| | | | | | | | | | | |  __/ |_| | | | (_) | (_| \__ \
  \__, |\___\__,_|         |_|\___|_| |_| |_| |_| |_| |_|\___|\__|_| |_|\___/ \__,_|___/
   __/ |                                                                                
  |___/
*/
	
	
	
 // don't know exactly how these work, but they do!
	
    public static int gcd(int a, int b) {
    	if (b == 0) {
    		return a;
    	}
    	return Math.abs(gcd(b, a%b));
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

