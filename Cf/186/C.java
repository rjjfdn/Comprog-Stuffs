import java.util.*;
import java.math.*;
import java.io.*;

public class C {

    public static void main(String[] args) throws Exception {
    	BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(buffer.readLine());
    	String[] str = buffer.readLine().split(" ");
    	PriorityQueue<Integer> pq = new PriorityQueue<Integer>(1, 
    		new Comparator<Integer>() {
    			public int compare(Integer a, Integer b) {
    				return b-a;
    			}
    		}
    	);
    	BigInteger ans = BigInteger.ZERO;
    	for(int i=0; i<n; i++) {
    		int tmp = Integer.parseInt(str[i]);
    		pq.offer(tmp);
			ans = ans.add(new BigInteger("" + tmp));
    	}
    	int x = ((int)(Math.log(n)/Math.log(4)));
    	int j=0;
    	for(int i=n-1; i>=Math.max(0, n-(int)(Math.pow(4, x-1))); i--) {
    		int tmp = pq.poll();
    		ans = ans.add(new BigInteger(""+tmp).multiply(new BigInteger(""+(x-(int)Math.ceil(Math.log(j+1)/Math.log(4))))));
    		j++;
    	}
    	System.out.println(ans);
    }
}
