import java.util.*;

public class Main {
        
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	for(int i=0; i<n; i++) {
    		int x = s.nextInt();
    		int y = s.nextInt();
    		char[][] matrix = new char[x][y];
    		for(int j=0; j<x; j++)
    			matrix[j] = s.next().toCharArray();
    		boolean[][] visited = new boolean[x][y];
    		Vector<Language> list = new Vector<Language>();
    		int[] languages = new int[26];
			for(int j=0; j<x; j++)
				for(int k=0; k<y; k++) {
					if(!visited[j][k]) {
						char tmp = matrix[j][k];
						languages[(int)(matrix[j][k]-'a')]++;
    					Queue<Integer> qx = new LinkedList<Integer>();
    					Queue<Integer> qy = new LinkedList<Integer>();
						qx.add(j);
						qy.add(k);
						while(qx.size() != 0) {
							int xx = qx.remove();
							int yy = qy.remove();
							visited[xx][yy] = true;
							int[] xxx = {0,1,0,-1};
							int[] yyy = {1,0,-1,0};
							for(int l=0; l<4; l++)
								if(xx+xxx[l] >= 0 && xx+xxx[l] < x)
									if(yy+yyy[l] >= 0 && yy+yyy[l] < y)
										if(!visited[xx+xxx[l]][yy+yyy[l]])
											if(matrix[xx+xxx[l]][yy+yyy[l]] == tmp) {
												qx.add(xx+xxx[l]);
												qy.add(yy+yyy[l]);
											}
						}
					}
				}
			for(int j=0; j<26; j++)
				if(languages[j] > 0)
					list.addElement(new Language((char)(j+'a'), languages[j]));
			Collections.sort(list);
			System.out.println("World #" + (i+1));
			for(int j=0; j<list.size(); j++)
				System.out.println(list.elementAt(j));
    	}
    }
}

class Language implements Comparable<Language> {
	
	char lang;
	int freq;
	
	public Language(char l, int f) {
		lang = l;
		freq = f;
	}
	
	public int compareTo(Language l) {
		if(freq != l.freq)
			return l.freq - freq;
		else
			return lang - l.lang;
	}
	
	public String toString() {
		return lang + ": " + freq;
	}
}