package test;

import App.App;
import logging.Log;

public class Gamma {

	public static void main(String[] args) {
		Log.start(Log.INFO, true);
		App app = new App(args);
		app.print(0);
	}

}
