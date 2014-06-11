import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	for(int i=0; i<n; i++) {
    		int m = s.nextInt();
    		char[][] matrix = new char[m][m];
    		for(int j=0; j<m; j++)
    			matrix[j] = s.next().toCharArray();
    		int startx, starty, endx, endy;
    		startx = starty = endx = endy = -1;
    		int count = 0;
    		for(int j=0; j<m; j++) {
    			for(int k=0; k<m; k++) {
    				if(matrix[j][k] == '#') {
    					count++;
    					if(startx == -1) {
	    					startx = j;
	    					starty = k;
    					}
    				}
    			}
    		}
    		if(Math.sqrt(count) != (int)Math.sqrt(count)) {
    			System.out.println("Case #" + (i+1) + ": NO");
    			continue;
    		}
    		count = (int)Math.sqrt(count);
    		boolean check = false;
    		Queue<Integer> qx = new LinkedList<Integer>();
    		Queue<Integer> qy = new LinkedList<Integer>();
    		qx.add(startx);
    		qy.add(starty);
    		while(qx.size() != 0) {
    			int xx = qx.remove();
    			int yy = qy.remove();
    			if(xx+1 < m) {
    				if(matrix[xx+1][yy] == '#') {
    					qx.add(xx+1);
    					qy.add(yy);
    					endx = Math.max(xx+1, endx);
    				}
    			}
    			if(yy+1 < m) {
    				if(matrix[xx][yy+1] == '#') {
    					qx.add(xx);
    					qy.add(yy+1);
    					endy = Math.max(yy+1, endy);
    				}
    			}
    		}
    		if(endx == startx+count-1 && endy == starty+count-1)
    			System.out.println("Case #" + (i+1) + ": YES");
    		else
    			System.out.println("Case #" + (i+1) + ": NO");
    	}
    }
}
