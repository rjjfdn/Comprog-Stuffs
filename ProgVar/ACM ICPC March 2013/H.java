import java.util.*;
import java.io.*;

public class H {

    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(new FileReader("h.in"));
    	int cases = 0;
    	while(true) {
    		int n = s.nextInt();
    		if(n == 0)
    			break;
    		if(cases != 0)
    			System.out.println();
    		cases++;
    		int m = s.nextInt();
    		int[][] matrix = new int[100][100];
    		int[] visited = new int[100];
    		for(int i=0; i<m; i++) {
    			int x = s.nextInt();
    			int y = s.nextInt();
    			matrix[x][y] = 1;
    			matrix[y][x] = 1;
    			visited[x] = -1;
    			visited[y] = -1;
    		}
    		visited[n] = 1;
    		Queue<Integer> queue = new LinkedList<Integer>();
    		queue.add(n);
    		System.out.println("Starting at " + n);
    		System.out.println("Cities visit order:");
    		int first = 0;
    		while(queue.size() != 0) {
    			int node = queue.remove();
    			if(first == 0)
    				System.out.print(node);
    			else
    				System.out.print(" " + node);
    			first++;
    			for(int i=0; i<19; i++)
    				if(matrix[node][i] == 1)
    					if(visited[i] == -1) {
    						visited[i] = 1;
    						queue.add(i);
    					}
    		}
    		System.out.println();
    		System.out.println("Cities not visited:");
			int f = 1;
			boolean check = false;
			for(int i=1; i<100; i++)
				if(visited[i] == -1) {
					if(f == 1)
						System.out.print(i);
					else
						System.out.print(" " + i);
					f++;
					check = true;
				}
			System.out.println((!check)?"none":"");
    	}
    }
}
