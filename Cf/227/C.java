import java.util.*;

public class C {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	String temp = s.next();
    	Queue<String> queue = new LinkedList<String>();
    	queue.add(temp);
    	int count = 0;
    	while(queue.size() != 0) {
    		//System.out.println(queue);
    		//s.nextLine();
    		String line = queue.remove();
    		String before = "";
	    	boolean check = false;
	    	while(true) {
	    		boolean check2 = false;
	    		int i = line.length()-1;
	    		//System.out.println(i + " " + line + " " + queue);
	    		//s.nextLine();
	    		while(true) {
	    			if(i == 0)
	    				break;
	    			String current = line.substring(i);
	    			String next = line.substring(0, i);
	    			if(!checkZero(current) && compare(current, before) >= 0 && compare(next, current) >= 0) {
	    				line = line.substring(0, i);
	    				before = current;
	    				queue.add(current);
	    				check = true;
	    				check2 = true;
	    				break;
	    			}
	    			i--;
	    		}
	    		if(!check2)
	    			break;
	    		if(!check)
	    			break;
	    	}
	    	if(!check)
	    		count++;
	    	else
	    		queue.add(line);
    	}
    	System.out.println(count);
    }
    
    public static int compare(String a, String b) {
    	if(b.equals(""))
    		return 1;
    	if(a.equals(""))
    		return -1;
    	while(a.charAt(0) == '0')
    		a = a.substring(1);
    	while(b.charAt(0) == '0')
    		b = b.substring(1);
    	if(a.length() < b.length())
    		return -1;
    	else if(a.length() > b.length())
    		return 1;
    	else
    		return a.compareTo(b);
    }
    
    public static boolean checkZero(String line) {
    	return line.charAt(0) == '0' && line.charAt(line.length()-1) == '0';
    }
}
