import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	for(int i=0; i<n; i++) {
    		int m = s.nextInt();
    		System.out.print(m + " ");
    		int o = s.nextInt();
    		int[] arr = new int[o];
    		for(int j=0; j<o; j++)
    			arr[j] = s.nextInt();
    		TreeSet<Triangle> list = new TreeSet<Triangle>();
    		boolean check = false;
    		while(true) {
    			int count = 0;
    			int sum = 0;
    			boolean ch = false;
    			for(int j=0; j<o; j++) {
    				sum += arr[j];
    				if(arr[j] == 1) {
    					ch = true;
    					arr[j] = 0;
    					int left = (j-1+o)%o;
    					int right = (j+1+o)%o;
    					while(arr[left] == 0)
    						left = (left-1+o)%o;
    					while(arr[right] == 0)
    						right = (right+1+o)%o;
    					if(left == right) {
    						check = true;
    						break;
    					}
    					if(left == j || right == j) {
    						check = true;
    						break;
    					}
    					arr[left]--;
    					arr[right]--;
    					list.add(new Triangle(j, left, right));
    				}
    			}
    			if(check)
    				break;
    			if(sum == 0)
    				break;
    			if(sum != 0 && !ch) {
    				check = true;
    				break;
    			}
    		}
    		if(check)
    			System.out.println("N");
    		else {
    			System.out.println("Y");
    			for(Triangle t : list)
    				System.out.println(t.a + " " + t.b + " " + t.c);
    		}
    	}
    }
}

class Triangle implements Comparable<Triangle> {
	
	int a, b, c;
	
	public Triangle(int d, int e, int f) {
		int[] arr = new int[3];
		arr[0] = d;
		arr[1] = e;
		arr[2] = f;
		Arrays.sort(arr);
		a = arr[0]+1;
		b = arr[1]+1;
		c = arr[2]+1;
	}
	
	public int compareTo(Triangle t) {
		if(a != t.a)
			return a - t.a;
		else if(b != t.b)
			return b - t.b;
		else
			return c - t.c;
	}
	
	public String toString() {
		return a + " " + b + " " + c;
	}
}