import java.util.*;
import java.io.*;
import java.math.*;

public class E {

    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(new FileReader("e.in"));
    	int n = s.nextInt();
    	for(int i=0; i<n; i++) {
    		int r = s.nextInt();
    		BigInteger c = s.nextBigInteger();
    		int m = s.nextInt();
    		int moves = 0;
    		for(int j=0; j<m; j++) {
    			int rr = s.nextInt();
    			BigInteger cc = s.nextBigInteger();
    			int dr = Math.abs(rr-1);
	    			BigInteger dc = BigInteger.ONE.subtract(cc);
    			if(dc.compareTo(BigInteger.ZERO) < 0)
    				dc = dc.multiply(new BigInteger("-1"));
    			if(dc.equals(BigInteger.ZERO) && dr == 0)
    				moves += 0;
    			else if(dc.equals(new BigInteger(""+dr)) || dc.equals(BigInteger.ZERO) || dr == 0)
    				moves++;
    			else
    				moves+=2;
    		}
    		if(moves%2 == 1)
    			System.out.println("YES");
    		else
    			System.out.println("NO");
    	}
    }
}
