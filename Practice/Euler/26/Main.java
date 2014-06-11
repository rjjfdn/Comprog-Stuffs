import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) {
    	int max = 0;
    	int num = 0;
    	for(int i=1000; i>=1; i--) {
    		BigInteger m = new BigInteger(""+i);
    		String nine = "";
    		for(int j=1; j<=1000; j++) {
    			nine += "9";
    			if(new BigInteger(nine).mod(m).equals(BigInteger.ZERO)) {
    				System.out.println(i + " " + nine.length());
    				if(max < nine.length()) {
    					max = nine.length();
    					num = i;
    				}
    				break;
    			}
    		}
    	}
    	System.out.println(num);
    }
}    
