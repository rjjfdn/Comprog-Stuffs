import java.io.*;
import java.util.*;

public class Main {
        
    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(new FileReader("ph.in"));
    	HashMap<String, Integer> map = new HashMap<String, Integer>();
    	map.put("Naga City", 0);
    	map.put("City of Iriga", 1);
    	map.put("Tabaco City", 2);
    	map.put("City of Ligao", 3);
    	map.put("Legazpi City", 4);
    	map.put("Sorsogon City", 5);
    	map.put("Masbate City", 6);
    	map.put("North", 0);
    	map.put("South", 1);
    	map.put("East", 2);
    	map.put("West", 3);
    	map.put("Northeast", 4);
    	map.put("Southwest", 5);
    	map.put("Southeast", 6);
    	map.put("Northwest", 7);
    	int cases = 1;
    	while(true) {
    		int m = s.nextInt();
    		if(m == 0)
    			break;
    		int n = s.nextInt();
    		System.out.println("Case " + cases++);
    		s.nextLine();
    		int[][][] graph = new int[7][7][8];
    		for(int i=0; i<m; i++) {
    			String[] split = s.nextLine().trim().split(",");
    			int idx2 = map.get(split[0]);
    			int idx1 = map.get(split[1]);
    			int idx3 = map.get(split[2]);
    			graph[idx2][idx1][idx3] = 1;
    			if(idx3%2 == 0)
    				graph[idx1][idx2][idx3+1] = 1;
    			else
    				graph[idx1][idx2][idx3-1] = 1;
    		}
    		for(int i=0; i<n; i++) {
    			String[] split = s.nextLine().trim().split(",");
    			int idx1 = map.get(split[0]);
    			int idx2 = map.get(split[1]);
    			Queue<Integer> queue = new LinkedList<Integer>();
    			Queue<Integer> qx = new LinkedList<Integer>();
    			Queue<Integer> qy = new LinkedList<Integer>();
    			boolean[] visited = new boolean[7];
    			queue.add(idx1);
    			qx.add(0);
    			qy.add(0);
    			visited[idx1] = true;
    			boolean check = false;
    			while(queue.size() != 0) {
    				int root = queue.remove();
    				int xx = qx.remove();
    				int yy = qy.remove();
    				if(root == idx2) {
    					int x = xx;
    					int y = yy;
    					String loc = "";
    					if(y == 0) {
    						if(x > 0)
    							loc = "north";
    						else
    							loc = "south";
    					}
    					if(x == 0) {
    						if(y > 0)
    							loc = "east";
    						else
    							loc = "west";
    					}
    					if(x != 0 && y != 0) {
    						if(x > 0 && y > 0)
    							loc = "northeast";
    						else if(x > 0 && y < 0)
    							loc = "northwest";
    						else if(x < 0 && y > 0)
    							loc = "southeast";
    						else
    							loc = "southwest";
    					}
    					System.out.println(split[0] + " is " + loc + " of " + split[1]);
    					check = true;
    					break;
    				}
    				for(int j=0; j<7; j++)
    					for(int k=0; k<8; k++)
    						if(graph[root][j][k] != 0 && !visited[j]) {
    							int x = xx;
    							int y = yy;
    							visited[j] = true;
    							queue.add(j);
    							switch(k) {
    								case 0:
    									x++;
    									break;
    								case 1:
    									x--;
    									break;
    								case 2:
    									y++;
    									break;
    								case 3:
    									y--;
    									break;
    								case 4:
    									x++;
    									y++;
    									break;
    								case 5:
    									x--;
    									y--;
    									break;
    								case 6:
    									x--;
    									y++;
    									break;
    								case 7:
    									x++;
    									y--;
    									break;
    							}
    							qx.add(x);
    							qy.add(y);
    						}
    			}
    			if(!check)
    				System.out.println("Relative location cannot be determined");
    		}
    		System.out.println();
    	}
    }
}
