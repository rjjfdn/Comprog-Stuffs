import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	BigInteger[] fib = new BigInteger[100];
    	fib[0] = BigInteger.ZERO;
    	fib[1] = new BigInteger("2");
    	fib[2] = new BigInteger("3");
    	for(int i=3; i<100; i++)
    		fib[i] = fib[i-1].add(fib[i-2]);
    	int n = s.nextInt();
    	for(int i=0; i<n; i++) {
    		int m = s.nextInt();
    		System.out.println("Scenario #" + (i+1) + ":");
    		System.out.println(fib[m]);
    		System.out.println();
    	}
    }
}
