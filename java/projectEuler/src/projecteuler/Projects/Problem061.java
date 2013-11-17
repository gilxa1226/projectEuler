/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteuler.Projects;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haller
 */
public class Problem061 implements Problem {

    private List<List> numbers;
    private int[] solution;
    
    public List<Integer> generateNumbers(int sides) {
        
        List<Integer> temp = new ArrayList<Integer>();
        int number = 0;
        int x = 0;
        
        while (number < 10000) {
            x++;
            switch(sides) {
                case 3:
                   number = x*(x+1)/2;break;
                case 4:
                   number = x*x;break;
                case 5:
                   number = x*(3*x-1)/2;break;
                case 6:
                   number = x*(2*x-1);break;
                case 7:
                   number = x*(5*x-3)/2;break;
                case 8:
                   number = x*(3*x-2);break;
            }
            
            if (number > 999) {
                temp.add(number);
            }
        }
        
        return temp;
    }
    
    private boolean findNext(int last, int length) {
        
        for (int i = 0; i < solution.length; i++) {
            if (solution[i] != 0) continue;
            
            for (int j = 0; j < numbers.get(i).size(); j++) {
                boolean unique = true;
                for(int k = 0; k < solution.length; k++){
                    if ((Integer)numbers.get(i).get(j) == solution[k]) {
                        unique = false;
                        break;
                    }
                }
 
            if ( unique && (Integer)numbers.get(i).get(j) / 100 == solution[last] % 100) {
                solution[i] = (Integer)numbers.get(i).get(j);
                if (length == 5) {
                    if (solution[5] / 100 == solution[i] % 100)
                        return true;
                }
                if (findNext(i, length + 1)) return true;
            }
        }
        solution[i] = 0;
    }
    return false;
        
        
    }
        
    @Override
    public void run() {
        
        numbers = new ArrayList<List>();
        solution = new int[6];
        int sum = 0;
        
        for(int x = 3; x <= 8; x++) {
            numbers.add(generateNumbers(x));
        }
        
        for (int i = 0; i < numbers.get(5).size(); i++) {
            solution[5] = (Integer)numbers.get(5).get(i);
            if(findNext(5, 1)) break;
        }
        
        for(int n : solution) {
            System.out.print(n + ", ");
            sum += n;
        }
        
        System.out.println("");
        System.out.println("Sum = " + sum);
    }

   
    
}
