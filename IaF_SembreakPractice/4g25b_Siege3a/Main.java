import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(new FileReader("rk.txt"));
    	Vector<String> list = new Vector<String>();
    	while(s.hasNext()) {
    		list.addElement(s.next().replaceAll(";", ","));
    	}
    	System.out.println(list.size());
    	PrintWriter printer = new PrintWriter(new FileWriter("out.txt"));
    	printer.print("char matrix[1200][50] = {");
    	printer.print("\"" + list.elementAt(0) + "\"");
    	for(int i=1; i<list.size(); i++)
    		printer.print(", \"" + list.elementAt(i) + "\"");
    	printer.println("};");
    	printer.close();
    }
}
