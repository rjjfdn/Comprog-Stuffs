import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class B{
	public static void main(String[] args)throws Exception{
		Scanner s = new Scanner(new FileReader("b.in"));
		int i = 1;
		while(n!=0){
			BigInteger num = s.nextBigInteger();
			if(num.isProbablePrime(10))
				System.out.println("Case " + i + ": PRIME");
			else
				System.out.println("Case " + i + ": NOT PRIME");
			i++;
		}
	}
}