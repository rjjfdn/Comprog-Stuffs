import java.util.*;
import java.util.regex.*;
import java.io.*;

public class J {
        
    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(new FileReader("j.in"));
    	String word = "";
    	int length = 0;
    	String pattern = "";
    	while(true) {
    		String tmp = s.next();
    		if(tmp.equals("E-N-D"))
    			break;
    		pattern += tmp + " ";
    	}
    	Pattern p = Pattern.compile("[a-zA-Z\\-]+");
    	Matcher m = p.matcher(pattern);
    	while(m.find())
    		if(m.group().length() > length) {
    			word = m.group();
    			length = m.group().length();
    		}
    	System.out.println(word.toLowerCase());
    }
}
