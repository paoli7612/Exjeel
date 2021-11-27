package logging;

public final class Warn extends Log {

	public Warn(String messaggio) {
		
		super(Log.Level.WARN, messaggio, ">>>");
		
	}
	
}
