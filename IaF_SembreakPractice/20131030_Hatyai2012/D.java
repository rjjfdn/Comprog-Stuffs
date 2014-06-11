import java.util.*;
import java.io.*;

public class D {

    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(new FileReader("inputD.txt"));
    	int cases = 1;
    	while(true) {
	    	int n = s.nextInt();
	    	if(n == 0)
	    		break;
	    	System.out.println("Case " + cases++ + ":");
	    	int[] xx = new int[n];
	    	int[] yy = new int[n];
	    	for(int i=0; i<n; i++) {
	    		xx[i] = s.nextInt();
	    		yy[i] = s.nextInt();
	    	}
	    	int ax = s.nextInt();
	    	int ay = s.nextInt();
	    	int bx = s.nextInt();
	    	int by = s.nextInt();
	    	int q = s.nextInt();
	    	Point[] apts = new Point[n];
	    	Point[] bpts = new Point[n];
	    	for(int i=0; i<n; i++) {
	    		apts[i] = new Point(xx[i], yy[i], ax, ay);
	    		bpts[i] = new Point(xx[i], yy[i], bx, by);
	    	}
	    	Arrays.sort(apts);
	    	Arrays.sort(bpts);
	    	for(int i=0; i<q; i++) {
	    		int ra = s.nextInt();
	    		int rb = s.nextInt();
	    		ra = ra;
	    		rb = rb;
	    		int idxa = Arrays.binarySearch(apts, new Point(0, 0, ra, 0));
	    		if(idxa < 0)
	    			idxa = -idxa-1;
	    		else
	    			idxa++;
	    		int idxb = Arrays.binarySearch(bpts, new Point(0, 0, rb, 0));
	    		if(idxb < 0)
	    			idxb = -idxb-1;
	    		else
	    			idxb++;
	    		int ans = n-idxa-idxb;
	    		if(ans < 0)
	    			System.out.println(0);
	    		else
	    			System.out.println(ans);
	    	}
    	}
    }
}

class Point implements Comparable<Point> {
	
	int ad;
	
	public Point(int xx, int yy, int ax, int ay) {
		ad = (xx-ax)*(xx-ax) + (yy-ay)*(yy-ay);
	}
	
	public int compareTo(Point p) {
		return ad - p.ad;
	}
}