package ArraysandStrings;

public class ValidNumber {
	public boolean isValidNUmber(String s) {
		int i = 0;
		boolean isNumeric = false;
		
		// handle leading white spaces
		while (i < s.length() && Character.isWhitespace(s.charAt(i))) {
			i++;
		}
		//handle sign
		if (s.charAt(i) == '+' || s.charAt(i) == '-') {
			i++;
		}
		
		while (i < s.length() && Character.isDigit(s.charAt(i))) {
			i++;
			isNumeric = true;
		}
		// check if there is a '.'
		if (i < s.length() && s.charAt(i) == '.') {
			i++;
			while (i < s.length() && Character.isDigit(s.charAt(i))) {
				i++;
				isNumeric = true;
			}
		}
		// handle trailing white spaces
		while (i < s.length() && Character.isWhitespace(s.charAt(i))) {
			i++;
		}
		return i == s.length() && isNumeric;
	}

	public static void main(String[] args) {
		ValidNumber vn = new ValidNumber();
		System.out.println(vn.isValidNUmber("-123 489"));
	}
}
