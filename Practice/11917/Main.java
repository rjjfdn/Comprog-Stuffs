import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	for(int i=0; i<n; i++) {
    		int m = s.nextInt();
    		HashMap<String, Integer> map = new HashMap<String, Integer>();
    		for(int j=0; j<m; j++)
    			map.put(s.next(), s.nextInt());
    		int d = s.nextInt();
    		String subject = s.next();
    		if(!map.containsKey(subject))
    			System.out.println("Case " + (i+1) + ": Do your own homework!");
    		else if(map.get(subject) <= d)
    			System.out.println("Case " + (i+1) + ": Yesss");
    		else if(map.get(subject) <= d+5)
    			System.out.println("Case " + (i+1) + ": Late");
    		else
    			System.out.println("Case " + (i+1) + ": Do your own homework!");
    	}
    }
}
