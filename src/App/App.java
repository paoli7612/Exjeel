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
	
	public final static int RIGHE = 46;
	public final static int COLONNE = 46;
	
	public File file;
	public Window finestra;
	
	public static void main(String[] args) {
		Log.start(Log.INFO, true, "log.log");
		new Warn("START APP");
		new App();
		new Warn("END APP");
	}

	public App(String filename, Boolean window) {
		if (filename == null) {
			new Info("Nuovo file");
			file = new File();			
		} else {			
			file = File.load("./data/" + filename);
		}
		
		if (window) {			
			finestra = new Window(this);
			finestra.resize();
		}
	}
	
	public App(Boolean window) {
		this(null, window);
	}
	
	public App(String filename) {
		this(filename, true);
	}
	
	public App() {
		this(true);
	}
	
	public void nuovo_foglio() {
		 new Warn("Nuovo foglio");
		 file.nuovo_foglio();
		 if (finestra != null)
			 finestra.aggiungi_foglio();
	}
	
	public void nuovo_foglio(Integer count) {
		for (int i=0; i<count; i++) {
			nuovo_foglio();
		}
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
		if (finestra != null)
			finestra.aggiorna(pos);
	}
	
	public void scrivi(Pos pos, String string) {
		file.scrivi(pos, string);
		if (finestra != null)
			finestra.aggiorna(pos);
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
	
	public void copia(String from, String to) {
		file.copia(new Pos(from), new Pos(to));
	}

	public void print(int i) {
		file.getFoglio(i).print();
	}

	public void print() {
		for (int i=0; i<file.nFogli(); i++)
			print(i);
	}

	public String leggi(Pos pos) {
		return file.leggi(pos);
	}

	public String leggiSotto(Pos p) {
		return file.leggiSotto(p);
	}
}
