import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	while(s.hasNext()) {
    		String preord = s.next();
    		String inord = s.next();
    		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    		for(int i=0; i<inord.length(); i++)
    			map.put(inord.charAt(i), i+1);
    		map.put(' ', 200);
    		Node tree = new Node(' ', new Str(preord), map, 0);
    		tree.postorder();
    		System.out.println();
    	}
    }
}

class Str {
	
	String str;
	
	public Str(String s) {
		str = s;
	}
}

class Node {
	
	Node left, right;
	char letter;
	
	public Node(char parent, Str cur, HashMap<Character, Integer> map, int loc) {
		if(cur.str.length() == 0)
			return;
		if(cur.str.length() == 1) {
			letter = cur.str.charAt(0);
			return;
		}
		letter = cur.str.charAt(0);
		cur.str = cur.str.substring(1);
		if(map.get(cur.str.charAt(0)) < map.get(letter))
			left = new Node(letter, cur, map, 0);
		if(map.get(cur.str.charAt(0)) > map.get(letter) && map.get(cur.str.charAt(0)) < map.get(parent))
			right = new Node(parent, cur, map, 1);
	}
	
	public void postorder() {
		if(left != null)
			left.postorder();
		if(right != null)
			right.postorder();
		System.out.print(letter);
	}
}

class Order implements Comparable<Order> {
	
	char letter;
	int index;
	
	public Order(char l, int i) {
		letter = l;
		index = i;
	}
	
	public int compareTo(Order o) {
		return index - o.index;
	}
}