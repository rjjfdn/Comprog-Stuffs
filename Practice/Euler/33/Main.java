import java.util.*;

public class Main {

    public static void main(String[] args) {
    	int num=1, den=1;
    	for(int i=10; i<=99; i++)
    		for(int j=i+1; j<=99; j++) {
    			if(i == j)
    				continue;
    			char[] a = (""+i).toCharArray();
    			char[] b = (""+j).toCharArray();
    			for(int k=0; k<2; k++)
    				for(int l=0; l<2; l++)
    					if(a[k] == b[l] && a[k] != '0') {
    						a[k] = ' ';
    						b[l] = ' ';
    					}
    			if(new String(a).trim().equals(""))
    				continue;
    			int x = Integer.parseInt(new String(a).trim());
    			int y = Integer.parseInt(new String(b).trim());
    			if(i*y == x*j && x < 10 && y < 10) {
    				System.out.println(i + " " + j);
    				num*=i;
    				den*=j;
    			}
    		}
    	int g = gcd(num, den);
    	System.out.println(num + " " + den);
    	System.out.println(den/g);
    }
    
    public static int gcd(int a, int b) {
    	if(b == 0)
    		return a;
    	return gcd(b, a%b);
    }
}
