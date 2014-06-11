import java.util.*;

public class Main {
	
	static long[][] dp;
	static int[] denom;
	
	static long answer(int cur, int idx) {
		if(cur < 0)
			return 0;
		if(dp[cur][idx] != -1)
			return dp[cur][idx];
		if(cur == 0)
			return 1;
		long ans = 0;
		for(int i=idx; i<8; i++) {
			ans += answer(cur-denom[i], i);
		}
		dp[cur][idx] = ans;
		return dp[cur][idx];
	}

    public static void main(String[] args) {
    	dp = new long[210][8];
    	denom = new int[8];
    	denom[0] = 1;
    	denom[1] = 2;
    	denom[2] = 5;
    	denom[3] = 10;
    	denom[4] = 20;
    	denom[5] = 50;
    	denom[6] = 100;
    	denom[7] = 200;
    	for(int i=0; i<210; i++)
    		for(int j=0; j<8; j++)
    			dp[i][j] = -1;
    	System.out.println(answer(200, 0));
    }
}
