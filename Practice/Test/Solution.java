import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    static int startx, starty, m, count, n;
/* Head ends here */
static void displayPathtoPrincess(int q, char[][] grid){
    Queue<String> ans = new LinkedList<String>();
    Queue<Integer> x = new LinkedList<Integer>();
    Queue<Integer> y = new LinkedList<Integer>();
    if(grid[startx][starty] == 'd') {
    	System.out.println("CLEAN");
    	return;
    }
    boolean[][] visited = new boolean[m][n];
    visited[startx][starty] = true;
    x.add(startx);
    y.add(starty);
    ans.add("");
    while(x.size() != 0) {
        int xx = x.remove();
        int yy = y.remove();
        String tmp = ans.remove();
        if(grid[xx][yy] == 'd') {
            System.out.println(tmp.split("\n")[0]);
            return;
        }
        int[] xxx = {0,1,0,-1};
        int[] yyy = {1,0,-1,0};
        Vector<Integer> rand = new Vector<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        while(rand.size() != 4) {
        	int temp = (int)(Math.random()*4);
        	if(set.add(temp))
	        	rand.add(temp);
        }
        for(Integer r : rand) {
        	int i = (int)r;
            if(xx+xxx[i] >= 0 && xx+xxx[i] < m && yy+yyy[i] >= 0 && yy+yyy[i] < n)
                if(!visited[xx+xxx[i]][yy+yyy[i]]) {
                    visited[xx+xxx[i]][yy+yyy[i]] = true;
                    x.add(xx+xxx[i]);
                    y.add(yy+yyy[i]);
                if(xxx[i] == 0) {
                    if(yyy[i] == 1)
                        ans.add(tmp+"RIGHT\n");
                    if(yyy[i] == -1)
                        ans.add(tmp+"LEFT\n");
                }
                if(yyy[i] == 0) {
                    if(xxx[i] == 1)
                        ans.add(tmp+"DOWN\n");
                    if(xxx[i] == -1)
                        ans.add(tmp+"UP\n");
                }
            }
        }
    }
  }
/* Tail starts here */
public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        startx = in.nextInt();
        starty = in.nextInt();
        m = in.nextInt();
        n = in.nextInt();
        char[][] grid = new char[m][n];
        count = 0;
        for(int i = 0; i < m; i++) {
            String tmp = in.next();
            for(int j=0; j<tmp.length(); j++) {
                grid[i][j] = tmp.charAt(j);
                if(grid[i][j] == 'd')
                	count++;
            }
        }
			displayPathtoPrincess(m,grid);
    }
}