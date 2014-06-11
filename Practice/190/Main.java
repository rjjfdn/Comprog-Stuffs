import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	while(s.hasNext()) {
    		double a = s.nextDouble();
    		double b = s.nextDouble();
    		double c = s.nextDouble();
    		double d = s.nextDouble();
    		double e = s.nextDouble();
    		double f = s.nextDouble();
    		if(b-d == 0 || b-f == 0) {
    			if(b==d) {
    				double temp = a;
    				a = e;
    				e = temp;
    				temp = b;
    				b = f;
    				f = temp;
    			}
    			else {
    				double temp = a;
    				a = c;
    				c = temp;
    				temp = b;
    				b = d;
    				d = temp;
    			}
    		}
    		double num = ((e*e + f*f - a*a - b*b)/(2*f-2*b)) - ((c*c + d*d - a*a - b*b)/(2*d-2*b));
    		double den = ((a-c)/(d-b) - (a-e)/(f-b));
    		double x = num/den;
    		double y = (2*a*x - a*a - b*b - 2*c*x + c*c + d*d)/(2*d - 2*b);
    		double r = Math.sqrt((x-a)*(x-a) + (y-b)*(y-b));
    		double xx = -2*x;
    		double yy = -2*y;
    		double cc = x*x + y*y - r*r;
    		System.out.printf("(x %s %.3f)^2 + (y %s %.3f)^2 = %.3f^2\n", (x<0)?"+":"-", Math.abs(x), (y<0)?"+":"-", Math.abs(y), r);
    		System.out.printf("x^2 + y^2 %s %.3fx %s %.3fy %s %.3f = 0\n", (xx<0)?"-":"+", Math.abs(xx), (yy<0)?"-":"+", Math.abs(yy), (cc<0)?"-":"+", Math.abs(cc));
    		System.out.println();
    	}
    }
}
