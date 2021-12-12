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
	
	public final static int RIGHE = 5;
	public final static int COLONNE = 10;
	
	public File file;
	public Window finestra;
	
	public App(String[] args) {
		if (args.length == 0) {
			new Info("Nessun argomento - nuovo file");
			file = new File();
		} else {
			new Critical("Passasto argomenti");
			file = new File();
		}
	}
	
	public static void main(String[] args) {
		Log.start(Log.INFO, true, "log.log");
		new Warn("START APP");	
				
		new App(args);
		
		new Warn("END APP");
	}

	public static void nuovo_foglio() {
		 new Warn("Nuovo foglio");
	}

	public static void salva() {
		new Warn("Salva");
	}

	public static void chiudi() {
		new Warn("Chiudi");
	}

	public static void carica(String path) {
		new Warn("Carica: " + path);
	}

	public static void elimina_foglio(int index) {
		new Warn("Elimina foglio : " + index);
	}

	public void usaFoglio(int i) {
		
	}

	public void scrivi(String pos, Float string) {
		file.scrivi(new Pos(pos), string);
	}

	public void scrivi(String pos, String string) {
		file.scrivi(new Pos(pos), string);
	}

	public void scrivi(String pos, Integer i) {
		scrivi(pos, i.floatValue());
	}

	public void print(int i) {
		file.getFoglio(0).print();
	}

}
