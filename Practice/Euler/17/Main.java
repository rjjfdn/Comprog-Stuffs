import java.util.*;

public class Main {

    public static void main(String[] args) {
    	int count = 0;
    	for(int i=1; i<=1000; i++) {
    		count += process(i);
    		System.out.println(i + " " + process(i));
    	}
    	System.out.println(count);
    }
    
    public static int process(int num) {
    	String line = "" + num;
    	int count = 0;
    	for(int i=0; i<line.length(); i++) {
    		if(line.length()-i == 4)
    			count += 8 + digit(line.charAt(i)-'0');
    		else if(line.length()-i == 3 && line.charAt(i) != '0') {
    			count += 7 + digit(line.charAt(i)-'0');
    			if(num%100 != 0)
    				count += 3;
    		}
    		else if(line.length()-i == 2) {
    			if(line.charAt(i) != '1')
    				count += tens(line.charAt(i)-'0') + digit(line.charAt(i)-'0');
    			else
    				count += ten(line.charAt(i+1)-'0');
    		}
    		else if(line.length() == 1)
    			count += digit(line.charAt(i)-'0');
    		else if(line.charAt(i-1) != '1')
    			count += digit(line.charAt(i)-'0');
    		System.out.println(count);
    	}
    	return count;
    }
    
    public static int ten(int n) {
    	switch(n) {
    		case 0:
    			return 3;
    		case 1: case 2:
    			return 6;
    		case 3: case 4: case 8: case 9:
    			return 8;
    		case 5: case 6:
    			return 7;
    		case 7:
    			return 9;
    	}
    	return 0;
    }
    
    public static int digit(int n) {
    	switch(n) {
    		case 1:	case 2: case 6:
    			return 3;
    		case 3: case 7: case 8:
    			return 5;
    		case 4: case 5: case 9:
    			return 4;
    	}
    	return 0;
    }
    
    public static int tens(int n) {
    	switch(n) {
    		case 2:
    			return 3;
    		case 3: case 4: case 5: case 8:
    			return 1;
    		case 6: case 7: case 9:
    			return 2;
    	}
    	return 0;
    }
}
