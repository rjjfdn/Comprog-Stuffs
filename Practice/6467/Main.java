import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	for(int i=0; i<n; i++) {
    		int m = s.nextInt();
    		System.out.print(m + " ");
    		int o = s.nextInt();
    		int p = s.nextInt();
    		boolean[][] graph = new boolean[o][o];
    		for(int j=0; j<p; j++) {
    			int a = s.nextInt()-1;
    			int b = s.nextInt()-1;
    			graph[a][b] = true;
    		}
    		int[] level = new int[o];
    		Queue<Integer> q = new LinkedList<Integer>();
    		for(int j=0; j<o; j++) {
    			level[j] = -1;
    			boolean check = false;
    			for(int k=0; k<o; k++) {
    				if(graph[k][j]) {
    					check = true;
    					break;
    				}
    			}
    			if(!check) {
    				level[j] = 1;
    				q.add(j);
    			}
    		}
    		int ans = 0;
    		while(q.size() != 0) {
    			int v = q.remove();
    			ans = Math.max(ans, level[v]);
    			for(int j=0; j<o; j++) {
    				if(graph[v][j]) {
    					boolean check = false;
    					Vector<Integer> list = new Vector<Integer>();
    					for(int k=0; k<o; k++) {
    						if(graph[k][j] && level[k]<0) {
    							check = true;
    							break;
    						}
    						else if(graph[k][j] && level[k]>0)
    							list.addElement(level[k]);
    					}
    					if(!check) {
    						Collections.sort(list);
    						if(list.size() == 1)
    							level[j] = level[v];
    						else if(list.elementAt(list.size()-1) == list.elementAt(list.size()-2))
    							level[j] = list.elementAt(list.size()-1)+1;
    						else
    							level[j] = list.elementAt(list.size()-1);
    						q.add(j);
    					}
    				}
    			}
    		}
    		System.out.println(ans);
    	}
    }
}
