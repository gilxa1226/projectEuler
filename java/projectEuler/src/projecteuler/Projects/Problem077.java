/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteuler.Projects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author michael.j.haller
 */
public class Problem077 implements Problem {

    private static int n = 1000;
    private boolean[] primesTable = new boolean[n];    
    
    private void fillSeive() {
        Arrays.fill(primesTable, true);
        primesTable[0] = false;
        primesTable[1] = false;
        primesTable[2] = true;
        primesTable[3] = true;
        //int fillSize = (int)Math.sqrt(n);
        for (int i = 4; i < n; i += 2) primesTable[i] = false;
        for (int i = 3; i < n; i += 2) {
            for (int j = i+i; j < n; j += i) {
                primesTable[j] = false;
            }
        }
    }
    
    private Object[] getPrimes() {
        List<Integer> primes = new ArrayList<Integer>();
        
        for( int x = 0; x < primesTable.length; x++ ) {
            if(primesTable[x]) {
                primes.add(x);
            }
        } 
        
        return primes.toArray();
    }
    
    
    @Override
    public void run() {
        int target = 2;
        int[] ways;
        fillSeive();
        Object[] primes = getPrimes();
        
        while (true) {
            ways = new int[target + 1];
            ways[0] = 1;
            for (Object prime : primes) {
                for (int j = Integer.valueOf(prime.toString()); j <= target; j++) {
                    int temp = j - Integer.valueOf(prime.toString());
                    ways[j] += ways[temp];
                }
            }

            if (ways[target] > 5000) {
                break;
            }
            target++;
        }
        
        System.out.println("Number: " + target);
        
    }
    
}
