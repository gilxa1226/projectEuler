/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package projecteuler.Projects;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author michael.j.haller
 */
public class Problem081 implements Problem {

    int[][] grid;
        
    private void zeroGrid(int[][] grid, int size) {
        for(int x = 0; x < size; x++) {
            for(int y = 0; y < size; y++) {
                grid[x][y] = 0;
            }
        }
    }
    
    private void zeroGrid(long[][] grid, int size) {
        for(int x = 0; x < size; x++) {
            for(int y = 0; y < size; y++) {
                grid[x][y] = 0;
            }
        }
    }
    
    private int readGrid(String filename) {
        int size = 0;
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            String tmp = in.readLine();
            StringTokenizer strtok;
            size = Integer.parseInt(tmp);
            int x = 0;
            int y = 0;
            grid = new int[size][size];
            zeroGrid(grid, size);
            
            tmp = in.readLine();
            while ( !tmp.isEmpty() ) {
                strtok = new StringTokenizer(tmp, ",");
                while (strtok.hasMoreTokens()) {
                    Integer temp = Integer.parseInt(strtok.nextToken());
                    grid[x][y] = temp.intValue();
                    y++;
                }
                y = 0;
                x++;
                tmp = in.readLine();
            }
          
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Problem067.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return size;
        }
    }
    
    private void printGrid(int[][] grid, int size) {
        for(int x = 0; x < size; x++) {
            for(int y = 0; y < size; y++) {
                System.out.print(grid[x][y] + "\t");
            }
            System.out.println("");
        }
    }
    
    private void printGrid(long[][] grid, int size) {
        for(int x = 0; x < size; x++) {
            for(int y = 0; y < size; y++) {
                System.out.print(grid[x][y] + "\t");
            }
            System.out.println("");
        }
    }
    
    private void computeSums(long[][] sums, int size) {
        long temp;
        
        for ( int x = 0; x < size; x++ ) {
            for ( int y = 0; y < size; y++) {
                if ( (x == 0) && (y == 0) ) {
                    sums[x][y] = grid[x][y];
                } else {
                    if ( y == 0 ) {
                        sums[x][y] = sums[x-1][y] + grid[x][y];
                    } else if ( x == 0) {
                        sums[x][y] = sums[x][y-1] + grid[x][y];
                    } else {
                        temp = Math.min(sums[x-1][y], sums[x][y-1]);
                        sums[x][y] = temp + grid[x][y];
                    }

                }
            }
        }
    }
    
    @Override
    public void run() {
        String filename = "problem_081_large.txt";
        int size = readGrid(filename);
        long[][] sums = new long[size][size];
        zeroGrid(sums, size);
        printGrid(grid, size);
        System.out.println("");
        
        computeSums(sums, size);
        printGrid(sums, size);
        
        System.out.println("Minimal path sum: " + sums[size-1][size-1]);
        
    }
    
}
