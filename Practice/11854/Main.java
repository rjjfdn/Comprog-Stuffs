import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	while(true) {
    		int[] arr = new int[3];
    		arr[0] = s.nextInt();
    		arr[1] = s.nextInt();
    		arr[2] = s.nextInt();
    		if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0)
    			break;
    		Arrays.sort(arr);
    		if(arr[0]*arr[0] + arr[1]*arr[1] == arr[2]*arr[2])
    			System.out.println("right");
    		else
    			System.out.println("wrong");
    	}
    }
}
