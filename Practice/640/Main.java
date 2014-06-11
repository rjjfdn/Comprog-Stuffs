import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(System.in);
    	PrintWriter printer = new PrintWriter(new FileWriter("test.in"));
    	boolean[] visited = new boolean[1000001];
    	for(int i=1; i<=1000000; i++) {
    		int proc = self(i);
    		if(proc <= 1000000)
    			visited[proc] = true;
    	}
    	for(int i=1; i<=1000000; i++)
    		if(!visited[i])
    			printer.println("System.out.println(\"" + i + "\");");
    	printer.close();
    }
    
    public static int self(int num) {
    	String str = "" + num;
    	int tot = num;
    	for(int i=0; i<str.length(); i++)
    		tot += Integer.parseInt(str.substring(i, i+1));
    	return tot;
    }
}
