package projecteuler.Projects;

import projecteuler.lib.commonMath;

/**
 *
 * @author Michael J. Haller
 * @version 1.0
 */
public class Problem037 implements Problem {

	private boolean checkRight(long number) {
		
		String theNum = Long.toString(number);
		boolean isPrime = true;
		
		for ( int x = theNum.length()-1; x > 0 ; x-- ) {
			if ( !commonMath.isPrime(Long.parseLong(theNum.substring(0, x))) ) {
				isPrime = false;
			}
		}
		
		return isPrime;
	}
	
	private boolean checkLeft(long number) {
		
		String theNum = Long.toString(number);
		boolean isPrime = true;
		
		for ( int x = 0; x < theNum.length(); x++ ) {
			if ( !commonMath.isPrime(Long.parseLong(theNum.substring(x))) ) {
				isPrime = false;
			}
		}
		
		return isPrime;
	}
		
	@Override
	public void run() {
		
		int truncCount = 0;
		long sum = 0;
		
		for ( long x = 13; x < Long.MAX_VALUE; x++ ) {
			if ( commonMath.isPrime(x)) {
				if ( checkRight(x) && checkLeft(x) ) {
					sum += x;
					System.out.println(x);
					truncCount++;
				}
				
				if ( truncCount == 11 ) {
					break;
				}
			}
		}
		
		System.out.println(sum);
		
		
	}
	
}
