import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	TreeSet<String> dict = new TreeSet<String>();
    	String buff = "";
    	while(s.hasNext()) {
    		String line = buff + s.nextLine();
    		buff = "";
    		Scanner inp = new Scanner(line);
    		while(inp.hasNext()) {
    			String text = inp.next().trim();
    			if(inp.hasNext()) {
    				for(int i=0; i<text.length(); i++)
    					if(Character.isLetter(text.charAt(i)) || text.charAt(i) == '-') {
    						String tmp = ""+text.charAt(i);
    						int j;
    						for(j=i+1; j<text.length(); j++) {
	    						//	System.out.println(text.charAt(j));
	    						//	new Scanner(System.in).nextLine();
    							if(!Character.isLetter(text.charAt(j)) && text.charAt(j) != '-')
    								break;
    							tmp += text.charAt(j);
    						}
	    					i=j;
	    					//	System.out.println(tmp);
    						dict.add(tmp.toLowerCase());
    					}
    			}
    			else {
    				if(text.charAt(text.length()-1) == '-')
    					buff = text.substring(0, text.length()-1);
    				else {
	    				for(int i=0; i<text.length(); i++)
	    					if(Character.isLetter(text.charAt(i)) || text.charAt(i) == '-') {
	    						String tmp = ""+text.charAt(i);
	    						int j;
	    						for(j=i+1; j<text.length(); j++) {
	    							//System.out.println(text.charAt(j));
	    							//new Scanner(System.in).nextLine();
	    							if(!Character.isLetter(text.charAt(j)) && text.charAt(j) != '-')
	    								break;
	    							tmp += text.charAt(j);
	    						}
	    						i=j;
	    						//System.out.println(tmp);
    							dict.add(tmp.toLowerCase());
	    					}
    				}
    			}
    		}
    	}
    	for(String str : dict)
    		System.out.println(str);
    }
}
