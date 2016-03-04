package ArraysandStrings;

import java.util.Arrays;

public class LongestSubstring {

	// to find length of longest substring without repeating the characters
	// Time: O(n), Space: O(1)
	public int longestSubstring(String s) {
		int max = 0;
		int[] charMap = new int[256];
		Arrays.fill(charMap, -1);
		int k = 0;
		for (int i = 0; i < s.length(); i++) {
			if (charMap[s.charAt(i)] >= k) {
				k = charMap[s.charAt(i)] + 1; // startingIndex for substring
			}
			charMap[s.charAt(i)] = i;
			max = Math.max(i - k + 1, max); // check if the lenght is greater
											// than max length
		}
		return max;
	}

	// to find length of longest substring containing at the most 2 distinct
	// characters
	//Time: O(n) , Space: O(n)
	public int longestSubstring2DistinctCharacter(String s) {

		int i = 0; // to keep track of starting index
		int maxLen = 0; // to keep track of maximum length
		int distinctChar = 0; // to keep track of distinct characters
		int[] charMap = new int[256];

		for (int j = 0; j < s.length(); j++) {

			if (charMap[s.charAt(j)] == 0) {
				distinctChar++; // increase distinct characters count
			}

			charMap[s.charAt(j)]++; // increase count for the character

			while (distinctChar > 2) { // if distinct characters
										// greater than 2, change the starting
										// index of the substring
				charMap[s.charAt(i)]--;
				if (charMap[s.charAt(i)] == 0) {
					distinctChar--;
				}
				i++;
			}
			maxLen = Math.max(j - i + 1, maxLen);
		}
		return maxLen;
	}

	public static void main(String[] args) {

		LongestSubstring ls = new LongestSubstring();
		System.out.println(ls.longestSubstring2DistinctCharacter("aabbc"));
	}
}
