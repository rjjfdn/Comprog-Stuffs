import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	for(int i=0; i<n; i++) {
    		String line = s.next();
    		int[][] matrix = new int[line.length()][line.length()];
    		for(int j=0; j<line.length(); j++)
    			matrix[0][j] = line.charAt(j)-'0';
    		for(int j=1; j<line.length(); j++) {
    			line = s.next();
    			for(int k=0; k<line.length(); k++)
    				matrix[j][k] = line.charAt(k)-'0';
    		}
    		for(int j=0; j<line.length(); j++)
    			for(int k=0; k<line.length(); k++) {
    				if(j > 0)
    					matrix[j][k] += matrix[j-1][k];
    				if(k > 0)
    					matrix[j][k] += matrix[j][k-1];
    				if(j > 0 && k > 0)
    					matrix[j][k] -= matrix[j-1][k-1];
    			}
    		int max = 0;
    		for(int j=0; j<line.length(); j++)
    			for(int k=0; k<line.length(); k++)
    				for(int a=j; a<line.length(); a++)
    					for(int b=k; b<line.length(); b++) {
    						int temp = matrix[a][b];
    						if(j > 0)
    							temp -= matrix[j-1][b];
    						if(k > 0)
    							temp -= matrix[a][k-1];
    						if(j > 0 && k > 0)
    							temp += matrix[j-1][k-1];
    						if(temp == (a+1-j)*(b+1-k))
    							if(max < temp)
    								max = temp;
    					}
    		if(i != 0)
    			System.out.println();
    		System.out.println(max);
    	}
    }
}
