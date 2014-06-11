import java.util.*;
import java.io.*;

public class H {

	static int[][] dp;

    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(new FileReader("h.in"));
    	int n = s.nextInt();
    	dp = new int[2010][2010];
    	for(int i=0; i<2010; i++)
    		for(int j=0; j<2010; j++)
	    		dp[i][j] = -1;
    	dp[0][0] = 0;
    	dp[0][1] = 1;
    	dp[0][2] = 1;
    	dp[0][3] = 2;
    	dp[0][2000] = backtrack(0, 2000);
    	for(int i=0; i<n; i++) {
    		int m = s.nextInt();
    		System.out.println(dp[m]);
    	}
    }
    
    public static int backtrack(int start, int num) {
    	if(dp[num] != -1)
    		return dp[num];
    	int ans = 0;
    	for(int i=1; i<num; i++)
    		ans = (ans+i+backtrack(i))%100999;
    	return dp[num] = ans;
    }
}
