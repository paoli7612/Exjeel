import core.Foglio;
import logging.*;

public class App {

	public static void main(String[] args) {

		Log.livello = Log.Level.INFO;
		Log.file = "log";
		Log.sysOut = true;
		
		new Warn(">>> Start app <<<");
		
		Foglio f = new Foglio();

		new Warn(">>> Stop app <<<");		
	}

}
