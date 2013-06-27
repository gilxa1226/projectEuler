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
public class Problem046 implements Problem {

    @Override
    public void run() {
        
        int temp;
        double tmp;
        boolean smallest = true;
        int smallestNum = 0;
        int x;
        
        for ( x = 9; x < Integer.MAX_VALUE; x = x + 2) {
            if ( !commonMath.isPrime(x)) {
                for ( int y = 3; y < x; y = y + 2 ) {
                    if ( commonMath.isPrime(y)) {
                        temp = x - y;
                        tmp = temp / 2;
                        tmp = Math.sqrt(tmp);
                        
                        if ( tmp != (int)tmp ) {
                            smallest = true;
                        } else {
                            smallest = false;
                            break;
                        }
                    }
                }
                
                if ( smallest ) {
                    smallestNum = x;
                    break;
                }
            }
        }
        
        System.out.println("Smallest: " + smallestNum);
        
    }
    
}
