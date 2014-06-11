import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	while(s.hasNext()) {
    		String a = s.next();
    		String b = s.next();
    		boolean check = false;
    		for(int i=2; i<=36; i++) {
    			for(int j=2; j<=36; j++) {
    				BigInteger one;
    				try {
	    				one = new BigInteger(a, i);
    				}
    				catch(Exception e) {
    					break;
    				}
    				try {
	    				BigInteger two = new BigInteger(b, j);
	    				if(one.equals(two)) {
	    					System.out.println(a + " (base " + i + ") = " + b + " (base " + j + ")");
	    					check = true;
	    					break;
	    				}
    				}
    				catch(Exception e) {
    					continue;
    				}
    			}
    			if(check)
    				break;
    		}
    		if(!check)
    			System.out.println(a + " is not equal to " + b + " in any base 2..36");
    	}
    }
}
