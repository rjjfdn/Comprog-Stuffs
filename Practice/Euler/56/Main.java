import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) {
    	int max = 0;
    	for(int i=1; i<100; i++) {
    		for(int j=1; j<100; j++) {
    			BigInteger num = new BigInteger(""+i).pow(j);
    			int count = 0;
    			char[] arr = num.toString().toCharArray();
    			for(int k=0; k<arr.length; k++)
    				count += (int)(arr[k]-'0');
    			max = Math.max(max, count);
    		}
    	}
    	System.out.println(max);
    }
}
