package ArraysandStrings;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

	public List<String> findMissingRanges(int[] array, int begin, int end) {

		List<String> missingRanges = new ArrayList<String>();
		int start = begin - 1; // for first missing range starting from array[0]
		for (int i = 0; i <= array.length; i++) {
			int last = (i == array.length) ? end + 1 : array[i];
			// for handling the last missing range inclusive the end element
			if (last - start > 1) {
				missingRanges.add(getRange(start + 1, last - 1));
			}
			start = last; // the start of next missing range
		}
		return missingRanges;
	}

	public String getRange(int start, int last) {
		String range = (start == last) ? String.valueOf(start) : 
			start + "->" + last;
		return range;
	}

	public static void main(String[] args) {

		MissingRanges mr = new MissingRanges();
		int[] array = { 0, 1, 3, 50, 75 };
		List<String> output = mr.findMissingRanges(array, 0, 99);
		for (String s : output) {
			System.out.print(" " + s);
		}
	}
}
