/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteuler.Projects;

import java.math.BigInteger;

/**
 *
 * @author haller
 */
public class Problem063 implements Problem {

    @Override
    public void run() {
        
        int result = 0;
        int n = 1;
        boolean end = false;
        int upperBound = 10;
        int lower = 0;
        
        while ( lower < upperBound) {
            lower = (int)Math.ceil(Math.pow(10, (n-1.0)/n));
            result += 10 - lower;
            n++;
        }
        
        
        System.out.println("Count: " + result);
        
    }
    
}
