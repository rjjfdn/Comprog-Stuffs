import java.util.*;

public class B {
        
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	int k = s.nextInt();
    	int l = s.nextInt();
    	int r = s.nextInt();
    	int sall = s.nextInt();
    	int sk = s.nextInt();
    	int[] arr = new int[n];
    	if(n == 1) {
			for(int i=0; i<arr.length; i++)
				System.out.print(sall + " ");
			System.out.println();
    		System.exit(0);
    	}
    	sall -= sk;
    	n--;
		int a = sk/k;
		int b = sk%k;
		if(b == 0) {
			b = k;
			a--;
		}
		for(int i=0; i<b; i++) {
    		arr[n--] = a+1;
    		sk -= a+1;
		}
		for(int i=b; i<k; i++) {
			arr[n--] = a;
			sk -= a;
		}
		a = sall/(n+1);
		b = sall%(n+1);
		if(b == 0) {
			b = n+1;
			a--;
		}
		for(int i=0; i<b; i++) {
    		arr[n--] = a+1;
    		sall -= a+1;
		}
		while(n >= 0) {
			arr[n--] = a;
			sall -= a;
		}
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
    }
}
