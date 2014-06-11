import java.util.*;
import java.io.*;
import java.math.*;

public class D {
        
    public static void main(String[] args) throws Exception {
    	Vector<Integer> primes = new Vector<Integer>();
    	boolean[] isNPrime = new boolean[10000010];
    	isNPrime[0] = true;
    	isNPrime[1] = true;
    	for(int i=2; i<10000010; i++)
    		if(!isNPrime[i]) {
    			primes.addElement(i);
    			for(int j=i+i; j<10000010; j+=i) {
    				isNPrime[j] = true;
    			}
    		}
    	int ten = 10000, three2 = 33000, six4 = 65000;
    	Vector<Integer> nprimes = new Vector<Integer>();
    	while(true) {
    		int idx = Collections.binarySearch(primes, ten);
    		idx = -idx-1;
    		if(idx == primes.size())
    			break;
    		nprimes.addElement(primes.elementAt(idx));
    		idx = Collections.binarySearch(primes, three2);
    		idx = -idx-1;
    		if(idx == primes.size())
    			break;
    		nprimes.addElement(primes.elementAt(idx));
    		idx = Collections.binarySearch(primes, six4);
    		idx = -idx-1;
    		if(idx == primes.size())
    			break;
    		nprimes.addElement(primes.elementAt(idx));
    		ten *= 10;
    		three2 *= 10;
    		six4 *= 10;
    	}
    	BigInteger[] dp = new BigInteger[5001];
    	for(int i=3500; i<=5000; i++) {
    		for(int j=nprimes.size()-1; j>=0; j--) {
    			BigInteger num = new BigInteger(""+nprimes.elementAt(j));
    			num = num.pow((int)(i/Math.log10(nprimes.elementAt(j))));
    			int len = i-num.toString().length();
    			if(len == 0) {
    				dp[i] = num;
    				break;
    			}
    			else {
    				int tmp = (int)Math.pow(10, len);
    				if(tmp > 8000) {
    					int idx = Collections.binarySearch(primes, tmp);
    					idx = -idx-1;
    					if(idx == primes.size())
    						continue;
    					dp[i] = num.multiply(new BigInteger(""+primes.elementAt(idx)));
    					break;
    				}
    				else continue;
    			}
    		}
    	}
    	Scanner s = new Scanner(new FileReader("d.in"));
    	while(true) {
    		int n = s.nextInt();
    		int t = s.nextInt();
    		if(n == 0 && t == 0)
    			break;
    		System.out.println(dp[n].toString().length());
    	}
    }
}
