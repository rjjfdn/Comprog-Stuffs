import java.util.*;

public class Main {
	
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	long[] fact = new long[1000100];
    	fact[0] = 1;
    	for(int i=1; i<1000000; i++) {
    		fact[i] = i*fact[i-1];
    		if(fact[i] > 6227020800L) {
    			fact[i] = 0;
    			break;
    		}
    	}
    	while(s.hasNext()) {
    		int n = s.nextInt();
    		if((n < 8 && n >= 0) || (n < 0 && (-n) % 2 == 0))
    			System.out.println("Underflow!");
    		else if(n < 0 && (-n) % 2 == 1)
    			System.out.println("Overflow!");
    		else if(fact[n] == 0)
    			System.out.println("Overflow!");
    		else
    			System.out.println(fact[n]);
    	}
    }
}
