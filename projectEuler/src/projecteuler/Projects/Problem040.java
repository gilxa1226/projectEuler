/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.Projects;

/**
 *
 * @author michael.j.haller
 */
public class Problem040 implements Problem {

    private String buildString(int size) {
        
        StringBuilder temp = new StringBuilder();
        temp.append(0);
        int x = 1;
        
        
        while ( temp.toString().length() <= size ) {
            temp.append(x);
            x++;
        }
        
        return temp.toString();
        
    }
    
    @Override
    public void run() {
        String number = buildString(1000000);
        int answer = Integer.parseInt(Character.toString(number.charAt(1))) *
                Integer.parseInt(Character.toString(number.charAt(10))) *
                Integer.parseInt(Character.toString(number.charAt(100))) *
                Integer.parseInt(Character.toString(number.charAt(1000))) *
                Integer.parseInt(Character.toString(number.charAt(10000))) *
                Integer.parseInt(Character.toString(number.charAt(100000))) *
                Integer.parseInt(Character.toString(number.charAt(1000000)));
        
        System.out.println(number);
        System.out.println(number.charAt(1));
        System.out.println(number.charAt(10));
        System.out.println(number.charAt(100));
        System.out.println(number.charAt(1000));
        System.out.println(number.charAt(10000));
        System.out.println(number.charAt(100000));
        System.out.println(number.charAt(1000000));
        System.out.println(answer);
    }
    
}
