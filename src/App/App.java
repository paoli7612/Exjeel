package App;
/**
 * Classe principale del progetto. La applicazione verra fatta partire tramite questa classe
 */

import core.File;
import core.Pos;
import graphic.Window;
import logging.*;

/**s
 * @author Tommaso Paoli
 * 
 * Avvio della applicazione
 */
public class App {
	
	public final static int RIGHE = 20;
	public final static int COLONNE = 20;
	
	public File file;
	public Window finestra;
	
	public static void main(String[] args) {
		Log.start(Log.INFO, true, "log.log");
		new Warn("START APP");	
		new App(args);
		new Warn("END APP");
	}

	public App(String[] args) {
		if (args.length == 0) {
			new Info("Nessun argomento - nuovo file");
			file = new File();
			finestra = new Window(this);
			usaFoglio(0);
		} else {
			new Critical("Passasto argomenti");
			file = new File();
		}
	}
	

	public void nuovo_foglio() {
		 new Warn("Nuovo foglio");
	}

	public void salva() {
		new Warn("Salva");
	}

	public void chiudi() {
		new Warn("Chiudi");
		finestra.dispose();
	}

	public void carica(String path) {
		new Warn("Carica: " + path);
	}

	public void elimina_foglio(int index) {
		new Warn("Elimina foglio : " + index);
	}

	public void usaFoglio(int i) {
		this.file.setSelezionato(i);
	}
	
	public void scrivi(Pos pos, Float value) {
		file.scrivi(pos, value);
	}
	
	public void scrivi(Pos pos, String string) {
		file.scrivi(pos, string);
	}

	public void scrivi(String pos, Float value) {
		scrivi(new Pos(pos), value);
	}

	public void scrivi(String pos, String string) {
		scrivi(new Pos(pos), string);
	}

	public void scrivi(String pos, Integer i) {
		scrivi(pos, i.floatValue());
	}
	
	public void print(int i) {
		file.getFoglio(i).print();
	}

	public void copia(String from, String to) {
		file.copia(new Pos(from), new Pos(to));
	}


}
