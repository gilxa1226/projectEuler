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
public class Problem056 implements Problem {

    
    
    @Override
    public void run() {
        
        BigInteger bigA;
        BigInteger power;
        int max = -1;
        
        for ( int a = 1; a < 100; a++ ) {
            for ( int b = 1; b < 100; b++ ) {
                bigA = BigInteger.valueOf(a);
                power = bigA.pow(b);
                int temp = commonMath.sumDigits(power);
                
                if ( temp > max) { max = temp; }
            }
        }
        
        System.out.println(max);
    }
    
}
