import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	String[] split = s.next().split(",");
    	Arrays.sort(split);
    	BigInteger ans = BigInteger.ZERO;
    	for(int i=0; i<split.length; i++) {
    		int sum = 0;
    		for(int j=1; j<split[i].length()-1; j++)
    			sum += (split[i].charAt(j)-'A'+1);
    		sum *= (i+1);
    		ans = ans.add(new BigInteger(""+sum));
    	}
    	System.out.println(ans);
    }
}
