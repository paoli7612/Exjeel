package test;

import App.App;
import logging.Log;

public class Alfa {

	public static void main(String[] args) {
		Log.start(Log.INFO, true);
		App app = new App();
		
		app.write("A1", "5");
		app.write("B1", "-2");
		app.write("C1", "2.4");
		app.write("D1", "-14.6");
		app.write("E1", "14.6");
				
		app.print();		
	}

}
