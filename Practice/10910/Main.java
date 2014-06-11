import java.util.*;

public class Main {
	
	static int[][] table;
	static int n, t, p;

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int m = s.nextInt();
    	for(int q=0; q<m; q++) {
    		n = s.nextInt();
    		t = s.nextInt();
    		p = s.nextInt();
    		table = new int[n+10][t+10];
    		for(int i=0; i<=n; i++)
    			for(int j=0; j<=t; j++)
    				table[i][j] = -1;
    		System.out.println(backtrack(1, 0));
    	}
    }
    
    public static int backtrack(int nn, int tt) {
    	if(nn == n+1) {
    		if(tt == t)
    			return 1;
    		else
    			return 0;
    	}
    	if(table[nn][tt] != -1)
    		return table[nn][tt];
    	int curt = t-tt;
    	int curn = n-nn;
    	curt = curt - p*curn;
    	int total = 0;
    	for(int i=p; i<=curt; i++)
    		total += backtrack(nn+1, tt+i);
    	table[nn][tt] = total;
    	return table[nn][tt];
    }
}
