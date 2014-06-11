import java.util.*;

public class C {
       
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	if(n%2 == 0) {
    		System.out.println(-1);
    	}
    	else {
    		System.out.print(0);
    		for(int i=1; i<n; i++)
    			System.out.print(" " + i);
    		System.out.println();
    		System.out.print(n-1);
    		for(int i=0; i<n-1; i++)
    			System.out.print(" " + i);
    		System.out.println();
    		System.out.print((n-1)%n);
    		for(int i=1; i<n; i++)
    			System.out.print(" " + ((i+i-1)%n));
    		System.out.println();
    	}
    }
}
