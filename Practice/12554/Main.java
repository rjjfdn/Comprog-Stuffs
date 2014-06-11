import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	s.nextLine();
    	String[] arr = new String[n];
    	for(int i=0; i<n; i++)
    		arr[i] = s.nextLine();
    	String[] split = "Happy birthday to you Happy birthday to you Happy birthday to Rujia Happy birthday to you".split(" ");
    	int index = 0;
    	for(int j=0; j<n/split.length+1; j++)
	    	for(int i=0; i<split.length; i++) {
	    		System.out.println(arr[index] + ": " + split[i]);
	    		index = (index+1)%n;
	    	}
    }
}
