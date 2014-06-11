import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int t = s.nextInt();
    	for(int i=0; i<t; i++) {
	    	int n = s.nextInt();
	    	int m = s.nextInt();
	    	Vector<DNA> list = new Vector<DNA>();
	    	for(int j=0; j<m; j++)
	    		list.addElement(new DNA(s.next()));
	    	Collections.sort(list);
	    	if(i != 0)
	    		System.out.println();
	    	for(DNA d : list)
	    		System.out.println(d.dna);
    	}
    }
}

class DNA implements Comparable<DNA> {
	
	String dna;
	
	public DNA(String d) {
		dna = d;
	}
	
	public int compareTo(DNA d) {
		int a = 0, b = 0;
		for(int i=0; i<dna.length(); i++)
			for(int j=i+1; j<dna.length(); j++)
				if(dna.charAt(i) > dna.charAt(j))
					a++;
		for(int i=0; i<d.dna.length(); i++)
			for(int j=i+1; j<d.dna.length(); j++)
				if(d.dna.charAt(i) > d.dna.charAt(j))
					b++;
		return a-b;
	}
}