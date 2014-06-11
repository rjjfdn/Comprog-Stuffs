import java.util.*;
import java.io.*;

public class Try {

    public static void main(String[] args) throws Exception {
    	PrintWriter printer = new PrintWriter(new FileWriter("try2.out"));
    	String str = "ENSW";
    	//for(int i=0; i<4; i++)
    		//for(int j=0; j<4; j++)
    			//for(int k=0; k<4; k++)
    				//for(int l=0; l<4; l++)
    					//for(int m=0; m<4; m++)
    						//for(int n=0; n<4; n++)
    							for(int o=0; o<4; o++)
    					printer.print("\"" + //str.charAt(i) +
    									//str.charAt(j) +
    									//str.charAt(k) +
    									//str.charAt(l) +
    									//str.charAt(m) + 
    									//str.charAt(n) + 
    									str.charAt(o) + "\",");
    	printer.close();
    }
}
