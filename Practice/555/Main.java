import java.util.*;
import java.io.*;

public class Main {

	static class Cards implements Comparable<Cards> {
		
		char[] card;
		char a, b;
		
		public Cards(String c) {
			card = c.toCharArray();
			if(card[0] == 'H')
				a = 'Z';
			else
				a = card[0];
			switch(card[1]) {
				case 'T':
					b = '9'+1;
					break;
				case 'J':
					b = '9'+2;
					break;
				case 'Q':
					b = '9'+3;
					break;
				case 'K':
					b = '9'+4;
					break;
				case 'A':
					b = '9'+5;
					break;
				default:
					b = card[1];
			}
		}
		
		public int compareTo(Cards c) {
			//System.out.println(new String(card) + " " + new String(c.card));
			if(a != c.a)
				return a - c.a;
			else
				return b - c.b;
		}
	}

    public static void main(String[] args) throws Exception {
    	BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    	while(true) {
    		String line = buffer.readLine();
    		if(line.equals("#"))
    			break;
    		int start = 0;
    		if(line.equals("W"))
    			start = 0;
    		if(line.equals("N"))
    			start = 1;
    		if(line.equals("E"))
    			start = 2;
    		if(line.equals("S"))
    			start = 3;
    		TreeSet<Main.Cards> ans[] = new TreeSet[4];
    		for(int i=0; i<4; i++)
    			ans[i] = new TreeSet<Main.Cards>();
    		char[] deck = (buffer.readLine() + buffer.readLine()).toCharArray();
    		for(int i=0; i<deck.length; i+=2) {
				ans[start].add(new Cards("" + deck[i] + deck[i+1]));
				start = (start+1)%4;
    		}
    		System.out.print("S:");
    		for(Cards c : ans[2])
    			System.out.print(" " + new String(c.card));
    		System.out.println();
    		System.out.print("W:");
    		for(Cards c : ans[3])
    			System.out.print(" " + new String(c.card));
    		System.out.println();
    		System.out.print("N:");
    		for(Cards c : ans[0])
    			System.out.print(" " + new String(c.card));
    		System.out.println();
    		System.out.print("E:");
    		for(Cards c : ans[1])
    			System.out.print(" " + new String(c.card));
    		System.out.println();
    	}
    }
}