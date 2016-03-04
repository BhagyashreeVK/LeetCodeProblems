package ArraysandStrings;

public class ReverseString {

	/*
	 * Question: Given an input string s, reverse the string word by word.
	 * Assume string contains leading and trailing spaces More than one spaces
	 * shoudl to reduced to a single space
	 */

	// Time O(n), Space O(n)
	public String reverseWords(String s) {
		StringBuilder reversed = new StringBuilder();
		int j = s.length();
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				j = i;
			} else if (i == 0 || s.charAt(i - 1) == ' ') {
				if (reversed.length() != 0) {
					reversed.append(' ');
				}
				reversed.append(s.substring(i, j));
			}
		}
		return reversed.toString();
	}

	// No Trailing spaces
	// Time O(n), Space O(1)
	public void reverseWords(char[] s) {
		reverse(s, 0, s.length);
		int begin = 0;
		for (int i = 0; i <= s.length; i++) {
			if (i == s.length || s[i] == ' ') {
				reverse(s, begin, i);
				begin = i + 1;
			}
		}
	}

	public void reverse(char[] s, int begin, int end) {
		for (int i = begin; i >= (end - begin) / 2; i--) {
			char temp = s[begin + i];
			s[begin + i] = s[end - 1 - i];
			s[end - 1 - i] = temp;
		}
	}

	public static void main(String[] args) {
		ReverseString rs = new ReverseString();
		rs.reverseWords("  the sky is   blue!");
	}
}
