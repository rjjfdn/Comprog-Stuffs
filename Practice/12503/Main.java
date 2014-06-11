import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	for(int i=0; i<n; i++) {
    		int m = s.nextInt();
    		s.nextLine();
    		int sum = 0;
    		int[] arr = new int[m];
    		boolean check = false;
    		for(int j=0; j<m; j++) {
    			String tmp = s.nextLine();
    			if(tmp.charAt(0) == 'L') {
    				sum--;
    				arr[j] = -1;
    			}
    			else if(tmp.charAt(0) == 'R') {
    				sum++;
    				arr[j] = 1;
    			}
    			else {
    				Scanner sc = new Scanner(tmp);
    				sc.next();
    				sc.next();
    				int o = sc.nextInt();
    				arr[j] = arr[o-1];
    				sum += arr[j];
    			}
    		}
    		System.out.println(sum);
    	}
    }
}
