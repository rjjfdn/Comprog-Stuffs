import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	long[] ans = new long[70];
    	ans[1] = 1;
    	ans[2] = 1;
    	ans[3] = 1;
    	for(int i=4; i<70; i++)
    		ans[i] = ans[i-1] + ans[i-2] + ans[i-3];
    	int cases = 1;
    	while(true) {
    		int n = s.nextInt();
    		if(n == 0)
    			break;
    		System.out.println("Case " + cases++ + ": " + ans[n]);
    	}
    }
}
