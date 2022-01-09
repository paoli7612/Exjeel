package logging;

/**
 * Messaggi di errore che causano il crash della applicazione
 * 
 * @author Tommaso Paoli
 */
public final class Critical extends Log {

	/**
	 * 
	 * @param messaggio stringa di testo da mostrare come errore critico
	 */
	public Critical(final String messaggio) {
		super(Log.CRITICAL, messaggio, "[!!!]", "[!!!]");
	}
	
	public Critical(Exception e) {
		this(e.toString());
	}
	
}
