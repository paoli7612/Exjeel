package logging;

/**
 * Messaggi di errore che non causano il crash della applicazione
 * 
 * @author Tommaso Paoli
 */
public final class Error extends Log {

	public Error(final String messaggio) {
		
		super(Log.ERROR, messaggio, "[!]");
		
	}
	
}
