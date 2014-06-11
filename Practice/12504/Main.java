import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	s.nextLine();
    	for(int q=0; q<n; q++) {
    		String a = s.nextLine();
    		String b = s.nextLine();
    		a = a.substring(1, a.length()-1);
    		b = b.substring(1, b.length()-1);
    		if(a.equals("") || b.equals("")) {
    			if(a.equals("") && b.equals(""))
    				System.out.println("No changes");
    			else if(a.equals("") && !b.equals("")) {
    				String[] bb = b.split(",");
    				Vector<String> list = new Vector<String>();
    				for(int i=0; i<bb.length; i++) {
    					String[] temp = bb[i].split(":");
    					list.addElement(temp[0]);
    				}
    				Collections.sort(list);
    				System.out.print("+" + list.elementAt(0));
    				for(int k=1; k<list.size(); k++)
    					System.out.print("," + list.elementAt(k));
    				System.out.println();
    			}
    			else {
    				String[] bb = a.split(",");
    				Vector<String> list = new Vector<String>();
    				for(int i=0; i<bb.length; i++) {
    					String[] temp = bb[i].split(":");
    					list.addElement(temp[0]);
    				}
    				Collections.sort(list);
    				System.out.print("-" + list.elementAt(0));
    				for(int k=1; k<list.size(); k++)
    					System.out.print("," + list.elementAt(k));
    				System.out.println();
    			}
    			System.out.println();
    			continue;
    		}
    		String[] aa = a.split(",");
    		String[] bb = b.split(",");
    		HashMap<String, String> map1 = new HashMap<String, String>();
    		HashMap<String, String> map2 = new HashMap<String, String>();
    		for(int i=0; i<aa.length; i++) {
    			String[] temp = aa[i].split(":");
    			map1.put(temp[0], temp[1]);
    		}
    		for(int i=0; i<bb.length; i++) {
    			String[] temp = bb[i].split(":");
    			map2.put(temp[0], temp[1]);
    		}
    		Vector<String> first = new Vector<String>();
    		Vector<String> second = new Vector<String>();
    		Vector<String> third = new Vector<String>();
    		for(Map.Entry<String, String> entry : map1.entrySet()) {
    			if(map2.containsKey(entry.getKey())) {
    				if(!map2.get(entry.getKey()).equals(entry.getValue()))
    					third.addElement(entry.getKey());
    			}
    			else
    				second.addElement(entry.getKey());
    		}
    		for(Map.Entry<String, String> entry : map2.entrySet())
    			if(!map1.containsKey(entry.getKey()))
    				first.addElement(entry.getKey());
    		Collections.sort(first);
    		Collections.sort(second);
    		Collections.sort(third);
    		if(first.size() == 0 && second.size() == 0 && third.size() == 0)
    			System.out.println("No changes");
    		else {
    			if(first.size() != 0) {
    				System.out.print("+" + first.elementAt(0));
    				for(int k=1; k<first.size(); k++)
    					System.out.print("," + first.elementAt(k));
    				System.out.println();
    			}
    			if(second.size() != 0) {
    				System.out.print("-" + second.elementAt(0));
    				for(int k=1; k<second.size(); k++)
    					System.out.print("," + second.elementAt(k));
    				System.out.println();
    			}
    			if(third.size() != 0) {
    				System.out.print("*" + third.elementAt(0));
    				for(int k=1; k<third.size(); k++)
    					System.out.print("," + third.elementAt(k));
    				System.out.println();
    			}
    		}
    		System.out.println();
    	}
    }
}
