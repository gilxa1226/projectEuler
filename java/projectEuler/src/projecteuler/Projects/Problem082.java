/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package projecteuler.Projects;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author michael.j.haller
 */
public class Problem082 implements Problem {

    int[][] grid;
    int MAX = Integer.MAX_VALUE / 2;
        
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
                
        for ( int i = 0; i < size; i++ ) {
            Arrays.fill(sums[i], MAX);
        }
        
        for ( int i = 0; i < size; i++ ) {
            sums[i][0] = grid[i][0];
        }
        
        for ( int x = 0; x < size; x++ ) {
            for ( int i = 0; i < size; i++ ) {
                for ( int y = 0; y < size; y++ ) {
                    long dist = getValue(sums, x, y);
                    dist = Math.min(grid[y][x] + getValue(sums, x - 1, y), dist);
                    dist = Math.min(grid[y][x] + getValue(sums, x, y -1), dist);
                    dist = Math.min(grid[y][x] + getValue(sums, x, y + 1), dist);
                    sums[y][x] = dist;
                }
            }
        }
        
    }
    
    private long getValue(long[][] grid, int x, int y) {
        if ( y < 0 || y >= grid.length || x < 0 || x >= grid[y].length) {
            return MAX;
        } else {
            return grid[y][x];
        }
    }
    
    @Override
    public void run() {
        String filename = "problem_082_large.txt";
        int size = readGrid(filename);
        long[][] sums = new long[size][size];
        zeroGrid(sums, size);
        printGrid(grid, size);
        System.out.println("");
        
        computeSums(sums, size);
        printGrid(sums, size);
        
        long min = MAX;
        
        for ( int x = 0; x < size; x++ ) {
            min = Math.min(sums[x][size-1], min);
        }
        
        System.out.println("Min distance: " + min);
    }
    
}
