import java.util.*;
import java.math.*;
import java.io.*;

public class C {

    public static void main(String[] args) throws Exception {
    	BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    	String line = buffer.readLine();
    	int k = Integer.parseInt(buffer.readLine());
    	long value = 0;
    	long base = 0;
    	System.out.println(pow(2, line.length()-1));
    	base = (pow(pow(2, line.length()-1), k) - 1) / (pow(2, line.length()-1) - 1);
    	for(int i=0; i<line.length(); i++) {
    		switch(line.charAt(i)) {
    			case '0': case '5':
    				value = (value+pow(2, i)) % 1000000007;
    				break;
    			default: continue;
    		}
    	}
    	System.out.println((base*value)%1000000007);
    }
    
    static long pow(long n, long exp){
  long prod = 1;
  if(exp<0) return 0;
  long mod=1000000007;
  while (exp > 0){
    if ((exp & 1) != 0)
       {prod *= n;prod=prod%mod;}
    n*=n;n=n%mod;
    exp >>= 1;
  }
  return prod;
}
}
