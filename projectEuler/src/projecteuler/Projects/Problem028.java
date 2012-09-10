/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.Projects;

/**
 *
 * @author michael.j.haller
 */
public class Problem028 implements Problem {

    private int sumSpiral(int num) {
        if ( num == 1 ) { return 1; }
        
        return sumSpiral(num-2) + (4 * num * num) - (6 * num) + 6;
    }
    
       
    @Override
    public void run() {
    
        int size = 1001;
        
        System.out.println(sumSpiral(size));
        
    }
    
    
    
}
