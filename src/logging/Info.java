package logging;

/** 
 * Messaggi informativi che attestano solo cosa sia andato correttamente
 * 
 * @author Tommaso Paoli
 */
public final class Info extends Log {

	/**
	 * 
	 * @param messaggio stringa di testo da mostrare come info
	 */
	public Info(final String messaggio) {

		super(Log.INFO, messaggio, "[()]");
		
	}
	
}
