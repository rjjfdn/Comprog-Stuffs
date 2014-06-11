import java.util.*;

public class Main {
        
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	while(s.hasNext()) {
    		long n = s.nextLong()/2 + 1;
    		System.out.println(3*(2*n*n-3));
    	}
    }
}
