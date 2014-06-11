import java.util.*;
import java.io.*;

public class E {
	
	static int[][][] cost;
	static String a, b, c;

    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(new FileReader("e.in"));
    	int n = s.nextInt();
    	s.nextLine();
    	for(int i=0; i<n; i++) {
    		a = " " + s.nextLine();
    		b = " " + s.nextLine();
    		c = " " + s.nextLine();
    		cost = new int[a.length()][b.length()][c.length()];
    		for(int j=1; j<a.length(); j++)
    			for(int k=1; k<b.length(); k++)
    				for(int l=1; l<c.length(); l++) {
    					if(a.charAt(j) == b.charAt(k) && b.charAt(k) == c.charAt(l))
    						cost[j][k][l] = cost[j-1][k-1][l-1] + 1;
    					else
    						cost[j][k][l] = Math.max(cost[j-1][k][l], Math.max(cost[j][k-1][l], cost[j][k][l-1]));
    				}
    		System.out.println(cost[a.length()-1][b.length()-1][c.length()-1] + " " + backtrack(a.length()-1, b.length()-1, c.length()-1));
    	}
    }
    
    public static String backtrack(int i, int j, int k) {
    	if(i == 0 || j == 0 || k == 0)
    		return "";
    	else if(a.charAt(i) == b.charAt(j) && b.charAt(j) == c.charAt(k))
    		return backtrack(i-1, j-1, k-1) + a.charAt(i);
    	else {
    		int max = Math.max(cost[i-1][j][k], Math.max(cost[i][j-1][k], cost[i][j][k-1]));
    		if(max == cost[i-1][j][k])
    			return backtrack(i-1, j, k);
    		else if(max == cost[i][j-1][k])
    			return backtrack(i, j-1, k);
    		else
    			return backtrack(i, j, k-1);
    	}
    }
}
