/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.Projects;

import projecteuler.lib.commonMath;

/**
 *
 * @author haller
 */
public class Problem038 implements Problem {

    @Override
    public void run() {
        
        StringBuilder theNum;
        int temp;
        int largestPan = -1;
        
        for ( int x = 2; x < 9999; x++ ) {
            
            theNum = new StringBuilder();
            
            for ( int y = 1; y < 9999; y++ ) {
                temp = x * y;
                theNum.append(temp);                
                
                if ( theNum.toString().length() == 9 ) {
                    
                    if ( (commonMath.isPandigital(theNum.toString())) && (Integer.parseInt(theNum.toString()) > largestPan) ) {
                        largestPan = Integer.parseInt(theNum.toString());
                        break;
                    }
                }
                
                if ( theNum.toString().length() > 9 ) {
                    break;
                }
                
            }
        }
        
        System.out.println(largestPan);
        
    }
    
}
