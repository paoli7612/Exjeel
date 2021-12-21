package test;

import App.App;
import logging.Log;
import utils.Parse;

// Fibonacci

public class BBeta {
	
	public static void main(String[] args) {
		Log.start(Log.INFO, true);
		App app = new App(false);
		
		app.scrivi("A1", 0);
		app.scrivi("B1", 1);
		
		app.copia("A1", "A2");
		app.copia("B1", "B2");
					
		for (int i=0; i<8; i++) {
			app.scrivi(Parse.cc('C'+i)+"1", "=" + Parse.cc('A'+i) + "1+" + Parse.cc('B'+i) + "1");
			app.scrivi(Parse.cc('C'+i)+"2", "=" + Parse.cc('A'+i) + "2-" + Parse.cc('B'+i) + "2");
		}			
		
		app.print();
	}


}
