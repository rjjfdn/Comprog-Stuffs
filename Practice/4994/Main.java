import java.util.*;

public class Main {
	
	static String[] list;
	static int m;
	static boolean[] visited;
	
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	for(int i=0; i<n; i++) {
    		m = s.nextInt();
    		list = new String[m];
    		for(int j=0; j<m; j++)
    			list[j] = s.next();
    		visited = new boolean[m];
    		System.out.println("Case " + (i+1) + ": " + backtrack(0, ""));
    	}
    }
    
    public static int backtrack(int cur, String str) {
    	if(cur == m) {
    		return str.length();
    	}
    	int ans = -1;
    	for(int i=0; i<m; i++) {
    		if(!visited[i]) {
    			visited[i] = true;
    			String tmp = list[i];
    			if(str.length() == 0) {
    				if(ans == -1)
    					ans = backtrack(cur+1, tmp);
    				else
    					ans = Math.min(ans, backtrack(cur+1, tmp));
    			}
    			else
	    			for(int j=0; j<=str.length(); j++) {
	    				String tmp2 = str.substring(j);
	    				if(tmp2.length() > tmp.length())
	    					continue;
	    				if(tmp.substring(0, tmp2.length()).equals(tmp2)) {
	    					if(ans == -1)
	    						ans = backtrack(cur+1, str+tmp.substring(tmp2.length()));
	    					else
	    						ans = Math.min(ans, backtrack(cur+1, str+tmp.substring(tmp2.length())));
	    					break;
	    				}
	    			}
    			visited[i] = false;
    		}
    	}
    	return ans;
    }
}
