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
public class Problem016 implements Problem {

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
        

        //sum = sum.add(one);
        

        return sum.intValue();
    }
    
    @Override
    public void run() {
        
        //double x = (double) Math.pow(2, 1000);
        BigInteger x = new BigInteger("2");
        BigInteger pow = x.pow(1000);
        //System.out.println(pow);
        
        System.out.println(sumDigits(pow));
        
    }
    
}
