import java.util.*;

public class Main {
        
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int t = s.nextInt();
    	for(int x=0; x<t; x++) {
    		int n = s.nextInt();
	    	int k = s.nextInt();
	    	int[] arr = new int[n];
	    	int[] arr2 = new int[n];
	    	HashMap<Integer, Integer> unsorted = new HashMap<Integer, Integer>();
	    	HashMap<Integer, Integer> sorted = new HashMap<Integer, Integer>();
	    	for(int i=0; i<n; i++) {
	    		arr[i] = s.nextInt();
	    		arr2[i] = arr[i];
	    		unsorted.put(arr[i], i);
	    	}
	    	int[] pos = new int[n];
	    	int p = -1;
	    	for(int i=0; i<n; i++) { 
	    		if(i%k == 0) // pang count to sa zones?
	    			p++;
	    		int num = -1;
	    		int count = k-(i%k);
	    		if((p+1)*k >= n)
	    			count -= ((p+1)*k)-n;
	    		for(int j=n-1; j>=0; j--)
	    			if((arr[j]-1)/k == p && count > 0) {
	    				num = arr[j];
						count--;
						if(count == 0)
							break;
	    			}
	    		pos[i] = num;
	    		sorted.put(num, i);
	    	}
	    	int max = 0;
	    	for(int i=1; i<=n; i++)
	    		max = Math.max(max, Math.abs(unsorted.get(i)-sorted.get(i)));
	    	int count = 0;
    		for(int j=0; j<n; j++) {
    			int idx1 = unsorted.get(pos[j]);
    			int idx2 = sorted.get(pos[j]);
    			if(idx2 < idx1)
	    			count += idx1-idx2;
    			/*if(idx2 < idx1) {
    				int temp = arr[idx1];
    				for(int q=idx1-1; q>=idx2; q--) {
    					arr[q+1] = arr[q];
    					unsorted.put(arr[q+1], q+1);
						count++;
    				}
    				unsorted.put(temp, idx2);
    				arr[idx2] = temp;
    			}*/
    		}
    		System.out.println(count);
	    	System.out.println("Case " + (x+1) + ": " + (count-max));
    	}
    }
}
