package test;

import App.App;
import logging.Log;

public class Esplion {

	public static void main(String[] args) {
		Log.start(Log.INFO, true);
		App app = new App(true);
		
		app.scrivi("A1", 10);
		app.scrivi("B1", 15);
			
		app.scrivi("A3", "Somma");
		app.scrivi("B3", "=A1+B1");
		
		app.scrivi("A4", "Sottr");
		app.scrivi("B4", "=A1-B1");
		
		app.print();
		
		app.scrivi("B1", 80);
							
		app.print();


	}

}