/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.Projects;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author michael.j.haller
 */
public class Problem021 implements Problem {

    private int sumDivisors(int num) {
        int sum = 0;
        
        for ( int x = 1; x <= (num/2); x++) {
            if ( (num % x) == 0 ) {
                sum += x;
            }
        }
      
        return sum;
    }
    
    @Override
    public void run() {
        int sum = 0;
        int a, b;
        Map<Integer, Integer> found = new HashMap<Integer, Integer>();
        
        
        for ( int x = 1; x < 10000; x++ ) {
            a = sumDivisors(x);
            b = sumDivisors(a);
            
            if ( x == b && a != b ) {
                sum+=x;
            }
        }
        
        System.out.println(sum);

        
    }
    
}
