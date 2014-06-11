import java.util.*;

public class Main {

    public static void main(String[] args) {
    	long sum = 0;
    	Vector<Integer> list = new Vector<Integer>();
    	for(int i=1; i<=28123; i++) {
    		long count = 0;
    		for(int j=1; j<=i/2; j++) {
    			if(i%j == 0)
    				count += j;
    		}
    		if(count > i)
    			list.addElement(i);
    	}
    	System.out.println(list.size());
    	Vector<Integer> list2 = new Vector<Integer>();
    	for(int i=0; i<list.size(); i++)
    		for(int j=i; j<list.size(); j++)
    			list2.addElement(list.elementAt(i) + list.elementAt(j));
    	Collections.sort(list2);
    	System.out.println(list2.elementAt(0));
    	for(int i=1; i<=28123; i++) {
    		int idx = Collections.binarySearch(list2, i);
    		if(idx < 0)
    			sum += i;
    	}
    	System.out.println(sum);
    }
}
