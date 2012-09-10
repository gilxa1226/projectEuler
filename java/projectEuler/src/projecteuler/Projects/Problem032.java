package projecteuler.Projects;

import java.util.HashSet;
import java.util.Set;
import projecteuler.lib.commonMath;

/**
 *
 * @author Michael J. Haller
 * @version 1.0
 */
public class Problem032 implements Problem {

		
	@Override
	public void run() {
		
		int temp;
		int sum = 0;
		StringBuilder bigNum;
		Set<String> pandigital = new HashSet<String>();
		
		for ( int x = 2; x < 9999;  x++ ) {
			for ( int y = 2; y < 9999; y++) {
				bigNum = new StringBuilder();
				temp = x * y;
				
				bigNum.append(x).append(y).append(temp);
				
				if ( bigNum.toString().length() == 9 ) {
					if ( commonMath.isPandigital(bigNum.toString()) ) {
						if ( !pandigital.contains(Integer.toString(temp)))  {
							sum += temp;
							pandigital.add(Integer.toString(temp));
						}
					}
				}
				
			}
		}
		
		System.out.println("");
		System.out.println(sum);
	}
	
}
