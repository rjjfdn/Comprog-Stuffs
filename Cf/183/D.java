import java.util.*;

public class D {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	long n, m, x, y, a, b;
    	n = s.nextLong();
    	m = s.nextLong();
    	x = s.nextLong();
    	y = s.nextLong();
    	a = s.nextLong();
    	b = s.nextLong();
    	long ux = (n-x)/a;
    	long uy = (n-y)/b;
    	long lx = (-x)/a;
    	long ly = (-y)/b;
    	long uxx = Math.min(ux, uy);
    	long lxx = Math.max(lx, ly);
    	System.out.println((x+a*lxx) + " " + (y+b*lxx) + " " + (x+a*uxx) + " " + (y+b*uxx));
    }
}
