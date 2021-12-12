package test;

import App.App;
import logging.Log;
import utils.Parse;

// Fibonacci

public class Beta {
	
	public static void main(String[] args) {
		Log.start(Log.INFO, true);
		App app = new App(args);
		
		app.usaFoglio(0);
		app.scrivi("A1", 0);
		app.scrivi("B1", 1);
			
		for (int i=0; i<8; i++) {
			app.scrivi(Parse.cc('C'+i)+"1", "=" + Parse.cc('A'+i) + "1+" + Parse.cc('B'+i) + "1");
		}
				
		app.print(0);
	}


}
