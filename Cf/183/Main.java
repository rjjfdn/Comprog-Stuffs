import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	int count = 0;
    	for(int i=1; i<=n; i++) {
    		for(int j=1; j<=i; j++) {
    			int k = (int)(Math.sqrt(i*i + j*j));
    			double kk = (Math.sqrt(i*i + j*j));
    			if(k == kk && k <= n) {
    				count++;
					//System.out.println(k + " " + j + " " + i);
    			}
    		}
    	}
    	System.out.println(count);
    }
}
