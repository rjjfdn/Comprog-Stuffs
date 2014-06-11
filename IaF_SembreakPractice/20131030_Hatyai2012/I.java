import java.util.*;
import java.io.*;

public class I {

    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(new FileReader("i.in"));
    	boolean[] isNPrime = new boolean[100010];
    	isNPrime[0] = true;
    	isNPrime[1] = true;
    	for(int i=2; i<100000; i++)
    		if(!isNPrime[i])
    			for(int j=i+i; j<100000; j+=i)
    				isNPrime[j] = true;
    	while(true) {
    		String line = s.next();
    		if(line.equals("0"))
    			break;
    		int max = 0;
    		for(int i=0; i<line.length(); i++)
    			for(int j=i+1; j<=i+5 && j<line.length(); j++) {
    				int idx = Integer.parseInt(line.substring(i, j));
    				if(!isNPrime[idx])
    					max = Math.max(idx, max);
    			}
    		System.out.println(max);
    	}
    }
}
