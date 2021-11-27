package logging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.stream.Stream;

public class Log {

	public enum Level { CRITICAL, ERROR, WARN, INFO, NULL };
	
	public static Level livello = Level.ERROR;
	public static String file;
	public static boolean sysOut;
	
	public Log(Level livello, String messaggio, String base, String end) {	
		
		String str = base + " " + messaggio + " " + end;
		
		if (livello == Log.livello) {
			System.out.println(str);
		}
		
		try {
			if (Log.file != null) {
				FileWriter fw = new FileWriter(Log.file);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(str);
			}			
		} catch (Exception e) {
			new Error("File di log non scrivibile");
		}
			
			
	}
	
	public Log(Level livello, String messaggio, String base) {
		this(livello, messaggio, base, "");
	}
	
}
