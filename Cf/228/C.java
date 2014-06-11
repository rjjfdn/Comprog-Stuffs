import java.util.*;

public class C {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	Vector<Pile> list = new Vector<Pile>();
    	for(int i=0; i<n; i++)
    		list.addElement(new Pile(1, s.nextInt()));
    	Collections.sort(list);
    	int count = 0;
    	while(list.size() != 0) {
    		Pile temp = list.elementAt(0);
    		list.removeElementAt(0);
    		int height = temp.height;
    		boolean check = false;
    		for(int i=0; i<list.size(); i++) {
    			if(list.elementAt(i).capacity >= height) {
    				list.elementAt(i).capacity = temp.capacity;
    				list.elementAt(i).height += height;
    				check = true;
    				break;
    			}
    		}
    		if(!check)
    			count++;
    		Collections.sort(list);
    	}
    	System.out.println(count);
    }
}

class Pile implements Comparable<Pile> {
	
	int height, capacity;
	
	public Pile(int h, int c) {
		height = h;
		capacity = c;
	}
	
	public int compareTo(Pile p) {
		if(capacity != p.capacity)
			return capacity-p.capacity;
		else
			return p.height-height;
	}
}