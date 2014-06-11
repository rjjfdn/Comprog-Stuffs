import java.util.*;

public class Main {
	
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	UFDS friends;
    	int n = s.nextInt();
    	friends = new UFDS(n);
    	while(true) {
    		int q = s.nextInt();
    		int x = s.nextInt();
    		int y = s.nextInt();
    		if(q == 0 && x == 0 && y == 0)
    			break;
    		switch(q) {
    			case 1:
    				if(!enemies.isSameSet(x, y)) {
    					friends.unionSet(x, y);
						
    				}
    				else
    					System.out.println(-1);
    				break;
    			case 2:
    				if(!friends.isSameSet(x, y))
    					enemies.unionSet(x, y)
    		}
    	}
    }
}

class UFDS {
		
	int[] pset;
	
	public UFDS(int n) {
		initSet(n);
	}
	
	void initSet(int n) {
		pset = new int[n];
		for(int i=0; i<n; i++) {
			pset[i] = i;
		}
	}
	
	int findSet(int i) {
		if(pset[i] == i)
			return i;
		else {
			pset[i] = pset[findSet(i)];
			return pset[i];
		}
	}
	
	boolean isSameSet(int i, int j) {
		return findSet(i) == findSet(j);
	}
	
	void unionSet(int i, int j) {
		if(!isSameSet(i, j))
			pset[findSet(j)] = pset[findSet(i)];
	}
	
}