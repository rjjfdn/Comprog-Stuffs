import java.util.*;

public class C {
	
	static int n, m, k;
        
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	n = s.nextInt();
    	m = s.nextInt();
    	k = s.nextInt();
    	char[][] maze = new char[n][m];
    	for(int i=0; i<n; i++)
    		maze[i] = s.next().toCharArray();
    	boolean[][] visited = new boolean[n][m];
    	boolean check = false;
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<m; j++)
    			if(maze[i][j] != '#') {
    				dfs(maze, visited, i, j);
    				check = true;
    				break;
    			}
    		if(check)
    			break;
    	}
    	for(int i=0; i<n; i++)
    		System.out.println(new String(maze[i]));
    }
    
    public static void dfs(char[][] maze, boolean[][] visited, int x, int y) {
    	if(k == 0)
    		return;
    	visited[x][y] = true;
    	int[] xx = {0,1,0,-1};
    	int[] yy = {1,0,-1,0};
    	for(int i=0; i<4; i++)
    		if(x+xx[i] >= 0 && x+xx[i] < n)
    			if(y+yy[i] >= 0 && y+yy[i] < m)
    				if(maze[x+xx[i]][y+yy[i]] != '#')
	    				if(!visited[x+xx[i]][y+yy[i]])
    						dfs(maze, visited, x+xx[i], y+yy[i]);
    	if(k == 0)
    		return;
    	k--;
    	maze[x][y] = 'X';
    }
}
