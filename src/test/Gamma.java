package test;

import App.App;
import logging.Log;

public class Gamma {

	public static void main(String[] args) {
		Log.start(Log.INFO, true);
		App app = new App(true);
		app.nuovo_foglio(2);
		
		app.usaFoglio(0);
		app.scrivi("A1", 2);
		app.scrivi("B2", "=A1+A1");
		
		app.usaFoglio(1);
		app.scrivi("A1", 3);
		app.scrivi("B2", "=A1+A1");
		app.scrivi("C3", "=B2+B2");
		
		app.usaFoglio(2);
		app.scrivi("A1", 4);
		app.scrivi("B2", "=A1+A1");
		app.scrivi("C3", "=B2+B2");
		app.scrivi("D4", "=C3+C3");
		
		app.print();
	}

}
