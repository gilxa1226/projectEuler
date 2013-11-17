/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteuler.Projects;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author haller
 */
public class Problem062 implements Problem {

    class Cube {
        long n;
        int perms;
    }
    
    int chain = 5;
      
    private long getSmallestPermutation(long number) {
        int[] digits = new int[10];
        long k = number;
        int tmp;
        long retValue = 0;
        
        while ( k > 0 ) {
            tmp = (int) (k % 10);
            digits[tmp]++;
            k /= 10;
        }
        
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < digits[i]; j++) {
                retValue = retValue * 10 + i;
            }
        }

        return retValue;
    }
   
    @Override
    public void run() {
        
        long x = 1;
        Map<Long, Cube> cubes = new HashMap<Long, Cube>();
        long smallestPerm;
        long cube;
        Cube temp = null;
        Cube result = null;
        
        while (true) {
            x++;
            //System.out.println("checking x = " + x);
            cube = (long) Math.pow(x, 3);
            smallestPerm = getSmallestPermutation(cube);
            if (!cubes.containsKey(smallestPerm)) {
                temp = new Cube();
                temp.n = x;
                temp.perms = 1;
                cubes.put(smallestPerm, temp);
            } else {
                temp = cubes.get(smallestPerm);
                
                if (++temp.perms == chain) {
                    result = cubes.get(smallestPerm);
                    break;
                } else {
                    cubes.put(smallestPerm, temp);
                }
            }
                        
        }
        
        System.out.println("Smallest Cube generated with 5 cube permutations: " + result.n * result.n * result.n );
    }
    
}
