

public class CountFrequency {
	
	public static int count(char ch,StringBuilder strg) {
		int count = 0;
		for(int i = 0 ; i < strg.length() ; i++) {
			if(strg.charAt(i) == ch) {
				strg.deleteCharAt(i);
				count++;
				i--;
			}
		}
		return count;
	}
	
}
