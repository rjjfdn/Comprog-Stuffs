import java.util.*;

public class A {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	int m = s.nextInt();
    	int k = s.nextInt();
    	int[] arr = new int[n];
    	for(int i=0; i<n; i++)
    		arr[i] = s.nextInt();
    	Arrays.sort(arr);
    	for(int i=0; i<n; i++) {
    		if(arr[i] == 1)
    			m--;
    		else {
    			if(k == 0)
    				m--;
    			else
    				k--;
    		}
    	}
    	int ans = 0;
    	if(m < 0)
    		ans += -m;
    	if(k < 0)
    		ans += -k;
    	System.out.println(ans);
    }
}
