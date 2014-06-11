import java.util.*;
import java.math.*;

public class A {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	BigInteger n = s.nextBigInteger();
    	BigInteger g = s.nextBigInteger();
    	for(int i=1; i<n.intValue(); i++)
    		g = g.gcd(s.nextBigInteger());
    	System.out.println(n.multiply(g));
    }
}
