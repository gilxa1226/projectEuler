/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.Projects;

/**
 *
 * @author michael.j.haller
 */
public class Problem043 implements Problem {

    private int cnt = 1;
    private long sum = 0;
    
    
    private void permuteString(String beginString, String endString){
        if ( endString.length() <= 1 ) {
            //System.out.println(beginString + endString);
            if ( isSubStrDiv(Long.parseLong(beginString + endString))) {
                sum += Long.parseLong(beginString + endString);
            }
            cnt++;
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
    
    private boolean isSubStrDiv(long number) {
        
        String theNum = Long.toString(number);
        
        if ( (Integer.parseInt(theNum.substring(1, 4)) % 2) != 0 ) {
            return false;
        }
        
        if ( (Integer.parseInt(theNum.substring(2, 5)) % 3) != 0 ) {
            return false;
        }
        
        if ( (Integer.parseInt(theNum.substring(3, 6)) % 5) != 0 ) {
            return false;
        }
        
        if ( (Integer.parseInt(theNum.substring(4, 7)) % 7) != 0 ) {
            return false;
        }
        
        if ( (Integer.parseInt(theNum.substring(5, 8)) % 11) != 0 ) {
            return false;
        }
        
        if ( (Integer.parseInt(theNum.substring(6, 9)) % 13) != 0 ) {
            return false;
        }
        
        if ( (Integer.parseInt(theNum.substring(7, 10)) % 17) != 0 ) {
            return false;
        }
        
        return true;
        
    }
    
    
    @Override
    public void run() {
        
        permuteString("", "0123456789");
        
        System.out.println(sum);
    }
    
}
