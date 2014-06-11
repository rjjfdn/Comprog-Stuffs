import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int cases = 1;
    	while(true) {
    		int m = s.nextInt();
    		int n = s.nextInt();
    		if(n == 0 && m == 0)
    			break;
    		int[] x = new int[m+1];
    		int[] y = new int[n+1];
    		for(int i=1; i<=m; i++)
    			x[i] = s.nextInt();
    		for(int i=1; i<=n; i++)
    			y[i] = s.nextInt();
    		int[][] c = new int[m+1][n+1];
    		for(int i=1; i<=m; i++)
    			for(int j=1; j<=n; j++) {
    				if(x[i] == y[j])
    					c[i][j] = c[i-1][j-1] + 1;
    				else
    					c[i][j] = Math.max(c[i][j-1], c[i-1][j]);
    			}
    		System.out.println("Twin Towers #" + cases++);
			System.out.print("Number of Tiles : ");
    		System.out.println(c[m][n]);
    		System.out.println();
    	}
    }
}
