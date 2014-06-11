import java.util.*;
import java.io.*;

public class A{
	static int[][] dp;
	static int m;
	static int n;
	static int MOD;
	public static void main(String[] args)throws Exception{
		Scanner s = new Scanner(System.in);
		MOD = 1000007;
		int t = s.nextInt();
		for(int i=0;i<t;i++){
			m = s.nextInt();
			n = s.nextInt();
			dp = new int[30][30];
			int res = solve(1,1);
			System.out.println(res);
		}
	}
	static int solve(int x, int y){
		//if x,y == m,n
		int a = 0;
		int b = 0;
		int c = 0;
		if(x > m && y > n)
			return 0;
		if(x == m && y == n)
			return 1;
		else
		if(dp[x][y] != 0)
			return dp[x][y];
		else{
			if((x+1) <= m)
				a = solve(x+1,y);
			if((y+1) <= n)
				b = solve(x,y+1);
			if((y+1) <= n && (x+1) <= m);
				c = solve(x+1,y+1);
			int res = (a+b+c)%MOD;
			dp[x][y] = res;
			return res; 
		}
		
	}
}