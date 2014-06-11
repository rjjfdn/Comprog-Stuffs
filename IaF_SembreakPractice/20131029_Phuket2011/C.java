import java.util.*;
import java.io.*;

public class C {

    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(new FileReader("c.in"));
    	int q = s.nextInt();
    	for(int i=0; i<q; i++) {
    		int n = s.nextInt();
    		int m = s.nextInt();
    		s.nextLine();
    		int[] matrix = new int[m];
    		int[] c = new int[m];
    		for(int j=0; j<m; j++) {
    			String line = s.nextLine();
    			Scanner inp = new Scanner(line);
    			while(inp.hasNext())
	    			matrix[j] += Math.pow(2, inp.nextInt());
    		}
    		boolean check = false;
    		for(int j=0; j<(int)Math.pow(2,n); j++) {
    			boolean ch = true;
    			for(int k=0; k<m; k++) {
    				int count = j&matrix[k];
    				if(count==0 || count==matrix[k]) {
    					ch = false;
    					break;
    				}
    			}
    			if(ch) {
    				check = true;
    				break;
    			}
    		}
    		if(check)
    			System.out.print("Y");
    		else
    			System.out.print("N");
    	}
    }
}
