package test;

import App.App;
import core.Pos;
import logging.Info;
import logging.Log;

public class Esplion {
	
	public static App app;

	public static void main(String[] args) {
		Log.start(Log.INFO, true);
		app = new App(true);
		
		app.scrivi("A1", 10);
		app.scrivi("B1", 15);
			
		app.scrivi("A3", "Somma");
		app.scrivi("B3", "=A1+B1");
		
		app.scrivi("A4", "Sottrazione");
		app.scrivi("B4", "=A1-B1");
		
		app.print();
		
		app.scrivi("B1", 80);
		
		new Info(app.leggiSopra(new Pos("A3")));
							
		app.print();
		
		utils.Thread.setTimeout(new Runnable() {
			
			@Override
			public void run() {
				Esplion.app.finestra.resize();
			}
		}, 1000);


	}

}
