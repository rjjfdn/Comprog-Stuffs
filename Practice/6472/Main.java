import java.util.*;
import java.math.*;

public class Main {
        
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	BigInteger[] fact = new BigInteger[10010];
    	fact[0] = BigInteger.ONE;
    	for(int i=1; i<10010; i++)
    		fact[i] = fact[i-1].multiply(new BigInteger(""+i));
    	for(int q=0; q<n; q++) {
    		int m = s.nextInt();
    		System.out.print(m + " ");
    		int p = s.nextInt();
    		int c = s.nextInt();
    		int r = s.nextInt();
    		int x = c-r+1;
    		BigInteger num = BigInteger.ONE;
    		for(int i=r-1; i>=0; i--) {
    			if(x+i == r)
    				break;
    			num = num.multiply(new BigInteger(""+(x+i)));
    		}
    		if(x > r)
    			num = num.divide(fact[r]);
    		else
    			num = num.divide(fact[x-1]);
    		num = num.multiply(new BigInteger(""+p).pow(c-r));
    		System.out.println(num);
    	}
    }
}
