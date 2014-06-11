import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	for(int i=0; i<n; i++) {
    		Player[] players = new Player[10];
    		for(int j=0; j<10; j++)
    			players[j] = new Player(s.next(), s.nextInt(), s.nextInt());
    		boolean[] visited = new boolean[10];
    		Vector<LineUp> list = new Vector<LineUp>();
    		int max = -1;
    		for(int j=0; j<10; j++) {
    			visited[j] = true;
    			for(int k=j+1; k<10; k++) {
    				visited[k] = true;
    				for(int l=k+1; l<10; l++) {
    					visited[l] = true;
    					for(int m=l+1; m<10; m++) {
    						visited[m] = true;
    						for(int o=m+1; o<10; o++) {
    							visited[o] = true;
    							Vector<Player> atts = new Vector<Player>();
    							Vector<Player> defs = new Vector<Player>();
    							for(int p=0; p<10; p++) {
    								if(visited[p])
    									atts.addElement(players[p]);
    								else
    									defs.addElement(players[p]);
    							}
    							LineUp temp = new LineUp(atts, defs);
    							list.addElement(temp);
    							visited[o] = false;
    						}
    						visited[m] = false;
    					}
    					visited[l] = false;
    				}
    				visited[k] = false;
    			}
    			visited[j] = false;
    		}
    		Collections.sort(list);
    		System.out.println("Case " + (i+1) + ":");
    		System.out.println(list.elementAt(0));
    	}
    }
}

class LineUp implements Comparable<LineUp> {
	
	Vector<Player> atts, defs;
	int atot, dtot;
	
	public LineUp(Vector<Player> a, Vector<Player> d) {
		atts = a;
		defs = d;
		atot = 0;
		dtot = 0;
		Collections.sort(atts);
		Collections.sort(defs);
		for(int i=0; i<5; i++) {
			atot += atts.elementAt(i).att;
			dtot += defs.elementAt(i).def;
		}
	}
	
	public int compareTo(LineUp lu) {
		if(atot != lu.atot)
			return lu.atot - atot;
		else if(dtot != lu.dtot)
			return lu.dtot - dtot;
		else {
			for(int i=0; i<5; i++) {
				String first = atts.elementAt(i).name;
				String second = lu.atts.elementAt(i).name;
				if(!first.equals(second))
					return first.compareTo(second);
			}
			return 0;
		}
	}
	
	public String toString() {
		String ret = "(" + atts.elementAt(0).name;
		for(int i=1; i<5; i++)
			ret += ", " + atts.elementAt(i).name;
		ret += ")\n(" + defs.elementAt(0).name;
		for(int i=1; i<5; i++)
			ret += ", " + defs.elementAt(i).name;
		ret += ")";
		return ret;
	}
}

class Player implements Comparable<Player> {
	
	String name;
	int att, def;
	
	public Player(String n, int a, int d) {
		name = n;
		att = a;
		def = d;
	}
	
	public int compareTo(Player p) {
		return name.compareTo(p.name);
	}
}