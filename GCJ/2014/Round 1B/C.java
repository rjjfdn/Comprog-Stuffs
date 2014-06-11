import java.util.*;
import java.io.*;
import java.math.*;

public class C {
	
	static int[][] graph;
	static int n;
	static String[] zip;
	static Vector<BigInteger> ans;
	static boolean[] visited;
	
	public static void backtrack(String cur, int idx, int visit) {
		if(visit == n) {
			ans.addElement(new BigInteger(cur));
			return;
		}
		for(int i=0; i<n; i++) {
			if(graph[idx][i] == 1) {
				graph[idx][i] = 0;
				boolean check = false;
				String plus = "";
				int v = 0;
				if(!visited[i]) {
					check = true;
					visited[i] = true;
					plus = zip[i];
					v = 1;
				}
				backtrack(cur + plus, i, visit + v);
				graph[idx][i] = 1;
				if(check)
					visited[i] = false;
			}
		}
	}
        
    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(new FileReader("c.in"));
    	PrintWriter p = new PrintWriter(new FileWriter("c.out"));
    	int t = s.nextInt();
    	for(int i=0; i<t; i++) {
    		n = s.nextInt();
    		int m = s.nextInt();
    		graph = new int[n][n];
    		zip = new String[n];
    		for(int j=0; j<n; j++)
    			zip[j] = s.next();
    		String min = zip[0];
    		int idx = 0;
    		for(int j=1; j<n; j++)
    			if(zip[idx].compareTo(zip[j]) > 0) {
    				min = zip[j];
    				idx = j;
    			}
    		for(int j=0; j<m; j++) {
    			int x = s.nextInt()-1;
    			int y = s.nextInt()-1;
    			graph[x][y] = 1;
    			graph[y][x] = 1;
    		}
    		ans = new Vector<BigInteger>();
    		visited = new boolean[n];
    		visited[idx] = true;
    		backtrack(min, idx, 1);
    		Collections.sort(ans);
    		p.println("Case #" + (i+1) + ": " + ans.elementAt(0));
    		System.out.println("Case #" + (i+1) + ": " + ans.elementAt(0));
    	}
    	p.close();
    }
}
