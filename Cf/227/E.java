import java.util.*;

public class E {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	Vector[] list = new Vector[n];
    	int count = 0;
    	int sum1 = 0, sum2 = 0;
    	for(int i=0; i<n; i++) {
    		int m = s.nextInt();
    		count += m;
    		list[i] = new Vector<Integer>();
    		for(int j=0; j<m; j++)
    			list[i].addElement(s.nextInt());
    	}
    	while(count != 0) {
    		int max = 0;
    		int maxidx = -1;
    		for(int i=0; i<n; i++) {
    			if(list[i].size() == 0)
    				continue;
    			if(max < (Integer) list[i].elementAt(0)) {
    				max = (Integer) list[i].elementAt(0);
    				maxidx = i;
    			}
    		}
    		sum1 += max;
    		list[maxidx].removeElementAt(0);
    		count--;
    		if(count == 0)
    			break;
    		max = 0;
    		maxidx = -1;
    		for(int i=0; i<n; i++) {
    			if(list[i].size() == 0)
    				continue;
    			if(max < (Integer) list[i].elementAt(list[i].size()-1)) {
    				max = (Integer) list[i].elementAt(list[i].size()-1);
    				maxidx = i;
    			}
    		}
    		sum2 += max;
    		list[maxidx].removeElementAt(list[maxidx].size()-1);
    		count--;
    	}
    	System.out.println(sum1 + " " + sum2);
    }
}
