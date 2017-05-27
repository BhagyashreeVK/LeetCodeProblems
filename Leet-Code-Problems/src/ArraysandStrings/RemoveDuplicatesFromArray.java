package ArraysandStrings;

import java.util.HashSet;

public class RemoveDuplicatesFromArray {
	
	// if it's a sorted array
	public void removeDups(int[] array){
		int i=0, j=1;
		while(j < array.length){
			if(array[i] == array[j]){
				j++;
			} else {
				array[++i] = array[j];
				array[j] = 0;
				j++;
			}
		}
	}
	
	//if not
	public void removeDupsWithHs(int[] array){
		HashSet<Integer> hs = new HashSet<Integer>();
		int i=0, j =0;
		while(i < array.length){
			if(hs.contains(array[i])){
				i++;
			} else {
				hs.add(array[i]);
				array[j] = array[i];
				i++;
				j++;
			}
		}
		
		while(j < array.length){
			array[j] = 0;
			j++;
		}
	}
	
	public void removeDupsWithoutHs(int[] array){

		for(int i = 0; i < array.length; i++){
			for(int j = i+1; j < array.length; j++){
				if(array[i] == array[j]){
					continue;
				} else {
					
				    if(i+j< array.length){
					  array[i+j] = array[j];
				    }
				}
			}
		}
	}
}
