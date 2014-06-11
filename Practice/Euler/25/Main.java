import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) {
    	Vector<BigInteger> list = new Vector<BigInteger>();
    	list.addElement(BigInteger.ONE);
    	list.addElement(BigInteger.ONE);
    	while(true) {
    		list.addElement(list.elementAt(list.size()-1).add(list.elementAt(list.size()-2)));
    		if(list.elementAt(list.size()-1).toString().length() == 1000) {
    			System.out.println(list.elementAt(list.size()-1) + " " + list.size());
    			break;
    		}
    	}
    }
}
