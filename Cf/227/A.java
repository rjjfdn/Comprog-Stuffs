import java.util.*;

public class A {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	String[] a = s.next().split(":");
    	String[] b = s.next().split(":");
    	int hr1 = Integer.parseInt(a[0]);
    	int min1 = Integer.parseInt(a[1]);
    	int hr2 = Integer.parseInt(b[0]);
    	int min2 = Integer.parseInt(b[1]);
    	int tot1 = hr1*60+min1;
    	int tot2 = hr2*60+min2;
    	int diff = tot1-tot2;
    	if(diff < 0)
    		diff += (24*60);
    	int hr3 = diff/60;
    	int min3 = diff%60;
    	if(hr3 < 10)
    		System.out.print("0");
    	System.out.print(hr3 + ":");
    	if(min3 < 10)
    		System.out.print("0");
    	System.out.println(min3);
    }
}
