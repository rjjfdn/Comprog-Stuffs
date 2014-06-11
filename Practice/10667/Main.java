import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	for(int i=0; i<n; i++) {
    		int m = s.nextInt();
    		int[][] matrix = new int[m][m];
    		for(int j=0; j<m; j++)
    			for(int k=0; k<m; k++)
    				matrix[j][k] = 1;
    		int o = s.nextInt();
    		for(int j=0; j<o; j++) {
    			int r1 = s.nextInt();
    			int c1 = s.nextInt();
    			int r2 = s.nextInt();
    			int c2 = s.nextInt();
    			for(int k=r1-1; k<r2; k++)
    				for(int l=c1-1; l<c2; l++)
    					matrix[k][l] = 0;
    		}
    		for(int j=0; j<m; j++)
    			for(int k=0; k<m; k++) {
    				if(j > 0)
    					matrix[j][k] += matrix[j-1][k];
    				if(k > 0)
    					matrix[j][k] += matrix[j][k-1];
    				if(j > 0 && k > 0)
    					matrix[j][k] -= matrix[j-1][k-1];
    			}
    		int max = 0;
    		for(int j=0; j<m; j++)
    			for(int k=0; k<m; k++)
    				for(int a=j; a<m; a++)
    					for(int b=k; b<m; b++) {
    						int temp = matrix[a][b];
    						if(j > 0)
    							temp -= matrix[j-1][b];
    						if(k > 0)
    							temp -= matrix[a][k-1];
    						if(j > 0 && k > 0)
    							temp += matrix[j-1][k-1];
    						if(temp == (a+1-j)*(b+1-k))
    							max = Math.max(max, temp);
    					}
    		System.out.println(max);
    	}
    }
}
