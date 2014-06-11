import java.util.*;
import java.io.*;

public class H {
	
	static int[][][] table;

    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(new FileReader("h.in"));
    	int n = s.nextInt();
    	for(int i=0; i<n; i++) {
    		int C = s.nextInt();
    		int P = s.nextInt();
    		int N = s.nextInt();
    		int D = s.nextInt();
    		table = new int[C+100][N+100][D+100];
    		int ans = backtrack(C, P, N, D);
    		System.out.println(ans);
    	}
    }
    
    public static int backtrack(int c, int p, int n, int d) {
    	if(c == 0)
    		return 0;
    	if(table[c][n][d] != 0)
    		return table[c][n][d];
    	int min = 2000000000;
    	if(d >= 1)
    		min = Math.min(min, backtrack(c-1, p+2, n, d-1)+1);
    	if(n >= 2)
    		min = Math.min(min, backtrack(c-1, p+2, n-2, d)+2);
    	if(d >= 1 && p >= 3)
    		min = Math.min(min, backtrack(c-1, p-3, n+1, d-1)+4);
    	if(n >= 1 && p >= 3)
    		min = Math.min(min, backtrack(c-1, p-3, n-1, d)+4);
    	if(p >= 8)
    		min = Math.min(min, backtrack(c-1, p-8, n, d)+8);
    	
    	table[c][n][d] = min;
    	return table[c][n][d];
    }
}
