/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteuler.Projects;

/**
 *
 * @author haller
 */
public class Problem076 implements Problem {

    @Override
    public void run() {
        int target = 100;
        int[] ways;
        
        ways = new int[target + 1];
        ways[0] = 1;
        for (int x = 1; x < 100; x++) {
             for (int j = x; j <= target; j++) {
                 ways[j] += ways[j-x];
             }
        }

        System.out.println("Number of ways to add up to 100: " + ways[100]);
        
    }
    
}
