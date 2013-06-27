/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.lib;

import java.math.BigInteger;

/**
 *
 * @author haller
 */
public class commonMath {
    
    public static boolean isPrime(long num) {

	if ( num == 1 ) {
		return false;
	}
	
        for ( int x = 2; x <= Math.sqrt(num); x++ ) {
            if ( num % x == 0 ) {
                return false;
            }
        }
        return true;
    }
    
    public static BigInteger factorial(int number) {
        BigInteger fact = new BigInteger("1");
        
        if (number == 0) {
            return BigInteger.ONE;
        }
        
        for(int x = number; x > 1; x--) {
            fact = fact.multiply(BigInteger.valueOf(x));
        }
        return fact;
    }
    
    public static boolean isPalindrome(int number) {
        
        String temp = Integer.toString(number);
        String rev = new StringBuilder(temp).reverse().toString();
        
        return temp.equals(rev);
    }
    
    public static boolean isPalindrome(long number) {
        
        String temp = Long.toString(number);
        String rev = new StringBuilder(temp).reverse().toString();
        
        return temp.equals(rev);
    }
    
    public static boolean isPalindrome(BigInteger number) {
        
        String temp = number.toString();
        String rev = new StringBuilder(temp).reverse().toString();
        BigInteger numRev = new BigInteger(rev);
        
        return number.equals(numRev);
    }
    
    public static int fib(int size) {
        
        BigInteger a = new BigInteger("1");
        BigInteger b = new BigInteger("1");
        BigInteger temp;
        int count = 1;
        
        while ( a.toString().length() < size) {
            temp = a;
            a = b;
            b = b.add(temp);
            count++;
        }
        
        return count;
    }
    
    public static int sumDigits(BigInteger num) {
        BigInteger temp = num;
        BigInteger one = new BigInteger("1");
        BigInteger ten = new BigInteger("10");
        BigInteger sum = new BigInteger("0");
        
        while ( temp.compareTo(one) > 0 ) {
            if ( temp.compareTo(new BigInteger("100")) == -1) {
            }
            
            if ( temp.compareTo(ten) == 0 ) {
                sum = sum.add(one);
            } else {
                sum = sum.add(temp.mod(ten));
            }
            
            
            temp = temp.divide(ten);
        }
        return sum.intValue();
    }

    public static boolean isEven(long number) {
        if ( number % 2 == 0 ) {
            return true;
        } else {
            return false;
        }
    }

    public static int calcWord(String name) {
        int sum = 0;
        
        for ( int x = 0; x < name.length(); x++ ) {
            sum += Character.getNumericValue(name.charAt(x)) - 9;
        }
        
        return sum;
    }
    
    public static boolean isPandigital(String theNum) {
		
		boolean isPan = true;
				
		for (int x = 0; x < 10; x++) {
			if ( theNum.indexOf(Integer.toString(x)) != theNum.lastIndexOf(Integer.toString(x)) ) {
				isPan = false;
			}
		}
		
		
		return isPan;
	}

        public static boolean isPandigital(String theNum, int panLen) {
		
		boolean isPan = true;
		
		if ( theNum.contains("0") ) {
			return false;
		}
		
		for (int x = 1; x <= panLen; x++) {
			if ( (theNum.indexOf(Integer.toString(x)) != theNum.lastIndexOf(Integer.toString(x))) 
                                || (theNum.indexOf(Integer.toString(x)) == -1) ) {
				isPan = false;
                                break;
			}
		}
		
		
		return isPan;
	}
    
        
        public static boolean sameDigits(int a, int b){

            String numA = Integer.toString(a);
            String numB = Integer.toString(b);
            int cnt = 0;

            if ( numA.length() != numB.length() ) {
                return false;
            }

            for ( int x = 0; x < numA.length(); x++) {
                if ( numA.contains(Character.toString(numB.charAt(x)))) {
                    cnt++;
                }
            }

            return cnt == numA.length();
        }
}
