/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.Projects;

/**
 *
 * @author michael.j.haller
 */
public class Problem015 implements Problem {

    private void zeroGrid(long[][] grid, int size) {
        for(int x = 0; x < size; x++) {
            for(int y = 0; y < size; y++) {
                grid[x][y] = 0;
            }
        }
    }
    
    private void populateGrid(long [][] grid, int size) {
        
        for(int x = 0; x < size; x++) {
            for(int y = 0; y < size; y++) {
                if ( (x == 0) || (y == 0) ) {
                    grid[x][y] = 1;
                } else {
                    grid[x][y] = grid[x-1][y] + grid[x][y-1];
                } 
                
            }
        }
    }
    
    private int findMovesToLoc(long[][] grid, int x, int y) {
        
        if ( (x == 0) && (y == 0)) {
            return 1;
        }
        
        if ( (x == 0) && (y > 0) ) {
            return findMovesToLoc(grid, 0, y-1);
        } 
        
        if ( (y == 0) && (x > 0) ) {
            return findMovesToLoc(grid, x-1, y);
        }
        
        return findMovesToLoc(grid, x-1,y) + findMovesToLoc(grid, x,y-1);
    }
    
    private void printGrid(long[][] grid, int size) {
        for(int x = 0; x < size; x++) {
            for(int y = 0; y < size; y++) {
                System.out.print(grid[x][y] + "\t");
            }
            System.out.println("");
        }
    }
    
    @Override
    public void run() {
        
        int size = 21;
        long[][] grid = new long[size][size];
        
        zeroGrid(grid, size);
        populateGrid(grid, size);
        long moves = grid[size-1][size-1];
        
        //printGrid(grid,size);
        
        System.out.println(moves);
        
    }
    
}
