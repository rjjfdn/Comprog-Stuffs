import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	while(true) {
    		int x = s.nextInt();
    		int y = s.nextInt();
    		if(x == 0 && y == 0)
    			break;
    		int[][] matrix = new int[x][y];
    		int n = s.nextInt();
    		for(int i=0; i<n; i++) {
    			int m = s.nextInt();
    			int o = s.nextInt();
    			for(int j=0; j<o; j++) {
    				int p = s.nextInt();
    				matrix[m][p] = 1;
    			}
    		}
    		int sx = s.nextInt();
    		int sy = s.nextInt();
    		int tx = s.nextInt();
    		int ty = s.nextInt();
    		Queue<Integer> qx = new LinkedList<Integer>();
    		Queue<Integer> qy = new LinkedList<Integer>();
    		Queue<Integer> qc = new LinkedList<Integer>();
    		qx.add(sx);
    		qy.add(sy);
    		qc.add(0);
    		matrix[sx][sy] = 1;
    		while(qx.size() != 0) {
    			int xx = qx.remove();
    			int yy = qy.remove();
    			int cc = qc.remove();
    			if(xx == tx && yy == ty) {
    				System.out.println(cc);
    				break;
    			}
    			int[] xxx = {0, 1, 0, -1};
    			int[] yyy = {1, 0, -1, 0};
    			for(int i=0; i<4; i++) {
    				if(xx+xxx[i] >= 0 && xx+xxx[i] < x)
    					if(yy+yyy[i] >=0 && yy+yyy[i] < y)
    						if(matrix[xx+xxx[i]][yy+yyy[i]] != 1) {
    							matrix[xx+xxx[i]][yy+yyy[i]] = 1;
    							qx.add(xx+xxx[i]);
    							qy.add(yy+yyy[i]);
    							qc.add(cc+1);
    						}
    			}
    		}
    	}
    }
}
