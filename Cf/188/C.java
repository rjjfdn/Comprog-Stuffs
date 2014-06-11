import java.util.*;
import java.math.*;

public class C {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	double temp = s.nextDouble();
    	double y = s.nextDouble();
    	double m = s.nextDouble();
    	double count = 0;
    	double x = Math.min(temp, y);
    	y = Math.max(temp, y);
    	if(m <= x && m <= y) {
    		System.out.println(0);
    		System.exit(0);
    	}
    	if(x <= 0 && y <= 0) {
    		System.out.println(-1);
    		System.exit(0);
    	}
    	double c = Math.ceil(-x/y);
    	x += y*c;
    	double d = y-x;
    	if(d == 0) {
    		c += 3;
			d = 2;
    	}
    	double f = -d/(1-((1+Math.sqrt(5))/2));
    	System.out.println(d + " " + x + " " + y + " " + f);
    	double pos = Math.floor(Math.log(m*Math.sqrt(5))/Math.log(((1+Math.sqrt(5))/2))+0.5);
    	System.out.println(c + " " + pos);
    }
}
