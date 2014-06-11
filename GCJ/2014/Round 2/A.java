import java.util.*;
import java.io.*;

public class A {

    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(new FileReader("a2.in"));
    	PrintWriter p = new PrintWriter(new FileWriter("a.out"));
    	int t = s.nextInt();
    	for(int i=0; i<t; i++) {
    		int n = s.nextInt();
    		int[] arr = new int[n];
    		int x = s.nextInt();
    		for(int j=0; j<n; j++)
    			arr[j] = s.nextInt();
    		Arrays.sort(arr);
    		int count = 0;
    		int k = 0;
    		for(int j=arr.length-1; j>=0; j--) {
    			if(j < k)
    				break;
    			else if(j == k)
    				count++;
    			else if(arr[j]+arr[k] <= x) {
    				count++;
    				k++;
    			}
    			else count++;
    		}
    		p.println("Case #" + (i+1) + ": " + count);
    	}
    	p.close();
    }
}
