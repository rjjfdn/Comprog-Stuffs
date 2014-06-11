import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	while(s.hasNext()) {
			double B = Math.PI/4.0;
			double C = Math.PI/3.0 - Math.sqrt(3.0)/4.0;
			double x = 1-B-B+C;
    		double a = s.nextDouble();
    		x = a*a*x;
    		double y = a*a*(B-C)-x;
    		double z = a*a-4*x-4*y;
    		System.out.printf("%.3f %.3f %.3f\n", z, 4*y, 4*x);
    	}
    }
}
