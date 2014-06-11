import java.util.*;
import java.io.*;

public class Main {
    
    static int m, n;
    
    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(new FileReader("pd.in"));
    	while(true) {
    		String pid = s.next().trim();
    		m = s.nextInt();
    		n = s.nextInt();
    		int p = s.nextInt();
    		if(pid.equals("ZZ") && m == 0 && n == 0 && p == 0)
    			break;
    		for(int i=0; i<p; i++) {
    			String str1 = s.next();
    			String str2 = s.next();
    			String str = str1 + str2;
    			Vector<String> list = transform(str);
    			backtrack(list);
    			System.out.println("ProblemID " + pid + ": " + str1 + " * " + str2 + " = " + getStr(list));
    		}
    	}
    }
    
    public static String getStr(Vector<String> list) {
    	return list.elementAt(0) + list.elementAt(1);
    }
    
    public static Vector<String> transform(String str) {
    	StringTokenizer token = new StringTokenizer(str, "ab");
    	Vector<String> list = new Vector<String>();
    	list.addElement("a" + token.nextToken());
    	list.addElement("b" + token.nextToken());
    	list.addElement("a" + token.nextToken());
    	list.addElement("b" + token.nextToken());
    	return list;
    }
    
    public static void reduce(Vector<String> list) {
    	for(int i=1; i<list.size()-1; i++) {
    		if(Integer.parseInt(list.elementAt(i).substring(1)) == 0) {
    			char ch = list.elementAt(i-1).charAt(0);
    			int num;
    			if(ch == 'a')
    				num = (Integer.parseInt(list.elementAt(i-1).substring(1)) + Integer.parseInt(list.elementAt(i+1).substring(1)))%m;
    			else
    				num = (Integer.parseInt(list.elementAt(i-1).substring(1)) + Integer.parseInt(list.elementAt(i+1).substring(1)))%n;
    			list.setElementAt(ch+""+num, i-1);
    			list.removeElementAt(i+1);
    			list.removeElementAt(i);
    			i--;
    		}
    	}
    }
    
    public static void backtrack(Vector<String> list) {
    	while(list.size() != 2) {
	    	reduce(list);
	    	if(list.size() == 2)
	    		return;
	    	int a1 = Integer.parseInt(list.elementAt(0).substring(1));
	    	int b1 = Integer.parseInt(list.elementAt(1).substring(1));
	    	int a2 = Integer.parseInt(list.elementAt(2).substring(1));
	    	int b2 = Integer.parseInt(list.elementAt(3).substring(1));
	    	list.insertElementAt("b"+(b1-1), 0);
	    	list.insertElementAt("a"+a1, 0);
	    	list.setElementAt("a"+(m-1), 2);
	    	list.setElementAt("b1", 3);
	    	list.setElementAt("a"+(a2-1), 4);
	    	list.setElementAt("b"+b2, 5);
    	}
    }
}
