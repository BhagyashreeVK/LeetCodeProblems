package ArraysandStrings;

import java.util.HashMap;

public class Two_Sum {

	/*
	 * Given an array of integers, find two numbers such that they add up to a
	 * specific target number. The function twoSum should return indices of the
	 * two numbers such that they add up to the target, where index1 must be
	 * less than index2. Please note that your returned answers (both index1 and
	 * index2) are not zero-based. You may assume that each input would have
	 * exactly one solution.
	 */

	// Time: O(n), Space: O(n)
	public int[] twoSum(int[] inputArray, int sum) {

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

		for (int i = 0; i < inputArray.length; i++) {
			int difference = sum - inputArray[i];
			if (hm.containsKey(difference)) { // check if the difference already exists
				return new int[] { hm.get(difference) + 1, i + 1 }; // indices found
			}
			hm.put(inputArray[i], i); // put integer and it's index in the hashmap
		}
		return new int[] { -1, -1 }; // indices not found
	}

	// What if array is already sorted?
	// Binary search will take O(n log n), instead scan array from both sides
	// Time: O(n), Space: O(1)
	public int[] twoSumSortedArray(int[] inputArray, int sum) {

		int i = 0, j = inputArray.length - 1;
		while (i < j) {

			if (inputArray[i] + inputArray[j] < sum) {
				i++;
			} else if (inputArray[i] + inputArray[j] > sum) {
				j--;
			} else if (inputArray[i] + inputArray[j] == sum) {
				return new int[] { i + 1, j + 1 }; // indices found
			}
		}
		return new int[] { -1, -1 };
	}

	public void printArray(int[] inputArray) {
		for (int i : inputArray) {
			System.out.print(i + " ");
		}
	}

	public int[] findSum(int[] array, int sum){
		int difference = 0;
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		for(int i=0; i< array.length;i++){
		difference = sum - array[i];
		if(hm.containsKey(difference)){
		return new int[] {hm.get(difference)+1, i+1};
		}
		hm.put(array[i],i);
		}
		throw new IllegalArgumentException("No Two Sum Solution");
		}
	
	

public int[] findSum2(int[] array, int sum){


int i = 0, j = array.length -1;
int currentSum =  0;
while(i<j){
currentSum= array[i] + array[j];
if(currentSum < sum){
i++;
} else if(currentSum > sum){
j--;
} else if(currentSum == sum){
return new int[]{i+1, j+1};
}
}
throw new IllegalArgumentException("No solution found");
}
	
	public static void main(String[] args) {

		Two_Sum twoSum = new Two_Sum();

		int[] firstArray = { 1, 4, 4, 21, 9, 2 }; // unsorted Array
		int[] secondArray = { 1, 2, 4, 9, 12, 21 }; // sorted Array

		int[] solution1 = twoSum.twoSum(firstArray, 8);
		int[] solution2 = twoSum.twoSumSortedArray(secondArray, 33);

		twoSum.printArray(solution1);
		System.out.println();
		twoSum.printArray(solution2);

	}

}
