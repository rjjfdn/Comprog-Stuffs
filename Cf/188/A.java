import java.util.*;
import java.math.*;

public class A {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	BigInteger n = s.nextBigInteger();
    	BigInteger k = s.nextBigInteger();
    	BigInteger m = n.divide(new BigInteger("2"));
    	if(n.mod(new BigInteger("2")).equals(BigInteger.ZERO)) {
    		if(k.compareTo(m) <= 0)
    			System.out.println(k.multiply(new BigInteger("2")).subtract(BigInteger.ONE));
    		else {
    			System.out.println(k.subtract(m).multiply(new BigInteger("2")));
    		}
    	}
    	else {
    		m = m.add(BigInteger.ONE);
    		if(k.compareTo(m) <= 0)
    			System.out.println(k.multiply(new BigInteger("2")).subtract(BigInteger.ONE));
    		else {
    			System.out.println(k.subtract(m).multiply(new BigInteger("2")));
   			}
    	}
    }
}
