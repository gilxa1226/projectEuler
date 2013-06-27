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
public class Problem069 implements Problem {

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
    
    private boolean isRealativelyPrime(int a, int b) {
        
        if ( commonMath.isPrime(a) && commonMath.isPrime(b) ) {
            return true;
        }
        
        if ( gcd(a,b) == 1 ) {
            return true;
        } else {
            return false;
        }
    }
    
    private long sumList(List<Integer> intList) {
        long sum = 0;
        
        for(Integer i: intList) {
            sum += i.intValue();
        }
        
        return sum;
    }
    
    int fi(int n) 
     { 
       int result = n; 
       for(int i=2;i*i <= n;i++) 
       { 
         if (n % i == 0) result -= result / i; 
         while (n % i == 0) n /= i; 
       } 
       if (n > 1) result -= result / n; 
       return result; 
     } 
    
    @Override
    public void run() {
        int n = 2;
        int MAX = 1000000;
        List<Integer> rPrimes = null;
        double result;
        double max = 0.0;
        int maxN = n;
        int maxSize = 0;
        int fiN;
        
        for (n = 2; n <= MAX; n++ ) {
            
            rPrimes = new ArrayList<Integer>();
            System.out.println("n: " + n);
            
            fiN = fi(n);
            
//            for(int x = n-1; x >= 1; x-- ) {
//                if (isRealativelyPrime(n,x)) {
//                    rPrimes.add(x);
//                }
//            }

            result = (double)n/(double)fiN;
            
            if ( result > max ) {
                max = result;
                maxN = n;
                maxSize = fiN;
            }
           
        }
        
        System.out.println("n: " + maxN + ", size: " + maxSize + ", result: " + max); 
    }
    
}
