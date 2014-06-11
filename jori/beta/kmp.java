import java.util.*;

public class kmp {
	
	static int[] next;

    public static void main(String[] args) {
    	String p = " aaba";
    	String t = " aaabbaaba";
    	int m = p.length();
    	int n = t.length();
    	preprocess(p);
    	next[0] = -1;
    	int i, j;
    	for(i=0, j=0; i<n && j<m; i++, j++) {
    		while(j == 1 && t.charAt(i) != p.charAt(j))
    			j = next[j]+1;
    	}
		if(j == m)
			System.out.println(i-m+1);
		else
			System.out.println(i);
    }
    
    public static void preprocess(String p) {
    	int m = p.length();
    	next = new int[m+1];
    	int j=1, k=0;
    	next[k] = -1;
    	for(j=1; j<m-1; j++) {
    		if(p.charAt(j+1) == p.charAt(k+1))
    			next[j] = next[k];
    		else
    			next[j] = k;
    		while(k==0 && p.charAt(j+1) != p.charAt(k+1))
    			k = next[k];
    		k++;
    	}
    }
}
