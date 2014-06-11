import java.util.*;
import java.io.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String regex = "[^#]*#+[^#]*";
        Pattern p = Pattern.compile(regex);
        
        for(int i=0;i<n;i++){
        	int m = s.nextInt();
        	s.nextLine();
        	String[] arr = new String[m];
        	for(int j=0;j<m;j++)
        		arr[j] = s.nextLine().trim();
        		
        	boolean yes = false;
        	int idx 	= 0;
        	int count 	= 0;
        	int len 	= 0;
        	while(!arr[idx].contains("#") && idx < arr.length){
        		idx++;
        	} 
        	String str = arr[idx];       
        	if(Pattern.matches(regex,str)){
        		Pattern pat = Pattern.compile("#");
        		Matcher match = pat.matcher(str);
        		while(match.find()){
        			count++; 
        		}
        		while(idx < arr.length && arr[idx].contains("#"))
        		{
        			if(arr[idx].equals(str))
        				len++;
        			else
        				break;
        			idx++;
        		}
        	}
        	if(count == len && len != 0)
        		yes = true;
        	
        	while(idx < arr.length){
        		if(arr[idx].contains("#")){
        			yes = false;
        			break;
        		}
        		idx++;
        	}
        	System.out.print("Case #" + (i+1) + ": ");
        	System.out.println(yes? "YES":"NO");
        	
        } 
    }
}
