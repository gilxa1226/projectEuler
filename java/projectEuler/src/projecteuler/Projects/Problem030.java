/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.Projects;

/**
 *
 * @author michael.j.haller
 */
public class Problem030 implements Problem {

    private boolean sumOfPowers(long number, int power) {
        
        long temp = number;
        String num = Long.toString(temp);
        long sum = 0;
        long a;
       
        for (int x = 0; x < num.length(); x++ ) {
            a = temp % 10;
            a = (int) Math.pow(a, power);
            sum += a;
            temp = temp / 10;
        }
                
        return ( number == sum);
    }
    
    @Override
    public void run() {
        
        long sum = 0;
        int size = 5;
        
        for ( long x = 2; x < 9999999; x++ ) {
            if (sumOfPowers(x,size)) {
                System.out.println(x);
                sum += x;
            }
        }
        
        System.out.println("Sum: " + sum);
    }
    
}
