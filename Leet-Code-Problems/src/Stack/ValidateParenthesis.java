package Stack;

import java.util.HashMap;
import java.util.Stack;

public class ValidateParenthesis {

	@SuppressWarnings("serial")
	private static final HashMap<Character, Character> hm = new HashMap<Character, Character>() {
		{
			put('(', ')');
			put('{', '}');
			put('[', ']');
		}
	};

	public boolean isValid(String s) {

		char[] charArray = s.toCharArray();
		Stack<Character> tempStack = new Stack<Character>();
		for (char c : charArray) {
			if (hm.containsKey(c)) {
				tempStack.push(c);
			} else if (tempStack.isEmpty() || hm.get(tempStack.pop()) != c) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

	}

}
