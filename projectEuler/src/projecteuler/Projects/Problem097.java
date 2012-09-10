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
public class Problem097 implements Problem {

    @Override
    public void run() {
        BigInteger base = new BigInteger("28433");
        BigInteger two = new BigInteger("2");
        BigInteger bigNumber = two.pow(7830457);
        BigInteger product = base.multiply(bigNumber);
        product = product.add(BigInteger.ONE);
        String ans = product.toString();
        
        System.out.println(ans.substring(ans.length()-10));
    }
    
}
