/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteuler.Projects;

import java.util.Map;

/**
 *
 * @author michael.j.haller
 */
public class Problem031 implements Problem {

    private static final int[] coins = {200, 100, 50, 20, 10, 5, 2, 1};
    private static final int coinsSize = 8;
    private int changeCounts;
    
    private void doCalculateChange(int amount, int sortCount, int[] sortCounts) {
        
        int count, i;
        
        if (sortCount == 0) {
            for (i = 0; i < sortCounts.length; ++i) {
                if (sortCounts[i] != 0) {
                    System.out.println(sortCounts[i] + " x " + coins[i]);
                    
                } if ( i < sortCounts.length ) {
                    System.out.print(", ");
                }
            }
            
            System.out.println("");
            changeCounts++;
            return;
        }
        
        count = amount / coins[coinsSize - sortCount];
        
        if (sortCount > 1) {
            for (i = count; i >= 0; --i) {
                sortCounts[8 - sortCount] = i;
                doCalculateChange(amount - i * coins[coinsSize - sortCount], sortCount - 1, sortCounts);
            }       
        } else {
            sortCounts[coinsSize-1] = count;
            doCalculateChange(0, 0, sortCounts);
        }
        
    }
    
    @Override
    public void run() {
        int amount = 200;
        int sortCount = 8;
        int[] sortCounts = new int[sortCount];
   
        doCalculateChange(amount, sortCount, sortCounts);
        System.out.println("Change Counts: " + changeCounts);
    }
   
}
