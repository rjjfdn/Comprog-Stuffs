import java.util.*;
import java.math.*;

public class Main {
	
	static BigInteger[] dp;

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int cases = 1;
    	dp = new BigInteger[50010];
    	for(int i=0; i<50010; i++)
    		dp[i] = new BigInteger("-1");
    	while(true) {
    		BigInteger n = s.nextBigInteger();
    		if(n.equals(BigInteger.ZERO))
    			break;
    		System.out.print("Case " + cases++ + ": Public Key = " + n + " Private Key = ");
    		BigInteger m = n;
    		BigInteger md = new BigInteger("1000000000000");
    		if(!dp[n.intValue()].equals(new BigInteger("-1"))) {
    			System.out.println(dp[n.intValue()]);
    			continue;
    		}
    		int count = 1;
    		while(true) {
    			m = m.multiply(n);
    			count++;
    			
    		}
    	}
    }
}
