import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	while(s.hasNext()) {
    		int n = s.nextInt();
    		int m = s.nextInt();
    		HashMap<Integer, String> map = new HashMap<Integer, String>();
    		for(int i=0; i<n; i++) {
    			int tmp = s.nextInt();
    			if(map.containsKey(tmp))
    				map.put(tmp, map.get(tmp)+""+(i+1));
    			else
    				map.put(tmp, ""+(i+1));
    		}
    		for(int i=0; i<m; i++) {
    			int x = s.nextInt();
    			int y = s.nextInt();
    			if(map.containsKey(y)) {
    				String tmp = map.get(y);
    				if(x > tmp.length())
    					System.out.println(0);
    				else
    					System.out.println(tmp.charAt(x-1));
    			}
    			else System.out.println(0);
    		}
    	}
    }
}
