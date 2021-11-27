/**
 * Classe principale del progetto. La applicazione verra fatta partire tramite questa classe
 */

import core.Foglio;
import logging.*;

/**s
 * @author Tommaso Paoli
 * 
 * Avvio della applicazione
 */
public class App {

	/**
	 * @param args argomenti passati all'avvio dell'app
	 */
	public static void main(String[] args) {
		new Warn("Start app");
		Log.start(Log.INFO, true, null);
		
		try {
			Foglio f = new Foglio();
			for (int i=0; i<5; i++) {				
				f.write(i+4, 3, 4f*i/2);
			}
			f.print();			
		} catch (Exception e) {
			new Critical(e.toString());
		}

		Log.stop();
		new Warn("Stop app");	
	}

}
