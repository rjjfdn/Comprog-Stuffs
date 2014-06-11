import java.util.*;
import java.math.*;

public class Main {

	public static BigInteger modpow(BigInteger base, int pow) {
		BigInteger temp = base;
		for(int i=1; i<pow; i++) {
			base = base.multiply(temp);
			base = base.mod(new BigInteger("10000000000"));
		}
		return base;
	}

    public static void main(String[] args) {
    	BigInteger answer = (new BigInteger("28433").multiply(modpow(new BigInteger("2"), 7830457)).add(BigInteger.ONE)).mod(new BigInteger("10000000000"));
    	System.out.println(answer);
    }
}
