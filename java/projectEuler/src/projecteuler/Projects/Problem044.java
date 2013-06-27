/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.Projects;

/**
 *
 * @author michael.j.haller
 */
public class Problem044 implements Problem {

    private boolean isPentagonal(int x) {
        
        double temp = ((Math.sqrt((24 * x) + 1) + 1) / 6);
        
        if ( temp == (int) temp ) {
            return true;
        } else {
            return false;
        }
        
    }
    
    private int computePentagonal(int x) {
        return x * ((3 * x) - 1) / 2;
    }
    
    private int findPentagonalD() {
        
        for ( int k = 2; k < Integer.MAX_VALUE; k++ ) {
            for ( int j = 1; j < k; j++ ) {
                if ( isPentagonal(computePentagonal(k) + computePentagonal(j)) &&
                        isPentagonal(computePentagonal(k) - computePentagonal(j))) {
                    System.out.println(computePentagonal(k) + " - " + computePentagonal(j));
                    return computePentagonal(k) - computePentagonal(j);
                }
            }
        }
        
        return -1;
        
        
    }
    
    
    @Override
    public void run() {
        
        System.out.println(findPentagonalD());
        
    }
    
}
