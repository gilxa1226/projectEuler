/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteuler.Projects;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author michael.j.haller
 */
public class Problem074 implements Problem{

    private long factorial(long number) {
        
        long factorial = 1;
        
        for(long x = number; x > 0; x--) {
            factorial = factorial * x;
        }
        
        return factorial;
    }
    
    private long sumFactorials(long number) {
        long n = number;
        long sum = 0;
        
        while (n > 0) {
            sum += factorial(n % 10);
            n = n / 10;
        }
        
        return sum;
    } 
    
    private int countChains(long number) {
        
        Set<Long> found = new LinkedHashSet<Long>();
        long n = number;
        int sum = 0;
        
        while (!found.contains(n)) {
            sum ++;
            found.add(n);
            n = sumFactorials(n);
        }
        
        return sum;
    }
    
    
    @Override
    public void run() {
        
        int limit = 1000000;
        int count = 0;
        int counts[] = new int[limit+1];
        
       
        for (int x = 1; x < limit; x++) {
            System.out.println("Checking x = " + x);
            counts[x] = countChains(x);
            if (counts[x] == 60) {
                count++;
            }
        }

        System.out.println(count + " numbers contain exactly 60 non-repeating terms.");
        
    }
    
}
