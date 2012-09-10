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
public class Problem048 implements Problem {

    @Override
    public void run() {
       
        BigInteger sum = new BigInteger("0");
        BigInteger temp;
        BigInteger tempPow;
        
        for ( int x = 1; x <= 1000; x++ ) {
            temp = BigInteger.valueOf(x);
            tempPow = temp.pow(x);
            sum = sum.add(tempPow);
        }
        
        String answer = sum.toString();
        
        System.out.println(answer.substring(answer.length()-10));
        
    }
    
}
