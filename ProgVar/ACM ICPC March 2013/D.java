import java.util.*;
import java.io.*;

public class D {
	
	static int[] qx;

    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(new FileReader("d.in"));
    	while(true) {
    		String temp = s.next();
    		int n = s.nextInt();
    		int m = s.nextInt();
    		if(temp.equals("X") && n == 0 && m == 0)
    			break;
    		s.nextLine();
    		System.out.print("Set " + temp + ": ");
    		int[] px = new int[n+1];
    		int[] dx = new int[m+1];
    		String line = s.nextLine();
    		String[] split = line.split(" ");
    		putData(split, px);
    		split = s.nextLine().split(" ");
    		putData(split, dx);
    		if(n < m) {
    			System.out.println("Q(x)=0, R(x)=" + transform(px));
    			continue;
    		}
    		qx = new int[n-m+1];
    		for(int i=n; i>=m; i--) {
    			int mult = px[i]/dx[m];
    			qx[i-m] = mult;
    			for(int j=0; j<=m; j++)
    				px[j+i-m] -= mult*dx[j];
    		}
    		System.out.println("Q(x)=" + transform(qx) + ", R(x)=" + transform(px));
    	}
    }
    
    public static String transform(int[] px) {
    	String ans = "";
    	for(int i=px.length-1; i>=0; i--) {
    		if(px[i] == 0)
    			continue;
    		if(px[i] > 0)
    			ans += " + ";
    		else
    			ans += " - ";
    		if(px[i] != 1)
    			ans += Math.abs(px[i]);
    		if(i >= 2)
    			ans += "x^" + i;
    		else if(i == 1)
    			ans += "x";
    	}
    	if(ans.equals(""))
    		return "0";
    	else
	    	return ans.substring(3);
    }
    
    public static void putData(String[] split, int[] px) {
    	boolean check = false;
		for(int i=0; i<split.length; i+=2) {
			String[] tmp = split[i].split("x");
			int num = 0;
			if(split[i].charAt(0) == 'x')
				num = 1;
			else
				num = Integer.parseInt(tmp[0]);
			if(check)
				num = -num;
			if(split[i].charAt(split[i].length()-1) == 'x')
				px[1] = num;
			else if(tmp.length == 1)
				px[0] = num;
			else
				px[Integer.parseInt(tmp[1].substring(1))] = num;
			if(i+1 < split.length) {
				if(split[i+1].equals("-"))
					check = true;
				else
					check = false;
			}
		}
    }
}
