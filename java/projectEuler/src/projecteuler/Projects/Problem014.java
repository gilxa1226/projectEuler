/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.Projects;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author michael.j.haller
 */
public class Problem014 implements Problem {

    private boolean isEven(long number) {
        if ( number % 2 == 0 ) {
            return true;
        } else {
            return false;
        }
    }
    
    private long evenFunc(long number) {
        return number / 2;
    }
    
    private long oddFunc(long number) {
        return (3 * number) + 1;
    }
    
    @Override
    public void run() {
        
        int longestChain = 0;
        int chainNumber = 0;
        int sizeTemp = 0;
                
        for( int x = 2; x < 1000000; x++ ) {
            long temp = x;
            //System.out.println(x);
            sizeTemp++;
            
            //System.out.print("\t");
            while ( temp != 1 ) {
                if ( isEven(temp)) {
                    temp = evenFunc(temp);
                } else {
                    temp = oddFunc(temp);
                }
                sizeTemp++;
                //System.out.print(temp + " ");
            }
            //System.out.println("");
            if ( sizeTemp > longestChain ) { 
                chainNumber = x;
                longestChain = sizeTemp;
            }
            sizeTemp = 0;
        }
        
        System.out.println("Longest Chain Number: " + chainNumber);
        System.out.println("Longest Chain Size: " + longestChain);
        
    }
}
