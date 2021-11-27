package logging;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Stream;

public class Log {

	public static int NULL = 10;
	public static int CRITICAL = 4;
	public static int ERROR = 3;
	public static int WARN = 2;
	public static int INFO = 1;
	
	public static int livello = NULL;
	private static FileWriter file;
	public static boolean sysOut;
	
	public Log(int livello, String messaggio, String base, String end) {	
		
		String str = base + " " + messaggio + " " + end + "\n";
		
		if (livello >= Log.livello) {
			System.out.print(str);
	
			if (Log.file != null) {
				try {
					Log.file.write(str);
				} catch (Exception e) {
					new Error("File di log non scrivibile");
				}
			}	
		}
			
			
	}
	
	public Log(int livello, String messaggio, String base) {
		this(livello, messaggio, base, "");
	}
	
	public static void setFile(final String filename) throws Exception {
		Log.file = new FileWriter(filename);
	}
	
	public static void close() throws Exception {
		Log.file.close();
	}
	
}
