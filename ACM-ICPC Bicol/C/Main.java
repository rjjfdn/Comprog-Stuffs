import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(new FileReader("pc.in"));
    	int n = s.nextInt();
    	for(int i=0; i<n; i++) {
    		double a = s.nextDouble();
    		double b = s.nextDouble();
    		double c = s.nextDouble();
    		double d = s.nextDouble();
    		Vector<Double> answer = new Vector<Double>();
    		HashSet<Double> set = new HashSet<Double>();
    		for(int j=-1000000; j<=1000000; j++) {
    			double val = (((((a*j)+b)*j)+c)*j)+d;
    			if(Double.compare(val, 0.0) == 0) {
    				answer.addElement((double)j);
    				set.add((double)j);
    				double aa = a;
    				double bb = (a*j)+b;
    				double cc = (((a*j)+b)*j)+c;
    				double det = bb*bb - 4*aa*cc;
    				if(det == 0) {
    					double x = -bb/(2*aa);
    					if(x == -0)
    						x = 0;
    					if(set.add(x))
	    					answer.addElement(x);
    				}
    				else if(det > 0) {
    					double x1 = (-bb+Math.sqrt(det))/(2*aa);
    					double x2 = (-bb-Math.sqrt(det))/(2*aa);
    					if(x1 == -0)
    						x1 = 0;
    					if(x2 == -0)
    						x2 = 0;
    					if(set.add(x1))
	    					answer.addElement(x1);
	    				if(set.add(x2))
	    					answer.addElement(x2);
    				}
    				Collections.sort(answer);
    				System.out.printf("%.4f", answer.elementAt(0));
    				for(int k=1; k<answer.size(); k++)
    					System.out.printf(" %.4f", answer.elementAt(k));
    				System.out.println();
    				break;
    			}
    		}
    	}
    }
}
