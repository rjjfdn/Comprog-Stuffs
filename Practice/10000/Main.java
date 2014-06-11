import java.util.*;

public class Main {
	
	static int[][] dp;
	static int[][] graph;
	static int n;

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int cases=1;
    	while(true) {
    		n = s.nextInt();
    		if(n == 0)
    			break;
    		int m = s.nextInt();
    		dp = new int[n+1][n+1];
    		graph = new int[n+1][n+1];
    		for(int i=0; i<n+1; i++) {
	    		Arrays.fill(dp[i], -1);
				dp[i][i] = 0;
    		}
    		while(true) {
    			int x = s.nextInt();
    			int y = s.nextInt();
    			if(x == 0 && y == 0)
    				break;
    			graph[x][y] = 1;
    		}
    		int longest = -1;
    		int target = m;
    		for(int i=1; i<=n; i++)
				if(dfs(m, i) > longest) {
					longest = dfs(m, i);
					target = i;
				}
    		System.out.println("Case " + cases++ + ": The longest path from " + m + " has length " + longest + ", finishing at " + target + ".");
    		System.out.println();
    	}
    }
    
    public static int dfs(int root, int dest) {
    	if(dp[root][dest] != -1)
    		return dp[root][dest];
    	int max = -1;
    	for(int i=1; i<=n; i++) {
    		if(graph[root][i] == 1)
    			max = Math.max(max, dfs(i, dest)+1);
    	}
    	dp[root][dest] = max;
    	return max;
    }
}
