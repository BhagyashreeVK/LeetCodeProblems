package ArraysandStrings;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//can contain duplicates?
//is it sorted?
//O(n^2)
public class ThreeSum {

	public List<List<Integer>> findThreeSum(int[] array){
	
		Arrays.sort(array); //sort array
		List<List<Integer>> list = new LinkedList<>();
		for(int i=0; i <array.length-2;i++){
			if(i == 0 || ( i > 0 && array[i] != array[i-1])){
			int next = i+1, high = array.length-1, sum = 0 - array[i];
			while(next<high){
			 if(array[next]+array[high] == sum){
			    	list.add(Arrays.asList(array[i],array[next],array[high]));
			    	
			    	//remove duplciates
			    	while(next < high && array[next] == array[next+1])
			    		next++;
			    	while(next < high && array[high] == array[high-1])
			    		high--;
			    	//check next
			    	next++;
			    	high--;
			 } else if(array[next] + array[high] > sum)
				 high--;
			 else
				 next--;
		   }
		  }
		}
		
		return list;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
