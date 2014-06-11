import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	String[] split = s.next().split(",");
    	int count = 0;
    	for(int i=0; i<split.length; i++) {
    		int m = 0;
    		for(int j=1; j<split[i].length()-1; j++)
    			m += (split[i].charAt(j)-'A'+1);
    		double n = (1.0+Math.sqrt(8*m+1))/2.0;
    		if(n == (int)n)
    			count++;
    	}
    	System.out.println(count);
    }
}
