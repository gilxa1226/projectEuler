package projecteuler.Projects;

import projecteuler.lib.commonMath;

/**
 *
 * @author michael.j.haller
 */
public class Problem070 implements Problem {

    private int fi(int n) {
        int result = n;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                result -= result / i;
            }
            while (n % i == 0) {
                n /= i;
            }
        }
        if (n > 1) {
            result -= result / n;
        }
        return result;
    }
    
    
    @Override
    public void run() {
        
        int MAX = 10000000;
        int n = 0;
        double ratioMin = Double.MAX_VALUE;
        double ratio;
        
        for ( int x = 2; x < MAX; x++ ) {
            int fiX = fi(x);
            
            if ( commonMath.sameDigits(x, fiX) ) {
                ratio = (double)x / (double)fiX;
                if ( ratio < ratioMin ) {
                    ratioMin = ratio;
                    n = x;
                }
            }
            
        }
        
        System.out.println("X: " + n);
    }
    
}
