import java.math.*;
import java.util.*;

public class Main {
	
	static int o;
	static int[] dp;

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	for(int q=0; q<n; q++) {
    		int m = s.nextInt();
    		System.out.print(m + " ");
    		o = s.nextInt();
    		dp = new int[1000000];
    		int idx = 1;
    		while(true) {
    			if(k(idx) == 0 && k(idx+1) == 1 && k(idx+2) == 1) {
    				System.out.println(idx);
    				break;
    			}
    			idx++;
    		}
    	}
    }
    
    public static int k(int n) {
    	if(dp[n] != 0)
    		return dp[n];
    	if(n == 1 || n == 2)
    		return 1;
    	if(n == 0)
    		return 0;
    	return dp[n] = (k(n-1)+k(n-2))%o;
    }
}
