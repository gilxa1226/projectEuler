/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.Projects;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author michael.j.haller
 */
public class Problem019 implements Problem {

    @Override
    public void run() {
        
        Calendar cal = new GregorianCalendar();
        int cnt = 0;
        
        for ( int x = 1901; x < 2001; x++ ) {
            for ( int y = 1; y <= 12; y++) {
                cal.set(x, y, 1);
                if ( cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                    cnt++;
                }
            }
        }
        
        System.out.println(cnt);
    }
    
}
