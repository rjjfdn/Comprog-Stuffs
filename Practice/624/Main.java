import java.util.*;

public class Main {

	static int n, sum, m;
	static int[] table;
	static Vector<Integer> answer;

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	while(s.hasNext()) {
    		n = s.nextInt();
    		m = s.nextInt();
    		table = new int[m];
    		for(int i=0; i<m; i++)
    			table[i] = s.nextInt();
    		answer = new Vector<Integer>();
    		sum = 0;
    		backtrack(0, 0, 0);
    		for(int i=0; i<answer.size(); i++)
    			System.out.print(answer.elementAt(i) + " ");
    		System.out.println("sum:" + sum);
    	}
    }
    
    public static void backtrack(int temp, int index, int s) {
    	if(index == m) {
    		if(s > sum && s <= n) {
    			sum = s;
    			answer = new Vector<Integer>();
    			while(temp != 0) {
    				index--;
    				if(temp%2 == 1)
    					answer.addElement(table[index]);
    				temp/=2;
    			}
    		}
    		return;
    	}
    	backtrack((temp*2+1), index+1, s+table[index]);
    	backtrack(temp*2, index+1, s);
    }
}
