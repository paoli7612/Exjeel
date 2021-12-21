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

	public static String maxStr(String text, int i) {
		String r = text;
		while (r.length() < i) {
			r = " " + r;
		};
		r = r.substring(0, 5);
		return r;
	}

	public static String str(Float value) {
		return value+"";
	}
	
}
