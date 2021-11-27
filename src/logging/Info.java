package logging;

public final class Info extends Log {

	public Info(final String messaggio) {

		super(Log.Level.INFO, messaggio, "[()]");
		
	}
	
}
