package ArraysandStrings;

public class OneEditAway {
	
	public boolean isOneEditAway(String s, String t){
		
		int m = s.length();
		int n = t.length();
		
		//consider the shorter string first
		if( m > n) 
			return isOneEditAway(t,s);
		
		if(n - m > 1)
			return false;
		
		int shift  = n - m;
		int i = 0;
		
		while(i < m && s.charAt(i) == t.charAt(i)){
			i++;
		}
		
		if(i == m){ // if reached end of shorter string that means only one edit away if shift > 0;
			return shift > 0;
		}
		
		if(shift == 0) { //if not at the end of shorter string in the skip the letter and check for next
			i++;
		}
		
		while ( i < m && s.charAt(i) == t.charAt(i + shift)){ //check for the next letters in the longer string
			i++;
		}
		
		return i == m;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
