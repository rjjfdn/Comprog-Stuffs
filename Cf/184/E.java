import java.util.*;

public class E {
       
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	String line = s.nextLine();
    	PriorityQueue<String> pq = new PriorityQueue<String>(1, 
    		new Comparator<String>() {
    			public int compare(String a, String b) {
    				if(a.length() != b.length())
    					return b.length() - a.length();
    				else return a.compareTo(b);
    			}
    		}
    	);
    	pq.offer(line);
    	boolean check = true;
    	while(pq.size() != 0) {
    		String tmp = pq.poll();
    		for(int i=0; i<tmp.size(); i++) {
    			
    		}
    		check = false;
    	}
    }
}
