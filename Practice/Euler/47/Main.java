import java.util.*;

public class Main {

    public static void main(String[] args) {
    	int[] factors = new int[10000010];
    	for(int i=2; i<10000010; i++)
    		if(factors[i] == 0)
    			for(int j=i+i; j<10000010; j+=i)
    				factors[j]++;
    	for(int i=4; i<10000010; i++) {
    		if(factors[i] == 4 && factors[i-1] == 4 && factors[i-2] == 4 && factors[i-3] == 4) {
    			System.out.println(i-3);
    			break;
    		}
    	}
    }
}
