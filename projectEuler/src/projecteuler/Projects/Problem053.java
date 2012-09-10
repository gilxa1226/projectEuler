/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.Projects;

import java.math.BigInteger;

/**
 *
 * @author michael.j.haller
 */
public class Problem053 implements Problem {

    
    private BigInteger factorial(int number) {
        BigInteger fact = new BigInteger("1");
        
        if (number == 0) {
            return BigInteger.ONE;
        }
        
        for(int x = number; x > 1; x--) {
            fact = fact.multiply(BigInteger.valueOf(x));
        }
        return fact;
    }
    
    private double combinatorics(int n, int r) {
        
        BigInteger nFact = factorial(n);
        BigInteger rFact = factorial(r);
        BigInteger nrFact = factorial(n-r);
        
        BigInteger comb = nFact.divide((rFact.multiply(nrFact)));
        
        return comb.doubleValue();
    }
    
    @Override
    public void run() {
        
        double comb = 0;
        int cnt = 0;
        
        for (int x = 23; x <= 100; x++) {
            for(int y = 0; y <= x; y++) {
                comb = combinatorics(x,y);
                if ( comb > 1000000 ) { cnt++; }
            }
        }
        
        System.out.println(cnt);
    }
    
}
