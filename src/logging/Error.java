package logging;

/**
 * Messaggi di errore che non causano il crash della applicazione
 * 
 * @author Tommaso Paoli
 */
public final class Error extends Log {

	
	/**
	 * 
	 * @param messaggio stringa di testo da mostrare come errore non critico
	 */
	public Error(final String messaggio) {
		super(Log.ERROR, messaggio, "[!]");
	}
	
}
