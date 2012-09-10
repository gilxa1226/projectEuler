/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.Projects;

import java.math.BigInteger;
import projecteuler.lib.commonMath;

/**
 *
 * @author michael.j.haller
 */
public class Problem034 implements Problem {

    private int factorial(int number) {
        int temp = 1;
        for (int x = 1; x <= number; x++ ) {
            temp *= x;
        }
        return temp;
    }
    
    private int sumDigitFactorial(int number) {
        String theNumber = Integer.toString(number);
        int temp;
        int sum = 0;
        
        for ( int x = 0; x < theNumber.length(); x++ ) {
            temp = Integer.parseInt(String.valueOf(theNumber.charAt(x)));
            sum += factorial(temp);
        }
        return sum;
    }
    
    @Override
    public void run() {
        
        long sum = 0;
        
        for ( int x = 3; x < 999999; x++) {
            if ( x == sumDigitFactorial(x)) {
                System.out.println(x);
                sum += x;
            }
        }
        
        System.out.println("Sum: " + sum);
    }
    
}
