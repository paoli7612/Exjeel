package App;
/**
 * Classe principale del progetto. La applicazione verra fatta partire tramite questa classe
 */

import java.util.ArrayList;
import java.util.List;
import logging.*;

/**s
 * @author Tommaso Paoli
 * 
 * Avvio della applicazione
 */
public class App {
	
	public final static int RIGHE = 10;
	public final static int COLONNE = 10;
	
	public static void main(String[] args) {
		Log.start(Log.INFO, true, "log.log");
		new Warn("START APP");
		
		
		
		if (args.length == 0) {
			
		} else {
			new Critical("Passasto argomenti");
		}
		
		
		new Warn("END APP");
	}
}
