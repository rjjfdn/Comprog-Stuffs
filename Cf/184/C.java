import java.util.*;

public class C {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
    	int max = -1;
    	int n = s.nextInt();
    	for(int i=0; i<n; i++) {
    		int a = s.nextInt();
    		if(!map.containsKey(a))
    			map.put(a, 1);
    		else
    			map.put(a, map.get(a)+1);
    		max = Math.max(max, a);
    	}
    	int min = 0;
    	PriorityQueue<Integer> indices = new PriorityQueue<Integer>();
    	for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
    		indices.offer(entry.getKey());
    	}
    	while(indices.size() != 0) {
    		int index = indices.poll();
    		int val = map.get(index);
    		//System.out.println(map);

    		while(val > 1) {
    			int ans = (int)(Math.log(val)/Math.log(2));
    			int tmp = index + ans;
    			max = Math.max(tmp, max);
    			if(map.containsKey(tmp))
    				map.put(tmp, map.get(tmp) + 1);
    			else {
    				map.put(tmp, 1);
					indices.offer(tmp);
    			}
    			map.put(index, val-((int)(Math.pow(2, ans))));
    			val = map.get(index);
    		}
    		if(val == 1)
    			min++;
    	}
    	System.out.println(max+1-min);
    }
}
