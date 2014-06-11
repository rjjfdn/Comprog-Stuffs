import java.util.*;

public class Main {
	
	Vector<Integer> p, rank, setSize;
	int numSets;
	
	public void init(int N) {
		p = new Vector<Integer>(N);
		rank = new Vector<Integer>(N);
		setSize = new Vector<Integer>(N);
		numSets = N;
		for(int i=0; i<N; i++) {
			p.add(i);
			rank.add(0);
			setSize.add(1);
		}
	}
	
	public int findSet(int i) {
		if(p.get(i) == i)
			return i;
		else {
			int ret = findSet(p.get(i));
			p.set(i, ret);
			return ret;
		}
	}
	
	public boolean isSameSet(int i, int j) {
		return findSet(i) == findSet(j);
	}
	
	public void unionSet(int i, int j) {
		if(!isSameSet(i, j)) {
			numSets--;
			int x = findSet(i);
			int y = findSet(j);
			if(rank.get(x) > rank.get(y)) {
				p.set(y, x);
				setSize.set(x, setSize.get(x) + setSize.get(y));
			}
			else {
				p.set(x, y);
				setSize.set(y, setSize.get(y) + setSize.get(x));
			}
		}
	}
	
	public int numDisjointSets() {
		return numSets;
	}
	
	public int sizeOfSet(int i) {
		return setSize.get(findSet(i));
	}

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	while(true) {
    		int n = s.nextInt();
    		int r = s.nextInt();
    		init(n);
    		for(int i=0; i<r; i++) {
    			
    		}
    	}
    }
}
