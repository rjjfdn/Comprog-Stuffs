import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		Scanner s = new Scanner(new FileReader("pa.in"));		
		int total = 0, re = 0, pt = 0, cc = 0, ea = 0, tb = 0, cm = 0, ex = 0;
		while(s.hasNext()){
			String w = s.next();
			if(w.equals("Re"))
				re++;
			else if(w.equals("Pt"))
				pt++;
			else if(w.equals("Cc"))
				cc++;
			else if(w.equals("Ea"))
				ea++;
			else if(w.equals("Tb"))
				tb++;
			else if(w.equals("Cm"))
				cm++;
			else if(w.equals("Ex"))
				ex++;
			total++;
		}
		System.out.printf("%s %d %.2f\n", "Re", re, (double)re/(double)total);
		System.out.printf("%s %d %.2f\n", "Pt", pt, (double)pt/(double)total);
		System.out.printf("%s %d %.2f\n", "Cc", cc, (double)cc/(double)total);
		System.out.printf("%s %d %.2f\n", "Ea", ea, (double)ea/(double)total);
		System.out.printf("%s %d %.2f\n", "Tb", tb, (double)tb/(double)total);
		System.out.printf("%s %d %.2f\n", "Cm", cm, (double)cm/(double)total);
		System.out.printf("%s %d %.2f\n", "Ex", ex, (double)ex/(double)total);
		System.out.println("Total " + total + " 1.00");
	}
}