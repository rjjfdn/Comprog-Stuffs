import java.util.*;

public class B {
  private static int LSOne(int S) { return (S & (-S)); }

  private static Vector<Integer> ft_create(int n) { 
    Vector<Integer> v = new Vector<Integer>();
    // initialization: n + 1 zeroes, ignoring index 0, just using index [1..n]
    for (int i = 0; i <= n; i++) v.add(0);
    return v;
  }

  private static int ft_rsq(Vector<Integer> ft, int b) { // returns RSQ(1, b)
    int sum = 0; for (; b > 0; b -= LSOne(b)) sum += ft.get(b);
    return sum; }

  private static int ft_rsq(Vector<Integer> ft, int a, int b) { // returns RSQ(a, b)
    return ft_rsq(ft, b) - (a == 1 ? 0 : ft_rsq(ft, a - 1)); }

  // adjusts value of the k-th element by v (v can be +ve/inc or -ve/dec)
  private static void ft_adjust(Vector<Integer> ft, int k, int v) { // note: n = ft.size() - 1
    for (; k < (int)ft.size(); k += LSOne(k)) ft.set(k, ft.get(k) + v); }

  public static void main(String[] args) {
  	
  	Scanner s = new Scanner(System.in);
  	String line = s.nextLine().trim();;
  	Vector<Integer> ft = ft_create(line.length()-1);
  	for(int i=1; i<line.length(); i++)
  		if(line.charAt(i) == line.charAt(i-1))
  			ft_adjust(ft, i, 1);
  	int n = s.nextInt();
  	for(int i=0; i<n; i++) {
  		int x = s.nextInt();
  		int y = s.nextInt();
  		System.out.println(ft_rsq(ft, x, y-1));
  	}
            
  }
}
