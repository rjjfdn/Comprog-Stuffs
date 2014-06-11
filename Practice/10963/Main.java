import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	for(int i=0; i<n; i++) {
    		if(i != 0)
    			System.out.println();
    		int m = s.nextInt();
    		boolean check = true;
    		int first = Math.abs(s.nextInt()-s.nextInt());
    		for(int j=1; j<m; j++)
    			if(Math.abs(s.nextInt()-s.nextInt()) != first) {
    				check = false;
    			}
    		if(check)
    			System.out.println("yes");
    		else
    			System.out.println("no");
    	}
    }
}
