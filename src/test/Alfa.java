package test;

import App.App;
import logging.Log;

public class Alfa {

	public static void main(String[] args) {
		Log.start(Log.INFO, true);
		App app = new App();
		
		app.scrivi("A1", "5");
		app.scrivi("B1", "-2");
		app.scrivi("C1", "2.4");
		app.scrivi("D1", "-14.6");
		app.scrivi("E1", "14.6");
				
		app.print();		
	}

}
