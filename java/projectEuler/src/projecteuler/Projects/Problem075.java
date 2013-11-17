/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteuler.Projects;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author michael.j.haller
 */
public class Problem075 implements Problem {
    
    private long GCD(long a, long b) {
        if (b==0) return a;
        return GCD(b,a%b);
    }
    
    @Override
    public void run() {
        
        int N = 1500000;
        int[] counts = new int[N+1];
        Arrays.fill(counts, 0);
        int mlimit = (int)Math.sqrt(N / 2);
        int result = 0;
        
        for ( long m = 2; m < mlimit; m++ ) {
            for (long n = 1; n < m; n++ ) {
                if (((n + m) % 2) == 1 && GCD(m,n) == 1) {
                    long a = (m*m)-(n*n);
                    long b = (2 * m * n);
                    long c = (m*m) + (n*n);
                    long p = a + b + c;

                    while ( p < N ) { 
                        counts[(int)p]++;
                        if ( counts[(int)p] == 1 ) result++;
                        if ( counts[(int)p] == 2 ) result--;
                        p += a+b+c;
                    }
                }
            }
        }
        
        System.out.println("Values: " + result);
    }
    
}
