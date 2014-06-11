import java.util.*;

public class Main {

    public static void main(String[] args) {
    	int sum = 0;
    	for(int i=1; i<=10000; i++) {
    		int a = getSum(i);
    		int b = getSum(a);
    		if(a != i && b == i)
    			sum += i;
    	}
    	System.out.println(sum);
    }
    
    public static int getSum(int n) {
    	int count = 0;
    	for(int i=1; i<=n/2; i++)
    		if(n%i == 0)
    			count += i;
    	return count;
    }
}
