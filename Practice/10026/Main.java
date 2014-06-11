import java.util.*;

public class Main {
        
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	for(int i=0; i<n; i++) {
    		if(i != 0)
    			System.out.println();
    		int m = s.nextInt();
    		Vector<Task> tasks = new Vector<Task>();
    		for(int j=0; j<m; j++)
    			tasks.addElement(new Task(s.nextInt(), s.nextInt(), j+1));
    		Collections.sort(tasks);
    		System.out.print(tasks.elementAt(0).index);
    		for(int j=1; j<m; j++)
    			System.out.print(" " + tasks.elementAt(j).index);
    		System.out.println();
    	}
    }
}

class Task implements Comparable<Task> {
	
	int time, fine;
	int index;
	
	public Task(int t, int f, int i) {
		time = t;
		fine = f;
		index = i;
	}
	
	public int compareTo(Task t) {
		return time*t.fine - fine*t.time;
	}
}