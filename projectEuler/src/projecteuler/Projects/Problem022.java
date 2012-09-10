/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.Projects;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import projecteuler.lib.commonMath;

/**
 *
 * @author michael.j.haller
 */
public class Problem022 implements Problem {

    
    
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
            Collections.sort(temp);
            return temp;
        }
    }
    
        
    @Override
    public void run() {
        long sumOfNames = 0;
        List<String> names = readFile("names.txt");
        
        for ( int x = 0; x < names.size(); x++ ) {
            int temp = commonMath.calcWord(names.get(x)) * (x+1);
            System.out.println(names.get(x) + ": " + temp);
            sumOfNames += temp;
        }
        
        System.out.println(sumOfNames);
    }
    
}
