import java.util.*;
import java.io.*;

public class prob_b {
	
	static Vector<String> ans;
	static TreeSet<String> set;
	static boolean[] visited;

    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(new FileReader("prob_b.in"));
    	while(s.hasNext()) {
    		String str = s.next();
    		int n = s.nextInt();
    		ans = new Vector<String>();
    		set = new TreeSet<String>();
    		recurse("", 0, n);
    		visited = new boolean[ans.size()];
    		int len = str.length();
    		str = str + str;
    		boolean check = false;
    		Collections.sort(ans);
    		int count = 0;
    		for(int i=0; i<len; i++) {
    			String tmp = str.substring(i, i+n);
    			int index = Collections.binarySearch(ans, tmp);
    			//System.out.println(index);
    			if(index >= 0) {
    				if(visited[index]) {
    					check = true;
    					break;
    				}
    				else {
    					visited[index] = true;
    					count++;
    				}
    			}
    		}
    		if(check || count != ans.size())
    			System.out.println("NOT DE BRUIJN");
    		else
    			System.out.println("DE BRUIJN");
    	}
    }
    
    public static void recurse(String cur, int start, int end) {
    	if(start != end) {
    		recurse(cur + "0", start+1, end);
    		recurse(cur + "1", start+1, end);
    	}
    	else if(set.add(cur))
    		ans.addElement(cur);
    }
}
