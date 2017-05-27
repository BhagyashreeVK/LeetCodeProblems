package Stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class EvaluatePolishNotation {

	public static final Set<String> OPERATORS = new HashSet<>((Arrays.asList(
			"+", "*", "/", "-")));

	public int evaluateExpression(String[] array) {

		Stack<Integer> tempStack = new Stack<Integer>();
		int i = 0;
		while (i < array.length) {

			if (OPERATORS.contains(array[i])) {

				int operand2 = tempStack.pop();
				int operand1 = tempStack.pop();
				tempStack.push(eval(operand1, operand2, array[i]));
			} else {
				tempStack.push(Integer.parseInt(array[i]));
			}
			i++;
		}
		return tempStack.pop();
	}

	public int eval(int x, int y, String operator) {

		switch (operator) {

		case "+":
			return x + y;
		case "*":
			return x * y;
		case "-":
			return x - y;
		default:
			return x / y;

		}

	}

	// to use interface is better if we can add other operators

	interface Operator {
		int eval(int x, int y);
	}

	private static final Map<String, Operator> OPERATORS2 = new HashMap<String, Operator>() {
		{
			put("+", new Operator() {
				public int eval(int x, int y) {
					return x + y;
				}
			});
			put("-", new Operator() {
				public int eval(int x, int y) {
					return x - y;
				}
			});
			put("*", new Operator() {
				public int eval(int x, int y) {
					return x * y;
				}
			});
			put("/", new Operator() {
				public int eval(int x, int y) {
					return x / y;
				}
			});
		}
	};

	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (String token : tokens) {
			if (OPERATORS2.containsKey(token)) {
				int y = stack.pop();
				int x = stack.pop();
				stack.push(OPERATORS2.get(token).eval(x, y));
			} else {
				stack.push(Integer.parseInt(token));
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {

		String[] array = new String[] { "4", "13", "5", "/", "+" };

		EvaluatePolishNotation eval = new EvaluatePolishNotation();
		System.out.println(eval.evaluateExpression(array));

	}
}
