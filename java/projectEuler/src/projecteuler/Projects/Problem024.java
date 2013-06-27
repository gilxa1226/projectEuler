/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.Projects;

/**
 *
 * @author michael.j.haller
 */
public class Problem024 implements Problem {

    private int cnt = 1;
    private String value;
    private int perm = 1000000;
    
    private void permuteString(String beginString, String endString){
        if ( endString.length() <= 1 ) {
            //System.out.println(beginString + endString);
            if ( cnt == perm ) { 
                value = beginString + endString;
                cnt++;
            } else { 
                cnt++; 
            }
        } else {
            for ( int x = 0; x < endString.length(); x++ ) {
                try {
                    String newString = endString.substring(0, x) + endString.substring(x + 1);
                    
                    permuteString(beginString + endString.charAt(x), newString);
                } catch (StringIndexOutOfBoundsException ex) {
                    System.out.println("exception");
                }
            }
        }
    }
    
    
    @Override
    public void run() {
        
        permuteString("", "0123456789");
        //permuteString("", "012");
        
        System.out.println(value);
    }
    
    
    
}
