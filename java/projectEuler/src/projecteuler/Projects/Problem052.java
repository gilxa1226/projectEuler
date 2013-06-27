/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.Projects;

/**
 *
 * @author michael.j.haller
 */
public class Problem052 implements Problem {

    private boolean sameDigits(int a, int b){
        
        String numA = Integer.toString(a);
        String numB = Integer.toString(b);
        int cnt = 0;
        
        if ( numA.length() != numB.length() ) {
            return false;
        }
        
        for ( int x = 0; x < numA.length(); x++) {
            if ( numA.contains(Character.toString(numB.charAt(x)))) {
                cnt++;
            }
        }
        
        return cnt == numA.length();
    }
    
    @Override
    public void run() {
        
        int x2;
        int x3;
        int x4;
        int x5;
        int x6;
        
        for ( int x = 1; x < Integer.MAX_VALUE; x++ ) {
            x2 = x * 2;
            x3 = x * 3;
            x4 = x * 4;
            x5 = x * 5;
            x6 = x * 6;
            
            if ( sameDigits(x2, x3) && sameDigits(x4,x5) && sameDigits(x2, x6) && sameDigits(x2, x4) ) {
                System.out.println(x);
                break;
            }
            
        }
        
        
    }
    
}
