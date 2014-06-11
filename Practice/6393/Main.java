import java.util.*;

public class Main {
	
	static int[][] graph;
	static int[] visited;
	static boolean check;
	
	public static void dfs(int prev, int root) {
		visited[root] = -1;
		for(int i=0; i<52; i++) {
			if(i == root || i == prev)
				continue;
			if(visited[i] == 0 && graph[root][i] == 1)
				dfs(root, (i+26)%26);
			else if(visited[i] == -1 && graph[root][i] == 1) {
				check = true;
				return;
			}
		}
		visited[root] = 1;
	}

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	while(s.hasNext()) {
    		int n = s.nextInt();
	    	graph = new int[52][52];
			check = false;
	    	for(int i=0; i<n; i++) {
	    		String line = s.next();
	    		Vector<String> list = new Vector<String>();
	    		for(int j=0; j<line.length(); j+=2) {
	    			if(line.charAt(j) == '0')
	    				continue;
	    			list.addElement(line.charAt(j) + "" + line.charAt(j+1));
	    		}
	    		for(int j=0; j<list.size(); j++)
	    			for(int k=j+1; k<list.size(); k++) {
	    				String tmp1 = list.elementAt(j);
	    				String tmp2 = list.elementAt(k);
	    				int idx1 = (int)(tmp1.charAt(0)-'A')+(tmp1.charAt(1)=='+'?0:26);
	    				int idx2 = (int)(tmp2.charAt(0)-'A')+(tmp2.charAt(1)=='+'?0:26);
	    				if(tmp1.charAt(0) == tmp2.charAt(0) && idx1 != idx2) 
	    					check = true;
	    				if(idx1 != idx2) {
		    				graph[idx1][idx2] = 1;
		    				graph[idx2][idx1] = 1;
	    				}
	    			}
	    	}
			visited = new int[52];
			for(int j=0; j<52; j++) {
				if(check)
					break;
				if(visited[j] == 0)
					dfs(-1, j);
			}
			if(check)
				System.out.println("unbounded");
			else
				System.out.println("bounded");
    	}
    }
}
