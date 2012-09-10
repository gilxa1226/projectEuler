/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.Projects;

import projecteuler.lib.commonMath;

/**
 *
 * @author michael.j.haller
 */
public class Problem041 implements Problem {

    
    @Override
    public void run() {
        
        long largestPan = -1;
        
        for ( long x = 7654321; x > 0 ; x = x - 2 ) {
            if ( commonMath.isPandigital(Long.toString(x), Long.toString(x).length()) ) {
                if ( commonMath.isPrime(x) ) {
                    if (  x > largestPan ) {
                        largestPan = x;
                        System.out.println("PanPrime: " + x);   
                        break;
                    }
                }
            }
        }
        
        System.out.println("");
        System.out.println(largestPan);
        
    }
    
}
