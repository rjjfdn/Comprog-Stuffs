import java.util.*;

public class C {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	Stack<Integer> stack = new Stack<Integer>();
    	Queue<Integer> queue = new LinkedList<Integer>();
    	Vector<Integer> deck = new Vector<Integer>();
    	Vector<Number> list = new Vector<Number>();
    	Vector<Number> sort = new Vector<Number>();
    	int n = s.nextInt();
    	for(int i=0; i<n; i++) {
    		int m = s.nextInt();
    		switch(m) {
    			case 0:
    				Collections.sort(sort);
    				if(sort.size()-1 >= 0)
	    				sort.elementAt(sort.size()-1).big = true;
    				if(sort.size()-2 >= 0)
    					sort.elementAt(sort.size()-2).big = true;
    				if(sort.size()-3 >= 0)
    					sort.elementAt(sort.size()-3).big = true;
    				boolean cstack = false;
    				boolean cqueue = false;
    				for(int j=0; j<list.size(); j++) {
    					if(list.elementAt(j).big) {
    						if(!cqueue) {
    							queue.add(list.elementAt(j).number);
    							System.out.println("pushQueue");
    							cqueue = true;
    						}
    						else if(!cstack) {
    							stack.push(list.elementAt(j).number);
    							System.out.println("pushStack");
    							cstack = true;
    						}
    						else {
    							deck.addElement(list.elementAt(j).number);
    							System.out.println("pushFront");
    						}
    					}
    					else {
    						if(cqueue) {
    							queue.add(list.elementAt(j).number);
    							System.out.println("pushQueue");
    						}
    						else {
    							stack.push(list.elementAt(j).number);
    							System.out.println("pushStack");
    						}
    					}
    				}
    				Vector<String> answer = new Vector<String>();
    				if(stack.size() != 0)
    					answer.addElement("popStack");
    				if(queue.size() != 0)
    					answer.addElement("popQueue");
    				if(deck.size() != 0)
    					answer.addElement("popFront");
    				System.out.print(answer.size());
    				for(int k=0; k<answer.size(); k++)
    					System.out.print(" " + answer.elementAt(k));
    				System.out.println();
    				stack = new Stack<Integer>();
    				queue = new LinkedList<Integer>();
    				deck = new Vector<Integer>();
    				list = new Vector<Number>();
    				sort = new Vector<Number>();
    				break;
    			default:
    				list.addElement(new Number(list.size(), m));
    				sort.addElement(list.elementAt(list.size()-1));
    				break;
    		}
    	}
    }
}

class Number implements Comparable<Number> {
	
	int index, number;
	boolean big;
	
	public Number(int i, int n) {
		index = i;
		number = n;
		big = false;
	}
	
	public int compareTo(Number n) {
		if(number != n.number)
			return number - n.number;
		else
			return index - n.index;
	}
}