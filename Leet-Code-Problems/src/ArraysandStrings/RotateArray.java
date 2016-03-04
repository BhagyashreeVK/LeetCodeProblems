package ArraysandStrings;

public class RotateArray {
	/*
	 * Rotate an array to the right by k steps in-place without allocating extra
	 * space. For instance, with k = 3, the array [0, 1, 2, 3, 4, 5, 6] is
	 * rotated to [4, 5, 6, 0, 1, 2, 3].
	 */

	// Time O(n), Space O(1)
	public void rotateArray(int[] array, int steps) {
		steps %= array.length;
		reverse(array, 0, array.length - 1);
		reverse(array, 0, steps - 1);
		reverse(array, steps, array.length - 1);
	}

	public void reverse(int[] array, int begin, int end) {
		while (begin < end) {
			int temp = array[begin];
			array[begin] = array[end];
			array[end] = temp;
			begin++;
			end--;
		}
	}

	public static void main(String[] args) {

		RotateArray rs = new RotateArray();
		int[] array = { 0, 1, 2, 3, 4, 5, 6 };
		rs.rotateArray(array, 3);

		for (int i : array) {
			System.out.print(i + " ");
		}
	}
}
