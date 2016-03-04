package ArraysandStrings;

import java.util.HashMap;

/*Design and implement a TwoSum class. It should support the following operations: add 
 * and find.
 * add(input) – Add the number input to an internal data structure.
 * find(value) – Find if there exists any pair of numbers which sum is equal to the value.
 * For example, add(1); add(3); add(5); find(4) -> true; find(7) -> false
 */

//Space Complexity: O(n)
public class TwoSum {

	HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

	// O(1)
	public void add(int number) {
		if (hm.containsKey(number)) {
			int count = hm.get(number);
			hm.put(number, ++count);
		} else {
			hm.put(number, 1);
		}
	}

	// O(n)
	public boolean find(int sum) {
		for (int key : hm.keySet()) {
			int difference = sum - key;
			if (difference == key) { // to check for duplicate entries
				if (hm.get(key) >= 2) { // the count should be atleast 2
					return true;
				}
			} else if (hm.containsKey(difference)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {

		TwoSum twoSum = new TwoSum();

		twoSum.add(1);
		twoSum.add(3);
		twoSum.add(5);

		System.out.println("find(4) -> " + twoSum.find(4));
		System.out.println("find(5) -> " + twoSum.find(4));
	}
}
