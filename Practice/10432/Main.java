import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	while(s.hasNext()) {
    		double r = s.nextDouble();
    		double n = s.nextDouble();
    		double A = 360/n;
    		double pi = Math.acos(-1);
    		//System.out.println(pi);
    		double B = (180-A)/2.0;
    		//System.out.println(A + " " + (A*pi/180.0) + " " + pi);
    		double a = Math.sin(A*pi/180)*r/Math.sin(B*pi/180);
    		double su = (r+r+a)/2.0;
    		//System.out.println(su + " " + r + " " + a);
    		//System.out.println(r + " " + n + " " + A + " " + a + " " + su + " " + Math.sqrt(su) * Math.sqrt(su-r) * Math.sqrt(su-r) * (su-a)));
    		//System.out.println(A);
    		double area = Math.sqrt(su) * Math.sqrt(su-r) * Math.sqrt(su-r) * Math.sqrt(su-a) * n;
    		//System.out.println(area);
    		System.out.printf("%.3f\n", area);
    	}
    }
}
