import java.util.*;

public class Main {
        
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	while(s.hasNext()) {
    		int n = s.nextInt();
    		int m = s.nextInt();
    		int t = s.nextInt();
    		int beer = -1;
    		int burger = -1;
    		for(int i=0; i<=t; i++) {
    			int left = i;
    			int right = t-i;
    			int temp = (left/n) + (right/m);
    			if(beer == -1) {
    				beer = left%n + right%m;
    				burger = temp;
    			}
    			else if(beer > left%n + right%m) {
    				beer = left%n + right%m;
    				burger = temp;
    			}
    			else if(beer == left%n + right%m && burger < temp)
    				burger = temp;
    		}
    		if(beer == 0)
    			System.out.println(burger);
    		else
    			System.out.println(burger + " " + beer);
    	}
    }
}
