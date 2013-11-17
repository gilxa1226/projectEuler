/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteuler.Projects;

import java.util.Arrays;

/**
 *
 * @author michael.j.haller
 */
public class Problem058 implements Problem {

    private static int n = 900000000;
    private boolean[] primesTable = new boolean[n+1];    
    
    private void fillSeive() {
        Arrays.fill(primesTable, true);
        primesTable[2] = true;
        primesTable[3] = true;
        //int fillSize = (int)Math.sqrt(n);
        for (int i = 4; i < n; i += 2) primesTable[i] = false;
        for (int i = 3; i < n; i += 2) {
            for (int j = i+i; j < n; j += i) {
                primesTable[j] = false;
            }
        }
    }
    
    private int[][] generateSpiral(int size) {
        
        int a[][],r,c,k1=2,k2=3,l,p=0,co=0,re=0;
        a = new int[size][size];
        r = size / 2;
        c = r - 1;
        if (size % 2 == 0) {
            System.out.println("wrong entry for spiral path");
            System.exit(0);
        }
        while (p != (int) Math.pow(size, 2)) {
            //for right
            if (co != 0) {
                re = 1;
            }
            for (int ri = 1; ri <= k1 - re; ri++) {
                p++;
                c++;
                if (c == size) {
                    break;
                }
                a[r][c] = p;
            }
            if (c == size) {
                break;
            }
            //for down
            for (int dw = 1; dw <= k1 - 1; dw++) {
                p++;
                r++;
                a[r][c] = p;
            }
            //for left
            for (int le = 1; le <= k2 - 1; le++) {
                p++;
                c--;
                a[r][c] = p;
            }
            //for up
            for (int up = 1; up <= k2 - 1; up++) {
                p++;
                r--;
                a[r][c] = p;
            }
            k1 = k1 + 2;
            k2 = k2 + 2;
            co++;
        }
        
        return a;   
        
    }
    
    private void printSpiral(int[][] spiral) {
        
        int size = spiral.length;
        
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                System.out.print("\t" + spiral[x][y]);
            }
            System.out.println();
            System.out.println();
        }
    }
    
    private int countPrimes(int[][] spiral, int x, int y, int xFactor, int yFactor, int endX, int endY) {
        int numOfPrimes = 0;
        x += xFactor;
        y += yFactor;
        while ( (x != endX) && (y != endY) ) {
            
            if (primesTable[spiral[x][y]]) {
                numOfPrimes ++;
            }
            
            x += xFactor;
            y += yFactor;
        }
        
        return numOfPrimes;
    }
    
    private int countPrimesOnDiagonals(int [][] spiral) {
        int size = spiral.length;
        int numOfPrimes = 0;
        int centerX = (size-1)/2;
        int centerY = (size-1)/2;
        int xFactor = -1;
        int yFactor = -1;
        int x = centerX;
        int y = centerY;
              
        // Count up and left
        numOfPrimes += countPrimes(spiral, centerX, centerY, -1, -1, -1, -1);
        
        // Count up and right
        numOfPrimes += countPrimes(spiral, centerX, centerY, 1, -1, spiral.length, -1);
        
        // Count down and left
        numOfPrimes += countPrimes(spiral, centerX, centerY, -1, 1, -1, spiral.length);
        
        // Count down and right
        numOfPrimes += countPrimes(spiral, centerX, centerY, 1, 1, spiral.length, spiral.length);
        
        return numOfPrimes;
    }
    
    
    @Override
    public void run() {
        
        int spiralSize = 26241;
        int numOnDiagonal = (spiralSize * 2) - 1;
        int numberOfPrimes;
        double percentPrime;
        
        fillSeive();
        System.out.println("Seive Complete");
        
        int[][] spiralGrid = generateSpiral(spiralSize);
        
        //printSpiral(spiralGrid);
        numberOfPrimes = countPrimesOnDiagonals(spiralGrid);
        percentPrime = ((double)numberOfPrimes / (double)numOnDiagonal) * 100;
        System.out.println("Side Length: " + spiralSize);
        System.out.println("Number Of Primes = " + numberOfPrimes);
        System.out.println("Percent Prime = " + percentPrime + "%");
        System.out.println("========================================================");
        
//        while (percentPrime > 10.0) {
//            spiralSize += 2;
//            numOnDiagonal = (spiralSize * 2) - 1;
//            spiralGrid = null;
//            spiralGrid = generateSpiral(spiralSize);
//            numberOfPrimes = countPrimesOnDiagonals(spiralGrid);
//            percentPrime = ((double)numberOfPrimes / (double)numOnDiagonal) * 100;
//                        
//            System.out.println("Side Length: " + spiralSize);
//            System.out.println("Number Of Primes = " + numberOfPrimes);
//            System.out.println("Percent Prime = " + percentPrime + "%");
//            System.out.println("========================================================");
//            
//        }
    }
    
}
 