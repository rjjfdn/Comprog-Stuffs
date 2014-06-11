import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int cases = 1;
    	while(true) {
    		String one = " " + s.nextLine();
    		if(one.substring(1).startsWith("#"))
    			break;
    		String two = " " + s.nextLine();
    		char[] a = one.toCharArray();
    		char[] b = two.toCharArray();
    		int n = a.length;
    		int m = b.length;
    		int[][] table = new int[n][m];
    		for(int i=0; i<n; i++) {
    			for(int j=0; j<m; j++) {
    				if(i==0 || j==0)
    					table[i][j] = 0;
    				else if(a[i] == b[j])
    					table[i][j] = table[i-1][j-1]+1;
    				else
    					table[i][j] = Math.max(table[i-1][j], table[i][j-1]);
    			}
    		}
    		System.out.println("Case #" + cases + ": you can visit at most " + table[n-1][m-1] + " cities.");
    		cases++;
    	}
    }
}
