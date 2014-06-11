import java.util.*;
import java.math.*;

public class Main {
	
	static long[][] dp;
	static int o, p;

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	for(int i=0; i<n; i++) {
    		int m = s.nextInt();
    		System.out.print(m + " ");
    		o = s.nextInt();
    		p = s.nextInt();
    		dp = new long[o][(int)Math.pow(2, o)];
    		System.out.println(backtrack(0, 0));
    	}
    }
    
    public static long backtrack(int cur, int bitmask) {
    	if(cur == o)
    		return 1;
    	if(dp[cur][bitmask] != 0)
    		return dp[cur][bitmask];
    	long ans = 0;
    	for(int i=0; i<o; i++) {
    		if(cur < p && i == cur)
    			continue;
    		if((bitmask & (int)Math.pow(2, i)) == 0)
	    		ans += backtrack(cur+1, bitmask | (int)Math.pow(2, i));
    	}
    	return dp[cur][bitmask] = ans;
    }
}
