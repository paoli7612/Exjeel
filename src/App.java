import core.Foglio;
import logging.*;

public class App {

	public static void main(String[] args) throws Exception {

		Log.livello = Log.INFO;
		Log.setFile("log");
		Log.sysOut = false;
		
		new Warn("Start app");
		
		Foglio f = new Foglio();
		f.celle.get(3).get(3).value = 4f;
		f.print();

		new Warn("Stop app");	
		
		Log.close();
	}

}
