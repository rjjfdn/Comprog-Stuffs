import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Vector<Integer> primes = new Vector<Integer>();
    	boolean[] isNPrime = new boolean[10000010];
    	isNPrime[0] = true;
    	isNPrime[1] = true;
    	for(int i=2; i<10000010; i++)
    		if(!isNPrime[i]) {
    			primes.addElement(i);
    			for(int j=i+i; j<10000010; j+=i)
    				isNPrime[j] = true;
    		}
    	int count = 0;
    	for(int i=2; i<1000000; i++) {
    		String a = ""+i;
    		boolean check = true;
    		for(int j=0; j<a.length(); j++) {
    			if(isNPrime[Integer.parseInt(a)]) {
    				check = false;
    				break;
    			}
    			a = a.substring(1) + a.charAt(0);
    		}
    		if(check)
    			count++;
    	}
    	System.out.println(count);
    }
}
