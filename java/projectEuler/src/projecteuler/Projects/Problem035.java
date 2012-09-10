/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.Projects;

/**
 *
 * @author michael.j.haller
 */
public class Problem035 implements Problem {

    private boolean isPrime(int number){
        int x;
        boolean temp = true;
        
        for ( x = 2 ; x <= (Math.sqrt(number)) ; x++) {
            if ( number % x == 0 ) { temp = false; }
        }
        
        return temp;
    }
    
    private boolean isCircular(int number) {
        boolean temp = true;
        String theNumber = Integer.toString(number);
        String tmp;
        
        for ( int x = 0; x < theNumber.length(); x++) {
            if ( x == 0 ) {
                tmp = theNumber;
            } else {
                tmp = theNumber.substring(x, theNumber.length()) + theNumber.substring(0, x);
            }
            
            if ( !isPrime(Integer.parseInt(tmp))) {
                temp = false;
                break;
            }
        }
        
        return temp;
        
    }
    
    @Override
    public void run() {
        
        int end = 2000000;
        long sum = 0;
        
        for( int x = 2; x < end; x++ ) {
            if ( isPrime(x) ) { 
                if ( isCircular(x)) {
                    System.out.println(x);
                    sum++;
                }
            }
        }
                
        System.out.println("Count of all circular primes: " + sum);
    }
    
}
