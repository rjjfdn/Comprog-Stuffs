import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) {
    	HashSet<BigInteger> set = new HashSet<BigInteger>();
    	for(int i=2; i<=100; i++) {
    		for(int j=2; j<=100; j++) {
    			set.add(new BigInteger(""+i).pow(j));
    		}
    	}
    	System.out.println(set.size());
    }
}
