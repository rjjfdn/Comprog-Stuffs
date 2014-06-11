import java.util.*;

public class B {
        
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	int[] a = new int[n];
    	int[] b = new int[n];
    	int[] c = new int[n+n];
    	int j = 0;
    	for(int i=0; i<n; i++) {
    		a[i] = s.nextInt();
    		c[j] = a[i];
    		j++;
    		b[i] = s.nextInt();
    		c[j] = b[i];
    		j++;
    	}
    	Arrays.sort(c);
    	int mid = c[n-1];
    	int idx1 = Arrays.binarySearch(a, mid);
    	if(idx1 < 0)
    		idx1 = -idx1-1;
    	else
    		idx1++;
    	int idx2 = Arrays.binarySearch(b, mid);
    	if(idx2 < 0)
    		idx2 = -idx2-1;
    	else
    		idx2++;
    	idx1 = Math.max(idx1, n/2);
    	idx2 = Math.max(idx2, n/2);
    	for(int i=0; i<idx1; i++)
    		System.out.print(1);
    	for(int i=idx1; i<n; i++)
    		System.out.print(0);
    	System.out.println();
    	for(int i=0; i<idx2; i++)
    		System.out.print(1);
    	for(int i=idx2; i<n; i++)
    		System.out.print(0);
    	System.out.println();
    }
}
