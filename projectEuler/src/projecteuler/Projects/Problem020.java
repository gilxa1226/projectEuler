/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.Projects;

import java.math.BigInteger;

/**
 *
 * @author michael.j.haller
 */
public class Problem020 implements Problem {

    private BigInteger factorial(int number) {
        BigInteger fact = new BigInteger("1");
        
        for(int x = number; x > 1; x--) {
            fact = fact.multiply(BigInteger.valueOf(x));
        }
        return fact;
    }
    
     private int sumDigits(BigInteger num) {
        BigInteger temp = num;
        BigInteger one = new BigInteger("1");
        BigInteger ten = new BigInteger("10");
        BigInteger sum = new BigInteger("0");
        
        while ( temp.compareTo(one) > 0 ) {
            if ( temp.compareTo(new BigInteger("100")) == -1) {
            }
            
            if ( temp.compareTo(ten) == 0 ) {
                sum = sum.add(one);
            } else {
                sum = sum.add(temp.mod(ten));
            }
            
            
            temp = temp.divide(ten);
        }
        return sum.intValue();
    }
    
    @Override
    public void run() {
        
        //BigInteger fact = new BigInteger("10");
        
        BigInteger fct = factorial(100);
        
        System.out.println(sumDigits(fct));
    }
    
}
