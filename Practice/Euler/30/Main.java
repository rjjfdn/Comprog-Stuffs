import java.util.*;

public class Main {
        
    public static void main(String[] args) {
    	int sum = 0;
    	for(int i=2; i<=10000000; i++) {
    		int temp = i;
    		int count = 0;
    		count += Math.pow(temp%10, 5);
    		temp /= 10;
    		count += Math.pow(temp%10, 5);
    		temp /= 10;
    		count += Math.pow(temp%10, 5);
    		temp /= 10;
    		count += Math.pow(temp%10, 5);
    		temp /= 10;
    		count += Math.pow(temp%10, 5);
    		temp /= 10;
    		count += Math.pow(temp%10, 5);
    		temp /= 10;
    		count += Math.pow(temp%10, 5);
    		temp /= 10;
    		count += Math.pow(temp%10, 5);
    		temp /= 10;
    		count += Math.pow(temp%10, 5);
    		temp /= 10;
    		count += Math.pow(temp%10, 5);
    		temp /= 10;
    		count += Math.pow(temp%10, 5);
    		temp /= 10;
    		count += Math.pow(temp%10, 5);
    		temp /= 10;
    		if(count == i) {
    			sum += i;
    			System.out.println(i);
    		}
    	}
    	System.out.println(sum);
    }
}
