import java.util.*;

public class Main {

    public static void main(String[] args) {
    	int max = 0;
    	int num = 0;
    	for(int p=3; p<=1000; p++) {
    		int count = 0;
    		for(int i=1; i<p; i++) {
    			for(int j=1; j<i; j++) {
    				int k = p-i-j;
    				if(k < 0)
    					continue;
					if(i*i == j*j + k*k) {
						System.out.println(j + " " + k + " " + i);
						count++;
					}
    			}
    		}
    		if(max < count) {
    			max = count;
    			num = p;
    		}
    	}
    	System.out.println(num + " " + max);
    }
}
