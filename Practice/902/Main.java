import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	TreeMap<String, Integer> map;
    	while(s.hasNext()) {
    		int n = s.nextInt();
    		String line = s.next();
    		map = new TreeMap<String, Integer>();
    		String ans = "";
    		int max = 0;
    		for(int i=0; i<line.length()-n+1; i++) {
    			String temp = line.substring(i, i+n);
    			if(map.containsKey(temp)) {
    				int count = map.get(temp)+1;
    				map.put(temp, count);
					if(max < count) {
						max = count;
						ans = temp;
					}
    			}
    			else {
    				map.put(temp, 1);
					if(max < 1) {
						max = 1;
						ans = temp;
					}
    			}
    		}
    		System.out.println(ans);
    	}
    }
}
