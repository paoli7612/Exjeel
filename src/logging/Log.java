/**
 * @author Tommaso Paoli
 */

/**
 * logging is a group of bar utils for operating on foo things.
 */
package logging;

import java.io.FileWriter;

/**
 * Classe padre per ogni messaggio stampato tramite il modulo logging
 * 
 * @author Tommaso Paoli
 * 
 * Utilizzabile per settare i parametri del modulo logging
 * 
 */
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
			if (Log.sysOut) {				
				System.out.print(str);
			}
	
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

	public static void start(int livello, boolean sysOut, String filename) {
		try {			
			Log.setFile(filename);
		} catch (Exception e) {
			new Error("Impossibile scrivere sul file di log");
		}
		Log.livello = livello;
		Log.sysOut = sysOut;
	}
	
	public static void start(int livello, boolean sysOut) {
		start(livello, sysOut, null);
	}
	
	public static void stop() {
		if (Log.file == null) {
			return;			
		}
			
		try {
			Log.close();
		} catch (Exception e) {
			new Critical("Errore salvataggio file di log");
		}
	}
	
}
