import java.util.*;
import java.io.*;

public class J {

    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(new FileReader("j.in"));
    	while(true) {
    		String tmp = s.next();
    		int n = s.nextInt();
    		if(tmp.equals("X") && n == 0)
    			break;
    		System.out.print("Set " + tmp + ": ");
    		Point[] pts = new Point[n];
    		for(int i=0; i<n; i++) {
    			int x = s.nextInt();
    			int y = s.nextInt();
    			pts[i] = new Point(x, y);
    		}
    		GrahamScan ans = new GrahamScan(pts);
    		System.out.print(ans.hull.size());
    		Vector<Point> p = (Vector<Point>) ans.hull();
    		System.out.println(" " + area(p));
    	}
    }
    
    public static double area(Vector<Point> p) {
    	double result = 0;
    	double x1, y1, x2, y2;
    	for(int i=0; i<p.size(); i++) {
    		x1 = p.elementAt(i).x;
    		x2 = p.elementAt((i+1) % p.size()).x;
    		y1 = p.elementAt(i).y;
    		y2 = p.elementAt((i+1) % p.size()).y;
    		result += (x1 * y2 - x2 * y1);
    	}
    	return Math.abs(result)/2.0;
    }
}

class GrahamScan {
	
	Stack<Point> hull = new Stack<Point>();
	
	public GrahamScan(Point[] pts) {
		int n = pts.length;
		Point[] points = new Point[n];
		for(int i=0; i<n; i++)
			points[i] = pts[i];
			
		for(int i=0; i<n; i++)
			for(int j=i+1; j<n; j++)
				if(points[i].compareTo(points[j]) > 0) {
					Point tmp = points[i];
					points[i] = points[j];
					points[j] = tmp;
				}
		
		Arrays.sort(points, 1, n, points[0].POLAR_ORDER);
		hull.push(points[0]);
		
		int k1;
		for(k1=1; k1<n; k1++)
			if(!points[0].equals(points[k1]))
				break;
		if(k1 == n)
			return;
		
		int k2;
		for(k2=k1+1; k2<n; k2++)
			if(Point.ccw(points[0], points[k1], points[k2]) != 0)
				break;
		hull.push(points[k2-1]);
		
		for(int i=k2; i<n; i++) {
			Point top = hull.pop();
			while(Point.ccw(hull.peek(), top, points[i]) <= 0)
				top = hull.pop();
			hull.push(top);
			hull.push(points[i]);
		}
	}
	
	public Iterable<Point> hull() {
		Stack<Point> s = new Stack<Point>();
		for(Point p : hull)
			s.push(p);
		return s;
	}
}

class Point implements Comparable<Point> {
	
	double x, y;
	final Comparator<Point> POLAR_ORDER = new PolarOrder();
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public static int ccw(Point a, Point b, Point c) {
		double area2 = (b.x-a.x)*(c.y-a.y) - (b.y-a.y)*(c.x-a.x);
		if(area2 < 0)
			return -1;
		else if(area2 > 0)
			return 1;
		else
			return 0;
	}
	
	public int compareTo(Point p) {
		if(Double.compare(y, p.y) != 0)
			return Double.compare(y, p.y);
		else
			return Double.compare(x, p.x);
	}
	
	private class PolarOrder implements Comparator<Point> {
		public int compare(Point q1, Point q2) {
			double dx1 = q1.x-x;
			double dy1 = q1.y-y;
			double dx2 = q2.x-x;
			double dy2 = q2.y-y;
			
			if(dy1 >= 0 && dy2 < 0)
				return -1;
			else if(dy2 >= 0 && dy1 < 0)
				return 1;
			else if(dy1 == 0 && dy2 == 0) {
				if(dx1 >= 0 && dx2 < 0)
					return -1;
				else if(dx2 >= 0 && dx1 < 0)
					return 1;
				else return 0;
			}
			else return -ccw(Point.this, q1, q2);
		}
	}
}