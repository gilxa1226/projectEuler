/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteuler.Projects;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author michael.j.haller
 */
public class Problem054 implements Problem {

    
    class Card {
        private int rank;
        private char suit;

        public int getRank() {
            return rank;
        }

        public void setRank(char rank) {
            switch(rank) {
                case '1': this.rank = 1; break;
                case '2': this.rank = 2; break;
                case '3': this.rank = 3; break;
                case '4': this.rank = 4; break;
                case '5': this.rank = 5; break;
                case '6': this.rank = 6; break;
                case '7': this.rank = 7; break;
                case '8': this.rank = 8; break;
                case '9': this.rank = 9; break;
                case 'T': this.rank = 10; break;
                case 'J': this.rank = 11; break;
                case 'Q': this.rank = 12; break;
                case 'K': this.rank = 13; break;
                case 'A': this.rank = 14; break;
            }
        }

        public char getSuit() {
            return suit;
        }

        public void setSuit(char suit) {
            this.suit = suit;
        }
    }
    
    
    private final String[] player1Hand1 = {"2H", "2D", "4C", "4D", "4S"};
    private final String[] player2Hand1 = {"3C", "3D", "3S", "9S", "9D"};
    private final String[] testHand = {"1H", "2D", "1C", "2S", "2D"};

    private final int ONE_PAIR = 15;
    private final int TWO_PAIRS = 16;
    private final int THREE_OF_A_KIND = 17;
    private final int STRAIGHT = 18;
    private final int FLUSH = 19;
    private final int FULL_HOUSE = 20;
    private final int FOUR_OF_A_KIND = 21;
    private final int STRAIGHT_FLUSH = 22;
    private final int ROYAL_FLUSH = 23;
        
    private int[] getRanksArray(Card[] cards) {
        int[] ranks = new int[5];
        int idx = 0;
        
        for (Card c : cards) {
            ranks[idx] = c.getRank();
            idx++;
        }
        
        return ranks;
    }
    
    private Map<Integer, Integer> getRanksMap(int[] cards) {
        Map <Integer, Integer> cardMap = new HashMap<Integer, Integer>();
        
        for (int x : cards) {
            if ( cardMap.containsKey(x)) {
                cardMap.put(x, cardMap.get(x) + 1);
            } else {
                cardMap.put(x, 1);
            }
        }
        
        return cardMap;
    }
    
    private boolean isFlush(Card[] cards) {
        return (cards[0].getSuit() == cards[1].getSuit()) && (cards[2].getSuit() == cards[3].getSuit())  
                && (cards[0].getSuit() == cards[4].getSuit()) && (cards[2].getSuit() == cards[4].getSuit());
    }
    
    private boolean isRoyalFlush(Card[] cards) {
        
        if ( isFlush(cards) ) {
            for (Card x : cards) {
                if ( x.rank < 10 ) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
    
    private boolean isStraight(Card[] cards) {
        
        int[] ranks = getRanksArray(cards);
                
        Arrays.sort(ranks);
        
        int firstVal = ranks[0];
        for ( int x = 1; x < ranks.length; x++) {
            if (firstVal + x != ranks[x]) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isStraightFlush(Card[] cards) {
        return isFlush(cards) && isStraight(cards);
    }
    
    private int highCard(Card[] cards) {
        int[] ranks = getRanksArray(cards);
                
        Arrays.sort(ranks);
        
        return ranks[ranks.length - 1];
    }
    
    private boolean isFourOfAKind(Card[] cards) {
        
        int[] ranks = getRanksArray(cards);
        Map <Integer, Integer> counting;
        counting = new HashMap<Integer, Integer>();
        
        for (int x : ranks) {
            if ( counting.containsKey(x)) {
                counting.put(x, counting.get(x) + 1);
            } else {
                counting.put(x, 1);
            }
        }
        
        if (counting.keySet().size() > 2) {
            return false;
        } else {
            return counting.values().contains(Integer.valueOf(4));
        }
    }
    
    private boolean isThreeOfAKind(Card[] cards) {
        int[] ranks = getRanksArray(cards);
        Map <Integer, Integer> counting;
        counting = new HashMap<Integer, Integer>();
        
        for (int x : ranks) {
            if ( counting.containsKey(x)) {
                counting.put(x, counting.get(x) + 1);
            } else {
                counting.put(x, 1);
            }
        }
        
        if (counting.keySet().size() > 3) {
            return false;
        } else {
            return counting.values().contains(Integer.valueOf(3));
        }
    }
    
    private boolean isTwoPairs(Card[] cards) {
        int[] ranks = getRanksArray(cards);
        Map <Integer, Integer> counting;
        counting = new HashMap<Integer, Integer>();
        int numOfPairs = 0;
        
        for (int x : ranks) {
            if ( counting.containsKey(x)) {
                counting.put(x, counting.get(x) + 1);
            } else {
                counting.put(x, 1);
            }
        }
        
        for (Integer key : counting.keySet()) {
            if (counting.get(key) == 2) {
                numOfPairs++;
            }
        }
        
        return (numOfPairs == 2);
    }
    
    private boolean isPair(Card[] cards) {
        int[] ranks = getRanksArray(cards);
        Map <Integer, Integer> counting;
        counting = new HashMap<Integer, Integer>();
        int numOfPairs = 0;
        
        for (int x : ranks) {
            if ( counting.containsKey(x)) {
                counting.put(x, counting.get(x) + 1);
            } else {
                counting.put(x, 1);
            }
        }
        
        for (Integer key : counting.keySet()) {
            if (counting.get(key) == 2) {
                numOfPairs++;
            }
        }
        
        return (numOfPairs == 1);
    }
    
    private boolean isFullHouse(Card[] cards) { 
        return ( isThreeOfAKind(cards) && isPair(cards));
    }
    
    private int rankBestHand(Card[] cards) {
        
        if (isRoyalFlush(cards)) {
            return ROYAL_FLUSH;
        }
        
        if (isStraightFlush(cards))
        {
            return STRAIGHT_FLUSH;
        }
        
        if (isFourOfAKind(cards)) {
            return FOUR_OF_A_KIND;
        }
         
        if (isFullHouse(cards)) {
            return FULL_HOUSE;
        }
        
        if (isFlush(cards)) {
            return FLUSH;
        }
        
        if (isStraight(cards)) {
            return STRAIGHT;
        }
        
        if (isThreeOfAKind(cards)) {
            return THREE_OF_A_KIND;
        }
        
        if (isTwoPairs(cards)) {
            return TWO_PAIRS;
        }
        
        if (isPair(cards)) {
            return ONE_PAIR;
        }
          
        return highCard(cards);
    }
    
    private int compareTwoPairs(Card[] player1, Card[] player2) {
        Map <Integer, Integer> player1Cnt = getRanksMap(getRanksArray(player1));
        Map <Integer, Integer> player2Cnt = getRanksMap(getRanksArray(player2));
        int[] p1 = new int[2];
        int[] p2 = new int[2];
        int idx = 0;
        
        for ( Integer p : player1Cnt.keySet()) {
            if ( player1Cnt.get(p) == 2 ) {
                p1[idx] = p;
                idx++;
            } 
        }
        
        idx = 0;
        for ( Integer p : player2Cnt.keySet()) {
            if ( player2Cnt.get(p) == 2 ) {
                p2[idx] = p;
                idx++;
            } 
        }
        
        if ( p1[0] > p2[0]) {
            return 1;
        } else  if ( p1[0] < p2[0] ) {
            return -1;
        } else {
            if ( p1[1] > p2[1] ) {
                return 1;
            } else if (p1[1] < p2[1]) {
                return -1;
            } else {
                return compareSingles(player1, player2);
            }
         }
        
    }
    
    private int compareSingleSets(Card[] player1, Card[] player2, int numOfCards) {
        Map <Integer, Integer> player1Cnt = getRanksMap(getRanksArray(player1));
        Map <Integer, Integer> player2Cnt = getRanksMap(getRanksArray(player2));
        int p1rank = 0;
        int p2rank = 0;
        
        for ( Integer p : player1Cnt.keySet()) {
            if ( player1Cnt.get(p) == numOfCards ) {
                p1rank = p;
            } 
        }
        
        for ( Integer p : player2Cnt.keySet()) {
            if ( player2Cnt.get(p) == numOfCards ) {
                p2rank = p;
            } 
        }
               
        if ( Integer.compare(p1rank, p2rank) == 0 ) {
            return compareSingles(player1, player2);
        } else {
            return Integer.compare(p1rank, p2rank);
        }
        
    }
    
    private int compareStraights(Card[] player1, Card[] player2) {
        int[] p1 = getRanksArray(player1);
        int[] p2 = getRanksArray(player2);
        
        Arrays.sort(p1);
        Arrays.sort(p2);
        
        return Integer.compare(p1[p1.length-1], p2[p2.length-1]);
    }
    
    private int compareSingles(Card[] player1, Card[] player2) {
        int[] p1 = getRanksArray(player1);
        int[] p2 = getRanksArray(player2);
        
        Arrays.sort(p1);
        Arrays.sort(p2);
        
        for ( int x = p1.length-1; x >= 0; x-- ) {
            if ( Integer.compare(p1[x], p2[x]) != 0 ) {
                return Integer.compare(p1[x], p2[x]);
            } 
        }
        
        return 0;
    }
    
    private int compareFullHouse(Card[] player1, Card[] player2) {
        Map <Integer, Integer> player1Cnt = getRanksMap(getRanksArray(player1));
        Map <Integer, Integer> player2Cnt = getRanksMap(getRanksArray(player2));
        int p1rankThree = 0;
        int p1rankTwo = 0;
        int p2rankThree = 0;
        int p2rankTwo = 0;
        
        for ( Integer p : player1Cnt.keySet()) {
            if ( player1Cnt.get(p) == 3 ) {
                p1rankThree = p;
            } else if ( player1Cnt.get(p) == 2 ) {
                p1rankTwo = p;
            }
        }
        
        for ( Integer p : player2Cnt.keySet()) {
            if ( player2Cnt.get(p) == 3 ) {
                p2rankThree = p;
            } else if ( player2Cnt.get(p) == 2 ) {
                p2rankTwo = p;
            } 
        }
        
        if ( Integer.compare(p1rankThree, p2rankThree) != 0 ) {
            return Integer.compare(p1rankThree, p2rankThree);
        } else {
            return Integer.compare(p1rankTwo, p2rankTwo);
        }
                
    }
    
    private int compareHands(Card[] player1, Card[] player2, int ranking) {
        
        switch (ranking) {
            case ONE_PAIR: return compareSingleSets(player1, player2, 2);
            case TWO_PAIRS: return compareTwoPairs(player1, player2);
            case THREE_OF_A_KIND: return compareSingleSets(player1, player2, 3);
            case STRAIGHT: return compareStraights(player1, player2);
            case FLUSH: return compareSingles(player1, player2);
            case FULL_HOUSE: return compareFullHouse(player1, player2);
            case FOUR_OF_A_KIND: return compareSingleSets(player1, player2, 4);
            case STRAIGHT_FLUSH: return compareStraights(player1, player2);
            case ROYAL_FLUSH: return 0;  
            default: return compareSingles(player1, player2);
        }

    }
    
    
    private Card[] parseStringArray(String[] cardStringArray) {

        Card[] tmp = new Card[5];
        int idx = 0;
        
        for (String c : cardStringArray) {
            tmp[idx] = new Card();
            tmp[idx].setRank(c.charAt(0));
            tmp[idx].setSuit(c.charAt(1));
            idx++;
        }
        
        return tmp;
    }
    
    @Override
    public void run() {
        BufferedReader in = null;
        int player1wins = 0;
        try {
            String filename = "poker.txt";
            in = new BufferedReader(new FileReader(filename));
            String tmp = in.readLine();
            StringTokenizer strtok;
            String[] player1Hand;
            String[] player2Hand;
            
            while ( !tmp.isEmpty() ) {
                strtok = new StringTokenizer(tmp, " ");
                player1Hand = new String[5];
                player2Hand = new String[5];
                
                player1Hand[0] = strtok.nextToken();
                player1Hand[1] = strtok.nextToken();
                player1Hand[2] = strtok.nextToken();
                player1Hand[3] = strtok.nextToken();
                player1Hand[4] = strtok.nextToken();
                player2Hand[0] = strtok.nextToken();
                player2Hand[1] = strtok.nextToken();
                player2Hand[2] = strtok.nextToken();
                player2Hand[3] = strtok.nextToken();
                player2Hand[4] = strtok.nextToken();
                
                Card[] player1 = parseStringArray(player1Hand);
                Card[] player2 = parseStringArray(player2Hand);
                int player1Rank = rankBestHand(player1);
                int player2Rank = rankBestHand(player2);

                if ( player1Rank == player2Rank ) {

                    int comp = compareHands(player1, player2, player1Rank);

                    if ( comp > 0 ) {
                        System.out.println("player1 wins!");
                        player1wins++;
                    } else if ( comp < 0 ) {
                        System.out.println("player2 wins!");
                    } else {
                        System.out.println("tie!");
                    }

                } else {
                    if ( player1Rank > player2Rank ) {
                        System.out.println("player1 wins!");
                        player1wins++;
                    } else if ( player1Rank < player2Rank ) {
                        System.out.println("player2 wins!");
                    } else {
                        System.out.println("tie!");
                    }
                }
                tmp = in.readLine();
                if ( tmp == null ) { tmp = ""; }
            }
            
            System.out.println("Total Player 1 Wins: " + player1wins);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Problem054.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Problem054.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(Problem054.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
