import java.util.*;
import java.io.*;

public class G {

    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(new FileReader("g.in"));
    	int n = s.nextInt();
    	s.nextLine();
    	for(int i=0; i<n; i++) {
    		String line = s.nextLine();
    		Node tree = createTree(line);
    		if(tree.inOrder()) {
    			if(tree.isBalanced())
    				System.out.println("Tree #" + (i+1) + " is an AVL Tree.");
    			else
    				System.out.println("Tree #" + (i+1) + " is a binary search tree.");
    		}
    		else
    			System.out.println("Tree #" + (i+1) + " is just an ordinary tree.");
    	}
    }
    
    public static Node createTree(String line) {
    	if(line.length() == 0)
    		return null;
    	if(line.charAt(0) != '(')
    		return new Node(line.charAt(0));
    	int start = 1;
    	int i;
    	for(i=1; i<line.length(); i++) {
    		if(start == 0)
    			break;
    		if(line.charAt(i) == '(')
    			start++;
    		else if(line.charAt(i) == ')')
    			start--;
    	}
    	Node n = new Node(line.charAt(i));
    	n.left = createTree(line.substring(1, i-1));
    	n.right = createTree(line.substring(i+2, line.length()-1));
    	return n;
    }
}

class Node {
	
	Node left;
	Node right;
	char val;
	
	public Node(char v) {
		val = v;
	}
	
	public boolean isBalanced() {
		int hleft, hright;
		if(left != null)
			hleft = left.height();
		else hleft = 0;
		if(right != null)
			hright = right.height();
		else hright = 0;
		if(Math.abs(hleft - hright) <= 1)
			return true && (left!=null)?left.isBalanced():true && (right!=null)?right.isBalanced():true;
		else
			return false;
	}
	
	public int height() {
		int hleft = 1;
		int hright = 1;
		if(left != null)
			hleft += left.height();
		if(right != null)
			hright += right.height();
		return Math.max(hleft, hright);
	}
	
	public boolean inOrder() {
		char low = 'a'-1;
		char high = 'z'+1;
		int lval = (left!=null)?left.val:low;
		int rval = (right!=null)?right.val:high;
		if(lval > val || val > rval)
			return false;
		else
			return true && (left!=null)?left.inOrder():true && (right!=null)?right.inOrder():true;
	}
}