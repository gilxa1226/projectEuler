/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
public class Problem067 implements Problem {

    int[][] triangle;
    
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
    
    private int readTriangle(String filename) {
        int size = 0;
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            String tmp = in.readLine();
            StringTokenizer strtok;
            size = Integer.parseInt(tmp);
            int x = 0;
            int y = 0;
            triangle = new int[size][size];
            zeroGrid(triangle, size);
            
            tmp = in.readLine();
            while ( !tmp.isEmpty() ) {
                strtok = new StringTokenizer(tmp, " ");
                while (strtok.hasMoreTokens()) {
                    Integer temp = Integer.parseInt(strtok.nextToken());
                    triangle[x][y] = temp.intValue();
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
                    sums[x][y] = triangle[x][y];
                } else {
                    if ( x == 0 ) {
                      break;  
                    } if (y == 0) {
                        temp = Math.max(sums[x-1][y], sums[x-1][y+1]);
                        sums[x][y] = triangle[x][y] + temp;
                    } else if ( y == (size-1)) {
                        temp = Math.max(sums[x-1][y], sums[x-1][y-1]);
                        sums[x][y] = triangle[x][y] + temp;
                    } else if ( (y > 0 && (y < (size-1)))) {
                        temp = Math.max(sums[x-1][y], sums[x-1][y-1]);
                        temp = Math.max(temp, sums[x][y+1]);
                        sums[x][y] = triangle[x][y] + temp;
                    }
                }
            }
        }
        
    }
    
    
    @Override
    public void run() {
        
        String filename = "triangle.txt";
        int size = readTriangle(filename);
        long[][] sums = new long[size][size];
        zeroGrid(sums, size);
        
        computeSums(sums, size);
        long maxSize = -1;
        
        for(int x = 0; x < size; x++) {
            if ( sums[size-1][x] > maxSize ) { maxSize = sums[size-1][x];}
        }
        
        System.out.println(maxSize);
        
        //printGrid(triangle, size);
        //System.out.println("");
        //printGrid(sums, size);
    }
    
}
