import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int[] mid = new int[44800];
    	for(int i=0; i<44800; i++) {
    		mid[i] = i*i - i + 1;
    	}
    	while(true) {
    		int n = s.nextInt();
    		if(n == 0)
    			break;
    		int idx = Arrays.binarySearch(mid, n);
    		if(idx >= 0) {
    			System.out.println(idx + " " + idx);
    			continue;
    		}
    		else { 
    			idx = -idx-1-1;
    			//System.out.println("index: " + idx);
    			int num = idx, den = idx;
    			if(idx%2 == 0) {
    				if(n-mid[idx] <= idx-1) {
    					System.out.println(idx + " " + (idx-(n-mid[idx])));
    					continue;
    				}
    				else {
    					idx++;
    					System.out.println(idx + " " + (idx-(mid[idx]-n)));
    					continue;
    				}
    			}
    			else {
    				if(n-mid[idx] <= idx-1) {
    					System.out.println((idx-(n-mid[idx])) + " " + idx);
    					continue;
    				}
    				else {
    					idx++;
    					System.out.println((idx-(mid[idx]-n)) + " " + idx);
    					continue;
    				}
    			}
    		}
    	}
    }
}
