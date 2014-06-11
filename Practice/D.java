import java.util.*;

public class D {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int numcase = in.nextInt();
	if (numcase <= 0 || numcase > 100)
	    throw new IllegalArgumentException();

	for (int ncase = 0; ncase < numcase; ++ncase) {
	    int N = in.nextInt();
	    if (N < 2 || N > 100)
		throw new IllegalArgumentException();

	    int[] piles = new int[N];
	    int sum = 0;
	    for (int i = 0; i < N; ++i) {
		piles[i] = in.nextInt();
		sum += piles[i];
		if (piles[i] <= 0)
		    throw new IllegalArgumentException();
	    }

	    // check that the sum is a power of two
	    boolean powerOf2 = false;
	    for (int i = 1; i <= 30; ++i) {
		if (sum == (1 << i)) {
		    powerOf2 = true;
		    break;
		}
	    }
	    if (!powerOf2)
		throw new IllegalArgumentException();

	    // Main idea: the operation are designed such that we can make all piles
	    // even. So we do that, divide by 2, and recurse.
	    int numRecurse = 0;
	    while (sum % 2 == 0) {
		// separate into even and odd piles
		Queue<Integer> even = new LinkedList<Integer>();
		Queue<Integer> odd = new LinkedList<Integer>();

		for (int i = 0; i < N; ++i) {
		    if (piles[i] % 2 == 0)
			even.offer(piles[i]);
		    else
			odd.offer(piles[i]);
		}

		// now take 2 odd piles and make them into even piles
		while (!odd.isEmpty()) {
		    int odd1 = odd.poll();
		    int odd2 = odd.poll();

		    if (odd1 == odd2) {
			even.offer(odd1 + odd2);
		    } else {
			even.offer(Math.abs(odd1 - odd2));
			even.offer(2 * Math.min(odd1, odd2));
		    }
			System.out.println(odd1 + " " + odd2);
		    System.out.println((odd1 * (1 << numRecurse)) + " " + 
				       (odd2 * (1 << numRecurse)));
		}

		// store the result of this run back to piles
		N = 0;
		while (!even.isEmpty()) {
		    piles[N++] = even.poll()/2;
		}
		++numRecurse;
		sum /= 2;
	    }
	    System.out.println("0 0");
	}
    }
}