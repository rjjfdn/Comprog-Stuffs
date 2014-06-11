import java.util.*;
import java.io.*;
import java.math.*;
import java.util.regex.*;

public class B {

    public static void main(String[] args) throws Exception {
    	BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    	String str = buffer.readLine();
    	Pattern pattern = Pattern.compile("heavy");
    	Matcher matcher = pattern.matcher(str);
    	BigInteger count = BigInteger.ZERO;
    	Vector<Pair> heavy = new Vector<Pair>();
    	Vector<Pair> metal = new Vector<Pair>();
    	while(matcher.find()) {
    		heavy.addElement(new Pair(matcher.start(), matcher.end()));
    	}
    	pattern = Pattern.compile("metal");
    	matcher = pattern.matcher(str);
    	while(matcher.find()) {
    		metal.addElement(new Pair(matcher.start(), matcher.end()));
    	}
    	for(int i=0; i<heavy.size(); i++) {
    		Pair temp = heavy.elementAt(i);
    		int index = Collections.binarySearch(metal, temp);
    		if(index < 0) {
    			index = - index - 1;
    		}
    		count = count.add(new BigInteger(""+metal.size()).subtract(new BigInteger(""+index)));
    	}
    	System.out.println(count);
    }
}

class Pair implements Comparable<Pair> {
	
	int x, y;
	
	public Pair(int a, int b) {
		x = a;
		y = b;
	}
	
	public int compareTo(Pair p) {
		return x - p.x;
	}
}