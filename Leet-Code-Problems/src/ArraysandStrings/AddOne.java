package ArraysandStrings;

import java.util.ArrayList;
import java.util.List;

public class AddOne {
	
	public void addOne(List<Integer> digits){
		for(int i= digits.size() - 1 ; i >= 0 ; i-- ){
			int digit = digits.get(i);
			if( digit  < 9){
				digits.set(i, digit+1);
				return;
			} else{
				digits.set(i, 0);
			}
		}
		digits.add(0);
		digits.set(0,1);
	}
	
	public int[] addOne(int[] array){
		
		for(int i = array.length -1 ; i >=0 ; i--){
			if(array[i] < 9){
				array[i]++;
				return array;
			}
				array[i] = 0;
		}
		
			int[] digits = new int[array.length+1];
			digits[0] = 1;
			
			return digits;
	}
	
	public static void main(String[] args) {
		List<Integer> digits = new ArrayList<Integer>();
		digits.add(8);
		digits.add(9);
		AddOne addOne = new AddOne();
		int[] digInput = new int[]{9,9,9,9};
		int[] digitsArray = addOne.addOne(digInput);
		for (int i : digitsArray){
			System.out.print(i);
		}
	}
}
