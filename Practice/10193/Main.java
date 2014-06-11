import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	for(int i=0; i<n; i++) {
    		BigInteger a = new BigInteger(""+Integer.parseInt(s.next(), 2));
    		BigInteger b = new BigInteger(""+Integer.parseInt(s.next(), 2));
    		if(a.gcd(b).equals(BigInteger.ONE))
    			System.out.println("Pair #" + (i+1) + ": Love is not all you need!");
    		else
    			System.out.println("Pair #" + (i+1) + ": All you need is love!");
    	}
    }
}
