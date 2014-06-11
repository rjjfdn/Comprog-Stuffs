import java.util.*;

public class Main {

    public static void main(String[] args) {
    	int sum = 0;
    	for(int i=0; i<1000000; i++) {
    		if(palindrome(""+i) && palindrome(Integer.toString(i, 2)))
    			sum += i; 
    	}
    	System.out.println(sum);
    }
    
    public static boolean palindrome(String str) {
    	return str.equals(new StringBuffer(str).reverse().toString());
    }
}
