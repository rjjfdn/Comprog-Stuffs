import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(new FileReader("pb.in"));
    	while(s.hasNext()) {
    		String line = s.nextLine();
    		String[] rep = line.split("\\(");
    		String[] nonrep = (rep[0]+"0").split("\\.");
    		long num1 = Integer.parseInt(rep[1].substring(0, rep[1].length()-1));
    		String nine = "";
    		while(nine.length() != rep[1].length()-1)
    			nine += "9";
    		for(int i=0; i<nonrep[1].length()-1; i++)
    			nine += "0";
    		String ten = "";
    		while(nonrep[1].length() != ten.length())
    			ten += "0";
     		ten = "1" + ten;
     		String nr = nonrep[0]+nonrep[1];
    		long den1 = Long.parseLong(nine);
    		long den2 = Long.parseLong(ten);
    		long num2 = Long.parseLong(nr);
    		long num = num1*den2 + num2*den1;
    		long den = den1*den2;
    		long gcd = new BigInteger(""+num).gcd(new BigInteger(""+den)).longValue();
    		num /= gcd;
    		den /= gcd;
    		System.out.println(line + " = " + num + " / " + den);
    	}
    }
}
