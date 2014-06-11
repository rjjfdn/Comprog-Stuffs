import java.util.*;
import java.io.*;

public class C {

    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(new FileReader("c.in"));
    	int cases = 0;
    	while(true) {
    		if(cases != 0)
    			System.out.println();
    		cases++;
    		int n = s.nextInt();
    		int m = s.nextInt();
    		if(n == 0 && m == 0)
    			break;
    		int[][] matrix = new int[n][m];
    		boolean[][] visited = new boolean[n][m];
    		for(int i=0; i<n; i++)
    			for(int j=0; j<m; j++) {
    				String tmp = s.next();
    				if(tmp.equals("e")) {
    					matrix[i][j] = 0;
						visited[i][j] = false;
    				}
    				else {
    					matrix[i][j] = Integer.parseInt(tmp);
    					visited[i][j] = true;
    				}
    			}
    		int o = s.nextInt();
    		for(int q=0; q<o; q++) {
    			String tmp = s.next();
    			if(tmp.equals("del")) {
    				String next = s.next();
    				if(next.equals("cell")) {
    					String[] split = s.next().split(":");
    					int r = Integer.parseInt(split[0])-1;
    					int c = Integer.parseInt(split[1])-1;
    					if(r >= 0 && r < n && c >= 0 && c < m) {
    						matrix[r][c] = 0;
    						visited[r][c] = false;
    					}
    				}
    				else if(next.equals("row")) {
    					int r = Integer.parseInt(s.next())-1;
    					if(r >= 0 && r < n) {
    						for(int i=r+1; i<n; i++)
	    						for(int j=0; j<m; j++) {
	    							matrix[i-1][j] = matrix[i][j];
	    							visited[i-1][j] = visited[i][j];
	    						}
	    					for(int j=0; j<m; j++) {
	    						matrix[n-1][j] = 0;
	    						visited[n-1][j] = false;
	    					}
	    					n--;
    					}
    				}
    				else if(next.equals("col")) {
    					int c = Integer.parseInt(s.next())-1;
    					if(c >= 0 && c < m) {
    						for(int i=0; i<n; i++)
    							for(int j=c+1; j<m; j++) {
    								matrix[i][j-1] = matrix[i][j];
    								visited[i][j-1] = visited[i][j];
    							}
    						for(int i=0; i<n; i++) {
    							matrix[i][m-1] = 0;
    							visited[i][m-1] = false;
    						}
    						m--;
    					}
    				}
    			}
    			else if(tmp.equals("modify")) {
    				s.next();
    				String[] split = s.next().split(":");
    				int r = Integer.parseInt(split[0])-1;
    				int c = Integer.parseInt(split[1])-1;
    				int v = Integer.parseInt(s.next());
					if(r >= 0 && r < n && c >= 0 && c < m) {
						matrix[r][c] = v;
						visited[r][c] = true;
					}
    			}
    			else if(tmp.equals("add")) {
    				String next = s.next();
    				if(next.equals("cell")) {
    					String[] split = s.next().split(":");
    					int r1 = Integer.parseInt(split[0])-1;
    					int c1 = Integer.parseInt(split[1])-1;
    					split = s.next().split(":");
    					int r2 = Integer.parseInt(split[0])-1;
    					int c2 = Integer.parseInt(split[1])-1;
    					if(r1 >= 0 && r1 < n && c1 >= 0 && c1 < m)
    						if(r2 >= 0 && r2 < n && c2 >= 0 && c2 < m) {
    							matrix[r1][c1] += matrix[r2][c2];
    							visited[r1][c1] = visited[r1][c1] || visited[r2][c2];
    						}
    				}
    				else if(next.equals("row")) {
    					int r1 = Integer.parseInt(s.next())-1;
    					int r2 = Integer.parseInt(s.next())-1;
    					if(r1 >= 0 && r1 < n && r2 >= 0 && r2 < n)
    						for(int i=0; i<m; i++) {
    							matrix[r1][i] += matrix[r2][i];
    							visited[r1][i] = visited[r1][i] || visited[r2][i];
    						}
    				}
    				else if(next.equals("col")) {
    					int c1 = Integer.parseInt(s.next())-1;
    					int c2 = Integer.parseInt(s.next())-1;
    					if(c1 >= 0 && c1 < m && c2 >= 0 && c2 < m)
    						for(int i=0; i<n; i++) {
    							matrix[i][c1] += matrix[i][c2];
    							visited[i][c1] = visited[i][c1] || visited[i][c2];
    						}
    				}
    			}
    			else if(tmp.equals("sub")) {
    				String next = s.next();
    				if(next.equals("cell")) {
    					String[] split = s.next().split(":");
    					int r1 = Integer.parseInt(split[0])-1;
    					int c1 = Integer.parseInt(split[1])-1;
    					split = s.next().split(":");
    					int r2 = Integer.parseInt(split[0])-1;
    					int c2 = Integer.parseInt(split[1])-1;
    					if(r1 >= 0 && r1 < n && c1 >= 0 && c1 < m)
    						if(r2 >= 0 && r2 < n && c2 >= 0 && c2 < m) {
    							matrix[r1][c1] -= matrix[r2][c2];
    							visited[r1][c1] = visited[r1][c1] || visited[r2][c2];
    						}
    				}
    				else if(next.equals("row")) {
    					int r1 = Integer.parseInt(s.next())-1;
    					int r2 = Integer.parseInt(s.next())-1;
    					if(r1 >= 0 && r1 < n && r2 >= 0 && r2 < n)
    						for(int i=0; i<m; i++) {
    							matrix[r1][i] -= matrix[r2][i];
    							visited[r1][i] = visited[r1][i] || visited[r2][i];
    						}
    				}
    				else if(next.equals("col")) {
    					int c1 = Integer.parseInt(s.next())-1;
    					int c2 = Integer.parseInt(s.next())-1;
    					if(c1 >= 0 && c1 < m && c2 >= 0 && c2 < m)
    						for(int i=0; i<n; i++) {
    							matrix[i][c1] -= matrix[i][c2];
    							visited[i][c1] = visited[i][c1] || visited[i][c2];
    						}
    				}
    			}
    		}
    		if(n == 0 || m == 0)
    			System.out.println("Empty");
    		else {
    			for(int i=0; i<n; i++) {
    				if(visited[i][0])
	    				System.out.print(matrix[i][0]);
	    			else
	    				System.out.print("e");
    				for(int j=1; j<m; j++) {
    					if(visited[i][j])
	    					System.out.print("\t" + matrix[i][j]);
	    				else
	    					System.out.print("\te");
    				}
    				System.out.println();
    			}
    		}
    	}
    }
}
