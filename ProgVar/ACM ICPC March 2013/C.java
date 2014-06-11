import java.util.*;
import java.io.*;

public class C{
	public static void main(String[] args)throws Exception{
		Scanner s = new Scanner(new FileReader("c.in"));
		int i=1;
		while(true){
			int a = s.nextInt();
			if(a == 0)
				break;
			int b = s.nextInt();
			int c = s.nextInt();
			int sqr = (b*b) - (4*a*c);
			if(sqr < 0)
				System.out.println("Case " + i + ": COMPLEX");
			else{
				double x1 = ((double)(0.0-b) + Math.sqrt((double)sqr))/((double)a * 2);
				double x2 = ((double)(0.0-b) - Math.sqrt((double)sqr))/((double)a * 2);
				System.out.printf("Case %d: %.4f, %.4f\n", i, x1, x2);
			}
			i++;
		}
	}
}