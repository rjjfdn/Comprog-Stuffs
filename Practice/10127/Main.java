import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	while(s.hasNext()) {
    		BigInteger n = s.nextBigInteger();
    		BigInteger one = BigInteger.ONE;
    		int count = 1;
    		while(!one.mod(n).equals(BigInteger.ZERO)) {
    			one = one.multiply(BigInteger.TEN).add(BigInteger.ONE);
    			count++;
    		}
    		System.out.println(count);
    	}
    }
}
