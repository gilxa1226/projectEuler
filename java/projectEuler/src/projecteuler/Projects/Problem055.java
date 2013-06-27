/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.Projects;

import java.math.BigInteger;
import projecteuler.lib.commonMath;

/**
 *
 * @author michael.j.haller
 */
public class Problem055 implements Problem {

    private BigInteger reverseNumber(BigInteger num) {
        StringBuilder theNum = new StringBuilder();
        theNum.append(num.toString());
        BigInteger revNum = new BigInteger(theNum.reverse().toString());
        
        return revNum;
    }
    
    private boolean isLychrel(int num) {
        
        BigInteger temp = BigInteger.valueOf(num);
        boolean lychrel = true;
        
        for ( int x = 0; x < 50; x++ ) {
            temp = temp.add(reverseNumber(temp));
            
            if ( commonMath.isPalindrome(temp) ) {
                lychrel = false;
                break;
            }
        }
             
        return lychrel;
        
    }
    
    @Override
    public void run() {
        
        int cnt = 0;
        
        for ( int x = 10; x < 10000; x++ ) {
            if ( isLychrel(x) ) {
                cnt++;
            }
        }
        
        System.out.println(cnt);
    }
    
}
