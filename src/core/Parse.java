package core;

public class Parse {

	public static String delFirst(String s) {
		
		StringBuilder ss = new StringBuilder(s);
		ss.deleteCharAt(0);
		
		return ss.toString();
	}
	
	public static String delLast(String s) {
		
		StringBuilder ss = new StringBuilder(s);
		ss.deleteCharAt(s.length() - 1);
		
		return ss.toString();
	}
	
	
}
