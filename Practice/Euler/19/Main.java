import java.util.*;

public class Main {

    public static void main(String[] args) {
    	int count = 0;
    	for(int i=1901; i<=2000; i++)
    		for(int j=1; j<=12; j++) {
    			GregorianCalendar gc = new GregorianCalendar(i, j, 1);
    			if(gc.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
    				count++;
    		}
    	System.out.println(count);
    }
}
