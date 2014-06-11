import java.util.*;
import java.io.*;

public class F {

    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(new FileReader("f.in"));
    	while(s.hasNext()) {
    		String[] split = s.nextLine().split(",");
    		int n = Integer.parseInt(split[0]);
    		int m = Integer.parseInt(split[1]);
    		int[] fib = new int[m];
    		fib[0] = 1;
    		fib[1] = 2;
    		for(int i=2; i<m; i++)
    			fib[i] = fib[i-1] + fib[i-2];
    		int[] ans = new int[m];
    		for(int i=m-1; i>=0; i--)
    			if(n >= fib[i]) {
    				n -= fib[i];
    				ans[i] = 1;
    			}
    		if(n != 0)
    			System.out.println("\"NONE\"");
    		else {
    			System.out.print("[" + ans[m-1]);
    			for(int i=m-2; i>=0; i--)
    				System.out.print(", " + ans[i]);
    			System.out.println("]");
    		}
    	}
    }
}
