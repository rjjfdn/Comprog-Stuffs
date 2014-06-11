import java.util.*;
import java.math.*;

public class Main {
        
    static BigInteger[][] dp;
    static int x2, y2;
    
    public static BigInteger answer(int x1, int y1) {
    	if(x1 == 20 && y1 == 20)
    		return BigInteger.ONE;
    	if(dp[x1][y1] != null)
    		return dp[x1][y1];
    	BigInteger first, second;
    	if(x1 < 20)
    		first = answer(x1+1,y1);
    	else
    		first = BigInteger.ZERO;
    	if(y1 < 20)
    		second = answer(x1,y1+1);
    	else
    		second = BigInteger.ZERO;
    	dp[x1][y1] = first.add(second);
    	return dp[x1][y1];
    }
        
    public static void main(String[] args) {
    	dp = new BigInteger[25][25];
    	answer(0,0);
    	for(int i=0; i<13; i++)
    		System.out.println(dp[i][i]);
    }
}
