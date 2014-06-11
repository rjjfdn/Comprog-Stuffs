import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int m = s.nextInt();
    	int n = s.nextInt();
    	boolean[][] flag = new boolean[m+1][n+1];
    	while(s.hasNext()) {
    		int x = s.nextInt();
    		int y = s.nextInt();
    		char ch = s.next().charAt(0);
    		String line = s.next();
    		boolean check = false;
    		for(int i=0; i<line.length(); i++) {
    			//System.out.println(x + " " + y + " " + ch);
    			if(check)
    				break;
    			switch(line.charAt(i)) {
    				case 'R':
    					switch(ch) {
    						case 'N':
    							ch = 'E';
    							break;
    						case 'E':
    							ch = 'S';
    							break;
    						case 'S':
    							ch = 'W';
    							break;
    						case 'W':
    							ch = 'N';
    							break;
    					}
    					break;
    				case 'L':
    					switch(ch) {
    						case 'N':
    							ch = 'W';
    							break;
    						case 'W':
    							ch = 'S';
    							break;
    						case 'S':
    							ch = 'E';
    							break;
    						case 'E':
    							ch = 'N';
    							break;
    					}
    					break;
    				case 'F':
    					switch(ch) {
    						case 'N':
    							if(y+1 > n) {
    								if(!flag[x][y]) {
    									flag[x][y] = true;
    									check = true;
    									break;
    								}
    								else y--;
    							}
    							y++;
    							break;
    						case 'S':
    							if(y-1 < 0) {
    								if(!flag[x][y]) {
    									flag[x][y] = true;
    									check = true;
    									break;
    								}
    								else y++;
    							}
    							y--;
    							break;
    						case 'E':
    							if(x+1 > m) {
    								if(!flag[x][y]) {
    									flag[x][y] = true;
    									check = true;
    									break;
    								}
    								else x--;
    							}
    							x++;
    							break;
    						case 'W':
    							if(x-1 < 0) {
    								if(!flag[x][y]) {
    									flag[x][y] = true;
    									check = true;
    									break;
    								}
    								else x++;
    							}
    							x--;
    							break;
    					}
    					break;
    			}
    		}
    		System.out.println(x + " " + y + " " + ch + (check?" LOST":""));
    	}
    }
}
