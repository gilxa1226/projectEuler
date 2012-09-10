/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.Projects;

/**
 *
 * @author michael.j.haller
 */
public class Problem009 implements Problem {

    
    private boolean isTriplet(int a, int b, int c) {
        
        long la = (long) Math.pow(a, 2);
        long lb = (long) Math.pow(b, 2);
        long lc = (long) Math.pow(c, 2);
        
        return (la + lb) == lc;
    }
    
    private void findTriplet() {
        
        for ( int c = 3; ; c++ ) {
            for( int b = 2; b < c; b++) {
                for (int a = 1; a < b; a++) {
                    
                    if ( (a+b+c) == 1000) {
                        if ( isTriplet(a,b,c) ) {
                            System.out.println("a=" + a + "; b=" + b + "; c=" + c);
                            System.out.println("abc= " + (a*b*c));
                            return;
                        } 
                    }
                }
            }
        }
        
    }
    
    
    @Override
    public void run() {
        
        findTriplet();
    }
    
}
