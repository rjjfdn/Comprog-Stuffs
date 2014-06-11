import java.util.*;
import java.io.*;
import java.math.*;

public class A {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	int[] arr = new int[n+1];
    	int[] run = new int[n+1];
    	int sum = 0;
    	for(int i=1; i<=n; i++) {
    		arr[i] = s.nextInt();
    		sum += arr[i];
    	}
    	int max = 0;
    	for(int i=1; i<=n; i++) {
    		for(int j=i; j<=n; j++) {
    			int count = 0;
    			for(int k=1; k<=n; k++) {
    				if(k >= i && k <= j)
    					count += (1-arr[k]);
    				else
    					count += arr[k];
    			}
    			max = Math.max(max, count);
    		}
    	}
    	System.out.println(max);
    }
}
