import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	while(true) {
    		int n = s.nextInt();
    		if(n < 0)
    			break;
    		if(n == 1)
    			System.out.println(0 + "%");
    		else {
    			n--;
    			long an = 25;
    			an *= (n - 1);
    			an += 50;
    			System.out.println(an + "%");
    		}
    	}
    }
}
