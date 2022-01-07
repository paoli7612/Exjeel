package App;

import core.File;
import core.Pos;
import logging.Info;
import logging.Warn;

public class App {
	
	public final static int RIGHE = 40;
	public final static int COLONNE = 26;
	public final String info = "Clone minimale di un editor di fogli elettronici";
	
	public File file;
	
	public App() {
		file = new File();
	}
	
	public void start() {
		new Warn("App.start()");
	}
		
	public void nuovoFoglio() {
		new Warn("Nuovo foglio");
		file.newFoglio();
	}
	
	public void rimuoviFoglio() {
		new Warn("Rimuovi foglio");
		file.remFoglio();
	}
	
	public void print() {
		new Warn("Print");
		file.print();
	}
	
	public void scrivi(Pos pos, String v) {
		new Warn("Scrivi a %s: %s".formatted(pos.coord(), v));
		file.getFoglioSelezionato().scrivi(pos, v);
	}
	
	public void scrivi(String pos, String v) {
		scrivi(new Pos(pos), v);
	}
	

}
