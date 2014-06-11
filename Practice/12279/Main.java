import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int cases = 1;
    	while(true) {
    		int n = s.nextInt();
    		if(n == 0)
    			break;
    		int pos = 0;
    		int zer = 0;
    		for(int i=0; i<n; i++) {
    			int m = s.nextInt();
    			if(m > 0)
    				pos++;
    			else zer++;
    		}
    		System.out.println("Case " + cases++ + ": " + (pos-zer));
    	}
    }
}
