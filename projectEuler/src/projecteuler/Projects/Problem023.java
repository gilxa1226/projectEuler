/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.Projects;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author michael.j.haller
 */
public class Problem023 implements Problem {

    private int sumOfDivisorsOld(int number) {
        int sum = 0;
        
        for ( int x = 1; x < number; x++ ) {
            if ( number % x == 0 ) { sum += x; }
        }
        
        return sum;
    }
    
    private int sumOfDivisors(int number) {
        int prod=1;
        
        for(int k=2; k*k<=number; ++k) {
            int p=1;
            while(number%k==0) {
                p=p*k+1;
                number/=k;
            }
            prod*=p;
        }
        
        if(number>1) {
            prod*=1+number;
        }
            
        return prod;
    }
    
    private boolean isAbundant(int number) {
        return sumOfDivisors(number) > (number + number);
        //return sumOfDivisorsOld(number) > number;
    }
    
    @Override
    public void run() {
        List abundantNumbers = new ArrayList();
        List target = new ArrayList();
        long sum = 0;
        int temp;
        int cnt = 0;
               
        for ( int x = 1; x <= 28123; x++ ) {
            if ( isAbundant(x) ) {
                abundantNumbers.add(x);
            }
        }
        
        boolean abundant = false;
        int tmp;
        
        for ( int x = 1; x <= 20161; x++) {
            
            abundant = false;
            for(int y = 0; y < abundantNumbers.size(); y++ ) {
                tmp = (Integer)abundantNumbers.get(y);

                if ( tmp >= x ) { break; }
                
                temp = x - tmp;
                
                if ( isAbundant(temp) ) {
                    abundant = true;
                    break;
                }
            }
            
            if ( !abundant ) {
                cnt++;
                sum += x;
                target.add(x);
            }
        }
        
        System.out.println("Min abundant: " + abundantNumbers.get(0));
        System.out.println("Max abundant: " + abundantNumbers.get(abundantNumbers.size()-1));
        System.out.println("Abundant Numbers: " + abundantNumbers.size());
        System.out.println("Min target: " + target.get(0));
        System.out.println("Max target: " + target.get(target.size()-1));
        System.out.println("Count: " + cnt);
        System.out.println("Sum: " + sum);
      
    }
    
}
