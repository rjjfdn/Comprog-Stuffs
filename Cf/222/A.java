import java.util.*;

public class A {
        
    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(System.in);
    	int a = s.nextInt();
    	int b = s.nextInt();
    	int c = 0, d = 0, e = 0;
    	for(int i=1; i<=6; i++) {
    		int f = Math.abs(a-i);
    		int g = Math.abs(b-i);
    		if(f < g)
    			c++;
    		else if(f == g)
    			d++;
    		else
    			e++;
    	}
    	System.out.println(c + " " + d + " " + e);
    }
}
