import java.util.*;
import java.io.*;

public class B {
        
    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(new FileReader("b.in"));
    	int n = s.nextInt();
    	int len = n*(n+1)/2+1;
    	int[][] matrix = new int[len][len];
    	matrix[0][1] = s.nextInt();
    	int target = 2;
    	int max = 0;
    	for(int i=1; i<n; i++) {
    		int source = i*(i-1)/2+1;
    		boolean change = false;
    		for(int j=0; j<=i; j++) {
    			int m = s.nextInt();
    			max = Math.max(max, m);
    			matrix[source][target++] = m;
    			if(!change)
    				change = true;
    			else
    				if(j!=i)
	    				matrix[++source][target-1] = m;
    		}
    	}
    	max++;
    	for(int i=0; i<len; i++)
    		for(int j=0; j<len; j++)
    			if(matrix[i][j] != 0)
    				matrix[i][j] = max - matrix[i][j];
    	PriorityQueue<Node> pq = new PriorityQueue<Node>();
    	Node[] nodes = new Node[len];
    	nodes[0] = new Node(0, 0);
    	for(int i=1; i<len; i++)
    		nodes[i] = new Node(i, 2000000000);
    	pq.offer(nodes[0]);
    	int[] predecessor = new int[len];
    	predecessor[0] = -1;
    	boolean[] visited = new boolean[len];
    	while(!pq.isEmpty()) {
    		Node temp = pq.poll();
    		visited[temp.index] = true;
    		int idx = temp.index;
    		boolean check = false;
    		while(matrix[temp.index][idx] == 0) {
    			idx++;
    			if(idx == len) {
    				check = true;
    				break;
    			}
    		}
    		if(check)
    			continue;
    		for(int i=idx; i<=idx+1; i++) {
    			if(temp.index == 0 && i==idx+1)
    				break;
    			int alt = temp.dist + matrix[temp.index][i];
    			if(alt < nodes[i].dist && !visited[nodes[i].index]) {
    				nodes[i].dist = alt;
    				predecessor[i] = temp.index;
    				pq.offer(nodes[i]);
    			}
    		}
    	}
    	int path = 0;
    	int idx = -1, large = 2000000000;
    	for(int i=len-n; i<len; i++) {
    		if(large > nodes[i].dist) {
    			idx = i;
    			large = nodes[i].dist;
    		}
    	}
    	large = 0;
    	while(predecessor[idx] != -1) {
    		int orig = max - matrix[predecessor[idx]][idx];
    		path += orig*orig;
    		large += orig;
    		idx = predecessor[idx];
    	}
    	System.out.println(path + " " + large);
    	System.out.println((char)(path%26+'a')+""+(char)(large%26+'a'));
    }
}

class Node implements Comparable<Node> {
	
	int index, dist;
	
	public Node(int i, int d) {
		index = i;
		dist = d;
	}
	
	public int compareTo(Node n) {
		return dist-n.dist;
	}
}