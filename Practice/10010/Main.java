import java.util.*;

public class Main {
	
	static int x, y;
	static char[][] matrix;
	static boolean[][] visited;
	static boolean check;

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	int[] xx = {-1, 0, 1, 1, 1, 0, -1, -1};
    	int[] yy = {1, 1, 1, 0, -1, -1, -1, 0};
    	for(int i=0; i<n; i++) {
    		if(i != 0)
    			System.out.println();
    		x = s.nextInt();
    		y = s.nextInt();
    		matrix = new char[x][y];
    		visited = new boolean[x][y];
    		for(int j=0; j<x; j++)
    			matrix[j] = s.next().toLowerCase().toCharArray();
    		int m = s.nextInt();
    		String[] words = new String[m];
    		String[] sorted = new String[m];
    		int[] xxx = new int[m];
    		int[] yyy = new int[y];
    		HashSet<Pair> set = new HashSet<Pair>();
    		for(int j=0; j<m; j++) {
    			words[j] = s.next().toLowerCase();
    			sorted[j] = words[j];
    		}
    		Arrays.sort(sorted, Collections.reverseOrder());
    		for(int j=0; j<m; j++) {
    			String str = sorted[j];
    			next:for(int k=0; k<x; k++)
					for(int l=0; l<y; l++)
						if(str.charAt(0) == matrix[k][l]) {
							for(int o=0; o<8; o++) {
								check = false;
								for(int p=1; p<str.length(); p++) {
									//System.out.println(str + " " + (k+xx[o]*p) + " " + (l+yy[o]*p) + " " + p + " " + str.length() + " " + check);
									if(k+xx[o]*p < 0 || k+xx[o]*p >= x || l+yy[o]*p < 0 || l+yy[o]*p >=y) {
										check = true;
										break;
									}
									if(matrix[k+xx[o]*p][l+yy[o]*p] != str.charAt(p)) {
										check = true;
										break;
									}
								}
								if(!check) {
									++k; ++l;
									if(set.add(new Pair(k, l))) {
										xxx[j] = k;
										yyy[j] = l;
									}
									break next;
								}
							}
						}
    		}
    		Arrays.sort(sorted);
			for(int j=0; j<m; j++) {
				String str = words[j];
				int idx = Arrays.binarySearch(sorted, str);
				idx = m-idx-1;
				System.out.println(xxx[idx] + " " + yyy[idx]);
			}
    	}
    }
}

class Pair implements Comparable<Pair> {
	
	int x, y;
	
	public Pair(int i, int j) {
		x = i;
		y = j;
	}
	
	public int compareTo(Pair p) {
		if(x != p.x)
			return x - p.x;
		else
			return y - p.y;
	}
}