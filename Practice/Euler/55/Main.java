import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) {
    	int count = 0;
    	for(int i=0; i<10000; i++) {
    		BigInteger n = new BigInteger(""+i);
    		boolean check = false;
    		for(int j=0; j<55; j++) {
    			BigInteger m = new BigInteger(new StringBuffer(n.toString()).reverse().toString());
    			n = n.add(m);
    			String rev = new StringBuffer(n.toString()).reverse().toString();
    			if(n.toString().equals(rev)) {
    				check = true;
    				break;
    			}
    		}
    		if(!check)
    			count++;
    	}
    	System.out.println(count);
    }
}
