import java.util.*;
import java.io.*;
import java.math.*;

public class E {
	
	static BigInteger[] arr;
	static BigInteger num1;
	static BigInteger num2;
	
	public static void main (String[] args) throws Exception {
		arr = new BigInteger[1001];
		arr[0] = BigInteger.ZERO;
		arr[1] = BigInteger.ONE;
		for(int i=2;i<=1000;i++)
			arr[i] = arr[i-1].add(arr[i-2]);
		Scanner s = new Scanner(new FileReader("e.in"));
		while(s.hasNext()) {
			int n = s.nextInt();
			BigInteger res = arr[0];
			for(int i=0; i<=n; i++)
				res = res.add(arr[i].multiply(arr[i]));
			System.out.println(res);
		}
	}
}