package App;
/**
 * Classe principale del progetto. La applicazione verra fatta partire tramite questa classe
 */

import java.util.ArrayList;
import java.util.List;

import core.File;
import core.Foglio;
import core.Pos;
import graphic.Window;
import logging.*;

/**s
 * @author Tommaso Paoli
 * 
 * Avvio della applicazione
 */
public class App {
	
	public final static int RIGHE = 10;
	public final static int COLONNE = 10;
	
	public static Window finestra;
	public static File file;

	/**
	 * @param args argomenti passati all'avvio dell'app
	 */
	public static void main(String[] args) {
		// init logging livello INFO, stampa anche su stdout, scrivi tutto anche sul file 'log'
		Log.start(Log.INFO, true, "log");
		
		new Warn("Start app");
		
		// nuovo file
		file = new File();
		new Warn(file.nFogli() + " ");
		finestra = new Window(file);
			
		new Warn("Stop app");
		
	
	}
	
	public void fibonacci() {
	
		Foglio f = new Foglio();
		
		// ____________ Fibonacci ____________
		
		f.write("(A,1)", 0);
		f.write("(B,1)", 1);
		f.write("(C,1)", "=(A,1)+(B,1)");

		System.out.println("\n");
		for (int i=0; i<10; i++) {
			f.write("(%c,1)".formatted('C'+i), "=(%c,1)+(%c,1)".formatted('A'+i, 'B'+i));
		}
		
		// ____________ _________ ____________
		
		file.add(f);
	}

	public static void chiudi() {
		new Info("Chiudi");
		new Warn("Stop app");		
		Log.stop();
		App.finestra.dispose();
	}

	public static void carica(String filename) {
		new Info("Carica: " + filename);
		file = File.carica(filename);
	}

	public static void salva() {
		new Info("Salva");
	}

	public static void nuovo_foglio() {
		new Info("Aggiungi foglio");
		Foglio foglio = new Foglio();
		file.add(foglio);
		finestra.aggiungi_foglio();
	}
	
	public static void elimina_foglio(Integer index) {
		new Info("Elimina foglio index: " + index);
		finestra.elimina_foglio(index);
	}

	public static void write(Pos pos, String s) {
		// TODO Auto-generated method stub
		
	}

}
