import java.util.*;

public class Main {

    public static void main(String[] args) {
    	int sum = 1;
    	int sq = 3;
    	int diff = 2;
    	for(int i=0; i<500; i++) {
    		int square = sq*sq;
    		sum += square;
    		sum += square-diff;
    		sum += square-diff-diff;
    		sum += square-diff-diff-diff;
    		sq += 2;
    		diff += 2;
    	}
    	System.out.println(sum);
    }
}
