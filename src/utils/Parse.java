package utils;


public class Parse {

	public static String delFirst(String str) {
		return str.substring(1, str.length());
	}

	public static String delLast(String str) {
		return str.substring(0, str.length() - 1);
	}

	public static Character cchar(Integer i) {
		return Character.forDigit(i, 16);

	}

	public static String maxStr(String text, Integer i) {
		String r = text;
		while (r.length() < i) {
			r = " " + r;
		}
		;
		r = r.substring(0, 5);
		return r;
	}

	public static String str(Integer i) {
		return str(i.floatValue());
	}

	public static String str(Float v) {
		String str = "";
		// positivo negativo
		

		// cifra delle decine
		if (v < 10 && v >= -10) {
			if (v >= 0)
				str += "  ";
			else
				str += "-";
		} else {			
			if (v >= 0)
				str += " ";
			else
				str += "-";
			str += Parse.dec(v);
		}

		// cifra delle unità
		str += Parse.uni(v);

		// decimi di unità
		if ((v % 1) * 10 != 0)
			str += "," + Parse.decim(v);
		else
			str += "  ";

		return str;
	}

	private static Integer decim(Float v) {
		return (int) Math.abs((v % 1) * 10);
	}

	public static Object cint(float v) {
		return v;
	}

	public static Integer dec(float v) {
		return (int) Math.abs(v / 10);
	}

	public static Integer uni(float v) {
		return (int) Math.abs(v % 10);
	}

	public static Float cfloat(String str) throws Exception {
		try {
			return Float.parseFloat(str);
		} catch (Exception e) {
			throw new Exception("...");
		}
	}



}
