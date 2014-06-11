import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	while(true) {
    		int x = s.nextInt();
    		if(x == 0)
    			break;
    		int y = s.nextInt();
    		int[][] matrix = new int[x][y];
    		for(int i=0; i<x; i++) {
    			String line = s.next();
    			for(int j=0; j<y; j++) {
    				matrix[i][j] = Integer.parseInt(line.substring(j, j+1));
					if(i > 0)
						matrix[i][j] += matrix[i-1][j];
					if(j > 0)
						matrix[i][j] += matrix[i][j-1];
					if(i > 0 && j > 0)
						matrix[i][j] -= matrix[i-1][j-1];
    			}
    		}
    		int count = 0;
    		for(int i=0; i<x; i++)
    			for(int j=0; j<y; j++)
    				for(int k=i; k<x; k++)
    					for(int l=j; l<y; l++) {
    						int sum = matrix[k][l];
    						if(i > 0)
    							sum -= matrix[i-1][l];
    						if(j > 0)
    							sum -= matrix[k][j-1];
    						if(i > 0 && j > 0)
    							sum += matrix[i-1][j-1];
    						if(((k-i)+1)*((l-j)+1) == sum)
    							count++;
    					}
    		System.out.println(count);
    	}
    }
}
