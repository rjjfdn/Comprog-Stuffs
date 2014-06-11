import java.util.*;
import java.math.*;

public class Main {
        
    public static void main(String[] args) {
    	String line = new BigInteger("2").pow(1000).toString();
    	int sum = 0;
    	for(int i=0; i<line.length(); i++) {
    		sum += (line.charAt(i)-'0');
    	}
    	System.out.println(sum);
    }
}
