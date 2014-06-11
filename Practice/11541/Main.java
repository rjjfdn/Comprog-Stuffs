import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	for(int i=0; i<n; i++) {
    		String line = s.next();
    		System.out.print("Case " + (i+1) + ": ");
    		int j=0;
    		while(j<line.length()) {
    			char ch = line.charAt(j);
    			j++;
    			String num = "";
    			for(;j<line.length(); j++) {
    				if(Character.isLetter(line.charAt(j)))
    					break;
    				num += line.charAt(j);
    			}
    			for(int k=0; k<Integer.parseInt(num); k++)
    				System.out.print(ch);
    		}
    		System.out.println();
    	}
    }
}
