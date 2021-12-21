package test;

import App.App;
import logging.Log;
import utils.Parse;

public class Delta {

	public static void main(String[] args) {
		Log.start(Log.INFO, true);
		App app = new App(false);
		
		app.scrivi("A1", 10);
		app.scrivi("B1", 15);
		
		app.scrivi("C2", "=A1+B1");
		
		app.print();
		
		app.scrivi("B1", 0);
					
		app.print();

	}

}
