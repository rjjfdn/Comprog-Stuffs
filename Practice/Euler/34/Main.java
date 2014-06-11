import java.util.*;

public class Main {

    public static void main(String[] args) {
    	int[] fact = new int[10];
    	fact[0] = 1;
    	fact[1] = 1;
    	for(int i=2; i<10; i++)
    		fact[i] = i*fact[i-1];
    	int ans = 0;
    	for(int i=11; i<100000000; i++) {
    		int sum = 0;
    		int temp = i;
    		while(temp != 0) {
    			sum += fact[temp%10];
    			temp /= 10;
    		}
    		if(i == 145)
    			System.out.println(sum);
    		if(sum == i)
    			ans += sum;
    	}
    	System.out.println(ans);
    }
}
