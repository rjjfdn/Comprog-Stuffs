import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) {
    	BigInteger[] fact = new BigInteger[110];
    	fact[0] = BigInteger.ONE;
    	fact[1] = BigInteger.ONE;
    	for(int i=2; i<110; i++)
    		fact[i] = new BigInteger(""+i).multiply(fact[i-1]);
    	int count = 0;
    	for(int i=1; i<=100; i++)
    		for(int j=0; j<=i; j++) {
    			BigInteger num = fact[i].divide(fact[j].multiply(fact[i-j]));
    			if(num.compareTo(new BigInteger("1000000")) > 0)
    				count++;
    		}
    	System.out.println(count);
    }
}
