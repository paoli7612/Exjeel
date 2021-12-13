package test;

import App.App;
import logging.Log;

public class Alfa {

	public static void main(String[] args) {
		Log.start(Log.INFO, true);
		App app = new App(false);
		
		app.scrivi("A1", 5);
		app.scrivi("B2", 5);
		app.scrivi("C3", -2);
		app.scrivi("C4", 2.4f);
		app.scrivi("C5", -14.6f);
		app.scrivi("C1", 14.6f);
				
		app.print();		
	}

}
