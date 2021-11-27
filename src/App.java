import core.Foglio;
import logging.*;

public class App {

	public static void main(String[] args) throws Exception {

		Log.livello = Log.INFO;
		Log.setFile("log");
		Log.sysOut = true;
		
		new Warn("Start app");
		
		Foglio f = new Foglio();

		new Warn("Stop app");	
		
		Log.close();
	}

}
