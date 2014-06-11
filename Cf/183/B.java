import java.util.*;

public class B {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	String[] split = s.nextLine().split(":");
    	int year1, year2, month1, month2, day1, day2;
    	year1 = Integer.parseInt(split[0]);
    	month1 = Integer.parseInt(split[1]);
    	day1 = Integer.parseInt(split[2]);
    	split = s.nextLine().split(":");
    	year2 = Integer.parseInt(split[0]);
    	month2 = Integer.parseInt(split[1]);
    	day2 = Integer.parseInt(split[2]);
    	
    	boolean check = false;
    	
    	/*Cal[] two = new Cal[2];
    	two[0] = new Cal(year1, month1, day1);
    	two[1] = new Cal(year2, month2, day2);
    	Arrays.sort(two);
    	//System.out.println(two[0].day + " " + day1);
    	if(year1 != two[0].year || month1 != two[0].month || day1 != two[0].day)
    		check = true;
    	year1 = two[0].year;
    	month1 = two[0].month;
    	day1 = two[0].day;
    	year2 = two[1].year;
    	month2 = two[1].month;
    	day2 = two[1].day;*/
    	
    	GregorianCalendar calendar1 = new GregorianCalendar(year1, month1, day1);
    	GregorianCalendar calendar2 = new GregorianCalendar(year2, month2, day2);
    	
	    long milliseconds1 = calendar1.getTimeInMillis();
	    long milliseconds2 = calendar2.getTimeInMillis();
	    long diff = milliseconds2 - milliseconds1;
	    long diffDays = diff / (24 * 60 * 60 * 1000);
	    if(diffDays < 0)
	    	diffDays = (-diffDays)-1;
	    else if(diffDays == 0)
	    	diffDays = 1;
	    System.out.println(diffDays);
    }
}

class Cal implements Comparable<Cal> {
	
	int year, month, day;
	
	public Cal(int y, int m, int d) {
		year = y;
		month = m;
		day = d;
	}
	
	public int compareTo(Cal c) {
		if(year != c.year)
			return year - c.year;
		else if(month != c.month)
			return month - c.month;
		else
			return day - c.day;
	}
}