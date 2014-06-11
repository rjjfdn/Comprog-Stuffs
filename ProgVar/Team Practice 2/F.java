import java.util.*;
import java.io.*;

public class F {

    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(new FileReader("f.in"));
    	while(s.hasNext()) {
    		int side = s.nextInt();
    		int a = s.nextInt(); // 0,0
    		int b = s.nextInt(); // s,0
    		int c = s.nextInt(); // s,s
    		int d = s.nextInt(); // 0,s
    		int n = s.nextInt();
    		int count = 0;
    		for(int i=0; i<n; i++) {
    			int x = s.nextInt();
    			int y = s.nextInt();
    			if(a > (int)Math.sqrt(x*x + y*y) && b > (int)Math.sqrt((x-side)*(x-side) + y*y) &&
    				c > (int)Math.sqrt((x-side)*(x-side) + (y-side)*(y-side)) &&
    				d > (int)Math.sqrt(x*x + (y-side)*(y-side))) {
    					count++;
    				}
    		}
    		if(count <= n/2)
    			System.out.println("St. Stephen needs new equipment.");
    		else
    			System.out.println("The wireless coverage still stinks, but good enough for now.");
    	}
    }
}
