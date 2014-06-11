import java.util.*;
import java.io.*;

public class G {
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(new FileReader("g.in"));
		while(true){
			String in = s.nextLine().trim();
			if(in.equals("X 0"))
				break;
			String[] str = in.split(" ");
			String c = str[0];
			int n = Integer.parseInt(str[1]);
			Vector<Integer> v = new Vector<Integer>();
			for(int i=1; i<=n; i++)
				v.add(i);
            int count = 1;
			while(v.size() != 1){
				int i;
				if(count == 1)
					i = 0;
				else
					i = 1;
				for(; i<v.size(); i++)
					v.remove(i);
				count++;
				Collections.reverse(v);
			}
			System.out.println("Set " + c + ": " + v.elementAt(0));
		}
	}
}