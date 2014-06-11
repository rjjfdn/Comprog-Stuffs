import java.util.*;

public class Main {

    public static void main(String[] args) {
    	long t = 285, p = 165, h = 143;
    	while(true) {
    		t++;
    		p++;
    		h++;
    		long tt = t*(t+1)/2;
    		long pp = p*(3*p-1)/2;
    		long hh = h*(2*h-1);
    		System.out.println((pp-tt) + " " + (hh-tt) + " " + (hh-pp));
    		new Scanner(System.in).nextLine();
    		if(t*(t+1)/2 == p*(3*p-1)/2)
    			if(t*(t+1)/2 == h*(2*h-1))
    				break;
    	}
    	System.out.println(t);
    }
}
