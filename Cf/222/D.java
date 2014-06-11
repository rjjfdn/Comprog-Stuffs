import java.util.*;

public class D {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n, m, ss;
    	n = s.nextInt();
    	m = s.nextInt();
    	ss = s.nextInt();
    	Student[] list = new Student[n];
    	int[] bugs = new int[m];
    	for(int i=0; i<m; i++)
    		bugs[i] = s.nextInt();
    	for(int j=0; j<n; j++)
    		list[j] = new Student();
    	for(int j=0; j<n; j++)
    		list[j].b = s.nextInt();
    	for(int j=0; j<n; j++)
    		list[j].c = s.nextInt();
    	Arrays.sort(list);
    	Arrays.sort(bugs);
    	int num = bugs[m-1];
    	
    }
}

class Student implements Comparable<Student> {
	
	int b, c;
	
	public Student() {
		b = 0;
		c = 0;
	}
	
	public int compareTo(Student s) {
		if(b != s.b)
			return s.b - b;
		else
			return c - s.c;
	}
}