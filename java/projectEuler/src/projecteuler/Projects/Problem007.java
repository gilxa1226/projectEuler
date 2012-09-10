package projecteuler.Projects;


/**
 *
 * @author haller
 */
public class Problem007 implements Problem {

    private boolean isPrime(long num) {

        boolean prime = true;
        
        for ( int x = 2; x <= Math.sqrt(num); x++ ) {
            if ( num % x == 0 ) {
                prime = false;
            }
        }
        return prime;
    }
    
    @Override
    public void run() {
        int maxPrime = 100001;
        long count = 0;
        long idx = 2;
        
        while ( count < maxPrime ) {
            if ( isPrime(idx) ) {
                
                idx++;
                count++;
            } else {
                idx++;
            }
        }
        System.out.println(count + ": " + idx--);
        
    }
    
}
