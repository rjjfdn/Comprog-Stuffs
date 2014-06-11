import java.util.*;

public class B {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	char[][] matrix = new char[n][n];
    	for(int i=0; i<n; i++)
    		matrix[i] = s.next().toCharArray();
    	boolean check = false;
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n; j++) {
    			if(matrix[i][j] == '#') {
    				if(i+2<n && j-1>=0 && j+1<n) {
    					if(matrix[i+1][j] == matrix[i][j] &&
    						matrix[i+2][j] == matrix[i][j] &&
    						matrix[i+1][j-1] == matrix[i][j] &&
    						matrix[i+1][j+1] == matrix[i][j]) {
    							matrix[i][j] = '.';
    							matrix[i+1][j] = '.';
    							matrix[i+2][j] = '.';
    							matrix[i+1][j-1] = '.';
    							matrix[i+1][j+1] = '.';
    						}
    					else {
    						check = true;
    						break;
    					}
    				}
    				else {
    					check = true;
    					break;
    				}
    			}
    		}
    		if(check)
    			break;
    	}
    	if(check)
    		System.out.println("NO");
    	else
    		System.out.println("YES");
    }
}
