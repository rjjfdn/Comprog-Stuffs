import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int[][] matrix = new int[100][100];
    	for(int i=0; i<100; i++)
    		for(int j=0; j<=i; j++)
    			matrix[i][j] = s.nextInt();
    	int max = 0;
    	for(int i=1; i<100; i++) {
    		for(int j=0; j<=i; j++) {
    			if(j == 0)
    				matrix[i][j] += matrix[i-1][j];
    			else if(j == i)
    				matrix[i][j] += matrix[i-1][j-1];
    			else
    				matrix[i][j] += Math.max(matrix[i-1][j], matrix[i-1][j-1]);
    			max = Math.max(matrix[i][j], max);
    		}
    	}
    	System.out.println(max);
    }
}
