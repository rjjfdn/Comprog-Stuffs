import java.util.*;

public class Main {
        
    public static void main(String[] args) {
    	boolean[] nprime = new boolean[10000010];
    	Vector<Integer> composite = new Vector<Integer>();
    	Vector<Integer> prime = new Vector<Integer>();
    	HashSet<Integer> set = new HashSet<Integer>();
    	nprime[0] = true;
    	nprime[1] = true;
    	for(int i=2; i<10000010; i++)
    		if(!nprime[i]) {
    			prime.addElement(i);
    			for(int j=i+i; j<10000010; j+=i) {
    				if(j%2 == 1)
	    				if(set.add(j))
    						composite.addElement(j);
    				nprime[j] = true;
    			}
    		}
    	Collections.sort(composite);
    	for(int i=0; i<composite.size(); i++) {
    		int n = composite.elementAt(i);
    		boolean check = false;
    		for(int j=1; j<prime.size(); j++) {
    			int temp = n;
    			int m = prime.elementAt(j);
    			temp = temp-m;
    			if(temp < 0)
    				break;
    			temp /= 2;
    			if((int)Math.sqrt(temp)*(int)Math.sqrt(temp) == temp) {
    				check = true;
    				break;
    			}
    		}
    		if(!check) {
    			System.out.println(n);
    			break;
    		}
    	}
    }
}
