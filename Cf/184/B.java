import java.util.*;
import java.math.*;

public class B {
	
	static BigInteger[] arr;
	static BigInteger aden, anum;

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	BigInteger num = s.nextBigInteger();
    	BigInteger den = s.nextBigInteger();
    	int n = s.nextInt();
    	BigInteger gcd = num.gcd(den);
    	num = num.divide(gcd);
    	den = den.divide(gcd);
    	arr = new BigInteger[n];
    	for(int i=0; i<n; i++)
    		arr[i] = s.nextBigInteger();
    	aden = new BigInteger("-1");
    	anum = new BigInteger("-1");
    	//System.out.println(num + " " + den);
    	recurse(arr.length-2, BigInteger.ONE, arr[arr.length-1], BigInteger.ONE);
    	if(num.equals(anum) && den.equals(aden))
    		System.out.println("YES");
    	else
    		System.out.println("NO");
    }
    
    public static void recurse(int index, BigInteger prev, BigInteger den, BigInteger plus) {
    	if(index == -1) {
    		anum = new BigInteger(den.toString());
    		aden = new BigInteger(prev.toString());
    		return;
    	}
    	else
	    	recurse(index-1, den, arr[index].multiply(den).add(plus), den);
    }
}
