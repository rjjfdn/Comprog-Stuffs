import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	for(int i=0; i<n; i++) {
    		int m = s.nextInt();
    		long[] arr = new long[m-1];
    		for(int j=0; j<m-1; j++)
    			arr[j] = s.nextLong();
    		long max = 0, sum = 0;
    		int curx = 1, x = -1, y = -1;
    		for(int j=0; j<m-1; j++) {
    			if(sum+arr[j] < 0) {
    				curx = j+2;
    				sum = 0;
    			}
    			else {
    				sum += arr[j];
    				if(max < sum || (max == sum && curx <= x)) {
    					max = sum;
    					x = curx;
    					y = j;
    				}
    			}
    		}
    		if(max <= 0)
    			System.out.println("Route " + (i+1) + " has no nice parts");
    		else
    			System.out.println("The nicest part of route " + (i+1) + " is between stops " + x + " and " + (y+2));
    	}
    }
}
