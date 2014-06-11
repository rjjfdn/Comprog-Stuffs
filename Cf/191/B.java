import java.util.*;
import java.io.*;

public class B {
        
    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(System.in);
    	PrintWriter printer = new PrintWriter(new FileWriter("file.out"));
    	Vector<Integer> primes = new Vector<Integer>();
    	boolean[] isNPrime = new boolean[10000050];
    	int n = s.nextInt();
    	isNPrime[0] = true;
    	isNPrime[1] = true;
    	for(int i=2; i<=10000000; i++) {
    		if(!isNPrime[i]) {
    			primes.addElement((int)i);
    			if(primes.size() == n)
    				break;
	    		for(int j=i+i; j<=10000000; j+=i) {
	    			isNPrime[j] = true;
	    		}
    		}
    	}
    	System.out.print(primes.elementAt(0));
    	for(int i=1; i<n; i++)
    		System.out.print(" " + primes.elementAt(i));
    	System.out.println();
    }
}
