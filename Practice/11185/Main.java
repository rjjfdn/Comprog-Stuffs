import java.util.*;

public class Main {
 
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	while(true) {
    		int n = s.nextInt();
    		if(n < 0)
    			break;
    		System.out.println(Integer.toString(n, 3));
    	}
    }
}
