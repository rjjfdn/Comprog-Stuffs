import java.util.*;

public class B {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	int m = s.nextInt();
    	int[] arr = new int[n];
    	int[] arr2 = new int[m];
    	for(int i=0; i<n; i++)
    		arr[i] = s.nextInt();
    	for(int i=0; i<m; i++)
    		arr2[i] = s.nextInt();
    	Arrays.sort(arr);
    	Arrays.sort(arr2);
    	int j=m-1;
    	int count = 0;
    	for(int i=n-1; i>=0; i--) {
    		if(j < 0) {
    			count += (i+1);
    			break;
    		}
    		if(arr2[j] < arr[i])
    			count++;
    		else
    			j--;
    	}
    	System.out.println(count);
    }
}
