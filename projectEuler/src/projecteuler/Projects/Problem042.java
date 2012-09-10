/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.Projects;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import projecteuler.lib.commonMath;

/**
 *
 * @author michael.j.haller
 */
public class Problem042 implements Problem {

    private List<String> readFile(String Filename) {
        List<String> temp = new ArrayList<String>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(Filename));
            String tmp = in.readLine();
            StringTokenizer strtok = new StringTokenizer(tmp, ",");
            
            while (strtok.hasMoreTokens()) {
                tmp = strtok.nextToken();
                temp.add(tmp.substring(1, tmp.length()-1));
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Problem022.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return temp;
        }
    }
    
    private boolean isTriangle(int number) {
        int x = 1;
        int t = 1;
        boolean tri = false;
        
        do {
            x = (int)(.5 * t * ( t + 1 ));
            if ( x == number ) { tri = true; break; }
            t++;
        } while ( x < number );
        
        return tri;
    }
   
    
    @Override
    public void run() {
        
        List<String> words = readFile("words.txt");
        int cnt = 0;
        
        for ( int x = 0; x < words.size(); x++ ) {
            if ( isTriangle(commonMath.calcWord(words.get(x)))) {
                cnt++;
            }
        }
                
        System.out.println(cnt);
    }
    
}
