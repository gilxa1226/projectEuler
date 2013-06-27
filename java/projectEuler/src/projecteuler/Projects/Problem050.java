/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.Projects;

import java.util.ArrayList;
import java.util.List;
import projecteuler.lib.commonMath;

/**
 *
 * @author michael.j.haller
 */
public class Problem050 implements Problem {

    @Override
    public void run() {
        
        List<Integer> primes = new ArrayList<Integer>();
        int temp = 0;
        int numOfPrimes = 0;
        int cnt = 0;
        int largePrime = 0;
        int largestPrime = 0;
        int lrgCnt = 0;
        
        for ( int x = 2; x < 10000; x++ ) {
            if ( commonMath.isPrime(x) ) {
                primes.add(x);
            }
        }
       
        for ( int x = 0; x < primes.size(); x++ ) {
           
            temp = 0;
            cnt = 0;
            
            for ( int y = x; y < primes.size(); y++ ) {
                
                temp += primes.get(y);
                cnt++;
                
                if ( temp > 1000000) {
                    break;
                }
                
                if ( commonMath.isPrime(temp) ) {
                    largePrime = temp;
                    lrgCnt = cnt;
                }
            }
            
            if ( lrgCnt > numOfPrimes ) {
                numOfPrimes = lrgCnt;
                largestPrime = largePrime;
            }
        }
         
        System.out.println(numOfPrimes);
        System.out.println(largestPrime);
    }
    
}
