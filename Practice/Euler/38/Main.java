import java.util.*;

public class Main {
        
    public static void main(String[] args) {
    	int max = 0;
    	for(int i=9; i<10000; i++) {
    		String num = "";
    		int temp = i;
    		for(int j=1;; j++) {
    			if(num.length() >= 9)
    				break;
    			num += (temp*j);
    		}
    		if(num.length() > 9)
    			continue;
    		char[] arr = num.toCharArray();
    		Arrays.sort(arr);
    		if(new String(arr).equals("123456789"))
    			max = Math.max(max, Integer.parseInt(num));
    	}
    	System.out.println(max);
    }
}
