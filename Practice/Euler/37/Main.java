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
    	int sum = 0;
    	for(int q=0; q<primes.size(); q++) {
    		int num = primes.elementAt(q);
    		if(num < 10)
    			continue;
    		boolean check = false;
    		for(int i=1; i<8; i++) {
    			if(num < Math.pow(10, i))
    				break;
    			if(isNPrime[num%(int)Math.pow(10,i)] || isNPrime[num/(int)Math.pow(10,i)]) {
    				check = true;
    				break;
    			}
    		}
    		if(!check)
    			sum += num;
    	}
    	System.out.println(sum);
    }
}
