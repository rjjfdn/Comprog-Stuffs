import java.util.*;

public class Main {

    public static void main(String[] args) {
    	String line = "";
    	for(int i=1;; i++) {
    		line += i;
    		if(line.length() >= 1000000)
    			break;
    	}
    	int prod = 1;
    	char[] arr = line.toCharArray();
    	for(int i=0; i<7; i++)
    		prod *= (int)(arr[(int)Math.pow(10,i)-1]-'0');
    	System.out.println(prod);
    }
}
