/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.Projects;

/**
 *
 * @author michael.j.haller
 */
public class Problem251 implements Problem {

    private boolean isCardano(double a, double b, double c) {
        
        //double temp = b * Math.sqrt(c);
        //double testNum1 = Math.cbrt(a + temp);
        //double testNum2 = Math.cbrt(a - temp);
        //double sum = testNum1 + testNum2;
        
        double temp = 8*(Math.pow(a, 3)) + 15 * (Math.pow(a, 2)) - 27 * (Math.pow(b, 2*c)) + 6*a -1;
        
        return (temp == 0);
    }
    
    @Override
    public void run() {
        
        int counter = 0;
        int size = 1000;
        
        for ( double a = 0; a <= 1000; a++ ) {
            for ( double b = 0; b <= 1000; b++ ) {
                for ( double c = 0; c <= 1000; c++ ) {
                    if ( (a + b + c) <= size ) 
                    {
                        if (isCardano(a,b,c)) {
                            counter++;
                            //System.out.println(counter + ": (" + a + "," + b + "," + c + ")");
                        }
                    }
                }
            }
        }
        
                
        System.out.println(counter);
        
    }
    
    
    
}
