import java.util.*;

public class Main {
        
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	for(int i=0; i<n; i++) {
    		int x = s.nextInt();
    		int y = s.nextInt();
    		int z = s.nextInt();
    		long[][][] matrix = new long[x][y][z];
    		for(int j=0; j<x; j++)
    			for(int k=0; k<y; k++)
    				for(int l=0; l<z; l++)
    					matrix[j][k][l] = s.nextLong();
    		long maxx = -2000000000;
    		long[] tmpb = new long[z];
    		long[] tmpc = new long[z];
    		for(int j=0; j<x; j++)
    			for(int k=0; k<y; k++) {
    				for(int l=0; l<z; l++)
    					tmp[l] = 0;
    				for(int a=0; a<x; a++) {
    					for(int b=0; b<y; b++)
    						for(int c=0; c<z; c++)
    							tmp[c] += matrix[a][b][c];
						long cur=0, max=0;
						for(int c=0; c<z; c++) {
							cur = cur+tmp[c];
							if(max < cur)
								max = cur;
							if(cur < 0)
								cur = 0;
						}
						if(maxx < max)
							maxx = max;
    				}
    			}
    		if(i != 0)
    			System.out.println();
    		System.out.println(maxx);
    	}
    }
}
