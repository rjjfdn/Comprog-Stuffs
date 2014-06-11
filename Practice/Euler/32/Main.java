import java.util.*;

public class Main {

    public static void main(String[] args) {
    	long sum = 0;
    	for(int i=1; i<=5000; i++)
    		for(int j=i; j<=5000; j++) {
    			long tmp3 = i*j;
    			HashSet<Long> set = new HashSet<Long>();
    			long tmp1 = i;
    			long tmp2 = j;
    			char[] arr = (tmp3+""+tmp1+""+tmp2).toCharArray();
    			Arrays.sort(arr);
    			if(new String(arr).equals("123456789")) {
    				System.out.println(i*j);
    				if(!set.contains((long)(i*j))) {
    					set.add((long)(i*j));
	    				sum += (long)(i*j);
    				}
    			}
    		}
    	System.out.println(sum);
    }
}
