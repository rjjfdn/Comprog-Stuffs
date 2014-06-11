import java.util.*;
import java.io.*;

public class A {

    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(new FileReader("a.in"));
    	int n = s.nextInt();
    	long[] f = new long[n];
    	long[] c = new long[n];
    	for(int i=0; i<n; i++) {
    		f[i] = s.nextLong();
    		c[i] = s.nextLong();
    	}
    	int m = s.nextInt();
    	for(int i=0; i<m; i++) {
    		long v = s.nextInt();
    		long t = s.nextInt();
	    	long min = 2000000000;
    		for(int j=0; j<Math.pow(2, n); j++) {
		    	long cost = 0;
		    	long vol = 0;
    			for(int k=0; k<n; k++)
    				if((j&(int)Math.pow(2,k)) == (int)Math.pow(2,k)) {
    					cost += c[k];
    					vol += f[k]*t;
    				}
    			if(vol >= v)
    				min = Math.min(min, cost);
    		}
    		if(min == 2000000000)
    			System.out.println("Case " + (i+1) + ": IMPOSSIBLE");
    		else
    			System.out.println("Case " + (i+1) + ": " + min);
    	}
    }
}
