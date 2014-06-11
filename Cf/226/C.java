import java.util.*;

public class C {
	
	static boolean[] isNPrime;
	static int[] freq;
	static Vector<Integer> primes;
	static boolean[] check;

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	isNPrime = new boolean[10000010];
    	primes = new Vector<Integer>();
    	isNPrime[0] = true;
    	isNPrime[1] = true;
    	for(int i=2; i<10000010; i++)
    		if(!isNPrime[i]) {
    			primes.addElement(i);
    			for(int j=i+i; j<10000010; j+=i)
    				isNPrime[j] = true;
    		}
    	freq = new int[primes.size()];
    	int n = s.nextInt();
    	for(int i=0; i<n; i++) {
    		int m = s.nextInt();
    		check = new boolean[primes.size()];
    		factor(m);
    	}
    	for(int i=1; i<freq.length; i++)
    		freq[i] += freq[i-1];
    	int m = s.nextInt();
    	for(int i=0; i<m; i++) {
    		int l = s.nextInt();
    		int r = s.nextInt();
    		int idx1 = Collections.binarySearch(primes, l);
    		int idx2 = Collections.binarySearch(primes, r);
    		if(idx1 < 0)
    			idx1 = -idx1-2;
    		else idx1--;
    		if(idx2 < 0)
    			idx2 = -idx2-2;
    		int first, second;
    		if(idx1 < 0)
    			first = 0;
    		else if(idx1 == primes.size())
    			first = freq[idx1-1];
    		else
    			first = freq[idx1];
    		if(idx2 < 0)
    			second = 0;
    		else if(idx2 == primes.size())
    			second = freq[idx2-1];
    		else
    			second = freq[idx2];
    		System.out.println(second-first);
    	}
    }
    
    public static void factor(int m) {
    	if(m == 1)
    		return;
    	if(!isNPrime[m]) {
    		int idx = Collections.binarySearch(primes, m);
    		if(!check[idx]) {
	    		freq[idx]++;
	    		check[idx] = true;
    		}
    		return;
    	}
    	int divisor = rho(m);
    	factor(divisor);
    	factor(m/divisor);
    }
    
    public static long gcd(long p, long q) {
    	if(p%q == 0)
    		return q;
    	return gcd(q, p%q);
    }
    
    public static long f(long x) {
    	return x*x+((int)(Math.random()*10)-5);
    }
    
    public static int rho(int n) {
    	long divisor;
    	long x1 = 2, x2 = 2;
    	if(n%2 == 0)
    		return 2;
    	do {
    		x1 = f(x1)%n;
    		x2 = f(f(x2)%n)%n;
    		divisor = gcd(Math.abs(x1-x2), n);
    	} while(divisor == 1);
    	return (int) divisor;
    }
}
