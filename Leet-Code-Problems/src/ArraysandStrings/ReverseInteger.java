package ArraysandStrings;

public class ReverseInteger {

	public int reverseInteger(int x){
		int ret = 0;
		
		while( x != 0 ){
			
			if(Math.abs(ret) > 2147483647){
				return 0;
			}
			
			ret = ret * 10 + x%10;
			x /= 10;
		}
		
		return ret;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
