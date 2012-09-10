/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.Projects;

/**
 *
 * @author michael.j.haller
 */
public class Problem017 implements Problem {

    String[] words = new String[1001];
    
    
    private String toWords(int number) {
        
        String num = Integer.toString(number);
        int temp;
        StringBuilder theWord = new StringBuilder();
        
        if ( num.length() == 2 ) {
            
            temp = Integer.parseInt(num.substring(0, 1)) * 10;
            theWord.append(words[temp]);
            temp = Integer.parseInt(num.substring(1));
            theWord.append(words[temp]);
            
        } else {
            
            if ( num.contains("00") ) {
                
                temp = Integer.parseInt(num.substring(0,1));
                theWord.append(words[temp]);
                theWord.append("hundred");
                
            } else {
            
                temp = Integer.parseInt(num.substring(0, 1)) * 100;
                theWord.append(words[temp]);
                theWord.append("and");
                temp = Integer.parseInt(num.substring(1));
                theWord.append(words[temp]);
            
            }

        }
        
        return theWord.toString();
    }
    
    private void clearArray() {
        for ( int x = 0; x < 1001; x++ ) {
            words[x] = "";
        }
    }
    
    private void init() {
        
        clearArray();
        
        words[1] = "one";
        words[2] = "two";
        words[3] = "three";
        words[4] = "four";
        words[5] = "five";
        words[6] = "six";
        words[7] = "seven";
        words[8] = "eight";
        words[9] = "nine";
        words[10] = "ten";
        words[11] = "eleven";
        words[12] = "twelve";
        words[13] = "thirteen";
        words[14] = "fourteen";
        words[15] = "fifteen";
        words[16] = "sixteen";
        words[17] = "seventeen";
        words[18] = "eighteen";
        words[19] = "nineteen";
        words[20] = "twenty";
        words[30] = "thirty";
        words[40] = "fourty";
        words[50] = "fifty";
        words[60] = "sixty";
        words[70] = "seventy";
        words[80] = "eighty";
        words[90] = "ninty";
        words[1000] = "onethousand";
                
        for ( int x = 21; x < 1000; x++ ) {
            if ( words[x].isEmpty() ) {
                words[x] = toWords(x);
            }
        }       
              
        
        
    }
    
    @Override
    public void run() {
        
        long sum = 0;
        
        init();
        
        for ( int x = 1; x <= 1000; x++ ) {
            sum += words[x].length();
        }
        
        System.out.println(sum);
        
    }
    
}
