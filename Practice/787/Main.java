import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	while(s.hasNext()) {
    		Vector<BigInteger> list = new Vector<BigInteger>();
    		while(true) {
    			BigInteger n = s.nextBigInteger();
    			if(n.equals(new BigInteger("-999999")))
    				break;
    			list.addElement(n);
    		}
    		for(int i=1; i<list.size(); i++) {
    			BigInteger m = list.elementAt(i).multiply(list.elementAt(i-1));
    			if(!m.equals(BigInteger.ZERO))
	    			list.setElementAt(m, i);
    		}
    		BigInteger max = list.elementAt(0);
    		for(int i=1; i<list.size(); i++) {
    			if(max.compareTo(list.elementAt(i)) < 0)
    				max = list.elementAt(i);
    			for(int j=i-1; j>=0; j--) {
    				if(list.elementAt(j).equals(BigInteger.ZERO))
    					break;
    				BigInteger temp = list.elementAt(i).divide(list.elementAt(j));
    				if(max.compareTo(temp) < 0)
    					max = temp;
    			}
    		}
    		System.out.println(max);
    	}
    }
}
