package App;
/**
 * Classe principale del progetto. La applicazione verra fatta partire tramite questa classe
 */

import core.File;
import core.Foglio;
import graphic.Window;
import logging.*;

/**s
 * @author Tommaso Paoli
 * 
 * Avvio della applicazione
 */
public class App {
	
	public static Window finestra;
	public static File file;
	public static int nFogli;

	/**
	 * @param args argomenti passati all'avvio dell'app
	 */
	public static void main(String[] args) {
		Log.start(Log.WARN, true, "log");
		new Warn("Start app");
		
		try {
			Foglio f = new Foglio();
			for (int i=0; i<5; i++) {				
				f.write(i+4, 3, 4f*i/2);
			}
			
			f.write("(A,1)", 2);
			f.write("(A,2)", 4);
			f.write("(A,3)", 8);
			f.write("(A,5)", "=(A,2)+(A,3)");
			
			/*
			
			f.write(5, 5, "3");
			f.write(5, 6, "5");
			f.write(2, 2, "=(5,5)+(5,6)");
			f.write(1, 5, "=(2,2)*(5,5)");
			f.write(1, 1, "=(1,5)-(2,2)");
			f.write(2, 1, "=(1,5)/(2,2)");
			*/
			
			
			
			f.print();			
			
			file = new File();
			file.add(f);
			new Warn("Stop app");
			//finestra = new Window(file);
			
		} catch (Exception e) {
			new Critical(e.toString());
		}			
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
		finestra.aggiungi_foglio();
		nFogli++;
	}
	
	public static void elimina_foglio(Integer index) {
		new Info("Elimina foglio index: " + index);
		finestra.elimina_foglio(index);
	}

}
