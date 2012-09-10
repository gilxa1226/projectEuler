/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.Projects;

import java.math.BigInteger;

/**
 *
 * @author michael.j.haller
 */
public class Problem025 implements Problem {

    private int fib(int size) {
        
        BigInteger a = new BigInteger("1");
        BigInteger b = new BigInteger("1");
        BigInteger temp;
        int count = 1;
        
        while ( a.toString().length() < size) {
            temp = a;
            a = b;
            b = b.add(temp);
            count++;
        }
        
        return count;
    }
    
    @Override
    public void run() {
        
        BigInteger a = new BigInteger("1");
        BigInteger b = new BigInteger("1");
        
        System.out.println(fib(1000));
        
    }
    
}
