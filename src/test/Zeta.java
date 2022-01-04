package test;

import App.App;
import logging.Log;

public class Zeta {

	public static void main(String[] args) {
		Log.start(Log.INFO, true);
		App app = new App(false);
		app.scrivi("A1", 2);
		app.scrivi("A2", "=A1+A1");
		app.print();

	}

}
