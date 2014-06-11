import java.util.*;

public class B {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	int m = s.nextInt();
    	long[] arr = new long[n+1];
    	arr[0] = 0;
    	for(int i=1; i<=n; i++) {
    		int t = s.nextInt();
    		int c = s.nextInt();
    		arr[i] = arr[i-1] + (t*c);
    	}
    	for(int i=0; i<m; i++) {
    		int index = Arrays.binarySearch(arr, s.nextInt());
    		if(index < 0)
    			index = -index-1;
    		System.out.println(index);
    	}
    }
}
