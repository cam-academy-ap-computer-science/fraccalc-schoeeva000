/* PSUDOCODE
 * 
 * IN MAIN
 * get input from user
 * pass it to a method which does the calculations (simple!)
 * output that answer to the console
 * 
 * IN PRODUCE ANSWER
 * split the input by the operator(s) and put parts into strings
 * do this for each part, based on number of parts
 * 		split the parts (mixed numbers) into whole number, numerator, and denominator
 * 		take the numerator divided by denominator and add to the whole number (if fraction is improper)
 * 		make the fraction proper by making the numerator modulo denominator the new numerator
 * find the greatest common denominator by calling a method gcm, and make the denominators equal to that denom
 * 
 * 
 * 
 * call a method GCD to figure out the greatest common denominator for the num and denom
 * use this to simplify fraction, by dividing num and denom by the GCD
 * 
 * IN GCD
 * find the gcd! (see below)
 * 
 */


package fracCalc;

public class FracCalc {

    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation

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
