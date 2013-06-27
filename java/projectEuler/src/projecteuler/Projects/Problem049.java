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
public class Problem049 implements Problem {

    
    
    @Override
    public void run() {
        
        int t1, t2 = 0;
        StringBuilder theNum = new StringBuilder();
        
        for ( int x = 1000; x < 10000; x++ ) {
            
            if ( commonMath.isPrime(x) && (x != 1487) ) {
                t1 = x + 3330;
                t2 = t1 + 3330;
                
                if ( commonMath.isPrime(t1) && commonMath.isPrime(t2) &&               
                    commonMath.sameDigits(x, t1) && commonMath.sameDigits(x, t2) ) {
                    
                    theNum.append(x).append(t1).append(t2);
                    break;
                }
            }
        }
        
        System.out.println(theNum.toString());
        
    }
    
}
