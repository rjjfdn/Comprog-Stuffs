import java.util.*;

public class Main {

    public static void main(String[] args) {
    	long max = 0;
    	long num = 0;
    	long[] dp = new long[100000010];
    	for(int i=2; i<=1000000; i++) {
    		long temp = i;
    		long count = 0;
    		while(temp != 1) {
    			if(temp < 100000000)
	    			if(dp[(int)temp] != 0) {
	    				count += dp[(int)temp];
	    				break;
	    			}
    			if(temp%2 == 0)
    				temp /= 2;
    			else
    				temp = 3*temp+1;
    			count++;
    		}
    		dp[i] = count;
    		if(max < count) {
    			max = count;
    			num = i;
    		}
    	}
    	System.out.println(num + " " + max);
    }
}
