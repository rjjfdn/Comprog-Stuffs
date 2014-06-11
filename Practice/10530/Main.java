import java.util.*;

public class Main {
        
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	while(true) {
    		int n = Integer.parseInt(s.nextLine());
    		if(n == 0)
    			break;
    		int min = 0, max = 11;
    		String line = s.nextLine().trim();
    		boolean ans = true;
    		while(true) {
    			if(line.equals("right on")) {
    				if(min >= n || max <= n)
    					ans = false;
    				break;
    			}
    			if(line.equals("too high")) {
    				if(n <= min)
    					ans = false;
    				else
    					max = Math.min(max, n);
    			}
    			else {
    				if(n >= max)
    					ans = false;
    				else
    					min = Math.max(min, n);
    			}
    			n = Integer.parseInt(s.nextLine());
    			line = s.nextLine().trim();
    		}
    		if(ans)
    			System.out.println("Stan may be honest");
    		else
    			System.out.println("Stan is dishonest");
    	}
    }
}
