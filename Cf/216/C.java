import java.util.*;

public class C {
	
	static Vector<Node> graph;
	static boolean[] visited;
	static int answer;
	static Vector<Integer> ans;
        
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	graph = new Vector<Node>();
    	for(int i=0; i<n; i++)
    		graph.addElement(new Node(i));
    	for(int i=0; i<n-1; i++) {
    		int x = s.nextInt();
    		int y = s.nextInt();
    		int r = s.nextInt();
    		graph.elementAt(x-1).nodes.addElement(y-1);
    		graph.elementAt(x-1).weight.addElement(r);
    		graph.elementAt(y-1).nodes.addElement(x-1);
    		graph.elementAt(y-1).weight.addElement(r);
    	}
    	answer = 0;
    	ans = new Vector<Integer>();
    	visited = new boolean[n];
    	dfs(0, new Int(0), -1);
    	System.out.println(answer);
    	for(Integer a : ans)
    		System.out.print(a + " ");
    	System.out.println();
    }
    
    public static void dfs(int root, Int check, int w) {
    	visited[root] = true;
    	Vector<Integer> nodes = graph.elementAt(root).nodes;
    	Vector<Integer> weight = graph.elementAt(root).weight;
    	int count = 0;
    	for(int i=0; i<nodes.size(); i++) {
    		check.n = 0;
    		int n = nodes.elementAt(i);
    		int r = weight.elementAt(i);
    		if(!visited[n]) {
    			count++;
    			dfs(n, check, r);
    		}
    	}
    	if(count == 0) {
    		if(w == 2) {
    			ans.addElement(root+1);
    			answer++;
    			check.n = 1;
    		}
    	}
    	else if(check.n == 0) {
    		if(w == 2) {
    			ans.addElement(root+1);
    			answer++;
    			check.n = 1;
    		}
    	}
    }
}

class Int {
	int n;
	
	public Int(int a) {
		n = a;
	}
}

class Node {
	
	int node;
	Vector<Integer> nodes;
	Vector<Integer> weight;
	
	public Node(int n) {
		node = n;
		nodes = new Vector<Integer>();
		weight = new Vector<Integer>();
	}
}