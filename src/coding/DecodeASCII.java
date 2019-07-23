package coding;

import org.junit.Test;

public class DecodeASCII {
	
	/**
	 * string number to integer number
	 * */
	public int decodeASCII(String s) {
		char[] cs = s.toCharArray();
		int r = 0;
		for (char c : cs) {
			r = r * 10 + (c - 48);
		}
		return r;
	}
	
	@Test
	public void tryDecode(){
		System.out.println(decodeASCII("12"));
	} 
}
