import java.util.*;

public class A {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	int c = s.nextInt();
    	int[] arr = new int[n];
    	for(int i=0; i<n; i++)
    		arr[i] = s.nextInt();
    	int max = 0;
    	for(int i=1; i<n; i++)
    		max = Math.max(max, arr[i-1]-arr[i]-c);
    	System.out.println(max);
    }
}
