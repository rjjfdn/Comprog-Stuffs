import java.util.*;

public class Main {
	
	static char[][] matrix;
	static int m;

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	for(int i=0; i<n; i++) {
    		m = s.nextInt();
    		matrix = new char[m][m];
    		int count = 0;
    		for(int j=0; j<m; j++) {
    			matrix[j] = s.next().toCharArray();
    			for(int k=0; k<m; k++)
    				if(matrix[j][k] == '.')
    					count++;
    		}
    		if(count%5 != 0) {
    			System.out.println("Case " + (i+1) + ": Not Possible!");
    			continue;
    		}
    		boolean check = false;
    		for(int j=0; j<m; j++) {
    			for(int k=0; k<m; k++) {
    				if(matrix[j][k] == '.') {
    					if(j+2 < m && k-1 >= 0 && k+1 < m) {
    						if(!(matrix[j][k] == '.' &&
    							matrix[j+1][k] == '.' &&
    							matrix[j+2][k] == '.' &&
    							matrix[j+1][k-1] == '.' &&
    							matrix[j+1][k+1] == '.')) {
    								check = true;
    								break;
    							}
    						char adj = check(j, k, j+2, k, j+1, k-1, j+1, k+1);
    						if(adj == 'S') {
    							check = true;
    							break;
    						}
    						matrix[j][k] = adj;
    						matrix[j+1][k] = adj;
    						matrix[j+2][k] = adj;
    						matrix[j+1][k-1] = adj;
    						matrix[j+1][k+1] = adj;
    						count -= 5;
    					}
    					else {
    						check = true;
    						break;
    					}
    				}
    			}
    			if(check)
    				break;
    		}
    		if(check)
    			System.out.println("Case " + (i+1) + ": Not Possible!");
    		else if(count == 0) {
    			System.out.println("Case " + (i+1) + ":");
    			for(int j=0; j<m; j++)
    				System.out.println(new String(matrix[j]));
    		}
    		else
    			System.out.println("Case " + (i+1) + ": Not Possible!");
    	}
    }
    
    public static char check(int i1, int i2, int j1, int j2, int k1, int k2, int l1, int l2) {
    	boolean b = false;
    	boolean c = false;
    	boolean d = false;
    	int[] x = {0,1,0,-1,1,1,-1,-1};
    	int[] y = {1,0,-1,0,1,-1,1,-1};
    	for(int q=0; q<8; q++) {
    		if(i1+x[q] >= 0 && i1+x[q] < m && i2+y[q] >= 0 && i2+y[q] < m)
    			switch(matrix[i1+x[q]][i2+y[q]]) {
    				case 'B':
    					b = true;
    					break;
    				case 'C':
    					c = true;
    					break;
    				case 'D':
    					d = true;
    					break;
    			}
    		if(j1+x[q] >= 0 && j1+x[q] < m && j2+y[q] >= 0 && j2+y[q] < m)
    			switch(matrix[j1+x[q]][j2+y[q]]) {
    				case 'B':
    					b = true;
    					break;
    				case 'C':
    					c = true;
    					break;
    				case 'D':
    					d = true;
    					break;
    			}
    		if(k1+x[q] >= 0 && k1+x[q] < m && k2+y[q] >= 0 && k2+y[q] < m)
    			switch(matrix[k1+x[q]][k2+y[q]]) {
    				case 'B':
    					b = true;
    					break;
    				case 'C':
    					c = true;
    					break;
    				case 'D':
    					d = true;
    					break;
    			}
    		if(l1+x[q] >= 0 && l1+x[q] < m && l2+y[q] >= 0 && l2+y[q] < m)
    			switch(matrix[l1+x[q]][l2+y[q]]) {
    				case 'B':
    					b = true;
    					break;
    				case 'C':
    					c = true;
    					break;
    				case 'D':
    					d = true;
    					break;
    			}
    	}
    	if(!b)
    		return 'B';
    	if(!c)
    		return 'C';
    	if(!d)
    		return 'D';
    	return 'S';
    }
}
