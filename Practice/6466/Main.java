import java.util.*;

public class Main {
        
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	for(int i=0; i<n; i++) {
    		int m = s.nextInt();
    		System.out.print(m + " ");
    		double d = s.nextDouble();
    		double a = s.nextDouble();
    		double b = s.nextDouble();
    		double f = s.nextDouble();
    		double ans = 0;
    		boolean check = false;
    		while(true) {
    			double temp = ans;
    			double h;
    			if(d < 1e-9)
    				break;
    			if(!check)
    				h = d/(f+b);
    			else
    				h = d/(f+a);
    			ans += h*f;
    			d -= (h*a+h*b);
    			check = !check;
    		}
    		System.out.format("%.2f\n", ans);
    	}
    }
}
