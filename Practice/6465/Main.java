import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	for(int q=0; q<n; q++) {
    		int m = s.nextInt();
    		System.out.print(m + " ");
    		Vector<Integer> list = new Vector<Integer>();
    		for(int j=0; j<15; j++)
    			list.addElement(s.nextInt());
    		int count = 0;
    		while(list.size() != 0) {
    			int idx = -1;
    			int max = -1;
    			for(int i=0; i<list.size(); i++)
    				if(max < list.elementAt(i)) {
    					max = list.elementAt(i);
    					idx = i;
    				}
    			while(idx < list.size()) {
    				if(max == list.elementAt(idx))
    					list.removeElementAt(idx);
    				else break;
    			}
    			for(int i=idx-1; i>=0; i--) {
    				if(max == list.elementAt(i))
    					list.removeElementAt(i);
    				else break;
    			}
    			if(max == 0)
    				continue;
    			else
    				count++;
    		}
    		System.out.println(count);
    	}
    }
}
