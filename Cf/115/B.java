import java.util.*;

public class B {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int x = s.nextInt();
    	int y = s.nextInt();
    	char[][] matrix = new char[x][y];
    	Vector<Weed> list = new Vector<Weed>();
    	for(int i=0; i<x; i++) {
    		matrix[i] = s.next().toCharArray();
    		for(int j=0; j<y; j++)
    			if(matrix[i][j] == 'W')
    				list.addElement(new Weed(i, j));
    	}
    	Collections.sort(list);
    	int tot = 0;
    	int row = 0, col = 0;
    	for(int i=0; i<list.size(); i++) {
    		Weed tmp = list.elementAt(i);
    		tot += Math.abs(row-tmp.row) + Math.abs(col-tmp.col);
    		row = tmp.row;
    		col = tmp.col;
    	}
    	System.out.println(tot);
    }
}

class Weed implements Comparable<Weed> {
	
	int row, col;
	
	public Weed(int r, int c) {
		row = r;
		col = c;
	}
	
	public int compareTo(Weed w) {
		if(row != w.row)
			return row - w.row;
		else if(row%2 == 0)
			return col - w.col;
		else
			return w.col - col;
	}
}