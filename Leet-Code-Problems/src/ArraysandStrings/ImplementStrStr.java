package ArraysandStrings;

public class ImplementStrStr {

	/*
	 * Implement strstr(). Returns the index of the first occurrence of needle
	 * in haystack, or –1 if needle is not part of haystack.
	 */

	// Time: O(nm), Space: O(1)
	public int StrStr(String haystack, String needle) {

		if (needle.isEmpty()) {
			return 0;
		}

		if ((haystack.isEmpty() && !needle.isEmpty())
				|| (needle.length() > haystack.length())) {
			return -1;
		}

		for (int i = 0; i < haystack.length(); i++) {
			for (int j = 0; j < needle.length(); j++) {
				if (i + j >= haystack.length()) {
					return -1;
				}
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					break;
				}
				if (j == needle.length() - 1) {
					return i;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		ImplementStrStr implStr = new ImplementStrStr();

		String haystack = "aabbc123ddgg";
		String needle = "123";

	    needle = null;
	    
	    System.out.println(needle.isEmpty());
	    
		//System.out.println(implStr.StrStr(haystack, needle));

	}

}
