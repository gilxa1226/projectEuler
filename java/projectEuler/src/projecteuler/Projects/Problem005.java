/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.Projects;

/**
 *
 * @author michael.j.haller
 */
public class Problem005 implements Problem {

    @Override
    public void run() {
        
        int theNumber = 0;
        boolean found = false;
        
        for ( int x = 21; ; x++) {
            for ( int y = 1; y <= 20; y++ ) {
                if ( x % y != 0 ) {
                    found = false;
                    break;
                } else {
                    theNumber = x;
                    found = true;
                }
            }
            
            if (found) {
                break;
            }
        }
        
        System.out.println(theNumber);
        
    }
    
}
