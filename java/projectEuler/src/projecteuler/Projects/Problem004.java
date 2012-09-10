/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.Projects;

/**
 *
 * @author michael.j.haller
 */
public class Problem004 implements Problem {

    private boolean isPalindrome(int number) {
        
        String temp = Integer.toString(number);
        String rev = new StringBuilder(temp).reverse().toString();
        
        return temp.equals(rev);
    }
    
    
    
    @Override
    public void run() {
        int largest = 0;
        int temp = 0;
        
        for ( int x = 100; x < 1000; x++ ) {
            for (int y = 100; y < 1000; y++ ) {
                temp = x * y;
                if ( isPalindrome(temp)  && (temp > largest) ) {
                    largest = temp;
                }
            }
        }
        
        System.out.println("Largest Palidrome is: " + largest);
        
    }
    
}
