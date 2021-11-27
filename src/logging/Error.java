package logging;

public final class Error extends Log {

	public Error(final String messaggio) {
		
		super(Log.Level.ERROR, messaggio, "[!]");
	}
	
}
