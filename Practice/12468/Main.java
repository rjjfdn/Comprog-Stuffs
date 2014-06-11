import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	while(true) {
    		int n = s.nextInt();
    		int m = s.nextInt();
    		if(n == -1 && m == -1)
    			break;
    		int min = Math.min(n, m);
    		int max = Math.max(n, m);
    		System.out.println(Math.min(max-min, min-max+100));
    	}
    }
}
