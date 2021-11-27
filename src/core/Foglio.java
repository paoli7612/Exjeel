package core;

import logging.Info;

public class Foglio {

	public Foglio() {
	
		try {			
			new Info("nuovo foglio creato");
		} catch (Exception e) {
			new Error("errore nella creazione del foglio");
		}
				
	}	
}
