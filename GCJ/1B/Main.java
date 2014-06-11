import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	PrintWriter printer = new PrintWriter(new FileWriter("atest.in"));
    	printer.println(100);
    	for(int i=0; i<100; i++) {
    		int tmp = (int)(Math.random()*10000+1);
    		printer.println(tmp + " 100");
    		for(int j=0; j<100; j++) {
    			tmp = (int)(Math.random()*1000000+1);
    			printer.print(tmp + " ");
    		}
    		printer.println();
    	}
    	printer.close();
    }
}
