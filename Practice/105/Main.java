import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int[] arr = new int[10050];
    	int min = 10050;
    	while(s.hasNext()) {
    	//for(int j=0; j<8; j++) {
    		int l = s.nextInt();
    		int h = s.nextInt();
    		int r = s.nextInt();
    		min = Math.min(min, l);
    		for(int i=l; i<r; i++)
    			arr[i] = Math.max(arr[i], h);
    	}
    	Vector<Integer> answer = new Vector<Integer>();
    	int height = 0;
    	for(int i=min; i<10050; i++) {
    		if(height != arr[i]) {
    			/*if(arr[i] < height)
	    			answer.addElement(i-1);
	    		else*/ answer.addElement(i);
    			answer.addElement(arr[i]);
    			height = arr[i];
    		}
    	}
    	String hi = "";
    	for(Integer i : answer)
    		hi += "" + i + " ";
    	hi = hi.trim();
    	System.out.println(hi);
    }
}
