import java.util.*;

public class A {
        
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	int[] arr = new int[n];
    	for(int i=0; i<n; i++)
    		arr[i] = s.nextInt();
    	boolean check1 = true;
    	boolean check2 = true;
    	boolean check3 = true;
    	boolean check4 = true;
    	for(int i=1; i<n; i++)
    		if(arr[i-1] > arr[i]) {
    			check1 = false;
    			break;
    		}
    	for(int i=1; i<n; i++)
    		if(arr[i-1] < arr[i]) {
    			check2 = false;
    			break;
    		}
    	for(int i=2; i<n; i+=2)
    		if(arr[i-2] < arr[i]) {
    			check3 = false;
    			break;
    		}
    	for(int i=3; i<n; i+=2)
    		if(arr[i-2] > arr[i]) {
    			check3 = false;
    			break;
    		}
    	for(int i=2; i<n; i+=2)
    		if(arr[i-2] > arr[i]) {
    			check4 = false;
    			break;
    		}
    	for(int i=3; i<n; i+=2)
    		if(arr[i-2] < arr[i]) {
    			check4 = false;
    			break;
    		}
    	if(check1 || check2 || check3 || check4)
    		System.out.println("no");
    	else
    		System.out.println("yes");
    }
}
