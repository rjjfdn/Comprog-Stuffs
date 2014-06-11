import java.util.*;

public class A {
        
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	int[] arr = new int[n];
    	for(int i=0; i<n; i++)
    		arr[i] = s.nextInt();
    	Arrays.sort(arr);
    	Vector<Integer> list = new Vector<Integer>();
    	boolean[] visited = new boolean[10];
    	for(int i=0; i<n; i++) {
    		int tmp = arr[i];
    		if(tmp == 0) {
    			list.addElement(0);
    		}
    		else if(tmp < 10 && !visited[1]) {
    			list.addElement(tmp);
    			visited[1] = true;
    		}
    		else if(tmp < 100 && tmp % 10 == 0 && !visited[2]) {
    			list.addElement(tmp);
    			visited[2] = true;
    		}
    		else if(tmp < 1000 && tmp % 100 == 0 && !visited[3]) {
    			list.addElement(tmp);
    			visited[3] = true;
    		}
    	}
    	System.out.println(list.size());
    	if(list.size() != 0)
    		System.out.print(list.elementAt(0));
    	for(int i=1; i<list.size(); i++)
    		System.out.print(" " + list.elementAt(i));
    	System.out.println();
    }
}
