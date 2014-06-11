import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Vector<Integer> primes = new Vector<Integer>();
    	boolean[] isNPrime = new boolean[1000000];
    	isNPrime[0] = true;
    	isNPrime[1] = true;
    	for(int i=2; i<1000000; i++)
    		if(!isNPrime[i]) {
    			primes.addElement(i);
    			for(int j=i+i; j<1000000; j+=i)
    				isNPrime[j] = true;
    		}
    	int count = 0;
    	for(int i=0; i<primes.size(); i++) {
    		int n = primes.elementAt(i);
    		if(n > 150000)
    			break;
    		if(n < 10) {
    			System.out.print(primes.elementAt(i) + ", ");
    			continue;
    		}
    		boolean check = true;
    		for(int j=0; j<10; j++) {
    			n = Integer.parseInt("" + (n%10) + "" + (n/10));
    			if(isNPrime[n]) {
    				check = false;
    				break;
    			}
    		}
    		if(check) {
    			System.out.print(primes.elementAt(i) + ", ");
    			count++;
    		}
    	}
    	System.out.println("\n" + count);
    }
}
