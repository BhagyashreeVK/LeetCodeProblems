package ArraysandStrings;

public class ValidPalindrome {

	/*
	 * Given a string, determine if it is a palindrome, considering only
	 * alphanumeric characters and ignoring cases. For example,
	 * "A man, a plan, a canal: Panama" is a palindrome. "race a car" is not a
	 * palindrome.
	 * 
	 * Q: What about an empty string? Is it a valid palindrome? A: For the
	 * purpose of this problem, we define empty string as valid palindrome.
	 */

	// Time:O(n) Space:O(1)
	public boolean isValidPalindrome(String s) {

		if (s.isEmpty() || s.length() == 0 || s.equals(" ")) {
			return true;
		}

		int i = 0, j = s.length() - 1;

		while (i < j) {

			while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
				i++;
			}

			while (j > i && !Character.isLetterOrDigit(s.charAt(j))) {
				j--;
			}

			if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s
					.charAt(j))) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		ValidPalindrome vPal = new ValidPalindrome();
		System.out.println("String a12: 21a is a palindrome: "
				+ vPal.isValidPalindrome("a12: 21a"));
	}
}
