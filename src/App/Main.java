package App;

import logging.Log;

/**
 * Classe main per l'avvio sicuro della applicazione exjeel
 */
public class Main {

	/**
	 * nel caso sia specificato il primo argomento "cli" viene avviata la applicazione con l'interfaccia grafica
	 * @param args String[] argomenti passati all'avvio del main
	 * @author Paoli Tommaso 280873
	 */
	public static void main(String[] args) {
		Log.start(Log.INFO, true);
		
		App app;
		if (args.length == 1 && args[0].equals("gui")) {
			app = new GUIApp();
		} else {
			app = new CLIApp();
		}
		app.start();
	}

}
