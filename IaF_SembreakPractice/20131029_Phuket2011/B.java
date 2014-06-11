import java.util.*;
import java.io.*;

public class B {
       
    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(new FileReader("b.in"));
    	Node n = new Node(s.nextInt());
    	while(s.hasNext()) {
    		n.insert(s.nextInt());
    	}
    	n.postOrder();
    }
}

class Node {
	
	Node left, right;
	int val;
	
	public Node(int v) {
		val = v;
	}
	
	public void insert(int v) {
		if(v < val) {
			if(left == null)
				left = new Node(v);
			else
				left.insert(v);
		}
		else {
			if(right == null)
				right = new Node(v);
			else
				right.insert(v);
		}
	}
	
	public void postOrder() {
		if(left != null)
			left.postOrder();
		if(right != null)
			right.postOrder();
		System.out.println(val);
	}
}