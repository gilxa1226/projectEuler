/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.Projects;

/**
 *
 * @author michael.j.haller
 */
public class Problem010 implements Problem {

    private boolean isPrime(int number){
        int x;
        boolean temp = true;
        
        for ( x = 2 ; x <= (Math.sqrt(number)) ; x++) {
            if ( number % x == 0 ) { temp = false; }
        }
        
        return temp;
    }
    
    @Override
    public void run() {
        
        int end = 2000000;
        long sum = 0;
        
        for( int x = 2; x < end; x++ ) {
            if ( isPrime(x) ) { sum+=x; }
        }
        
        System.out.println(sum);
    }
    
}
