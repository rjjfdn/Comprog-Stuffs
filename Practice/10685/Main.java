import java.util.*;

public class Main {
        
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	while(true) {
    		int c = s.nextInt();
    		int r = s.nextInt();
    		if(c == 0 && r == 0)
    			break;
    		UFDS set = new UFDS(c);
    		HashMap<String, Integer> map = new HashMap<String, Integer>();
    		for(int i=0; i<c; i++)
    			map.put(s.next(), i);
    		for(int i=0; i<r; i++) {
    			String a = s.next();
    			String b = s.next();
    			set.unionSet(map.get(a), map.get(b));
    		}
    		System.out.println(set.max);
    	}
    }
}

class UFDS {
		
	int[] pset;
	int[] setSize;
	int max;
	
	public UFDS(int n) {
		initSet(n);
	}
	
	void initSet(int n) {
		pset = new int[n];
		setSize = new int[n];
		for(int i=0; i<n; i++) {
			pset[i] = i;
			setSize[i] = 1;
		}
		max = 1;
	}
	
	int findSet(int i) {
		if(pset[i] == i)
			return i;
		else {
			pset[i] = findSet(pset[i]);
			return pset[i];
		}
	}
	
	boolean isSameSet(int i, int j) {
		return findSet(i) == findSet(j);
	}
	
	int sizeOfSet(int i) {
		return setSize[findSet(i)];
	}
	
	void unionSet(int i, int j) {
		if(!isSameSet(i, j)) {
			setSize[findSet(j)] += setSize[findSet(i)];
			pset[findSet(i)] = findSet(j);
			max = Math.max(setSize[findSet(j)], max);
		}
	}
	
}