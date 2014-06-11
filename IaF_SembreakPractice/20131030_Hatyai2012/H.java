import java.util.*;
import java.io.*;

public class H {

    public static void main(String[] args) throws Exception {
    	Scanner s = new Scanner(new FileReader("h.in"));
    	int n = s.nextInt();
    	Person[] arr = new Person[n];
    	for(int i=0; i<n; i++)
    		arr[i] = new Person(s.next(), s.nextInt(), s.nextInt(), s.nextInt());
    	Arrays.sort(arr);
    	System.out.println(arr[n-1]);
    	System.out.println(arr[0]);
    }
}

class Person implements Comparable<Person> {
	
	String name;
	int year, month, day;
	
	public Person(String n, int d, int m, int y) {
		name = n;
		day = d;
		year = y;
		month = m;
	}
	
	public int compareTo(Person p) {
		if(year != p.year)
			return year-p.year;
		else if(month != p.month)
			return month-p.month;
		else
			return day-p.day;
	}
	
	public String toString() {
		return name;
	}
	
}