import java.util.*;

public class Main {
	
	static boolean[][] visited;
	static int[][] matrix;
	static int count, x, y;
	
	public static void dfs(int i, int j) {
		int[] xx = {0,1,0,-1};
		int[] yy = {1,0,-1,0};
		boolean check = false;
		for(int k=0; k<4; k++)
			if(i+xx[k] >= 0 && i+xx[k] < x)
				if(j+yy[k] >= 0 && j+yy[k] < y)
					if(!visited[i+xx[k]][j+yy[k]])
						if(matrix[i][j] > matrix[i+xx[k]][j+yy[k]]) {
							visited[i][j] = true;
							dfs(i+xx[k], j+yy[k]);
							visited[i][j] = false;
							check = true;
						}
		if(!check)
			count++;
	}
	
	public static boolean extend(int i, int j) {
		int[] xx = {0,1,0,-1};
		int[] yy = {1,0,-1,0};
		for(int k=0; k<4; k++)
			if(i+xx[k] >= 0 && i+xx[k] < x)
				if(j+yy[k] >= 0 && j+yy[k] < y)
					if(matrix[i][j] < matrix[i+xx[k]][j+yy[k]])
						return true;
		return false;
	}

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	for(int i=0; i<n; i++) {
    		x = s.nextInt();
    		y = s.nextInt();
    		matrix = new int[x][y];
    		count = 0;
    		for(int j=0; j<x; j++)
    			for(int k=0; k<y; k++)
    				matrix[j][k] = s.nextInt();
    		for(int j=0; j<x; j++)
    			for(int k=0; k<y; k++)
					if(!extend(j, k)) {
						visited = new boolean[x][y];
    					dfs(j, k);
					}
    		System.out.println("Case #" + (i+1) + ": " + count);
    	}
    }
}
