package test;

import App.App;
import logging.Log;

public class Beta {

	public static void main(String[] args) {
		Log.start(Log.WARN, true);
		App app = new App();
		
		app.scrivi("A1", "5");
		app.scrivi("B1", "+");
		app.scrivi("C1", "4");
		app.scrivi("D1", "->");
		app.scrivi("E1", "=A1+C1");
		app.print();		
		app.scrivi("A1", "6");
		app.print();

	}

}
