package test;

import App.App;
import core.Foglio;
import core.Pos;

public class Alfa {

	public static void main(String[] args) {
		App app = new App(args);
		
		app.usaFoglio(0);
		app.scrivi("A2", 5);
		app.scrivi("C1", 5);
		app.scrivi("H4", -2);
		app.scrivi("A1", 2.4f);
		app.scrivi("F4", -14.6f);
				
		app.file.getFoglio(0).print();		
	}

}
