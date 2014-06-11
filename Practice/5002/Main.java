import java.math.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	BigInteger[] fact = new BigInteger[1010];
    	fact[0] = BigInteger.ONE;
    	for(int i=1; i<1010; i++)
    		fact[i] = (new BigInteger(""+i).multiply(fact[i-1])).mod(new BigInteger("1000000007"));
    	int n = s.nextInt();
    	for(int i=0; i<n; i++) {
    		int m = s.nextInt();
    		int[][] graph = new int[m][m];
    		for(int j=0; j<m-1; j++) {
    			int a = s.nextInt();
    			int b = s.nextInt();
    			graph[a-1][b-1] = 1;
    		}
    		int root = -1;
    		for(int j=0; j<m; j++) {
    			boolean check2 = false;
    			for(int k=0; k<m; k++) {
    				if(graph[k][j] == 1) {
    					check2 = true;
    					break;
    				}
    			}
    			if(!check2)
    				root = j;
    		}
    		int count = 0;
    		BigInteger ans1 = BigInteger.ONE;
    		boolean[] visited = new boolean[m];
    		while(count != m) {
    			Vector<Integer> list = new Vector<Integer>();
    			for(int j=0; j<m; j++) {
    				boolean check = false;
    				for(int k=0; k<m; k++) {
    					if(graph[j][k] == 1 && !visited[k]) {
    						check = true;
    						break;
    					}
    				}
    				if(!check && !visited[j])
    					list.addElement(j);
    			}
    			for(int j=0; j<list.size(); j++)
    				visited[list.elementAt(j)] = true;
    			ans1 = ans1.multiply(fact[list.size()]);
    			count += list.size();
    			System.out.println(list + " " + count);
    			s.nextLine();
    		}
    		System.out.println(ans1);
    		Queue<Integer> queue = new LinkedList<Integer>();
    		visited = new boolean[m];
    		queue.add(root);
    		int[] level = new int[m];
    		int[] counts = new int[m];
    		while(queue.size() != 0) {
    			int u = queue.remove();
    			visited[u] = true;
    			counts[level[u]]++;
    			for(int j=0; j<m; j++) {
    				if(!visited[j])
	    				if(graph[u][j] == 1) {
	    					level[j] = level[u]+1;
	    					queue.add(j);
	    				}
    			}
    		}
    		BigInteger ans2 = BigInteger.ONE;
    		for(int j=0; j<m; j++)
    			ans2 = ans2.multiply(fact[counts[j]]);
    		System.out.println(ans1.add(ans2));
    	}
    }
}