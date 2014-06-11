import java.util.*;

public class Main {
        
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	while(s.hasNext()) {
    		double a = s.nextDouble();
    		double b = s.nextDouble();
    		double c = s.nextDouble();
    		if(a==0 || b==0 || c==0) {
    			System.out.printf("The radius of the round table is: %.3f\n", 0.0);
    			continue;
    		}
    		double sup = (a+b+c)/2.0;
    		double area = Math.sqrt(sup*(sup-a)*(sup-b)*(sup-c));
    		System.out.printf("The radius of the round table is: %.3f\n", (2*area)/(a+b+c));
    	}
    }
}
