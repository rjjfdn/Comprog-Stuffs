import java.util.*;
import java.io.*;

public class Main {
        
    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(new FileReader("pf.in"));
    	int n = s.nextInt();
    	HashMap<Long, Long> map = new HashMap<Long, Long>();
    	long count = 0;
    	for(int i=0; i<66000; i++)
    		for(int j=3; j<66000; j+=2) {
    			if(j*(long)Math.pow(2, i) > 66000)
    				break;
	    		map.put(j*(long)Math.pow(2, i), count++);
    		}
    	for(int i=17; i>=0; i--)
    		map.put((long)Math.pow(2, i), count++);
    	for(int i=0; i<n; i++) {
    		Vector<Number> list = new Vector<Number>();
    		while(true) {
    			long m = s.nextLong();
    			if(m == 0)
    				break;
    			list.addElement(new Number(m, map.get(m)));
    		}
    		Collections.sort(list);
    		System.out.print(list.elementAt(0).num);
    		for(int j=1; j<list.size(); j++)
    			System.out.print(" " + list.elementAt(j).num);
    		System.out.println();
    	}
    }
}

class Number implements Comparable<Number> {
	
	long num;
	long order;
	
	public Number(long n, long o) {
		num = n;
		order = o;
	}
	
	public int compareTo(Number n) {
		if(order < n.order)
			return -1;
		else if(order > n.order)
			return 1;
		else
			return 0;
	}
}