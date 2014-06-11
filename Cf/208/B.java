import java.util.*;

public class B {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	String a = "<3";
    	for(int i=0; i<n; i++)
    		a += s.next()+"<3";
    	String b = s.next();
    	int j = 0;
    	for(int i=0; i<b.length(); i++) {
    		if(j == a.length())
    			break;
    		if(a.charAt(j) == b.charAt(i))
    			j++;
    	}
    	if(j == a.length())
    		System.out.println("yes");
    	else
    		System.out.println("no");
    }
}
