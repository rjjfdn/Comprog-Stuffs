import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer token = new StringTokenizer(buffer.readLine());
    	int p = Integer.parseInt(token.nextToken());
    	int g = Integer.parseInt(token.nextToken());
    	HashMap<String, Integer> map = new HashMap<String, Integer>();
    	for(int i=0; i<p; i++) {
    		token = new StringTokenizer(buffer.readLine());
    		map.put(token.nextToken(), (parse(token.nextToken())*10));
    	}
    	String answer = "";
    	for(int i=0; i<g; i++) {
    		token = new StringTokenizer(buffer.readLine());
    		double left = 0, right = 0;
    		boolean check = false;
    		String comp = "";
    		while(token.hasMoreTokens()) {
    			String inp = token.nextToken();
    			if(Character.isLetterOrDigit(inp.charAt(0))) {
    				if(!check)
	    				left += map.get(inp);
    				else
    					right = parse(inp);
    			}
    			else {
    				if(inp.charAt(0) != '+') {
    					check = true;
    					comp = inp;
    				}
    			}
    		}
    		right *= 10;
    		if(comp.equals(">")) {
    			if(Double.compare(left, right) > 0)
    				answer +="Guess #" + (i+1) + " was correct.\n";
    			else
    				answer +="Guess #" + (i+1) + " was incorrect.\n";
    		}
    		if(comp.equals("<")) {
    			if(Double.compare(left, right) < 0)
    				answer +="Guess #" + (i+1) + " was correct.\n";
    			else
    				answer +="Guess #" + (i+1) + " was incorrect.\n";
    		}
    		if(comp.equals(">=")) {
    			if(Double.compare(left, right) >= 0)
    				answer +="Guess #" + (i+1) + " was correct.\n";
    			else
    				answer +="Guess #" + (i+1) + " was incorrect.\n";
    		}
    		if(comp.equals("<=")) {
    			if(Double.compare(left, right) <= 0)
    				answer +="Guess #" + (i+1) + " was correct.\n";
    			else
    				answer +="Guess #" + (i+1) + " was incorrect.\n";
    		}
    		if(comp.equals("=")) {
    			if(Double.compare(left, right) == 0)
    				answer +="Guess #" + (i+1) + " was correct.\n";
    			else
    				answer +="Guess #" + (i+1) + " was incorrect.\n";
    		}
    	}
    	System.out.print(answer);
    }
    
    public static int parse(String str) {
    	int ret = 0;
    	for(int i=0; i<str.length(); i++)
    		if(Character.isDigit(str.charAt(i)))
    			ret = ret*10 + (str.charAt(i)-'0');
    	return ret;
    }
}
