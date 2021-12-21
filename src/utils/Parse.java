package utils;

public class Parse {

	public static String delFirst(String str) {
		return str.substring(1, str.length());
	}
	
	public static String delLast(String str) {
		return str.substring(0, str.length()-1);
	}

	public static Character cc(int i) {
		return (char)i;
		
	}
	
}
