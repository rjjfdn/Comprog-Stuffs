import java.util.*;
import java.io.*;

public class Main {
        
    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(new FileReader("pg.in"));
    	int cases = 1;
    	while(true) {
    		String line = s.nextLine();
    		if(line.equals("0"))
    			break;
    		Scanner sc = new Scanner(line);
    		int x1 = sc.nextInt();
    		int y1 = sc.nextInt();
    		int x2 = sc.nextInt();
    		int y2 = sc.nextInt();
    		int n = sc.nextInt();
    		int m = (n+1)/2;
    		if(m == 0)
    			m = 5;
    		int[][][][] graph = new int[7][11][7][11];
    		int[] xx = {0,1,0,-1};
    		int[] yy = {1,0,-1,0};
    		for(int i=0; i<=6; i++)
    			for(int j=0; j<=10; j++)
    				for(int k=0; k<4; k++) {
    					int x = i+xx[k];
    					int y = j+yy[k];
    					if(x >= 0 && x <= 6 && y >= 0 && y <= 10) {
    						graph[i][j][x][y] = -1;
    						graph[x][y][i][j] = -1;
    						if(!(x == i && x == m))
    							if(!(y == j && y == n)) {
    								if(y == j) {
    									graph[i][j][x][y] = 1;
    									graph[x][y][i][j] = 1;
    								}
    								else {
    									graph[i][j][x][y] = i;
    									graph[x][y][i][j] = i;
    								}
    							}
    					}
    				}
    		int[][] dist = new int[7][11];
    		for(int i=0; i<=6; i++)
    			for(int j=0; j<=10; j++)
    				dist[i][j] = 2000000000;
    		dist[x1][y1] = 0;
    		Queue<Integer> qx = new LinkedList<Integer>();
    		Queue<Integer> qy = new LinkedList<Integer>();
    		qx.add(x1);
    		qy.add(y1);
    		boolean[][] visited = new boolean[7][11];
    		visited[x1][y1] = true;
    		while(qx.size() != 0) {
    			int x = qx.remove();
    			int y = qy.remove();
    			visited[x][y] = false;
    			for(int i=0; i<4; i++) {
    				int a = x+xx[i];
    				int b = y+yy[i];
    				if(a >= 0 && a <= 6 && b >= 0 && b <= 10)
    					if(graph[x][y][a][b] != -1)
    						if(dist[a][b] > dist[x][y]+graph[x][y][a][b]) {
    							dist[a][b] = dist[x][y]+graph[x][y][a][b];
    							if(!visited[a][b]) {
    								visited[a][b] = true;
    								qx.add(a);
    								qy.add(b);
    							}
    						}
    			}
    		}
    		if(dist[x2][y2] != 2000000000)
	    		System.out.println("Case " + cases++ + ": " + dist[x2][y2]);
	    	else
	    		System.out.println("Case " + cases++ + ": not possible");
    	}
    }
}
