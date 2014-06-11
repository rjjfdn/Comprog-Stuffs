import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	for(int i=0; i<n; i++) {
    		double c = s.nextDouble();
    		double f = 9.0*c/5.0 + 32;
    		double d = s.nextDouble();
    		f += d;
    		double cc = 5.0/9.0*(f-32);
    		System.out.printf("Case %d: %.2f\n", i+1, cc);
    	}
    }
}
