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
 * @author haller
 */
public class Problem012 implements Problem {

    
    
    private int findDivisors(long num) {
        int cnt = 0;
        cnt++; // 1
        cnt++; // num

        if (commonMath.isEven(num)) {
            cnt++; // 2
            
            for (int x = 3; x < (num / 2); x++) {
                if ( (num%x) == 0 ) {
                    cnt++;
                }
            }

        } else {
            for (int x = 3; x < num; x++) {
                if ( (num%x) == 0 ) {
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
    
    private int genTriangle(int triNum) {
        
        int temp = 0;
        
        for ( int x = 1; x < triNum; x++ ) {
            temp+=x;
        }
        
        return temp;
    }
    
    @Override
    public void run() {
        
        long triangle;
        int numFacts;
        
        for( int x = 7; ; x++) {
            triangle = genTriangle(x);
            numFacts = findDivisors(triangle);
            System.out.println("triangle: " + triangle + "  numFacts: " + numFacts);
            
            if ( numFacts > 500) {
                System.out.println("Winner: triangle: " + triangle + "  numFacts: " + numFacts);
                return;
            }
        
        }
        
    }
    
}
