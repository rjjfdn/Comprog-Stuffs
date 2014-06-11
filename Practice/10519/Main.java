import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	while(s.hasNext()) {
    		BigInteger n = s.nextBigInteger();
    		if(n.equals(BigInteger.ZERO))
    			System.out.println(1);
    		else
	    		System.out.println(n.multiply(n.subtract(BigInteger.ONE)).divide(new BigInteger("2")).add(BigInteger.ONE).multiply(new BigInteger("2")));
    	}
    }
}
