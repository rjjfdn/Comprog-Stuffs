import java.util.*;

public class C {
        
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	long[] arr = new long[2*n-1];
    	int[] visited = new int[2*n-1];
    	for(int i=0; i<arr.length; i++) {
    		arr[i] = s.nextLong();
    		if(arr[i] == 0)
    			visited[i] = 1000;
    		else
	    		visited[i] = (arr[i]<0)?0:1;
    		arr[i] = Math.abs(arr[i]);
    	}
    	Arrays.sort(arr);
    	int sum = 0;
    	for(int i=0; i<visited.length; i++)
    		if(visited[i] != 0)
    			sum++;
    	for(int j=0; j<1000000; j++) {
    		Arrays.sort(visited);
    		for(int i=0; i<n; i++) {
    			if(visited[i] == 1)
    				visited[i] = 0;
    			else if(visited[i] == 0)
    				visited[i] = 1;
    			else
    				visited[i] = 1000;
    		}
    		int count = 0;
    		for(int i=0; i<visited.length; i++) {
    			if(visited[i] != 0)
    				count++;
    		}
    		sum = Math.max(sum, count);
    	}
    	int ans = 0;
    	for(int i=0; i<arr.length-sum; i++)
    		ans -= arr[i];
    	for(int i=arr.length-sum; i<arr.length; i++)
    		ans += arr[i];
    	System.out.println(ans);
    }
}
