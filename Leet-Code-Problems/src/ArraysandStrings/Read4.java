package ArraysandStrings;

public class Read4 {

	public int read(char[] buf, int n){
		char[] buffer = new char[4];
		boolean eof = false;
		int readBytes  = 0;
		
		while(!eof && readBytes < n ){
			int sz = read4(buffer);
			if(sz  < 4){
				eof = true;
			}
			int bytes = Math.min(n-readBytes, sz);
			System.arraycopy(buffer,0,buf,readBytes,bytes);
			readBytes += bytes;
		}
		
		return readBytes;
	}

	private int read4(char[] buffer) {
		
		//reads 4 characters from file and returns remaining characters to be read from the file
		//if returns < 4 then eof reached 
		return 0;
	}
}
