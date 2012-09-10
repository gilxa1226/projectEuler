/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.Projects;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author michael.j.haller
 */
public class Problem029 implements Problem {

    private Map<String,Integer> genIntCombs(int a, int b) {
        Map<String,Integer> temp = new HashMap<String,Integer>();
        BigInteger j;
        
        for ( int x = 2; x <= a; x++ ) {
            for ( int y = 2; y <= b; y++ ) {
                j = BigInteger.valueOf(x).pow(y);
                temp.put(j.toString(), x);
            }
        }
        
        return temp;
    }
    
    @Override
    public void run() {
        
        int a = 100;
        int b = 100;
        Map<String, Integer> combs = genIntCombs(a,b);
        Set<String> term = combs.keySet();
        int terms = combs.keySet().size();
        
        System.out.println("Size: " + terms);
        
    }
    
}
