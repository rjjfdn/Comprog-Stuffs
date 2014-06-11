import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	for(int l=0; l<n; l++) {
    		int m = s.nextInt();
    		int[][] arrange = new int[m][52];
    		String[] cards = new String[52];
    		for(int j=0; j<m; j++)
    			for(int k=0; k<52; k++)
    				arrange[j][k] = s.nextInt();
    		String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    		String[] nums = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    		int index = 0;
    		for(int i=0; i<4; i++)
    			for(int j=0; j<13; j++)
    				cards[index++] = nums[j] + " of " + suits[i];
    		s.nextLine();
    		while(s.hasNext()) {
    			String line = s.nextLine();
    			if(line.equals(""))
    				break;
    			int idx = Integer.parseInt(line);
    			cards = shuffle(cards, arrange[idx-1]);
    		}
    		if(l != 0)
    			System.out.println();
    		for(String str : cards)
    			System.out.println(str);
    	}
    }
    
    public static String[] shuffle(String[] cards, int[] arrange) {
    	String[] newcards = new String[52];
    	for(int i=0; i<52; i++)
    		newcards[i] = cards[arrange[i]-1];
    	return newcards;
    }
}
