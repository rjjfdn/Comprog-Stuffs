import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int[] num = new int[10002000];
    	int[] den = new int[10002000];
    	num[0] = 1;
    	den[0] = 1;
    	boolean change = true;
    	int idx = 1;
    	for(int i=1; i<4472; i++) {
    		for(int j=i, k=0; j>=0; j--, k++) {
    			if(change) {
    				num[idx] = k+1;
    				den[idx] = j+1;
    			}
    			else {
    				num[idx] = j+1;
    				den[idx] = k+1;
    			}
    			idx++;
    		}
    		change = !change;
    	}
    	while(s.hasNext()) {
    		int n = s.nextInt();
    		System.out.println("TERM " + n + " IS " + num[n-1] + "/" + den[n-1]);
    	}
    }
}