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
public class Problem027 implements Problem {

    private long qFunction(int n, int a, int b) {
        long temp = n*n;
        long an = a * n;
        return temp + an + b;
    }
    
    @Override
    public void run() {
        
        long temp;
        int maxCnt = 0;
        int n = 0;
        int a = 0, b = 0;
        
        for ( int x = -999; x < 1000; x++ ) {
            for ( int y = -999; y < 1000; y++ ) {
                n = 0;
                while ( commonMath.isPrime(Math.abs(qFunction(n, x, y))) ) {
                    n++;
                }
                                
                if ( n > maxCnt ){ 
                    maxCnt = n; 
                    a = x;
                    b = y;
                }
            }
        }
        
        System.out.println("a = " + a + "; b = " + b + " - Count = " + maxCnt);
        System.out.println("Product: " + a*b);
        
    }
    
}
