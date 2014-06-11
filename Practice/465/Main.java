import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	BigInteger max = new BigInteger("" + Integer.MAX_VALUE);
    	while(s.hasNext()) {
    	//for(int i=0; i<2; i++) {
    		String report = "";
    		String str = s.nextLine();
    		System.out.println(str);
    		Scanner in = new Scanner(str);
    		BigInteger a = in.nextBigInteger();
    		if(a.compareTo(max) > 0)
    			report += "first number too big\n";
    		char ch = in.next().charAt(0);
    		BigInteger b = in.nextBigInteger();
    		if(b.compareTo(max) > 0)
    			report += "second number too big\n";
    		if(ch == '+')
    			a = a.add(b);
    		else
    			a = a.multiply(b);
    		if(a.compareTo(max) > 0)
    			report += "result too big\n";
    		if(!report.trim().equals(""))
	    		System.out.println(report.trim());
    	}
    }
}
