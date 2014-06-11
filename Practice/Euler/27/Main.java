import java.util.*;

public class Main {

    public static void main(String[] args) {
    	boolean[] isNPrime = new boolean[10000010];
    	isNPrime[0] = true;
    	isNPrime[1] = true;
    	for(int i=2; i<10000010; i++)
    		if(!isNPrime[i])
    			for(int j=i+i; j<10000010; j+=i)
    				isNPrime[j] = true;
    	int maxn = 0;
    	int maxa = -1001, maxb = -1001;
    	for(int a=-1000; a<=1000; a++)
    		for(int b=-1000; b<=1000; b++) {
    			int n = 0;
    			while(true) {
    				int m = n*n + a*n + b;
    				if(m < 0)
    					break;
    				if(isNPrime[m])
    					break;
    				n++;
    			}
    			if(maxn < n) {
    				maxn = n;
    				maxa = a;
    				maxb = b;
    			}
    		}
    	System.out.println(maxa*maxb);
    }
}
