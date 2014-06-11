import java.util.*;

public class Main {
	
	static int x, y, d;

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	while(s.hasNext()) {
    		int a = s.nextInt();
    		int b = s.nextInt();
    		extendedEuclid(a, b);
    		System.out.println(x + " " + y + " " + d);
    	}
    }
    
    public static void extendedEuclid(int a, int b) {
    	if(b == 0) {
    		x = 1;
    		y = 0;
    		d = a;
    		return;
    	}
    	extendedEuclid(b, a%b);
    	int x1 = y;
    	int y1 = x-(a/b)*y;
    	x = x1;
    	y = y1;
    }
}
