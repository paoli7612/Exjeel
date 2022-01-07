package App;

import logging.Info;
import logging.Log;

public class Main {

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
