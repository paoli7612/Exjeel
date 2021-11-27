package logging;

/** 
 * Messaggi a cui prestare attenzione
 * 
 * @author Tommaso Paoli
 */
public final class Warn extends Log {
	
	/**
	 * 
	 * @param messaggio stringa di testo da mostrare come warning message
	 */
	public Warn(String messaggio) {
		
		super(Log.WARN, messaggio, ">>>");
		
	}
	
}
