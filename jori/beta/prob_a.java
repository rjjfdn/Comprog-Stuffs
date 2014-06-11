import java.util.*;
import java.io.*;

public class prob_a {
	private static final int LEFT_ASSOC = 0;
	private static final int RIGHT_ASSOC = 1;

	private static final Map<String, int[]> OPERATORS = new HashMap<String, int[]>();
	static {
		OPERATORS.put("+", new int[] { 0, LEFT_ASSOC });
		OPERATORS.put("-", new int[] { 0, LEFT_ASSOC });
		OPERATORS.put("*", new int[] { 5, LEFT_ASSOC });
		OPERATORS.put("/", new int[] { 5, LEFT_ASSOC });
		OPERATORS.put("%", new int[] { 5, LEFT_ASSOC });
	}

	private static boolean isOperator(String token) {
		return OPERATORS.containsKey(token);
	}

	private static boolean isAssociative(String token, int type) {
		if (!isOperator(token)) {
			throw new IllegalArgumentException("Invalid token: " + token);
		}
		if (OPERATORS.get(token)[1] == type) {
			return true;
		}
		return false;
	}

	private static final int cmpPrecedence(String token1, String token2) {
		if (!isOperator(token1) || !isOperator(token2)) {
			throw new IllegalArgumentException("Invalied tokens: " + token1
					+ " " + token2);
		}
		return OPERATORS.get(token1)[0] - OPERATORS.get(token2)[0];
	}

	public static String[] infixToRPN(String[] inputTokens) {
		ArrayList<String> out = new ArrayList<String>();
		Stack<String> stack = new Stack<String>();
		for (String token : inputTokens) {
			if (isOperator(token)) {
				while (!stack.empty() && isOperator(stack.peek())) {
					if ((isAssociative(token, LEFT_ASSOC) && cmpPrecedence(
							token, stack.peek()) <= 0)
							|| (isAssociative(token, RIGHT_ASSOC) && cmpPrecedence(
									token, stack.peek()) < 0)) {
						out.add(stack.pop());
						continue;
					}
					break;
				}
				stack.push(token);
			} else if (token.equals("(")) {
				stack.push(token);
			} else if (token.equals(")")) {
				while (!stack.empty() && !stack.peek().equals("(")) {
					out.add(stack.pop());
				}
				stack.pop();
			} else {
				out.add(token);
			}
		}
		while (!stack.empty()) {
			out.add(stack.pop());
		}
		String[] output = new String[out.size()];
		return out.toArray(output);
	}

	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(new FileReader("prob_a.in"));
		while(s.hasNext()) {
			String line = s.nextLine();
			String[] split = line.split(" ");
			String[] output = infixToRPN(split);
			Stack<Long> stack = new Stack<Long>();
			try {
				for(String str : output) {
					//System.out.println("a: " + str + " " + stack);
					if(Character.isDigit(str.charAt(0)))
						stack.push(Long.parseLong(str));
					else {
						long a = stack.pop();
						long b = stack.pop();
						switch(str.charAt(0)) {
							case '+':
								stack.push(b+a);
								break;
							case '-':
								stack.push(Math.max(0, b-a));
								break;
							case '*':
								stack.push(a*b);
								break;
							case '/':
								stack.push(b/a);
								break;
							case '%':
								stack.push(b%a);
								break;
							default:
								int tmp = 2/0;
								break;
						}
					}
				}
			}
			catch(Exception e) {
				System.out.println("error");
				continue;
			}
			System.out.println(stack.peek());
		}
	}
}