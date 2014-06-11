import java.util.*;
import java.io.*;

public class prob_e {

    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(new FileReader("prob_e.in"));
    	while(true) {
    		String line = s.nextLine().trim();
    		if(line.equals("0000"))
    			break;
    		int[] arr = new int[4];
    		for(int i=0; i<line.length(); i++) {
    			if(Character.isDigit(line.charAt(i)))
    				arr[i] = line.charAt(i) - '0';
    			else
    				arr[i] = line.charAt(i) - 'A' + 10;
    		}
    		for(int i=0; i<4; i++) {
    			arr[i] = (arr[i]+13)%16;
    		}
    		char[] ch = new char[4];
    		for(int i=0; i<4; i++) {
    			if(arr[i] >= 10)
    				ch[i] = (char)(arr[i] - 10 + 'A');
    			else
    				ch[i] = (char)(arr[i] + '0');
    		}
    		System.out.println(ch[2] + "" + ch[3] + "" + ch[0] + "" + ch[1]);
    	}
    }
}
