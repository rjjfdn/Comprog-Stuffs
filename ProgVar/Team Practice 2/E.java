import java.util.*;
import java.io.*;

public class E {

    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(new FileReader("e.in"));
		int[][] magic1 = new int[3][3];
		int[][] magic2 = new int[3][3];
		magic1[0][0] = 8;
		magic1[0][1] = 1;
		magic1[0][2] = 6;
		magic1[1][0] = 3;
		magic1[1][1] = 5;
		magic1[1][2] = 7;
		magic1[2][0] = 4;
		magic1[2][1] = 9;
		magic1[2][2] = 2;
		for(int i=0; i<3; i++)
			for(int j=0; j<3; j++)
				magic2[j][i] = magic1[i][j];
		int cases = 1;
    	while(s.hasNext()) {
    		if(cases != 1)
    			System.out.println();
    		cases++;
			int[][] input = new int[3][3];
    		for(int i=0; i<3; i++)
    			for(int j=0; j<3; j++) {
	    			String inp = s.next();
	    			if(inp.equals("X"))
	    				input[i][j] = 0;
    				else
    					input[i][j] = Integer.parseInt(inp);
    			}
    		int[] min = new int[8];
    		for(int i=0; i<4; i++) {
    			min[i] = 2000000000;
    			int m = -1;
    			boolean check = false;
    			for(int j=0; j<3; j++) {
    				for(int k=0; k<3; k++) {
    					if(input[j][k] == 0)
    						continue;
    					if(m == -1)
    						m = input[j][k] - magic1[j][k];
    					else if(m != input[j][k] - magic1[j][k]) {
    						check = true;
    						break;
    					}
    				}
    				if(check)
    					break;
    			}
    			if(!check)
    				min[i] = m;
    			rotate(magic1);
    		}
    		for(int i=4; i<8; i++) {
    			min[i] = 2000000000;
    			int m = -1;
    			boolean check = false;
    			for(int j=0; j<3; j++) {
    				for(int k=0; k<3; k++) {
    					if(input[j][k] == 0)
    						continue;
    					if(m == -1)
    						m = input[j][k] - magic2[j][k];
    					else if(m != input[j][k] - magic2[j][k]) {
    						check = true;
    						break;
    					}
    				}
    				if(check)
    					break;
    			}
    			if(!check)
    				min[i] = m;
    			rotate(magic2);
    		}
    		int minimum = 2000000000;
    		for(int i=0; i<8; i++)
    			minimum = Math.min(minimum, (min[i]>=0)?min[i]:2000000000);
    		int[][] magic = new int[3][3];
			if(minimum == min[0]) {
				magic = magic1;
			}
			if(minimum == min[1]) {
				rotate(magic1);
				magic = magic1;
			}
			if(minimum == min[2]) {
				rotate(magic1);
				rotate(magic1);
				magic = magic1;
			}
			if(minimum == min[3]) {
				rotate(magic1);
				rotate(magic1);
				rotate(magic1);
				magic = magic1;
			}
			if(minimum == min[4]) {
				magic = magic2;
			}
			if(minimum == min[5]) {
				rotate(magic2);
				magic = magic2;
			}
			if(minimum == min[6]) {
				rotate(magic2);
				rotate(magic2);
				magic = magic2;
			}
			if(minimum == min[7]) {
				rotate(magic2);
				rotate(magic2);
				rotate(magic2);
				magic = magic2;
			}
    		for(int i=0; i<3; i++) {
    			System.out.print(magic[i][0]+minimum);
    			for(int j=1; j<3; j++)
    				System.out.print(" " + (magic[i][j]+minimum));
    			System.out.println();
    		}
    	}
    }
    
    public static void rotate(int[][] magic) {
    	int temp = magic[0][0];
    	magic[0][0] = magic[0][2];
    	magic[0][2] = magic[2][2];
    	magic[2][2] = magic[2][0];
    	magic[2][0] = temp;
    	temp = magic[0][1];
    	magic[0][1] = magic[1][2];
    	magic[1][2] = magic[2][1];
    	magic[2][1] = magic[1][0];
    	magic[1][0] = temp;
    }
}


/*
 * 8 1 6
 * 3 5 7
 * 4 9 2
 *
 * 8 3 4
 * 1 5 9
 * 6 7 2
 */