import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int index = 1;
    	Vector<Elephant> list = new Vector<Elephant>();
    	while(s.hasNext()) {
    		list.addElement(new Elephant(index++, s.nextInt(), s.nextInt()));
    	}
    	Collections.sort(list);
    	Elephant[] arr = new Elephant[list.size()];
    	for(int i=0; i<list.size(); i++)
    		arr[i] = list.elementAt(i);
    	int[] q = new int[list.size()];
    	int[] p = new int[list.size()];
    	for(int i=0; i<list.size(); i++)
    		p[i] = -1;
    	for(int k=0; k<list.size(); k++) {
    		int max = 0;
    		for(int j=0; j<k; j++)
    			if(arr[k].smart < arr[j].smart && arr[k].weight != arr[j].weight) {
    				if(q[j] > max) {
	    				p[k] = j;
    					max = q[j];
    				}
    			}
    		q[k] = max+1;
    	}
    	int max = 0;
    	for(int i=0; i<list.size(); i++)
    		if(q[i] > max)
    			max = q[i];
    	System.out.println(max);
    	int[] ans = new int[max];
    	int start = -1;
    	for(int i=list.size()-1; i>=0; i--)
    		if(q[i] == max) {
    			start = i;
    			break;
    		}
    	while(start != -1) {
    		max--;
    		ans[max] = list.elementAt(start).idx;
    		start = p[start];
    	}
    	for(int i=0; i<ans.length; i++)
    		System.out.println(ans[i]);
    }
}

class Elephant implements Comparable<Elephant> {
	
	int idx;
	int weight, smart;
	
	public Elephant(int i, int w, int s) {
		idx = i;
		weight = w;
		smart = s;
	}
	
	public int compareTo(Elephant t) {
		if(weight != t.weight)
			return weight - t.weight;
		else if(smart != t.smart)
			return t.smart - smart;
		else
			return idx - t.idx;
	}
	
	public String toString() {
		return "" + smart;
	}
}