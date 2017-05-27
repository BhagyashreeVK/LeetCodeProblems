package ArraysandStrings;

public class LongestPalindromSubstring {

	public String longestPalindromicSubstring(String s){
		
		int startIndex = 0, endIndex = 0;
		for(int i=0; i <s.length(); i++){
			
			int len1 = expandAroundCenter(s,i,i);
			int len2 = expandAroundCenter(s,i,i+1);
			int len  = Math.max(len1, len2);
			
			if(len > endIndex - startIndex){
				startIndex = i - ((len-1)/2);
				endIndex = i + (len/2);
			}
			
		}
		return s.substring(startIndex, endIndex+1);
	} 
	
	public int expandAroundCenter(String s, int right, int left){
		int R = right, L =left;
		while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
			R++;
			L--;
		}
		return R-L-1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
