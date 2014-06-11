import java.util.*;

public class A {
        
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	int m = s.nextInt();
    	int one = 0;
    	int zero = 0;
    	for(int i=0; i<n; i++) {
    		int tmp = s.nextInt();
    		if(tmp == 1)
    			one++;
    		else
    			zero++;
    	}
    	for(int i=0; i<m; i++) {
    		int a = s.nextInt();
    		int b = s.nextInt();
    		if((b-a+1)%2 == 1)
    			System.out.println(0);
    		else {
    			if((b-a+1)/2 <= Math.min(one, zero))
    				System.out.println(1);
    			else
    				System.out.println(0);
    		}
    	}
    }
}
