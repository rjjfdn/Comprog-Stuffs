import java.util.*;

public class Main {
	
	static int count;
	
	public static void permute(String line, boolean[] visited) {
		if(line.length() == 10) {
			count++;
			if(count == 1000000)
				System.out.println(line);
			return;
		}
		if(count >= 1000000)
			return;
		for(int i=0; i<10; i++) {
			if(!visited[i]) {
				visited[i] = true;
				permute(line+""+i, visited);
				visited[i] = false;
			}
		}
	}

    public static void main(String[] args) {
    	count = 0;
    	boolean[] visited = new boolean[10];
    	permute("", visited);
    }
}
