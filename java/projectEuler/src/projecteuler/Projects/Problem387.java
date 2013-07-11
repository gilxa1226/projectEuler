/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.Projects;

import java.math.BigInteger;
import projecteuler.lib.commonMath;

/**
 *
 * @author haller
 */
public class Problem387 implements Problem {

    
    private int sumOfDigits(long number) {
        
        String digits = Long.toString(number);
        int sum = 0;
        
        for(int x = 0; x < digits.length(); x++) {
            sum += Integer.parseInt(Character.toString(digits.charAt(x)));
        }
        
        return sum;
    }
    
    private boolean isHarshad(Long number, long sum) {
     
        return number % sum == 0 ? true : false;
    }
    
    private boolean isStrongHarshad(long number, long sum) {
        long result = number / sum;
        
        return (isHarshad(number, sum) && commonMath.isPrime(result));
    }
    
    boolean isRightTruncatableHarshad(long number) {
        boolean ret = true;
        long sum = 0;
        String digits = Long.toString(number);
        
        while (!digits.isEmpty()) {
            long newNumber = Long.parseLong(digits);
            sum = sumOfDigits(newNumber);
            ret = isHarshad(newNumber, sum);
            long dividend = newNumber / sum;
            if ( !ret && !commonMath.isPrime(dividend) ) {
                return false;
            }
            
            digits = digits.substring(0, digits.length()-1);
        }
        
        return ret;
    }
    
    @Override
    public void run() {
        long largeSet = 100000000000000L;
        long smallSet = 10000;
        long sum = 0;
        
        for (long x = 10; x < smallSet; x++) {
            if (commonMath.isPrime(x)) {
                String number = Long.toString(x);
                long newNumber = Long.parseLong(number.substring(0,number.length()-1));
                long newNumberSum = sumOfDigits(newNumber);
                
                if(isStrongHarshad(newNumber, newNumberSum) && isRightTruncatableHarshad(newNumber)) {
                    System.out.println(x);
                    sum += x;
                }
                               
            }
        }
        
        System.out.println("Sum = " + sum);
    }
    
}
