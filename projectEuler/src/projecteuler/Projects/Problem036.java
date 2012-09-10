/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.Projects;

/**
 *
 * @author michael.j.haller
 */
public class Problem036 implements Problem {

    @Override
    public void run() {
        
        int sum = 0;
        
        for ( int x = 1; x < 1000000; x++ ) {
            
            String intTest = Integer.toString(x);
            if ( intTest.equals(new StringBuilder(intTest).reverse().toString()) ) {
                //The integer is a palindrome
                String binTest = Integer.toBinaryString(x);
                
                if ( binTest.equals(new StringBuilder(binTest).reverse().toString()) ) {
                    // The Binary is a palindrome
                    System.out.println(intTest + " = " + binTest);
                    sum+=x;
                }
            }
        }
        
        System.out.println("Sum = " + sum);
    }
    
}
