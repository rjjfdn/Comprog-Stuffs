import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(new FileReader("pi.in"));
    	int n = s.nextInt();
    	for(int q=0; q<n; q++) {
    		int x1 = s.nextInt();
    		int y1 = s.nextInt();
    		int x2 = s.nextInt();
    		int y2 = s.nextInt();
    		int x3 = s.nextInt();
    		int y3 = s.nextInt();
    		Vec ab = new Vec(x1, y1, x2, y2);
    		Vec bc = new Vec(x2, y2, x3, y3);
    		Vec ca = new Vec(x3, y3, x1, y1);
    		int count = 0;
    		for(int i=0; i<=100; i++)
    			for(int j=0; j<=100; j++) {
    				Vec ap = new Vec(x1, y1, i, j);
    				Vec bp = new Vec(x2, y2, i, j);
    				Vec cp = new Vec(x3, y3, i, j);
    				int[] c = new int[3];
    				c[0] = Vec.cross(ap, ab);
    				c[1] = Vec.cross(bp, bc);
    				c[2] = Vec.cross(cp, ca);
    				int pos = 0;
    				int neg = 0;
    				int zer = 0;
    				for(int k=0; k<3; k++) {
    					if(c[k] > 0)
    						pos++;
    					if(c[k] == 0)
    						zer++;
    					if(c[k] < 0)
    						neg++;
    				}
    				if(neg == 3 || pos == 3)
   						count++;
    			}
    		System.out.println(count);
    	}
    }
}

class Vec {
	
	int x, y;
	
	public Vec(int a, int b, int c, int d) {
		x = c-a;
		y = d-b;
	}
	
	public static int cross(Vec a, Vec b) {
		return a.x*b.y - b.x*a.y;
	}
}