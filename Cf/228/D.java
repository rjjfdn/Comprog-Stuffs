import java.util.*;
import java.math.*;
import java.security.*;

public class D {
	
	private final static SecureRandom random = new SecureRandom();
	static Vector<Integer> factors;
	
	public static BigInteger rho(BigInteger N) {
		BigInteger divisor;
		BigInteger c = new BigInteger(N.bitLength(), random);
		BigInteger x = new BigInteger(N.bitLength(), random);
		BigInteger xx = x;
		
		if(N.mod(new BigInteger("2")).compareTo(BigInteger.ZERO) == 0)
			return new BigInteger("2");
		do {
			x = x.multiply(x).mod(N).add(c).mod(N);
			xx = xx.multiply(xx).mod(N).add(c).mod(N);
			xx = xx.multiply(xx).mod(N).add(c).mod(N);
			divisor = x.subtract(xx).gcd(N);
		} while((divisor.compareTo(BigInteger.ONE)) == 0);
		
		return divisor;
	}
	
	public static void factor(BigInteger N) {
		if(N.compareTo(BigInteger.ONE) == 0)
			return;
		if(N.isProbablePrime(20)) {
			factors.addElement(N.intValue());
			return;
		}
		BigInteger divisor = rho(N);
		factor(divisor);
		factor(N.divide(divisor));
	}

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	BigInteger N = s.nextBigInteger();
    	if(N.equals(BigInteger.ONE)) {
    		System.out.println(2);
    		System.out.println("NY");
    		System.out.println("YN");
    		System.exit(0); 
    	}
    	factors = new Vector<Integer>();
    	factors.addElement(1);
    	factor(N);
    	factors.addElement(1);
    	Vector[] conns = new Vector[factors.size()];
    	for(int i=0; i<factors.size(); i++)
    		conns[i] = new Vector<Integer>();
    	conns[0].addElement(0);
    	conns[factors.size()-1].addElement(1);
    	int cur = 2;
    	boolean[][] matrix = new boolean[1000][1000];
    	for(int i=1; i<factors.size()-1; i++) {
    		int temp = factors.elementAt(i);
    		boolean check = false;
    		for(int j=0; j<temp; j++) {
    			conns[i].addElement(cur);
    			if(i == factors.size()-2) {
    				matrix[1][cur] = true;
    				matrix[cur][1] = true;
    			}
    			cur++;
    		}
    		for(int j=0; j<conns[i-1].size(); j++)
    			for(int k=0; k<conns[i].size(); k++) {
    				int idx1 = (Integer) conns[i-1].elementAt(j);
    				int idx2 = (Integer) conns[i].elementAt(k);
    				matrix[idx1][idx2] = true;
    				matrix[idx2][idx1] = true;
    			}
    	}
    	System.out.println(1000);
    	for(int i=0; i<1000; i++) {
    		for(int j=0; j<1000; j++) {
    			if(matrix[i][j])
    				System.out.print("Y");
    			else
    				System.out.print("N");
    		}
    		System.out.println();
    	}
    }
}
