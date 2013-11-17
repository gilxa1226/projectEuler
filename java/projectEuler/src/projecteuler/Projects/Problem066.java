package projecteuler.Projects;

import java.math.BigInteger;

/**
 *
 * @author michael.j.haller
 */
public class Problem066 implements Problem {

    private BigInteger pellsEquation(BigInteger num, int D, BigInteger den) {
        
        BigInteger result = num.pow(2);
        result = result.subtract(den.pow(2).multiply(BigInteger.valueOf(D)));
        return result;
    }
    
    @Override
    public void run() {
        int result = 0;
        BigInteger pmax = BigInteger.ZERO;
        BigInteger temp;

        for (int D = 2; D <= 1000; D++) {
            System.out.println("checking D = " + D);
            BigInteger limit = BigInteger.valueOf((long)Math.sqrt(D));
            if (limit.multiply(limit).equals(BigInteger.valueOf((long)D)) ) {
                continue;
            }

            BigInteger m = BigInteger.ZERO;
            BigInteger d = BigInteger.ONE;
            BigInteger a = limit;

            BigInteger numm1 = BigInteger.ONE;
            BigInteger num = a;

            BigInteger denm1 = BigInteger.ZERO;
            BigInteger den = BigInteger.ONE;

            
            
            while (!pellsEquation(num, D, den).equals(BigInteger.ONE)) {
                //m = d * a - m;
                temp = d.multiply(a);
                m = temp.subtract(m);
                
                //d = (D - m * m) / d;
                temp = m.multiply(m);
                d = BigInteger.valueOf(D).subtract(temp).divide(d);
                
                //a = (limit + m) / d;
                temp = limit.add(m);
                a = temp.divide(d);

                BigInteger numm2 = numm1;
                numm1 = num;
                BigInteger denm2 = denm1;
                denm1 = den;

                num = a.multiply(numm1).add(numm2);
                den = a.multiply(denm1).add(denm2);
            }

            if (num.compareTo(pmax) > 0) {
                pmax = num;
                result = D;
            }
        }
        
        System.out.println("The result is: " + result);
    }
    
}
