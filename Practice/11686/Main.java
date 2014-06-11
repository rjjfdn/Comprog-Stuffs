import java.util.*;

public class Main {
	
	static Vector<Integer> list;
	static int[] visited;
	static Vector<Integer>[] graph;
	static boolean dag;

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	while(true) {
    		int n = s.nextInt();
    		int m = s.nextInt();
    		if(n == 0 && m == 0)
    			break;
    		graph = new Vector[n];
    		for(int i=0; i<n; i++)
    			graph[i] = new Vector<Integer>();
    		for(int i=0; i<m; i++) {
    			int x = s.nextInt();
    			int y = s.nextInt();
    			graph[y-1].addElement(x-1);
    		}
    		list = new Vector<Integer>();
    		visited = new int[n];
    		dag = true;
    		for(int i=0; i<n; i++) 
    			if(visited[i] == 0)
    				visit(i);
    		if(!dag)
    			System.out.println("IMPOSSIBLE");
    		else
    			for(int i=0; i<list.size(); i++)
    				System.out.println(list.elementAt(i)+1);
    	}
    }
    
    public static void visit(int i) {
    	if(visited[i] == -1) {
    		dag = false;
    		return;
    	}
    	if(!dag)
    		return;
    	if(visited[i] == 0) {
    		visited[i] = -1;
    		for(int j=0; j<graph[i].size(); j++)
    			visit(graph[i].elementAt(j));
    		visited[i] = 1;
    		list.addElement(i);
    	}
    }
}