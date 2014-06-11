import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	boolean[] isNPrime = new boolean[10000000];
    	isNPrime[0] = isNPrime[1] = true;
    	for(int i=2; i<10000000; i++)
    		if(!isNPrime[i])
    			for(int j=i+i; j<10000000; j+=i)
    				isNPrime[j] = true;
    	while(s.hasNext()) {
    		int n = s.nextInt();
    		if(isNPrime[n])
    			System.out.println(n + " is not prime.");
    		else if(isNPrime[Integer.parseInt(new StringBuffer(""+n).reverse().toString())] || (""+n).equals(new StringBuffer(""+n).reverse().toString()))
    			System.out.println(n + " is prime.");
    		else
    			System.out.println(n + " is emirp.");
    	}
    }
}
