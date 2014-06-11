import java.util.*;
import java.io.*;

public class A{
	public static void main(String[] args)throws Exception{
		Scanner s = new Scanner(new FileReader("a.in"));
		int n = s.nextInt();
		while(n!=0){
			int res = 0;
			while(n != 0){
				res = (res*10) + n%10;
				n /= 10;
			}
			System.out.println(res);
			n = s.nextInt();
			
		}
	}
}