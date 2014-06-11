import java.util.*;
import java.io.*;

public class prob_c {

    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(new FileReader("prob_c.in"));
    	int n = s.nextInt();
    	for(int j=0; j<n; j++) {
    		int m = s.nextInt();
    		int k = s.nextInt();
    		if(m == 1)
    			System.out.println(1);
    		else if(k <= 0 || m <= 0 || m > 1000 || k > 10000)
    			System.out.println("none");
    		else
    			System.out.println(josephus(m, k));
    	}
    }
    
    public static int josephus(int n, int k) {
    	if(n == 1)
    		return 1;
    	else
    		return ((josephus(n-1,k)+k-1)%n)+1;
    }
}
