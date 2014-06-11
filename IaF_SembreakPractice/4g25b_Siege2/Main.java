import java.util.*;

public class Main {
	
	static int count;

    public static void main(String[] args) {
    	Scanner s = new Scanner(new FileReader("week3.txt"));
    	while(true) {
    		String line = s.nextLine();
    		if(line.equals("$"))
    			break;
    		System.out.println(line);
    		line = s.nextLine();
    		Vector<String> list = new Vector<String>();
    		for(int i=0; i<line.length(); i++) {
    			int cur = conv(line.charAt(i));
    			for(int j=i+1; j<line.length(); j++) {
    				if(cur+conv(line.charAt(j)) <= 10) {
    					list.addElement(line.substring(i, j+1));
    					cur += conv(line.charAt(j));
    				}
    				else break;
    			}
    		}
	    	count = 0;
	    	for(char c='a'; c<='z'; c++)
	    		backtrack(""+c, conv(c));
	    	System.out.println(count);
    	}
    }
    
    public static void backtrack(String cur, int a) {
    	for(char c='a'; c<='z'; c++)
    		if(a+conv(c) <= 10)
    			backtrack(cur+c, a+conv(c));
    	count++;
    }
    
    public static int conv(char ch) {
    	switch(ch) {
    		case 'a':
    		case 'b':
    		case 'c':
    			return 1;
    		case 'd':
    		case 'e':
    		case 'f':
    			return 2;
    		case 'g':
    		case 'h':
    		case 'i':
    			return 3;
    		case 'j':
    		case 'k':
    		case 'l':
    			return 4;
    		case 'm':
    		case 'n':
    		case 'o':
    			return 5;
    		case 'p':
    		case 'q':
    		case 'r':
    			return 6;
    		case 's':
    		case 't':
    		case 'u':
    			return 7;
    		case 'v':
    		case 'w':
    		case 'x':
    			return 8;
    		case 'y':
    		case 'z':
    			return 9;
    	}
    	return 0;
    }
}
