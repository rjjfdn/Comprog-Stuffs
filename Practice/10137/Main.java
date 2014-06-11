import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	while(true) {
    		int n = s.nextInt();
    		if(n == 0)
    			break;
    		double[] arr = new double[n];
    		double ave = 0;
    		for(int i=0; i<n; i++) {
    			arr[i] = s.nextDouble();
				ave += arr[i];
    		}
    		ave = Math.round(ave/n*100)/100.0;
    		double minA=0, maxA=0;
    		for(int i=0; i<n; i++) {
    			if(arr[i] < ave)
    				maxA += ave-arr[i];
    			else
    				minA += arr[i]-ave;
    		}
    		System.out.format("$%.2f\n", Math.min(maxA, minA));
    	}
    }
}
