import java.util.*;

public class E {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	int[] arr = new int[n];
    	Cmp comparator = new Cmp();
    	PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10, comparator);
    	for(int i=0; i<n; i++)
    		pq.add(s.nextInt());
    	System.out.println(pq);
    	int p1 = 0, p2 = 0;
    	Queue<Integer> picks1 = new LinkedList<Integer>();
    	Queue<Integer> picks2 = new LinkedList<Integer>();
    	Queue<Integer> bans1 = new LinkedList<Integer>();
    	Queue<Integer> bans2 = new LinkedList<Integer>();
    	int m = s.nextInt();
    	char[] commands = new char[m];
    	int[] play = new int[m];
    	for(int i=0; i<m; i++) {
    		commands[i] = s.next().charAt(0);
    		play[i] = s.nextInt();
    		if(commands[i] == 'p') {
    			if(play[i] == 1)
    				picks1.add(i);
    			else
    				picks2.add(i);
    		}
    	}
    	picks1.add(m);
    	picks2.add(m);
    	for(int i=0; i<m; i++) {
    		char comm = commands[i];
    		int pl = play[i];
    		if(comm == 'p') {
    			if(pl == 1) {
    				if(picks1.peek() == i) {
	    				p1 += pq.remove();
	    				picks1.remove();
    				}
    			}
    			else {
    				if(picks2.peek() == i) {
	    				p2 += pq.remove();
	    				picks2.remove();
    				}
    			}
    		}
    		else {
    			if(pl == 1) {
    				while(picks1.peek() < picks2.peek()) {
    					p1 += pq.remove();
    					picks1.remove();
    					if(picks1.size() == 0)
    						break;
    				}
    				pq.remove();
    			}
    			else {
    				while(picks2.peek() < picks1.peek()) {
    					p2 += pq.remove();
    					picks2.remove();
    					if(picks2.size() == 0)
    						break;
    				}
    				pq.remove();
    			}
    		}
    	}
    	System.out.println(p1 - p2);
    }
}

class Cmp implements Comparator<Integer> {
	
	public int compare(Integer x, Integer y) {
		return y-x;
	}
}