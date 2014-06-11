import java.util.*;
import java.io.*;

public class B {
	
	public static int backtrack(int[] arr, boolean check, int index) {
		if(index >= arr.length-1)
			return 0;
		if(index < 0)
			index = 0;
		int count = 0;
		//System.out.println("entered " + check + " " + index);
		//System.out.print("arr: ");
		//print(arr);
		//System.out.println();
		if(check) {
			if(arr[index] > arr[index+1]) {
				int tmp = arr[index];
				arr[index] = arr[index+1];
				arr[index+1] = tmp;
				int c1 = backtrack(arr, check, index-1);
				tmp = arr[index];
				arr[index] = arr[index+1];
				arr[index+1] = tmp;
				int c2 = backtrack(arr, !check, index+1);
				count = Math.min(1+c1, c2);
			}
			else
				count = backtrack(arr, check, index+1);
		}
		else {
			if(arr[index] > arr[index+1])
				count = backtrack(arr, check, index+1);
			else {
				int tmp = arr[index];
				arr[index] = arr[index+1];
				arr[index+1] = tmp;
				count = 1+backtrack(arr, check, index+1);
				tmp = arr[index];
				arr[index] = arr[index+1];
				arr[index+1] = tmp;
			}
		}
		//print(arr);
		//System.out.println(", " + count + " " + index);
		return count;
	}
	
	public static void print(int[] arr) {
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
	}

    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(new FileReader("b.in"));
    	PrintWriter p = new PrintWriter(new FileWriter("b2.out"));
    	int t = s.nextInt();
    	for(int i=0; i<t; i++) {
    		int n = s.nextInt();
    		int[] arr = new int[n];
    		int[] arr2 = new int[n];
    		for(int j=0; j<n; j++)
    			arr[j] = s.nextInt();
    		for(int j=0; j<n; j++)
    			arr2[j] = arr[n-1-j];
    		int c1 = backtrack(arr, true, 0);
    		int c2 = backtrack(arr2, true, 0);
    		p.println("Case #" + (i+1) + ": " + Math.min(c1, c2));
    		System.out.println("Case #" + (i+1) + ": " + Math.min(c1, c2));
    		//p.println("Case #" + (i+1) + ": " + backtrack(arr, true, 0));
    		//System.out.print("Case #" + (i+1) + ": " + backtrack(arr, true, 0) + " --- ");
    		//System.out.println("Case #" + (i+1) + ": " + backtrack(arr2, true, 0));
    	}
    	p.close();
    }
}
