import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	while(true) {
    		int tmp = s.nextInt();
    		int tmp2 = s.nextInt();
    		if(tmp == 0 && tmp2 == 0)
    			break;
    		int x = Math.min(tmp, tmp2);
    		int y = Math.max(tmp, tmp2);
    		int ans = 0;
    		if(x == 1)
    			ans = y;
    		else if(x == 2) {
    			ans += y/4*4;
    			if(y%4 == 1)
    				ans += 2;
    			else if(y%4 != 0)
    				ans += 4;
    		}
    		else {
    			if(x%2 == 1 && y%2 == 1)
    				ans = x*y/2 + 1;
    			else
    				ans = x*y/2;
    		}
    		System.out.println(ans + " knights may be placed on a " + tmp + " row " + tmp2 + " column board.");
    	}
    }
}
