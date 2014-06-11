import java.util.*;
import java.io.*;

public class prob_d {
	
	static int x, y;
	static char[][] matrix;
	static char[][] answer;
	static boolean[][] visited;
	static int ans;

    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(new FileReader("prob_d.in"));
    	int n = s.nextInt();
    	for(int k=0; k<n; k++) {
    		x = s.nextInt();
    		y = s.nextInt();
    		s.nextLine();
    		matrix = new char[x][y];
    		for(int i=0; i<x; i++) {
    			matrix[i] = s.nextLine().toCharArray();
    		}
    		for(int i=0; i<x; i++) {
    			for(int j=0; j<y; j++) {
    				if(matrix[i][j] == '+') {
    					ans = -1;
    					visited = new boolean[x][y];
    					visited[i][j] = true;
    					backtrack(i, j, 0);
    					break;
    				}
    			}
    		}
    		if(ans == -1)
    			System.out.println("Unable to locate");
    		else {
    			for(int i=0; i<x; i++) {
    				System.out.println(new String(answer[i]));
    			}
    		}
    		System.out.println();
    	}
    }
    
    public static void backtrack(int a, int b, int num) {
    	int[] xx = {0, 1, 0, -1};
    	int[] yy = {1, 0, -1, 0};
    	for(int i=0; i<4; i++) {
    		if(a+xx[i] >= 0 && a+xx[i] < x)
    			if(b+yy[i] >=0 && b+yy[i] < y)
    			{
    				if(matrix[a+xx[i]][b+yy[i]] == ' ') {
    					//for(int j=0; j<x; j++)
    					//	System.out.println(new String(matrix[j]));
    					//System.out.println();
	    				if(!visited[a+xx[i]][b+yy[i]]) {
	    					visited[a+xx[i]][b+yy[i]] = true;
	    					matrix[a+xx[i]][b+yy[i]] = '+';
	    					backtrack(a+xx[i], b+yy[i], num+1);
	    					visited[a+xx[i]][b+yy[i]] = false;
	    					matrix[a+xx[i]][b+yy[i]] = ' ';
	    				}
    				}
	    			else if(matrix[a+xx[i]][b+yy[i]] == '@') {
	    				//System.out.println(ans + " " + num);
	    				if(ans == -1 || (ans != -1 && ans > num)) {
	    					ans = num;
		    				answer = new char[x][y];
		    				for(int q=0; q<x; q++)
		    					answer[q] = new String(matrix[q]).toCharArray();
	    				}
	    			}
    			}
    	}
    }
}
