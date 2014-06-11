import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	System.out.println("INTERSECTING LINES OUTPUT");
    	for(int i=0; i<n; i++) {
    		int x1 = s.nextInt();
    		int y1 = s.nextInt();
    		int x2 = s.nextInt();
    		int y2 = s.nextInt();
    		int x3 = s.nextInt();
    		int y3 = s.nextInt();
    		int x4 = s.nextInt();
    		int y4 = s.nextInt();
    		Line one = new Line(x1, y1, x2, y2);
    		Line two = new Line(x3, y3, x4, y4);
    		if(!one.isIntersect(two)) {
    			if(Double.compare(one.c, two.c) == 0)
    				System.out.println("LINE");
    			else
	    			System.out.println("NONE");
    		}
    	}
    	System.out.println("END OF OUTPUT");
    }
}

class Line {
	
	double a, b, c;
	final double EPS = 1e-9;
	
	public Line(int x1, int y1, int x2, int y2) {
		if(Math.abs(x1-x2) == 0) {
			a = 1;
			b = 0;
			c = -x1;
		}
		else {
			a = -(double)(y1-y2)/(x1-x2);
			b = 1;
			c = -(double)(a*x1) - y1;
		}
	}
	
	public boolean isParallel(Line l) {
		return Math.abs(a-l.a) < EPS && Math.abs(b-l.b) < EPS;
	}
	
	public boolean isIntersect(Line l) {
		if(isParallel(l))
			return false;
		double x = (l.b*c - b*l.c)/(l.a*b - a*l.b);
		double y;
		if(Math.abs(b) > EPS)
			y = -(a*x + c);
		else
			y = -(l.a*x + l.c);
		System.out.printf("POINT %.2f %.2f\n", x, y);
		return true;
	}
}