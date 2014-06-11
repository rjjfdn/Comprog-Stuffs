import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int cases = 1;
    	while(true) {
    		String line = s.next();
    		if(line.equals("#"))
    			break;
    		System.out.print("Case " + cases++ + ": ");
    		if(line.equals("CIAO"))
    			System.out.println("ITALIAN");
    		else if(line.equals("HELLO"))
    			System.out.println("ENGLISH");
    		else if(line.equals("HOLA"))
    			System.out.println("SPANISH");
    		else if(line.equals("HALLO"))
    			System.out.println("GERMAN");
    		else if(line.equals("BONJOUR"))
    			System.out.println("FRENCH");
    		else if(line.equals("ZDRAVSTVUJTE"))
    			System.out.println("RUSSIAN");
    		else
    			System.out.println("UNKNOWN");
    	}
    }
}
