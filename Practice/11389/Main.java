import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	while(true) {
    		int n = s.nextInt();
    		int d = s.nextInt();
    		int r = s.nextInt();
    		if(n == 0 && d == 0 && r == 0)
    			break;
    		int count = 0;
    		int[] first = new int[n];
    		int[] second = new int[n];
    		for(int i=0; i<n; i++)
    			first[i] = s.nextInt();
    		for(int i=0; i<n; i++)
    			second[i] = s.nextInt();
    		Arrays.sort(first);
    		Arrays.sort(second);
    		for(int i=0, j=second.length-1; i<first.length; i++, j--) {
    			int out = first[i]+second[j];
    			if(out > d)
	    			count += ((first[i]+second[j])-d);
    		}
    		System.out.println(count*r);
    	}
    }
}
