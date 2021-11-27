package logging;

public final class Critical extends Log {

	public Critical(final String messaggio) {
		
		super(Log.CRITICAL, messaggio, "[!!!]", "[!!!]");
		
	}
	
}
