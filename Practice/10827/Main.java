import java.util.*;

public class Main {
	
	static int[][] matrix;
	static int n;

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int m = s.nextInt();
    	for(int i=0; i<m; i++) {
    		n = s.nextInt();
    		matrix = new int[2*n][2*n];
    		int maxnum = -2000000000;
    		for(int j=0; j<n; j++)
    			for(int k=0; k<n; k++) {
    				matrix[j][k] = s.nextInt();
    				maxnum = Math.max(maxnum, matrix[j][k]);
    				matrix[j+n][k] = matrix[j][k];
    				matrix[j][k+n] = matrix[j][k];
    			}
    		int max = -2000000000;
    		for(int j=0; j<n; j++)
    			max = Math.max(max, maxSum(0,j,n,j+n));
    		for(int j=0; j<n; j++)
    			max = Math.max(max, maxSum(j,0,j+n,n));
    		if(max == 0)
    			System.out.println(maxnum);
    		else
	    		System.out.println(max);
    	}
    }
    
    public static int maxSum(int x, int y, int p, int q) {
    	int[][] mat = new int[n][n];
    	for(int i=x; i<p; i++)
    		for(int j=y; j<q; j++)
    			mat[i-x][j-y] = matrix[i][j];
    	/*for(int i=0; i<n; i++)
    		for(int j=0; j<n; j++) {
    			if(i > 0)
    				mat[i][j] += mat[i-1][j];
    			if(j > 0)
    				mat[i][j] += mat[i][j-1];
    			if(i > 0 && j > 0)
    				mat[i][j] -= mat[i-1][j-1];
    		}*/
    	int max = -2000000000;
    	for(int i=0; i<n; i++) {
    		int[] tmp = new int[n];
    		for(int j=i; j<n; j++) {
    			for(int k=0; k<n; k++)
    				tmp[k] += mat[j][k];
    			int cur = 0;
    			for(int k=0; k<n; k++) {
    				cur = cur + tmp[k];
    				if(max < cur)
    					max = cur;
    				if(cur < 0)
    					cur = 0;
    			}
    		}
    	}
    	return max;
    }
}
