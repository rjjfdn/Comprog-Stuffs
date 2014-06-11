import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
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
    	while(s.hasNext()) {
    		int n = s.nextInt();
    		if(n < 8)
    			System.out.println("Impossible.");
    		else {
    			if(n%2 == 1) {
    				System.out.print("2 3 ");
    				n -= 5;
    			}
    			else {
    				System.out.print("2 2 ");
    				n -= 4;
    			}
    			for(int i=0; i<primes.size(); i++) {
    				int tmp = primes.elementAt(i);
    				int tmp2 = n-tmp;
    				if(!isNPrime[tmp2]) {
    					System.out.println(tmp + " " + tmp2);
    					break;
    				}
    			}
    		}
    	}
    }
}
