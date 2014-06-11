import java.util.*;

public class B {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	char[] line = s.next().toCharArray();
    	long count = 0;
    	for(int j=0; j<line.length; j++)
    	for(int i=j; i<line.length-3; i++) {
    		if(line[i] == 'b' && line[i+1] == 'e' && line[i+2] == 'a' && line[i+3] == 'r') {
    			count += line.length-(i+3);
    			break;
    		}
    	}
    	System.out.println(count);
    }
}
