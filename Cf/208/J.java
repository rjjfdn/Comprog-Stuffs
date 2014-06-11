import java.util.*;
import java.io.*;

public class J {

    public static void main(String[] args) throws Exception {
//    	Scanner s = new Scanner(new FileReader("j.in"));
    	for(int i=1; i<=100; i++) {
    		int a = i+1;
    		int b = (1+a-1)*(a-1)/2;
    		int c = i;
    		int d = 0;
    		for(int j=0; j<i; j++)
    			d += a+j;
    		int n = (d-b);
    		int m = (a-c);
    		int count = 0;
    		if(n%m == 0)
    			count++;
    		for(int k=0; k<100; k++) {
    			a++;
    			b = (1+a-1)*(a-1)/2;
    			d += i;
    			n = (d-b);
    			m = (a-c);
    			if(n%m == 0)
    				count++;
    		}
    		System.out.println(i + ": " + count);
    	}
    }
}
