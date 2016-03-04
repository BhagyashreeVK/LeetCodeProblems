package ArraysandStrings;

public class StringToInteger {

	int maxDiv10 = Integer.MAX_VALUE / 10;

	//Time O(n), Space O(n)
	public int atoi(String s) {

		int i = 0;
		int num = 0;
		int sign = 1;
		
		// Remove leading whitespaces
		while (i < s.length() && Character.isWhitespace(s.charAt(i))) {
			i++;
		}
		
		// handle sign
		if (s.charAt(i) == '+') {
			i++;
		} else if (s.charAt(i) == '-') {
			sign = -1;
			i++;
		}
		
		while (i < s.length() && Character.isDigit(s.charAt(i))) {
			int digit = Character.getNumericValue(s.charAt(i));
			if (num > maxDiv10 || num == maxDiv10 && digit >= 8) {
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			num = num * 10 + digit;
			i++;
		}
		return sign * num;
	}

	public static void main(String[] args) {
		StringToInteger atoi = new StringToInteger();
		String s = "-12345";
		System.out.println(atoi.atoi(s));
	}
}
