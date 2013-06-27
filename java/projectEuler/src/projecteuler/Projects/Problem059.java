/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.Projects;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author michael.j.haller
 */
public class Problem059 implements Problem {

    static String filename = "cipher1.txt";
    
    private List fileContents() {
        BufferedReader in = null;
        ArrayList<Integer> theFile = null;
        StringTokenizer strtok = null;
        try {
            theFile = new ArrayList<Integer>();
            in = new BufferedReader(new FileReader(filename));
            String tmp = in.readLine();
            
            while (!tmp.isEmpty()) {
                strtok = new StringTokenizer(tmp, ",");
                while (strtok.hasMoreTokens()) {
                    Integer temp = Integer.parseInt(strtok.nextToken());
                    theFile.add(temp);
                }
                tmp = in.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Problem059.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Problem059.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(Problem059.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return theFile;
        }
    }
    
    private int charToAscii(char c) {
        return (int)c;
    }
    
    private char asciiToChar(int a) {
        return (char)a;
    }
    
    private int runXor(int encChar, int encKey) {
        return encChar ^ encKey;
    }
    
    private Map<String,String> loadWordList(String file) {
        BufferedReader in = null;
        HashMap<String,String> contents = null;
        StringTokenizer strtok = null;
        try {
            contents = new HashMap<String,String>();
            in = new BufferedReader(new FileReader(file));
            String tmp = in.readLine();
            
            while (!tmp.isEmpty()) {
                strtok = new StringTokenizer(tmp, ",");
                while (strtok.hasMoreTokens()) {
                    contents.put(strtok.nextToken().toUpperCase(), "1");
                }
                tmp = in.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Problem059.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Problem059.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(Problem059.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return contents;
        }
    }
    
    private boolean checkWords(String toCheck, Map<String,String> wordList) {
        boolean foundWords = false;
        StringTokenizer strTok = new StringTokenizer(toCheck, " ");
        String temp; 
        
        while (strTok.hasMoreTokens()) {
            try {
               temp = strTok.nextToken();
               if ( wordList.containsKey(temp) ) {
                   foundWords = true;
               }
            } catch (Exception e) {
                // do nothing
            }
        }
        
        return foundWords;
    }
    
    @Override
    public void run() {
        String outFile = "decrypted1.txt";
        String wordList = "words.txt";
        List<Integer> contents = fileContents();
        StringBuilder decodedContents = null;
        //int[] encKeys = {103, 111, 100};
        int[] encKeys = { (int)'a', (int)'a', (int)'a' };
        int pos = 0;
        int sum = 0;
        int decodedValue = 0;
        
        Map<String,String> dictionary = loadWordList(wordList);

        for(int x = encKeys[0]; x <= (int)'z'; x++) {
            encKeys[0] = x;
            encKeys[1] = 'a';
            encKeys[2] = 'a';
            
            for(int y = encKeys[1]; y <= (int)'z'; y++) {
                encKeys[1] = y;
                encKeys[2] = 'a';
                
                for(int z = encKeys[2]; z <= (int) 'z'; z++) {
                    encKeys[2] = z;
                    
                    decodedContents = new StringBuilder();

                    pos = 0;
                    
                    for(Integer i: contents) {
                        decodedValue = runXor(i.intValue(), encKeys[pos]);
                        sum += decodedValue;
                        decodedContents.append(asciiToChar(decodedValue));
                        pos++;
                        if (pos > 2) pos = 0;
                    }

                    if ( checkWords(decodedContents.toString(), dictionary) ) {
                        System.out.println(sum);
                        System.out.println("");
                        System.out.println(decodedContents.toString());
                    }
                  
                }
            }
            
        }
        
        
        
    }
    
}
