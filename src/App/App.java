package App;
/**
 * Classe principale del progetto. La applicazione verra fatta partire tramite questa classe
 */

import core.File;
import core.Pos;
import graphic.Window;
import logging.*;
import utils.Parse;

/**s
 * @author Tommaso Paoli
 * 
 * Avvio della applicazione
 */
public class App {
	
	public final static int RIGHE = 26;
	public final static int COLONNE = 26;
	
	public File file;
	public Window finestra;
	
	public final String info = "Clone minimale di un editor di fogli elettronici";
	
    /**
     * Metodo main per lanciare la applicazione
     * @param args argomenti passati
     */
	public static void main(String[] args) {
		Log.start(Log.INFO, true, "log.log");
		new Warn("START APP");
		new App();
		new Warn("END APP");
	}
	
	
	/**
	 * Costruttore applicazione
	 * @param filename specifica il file da aprire (null se avviamo la applicazione per creare un nuovo file)
	 * @param window specifica se utilizzare o meno l'interfaccia grafica
	 */
	public App(String filename, Boolean window) {
		if (filename == null) {
			new Info("Nuovo file vuoto");
			file = new File();			
		} else {			
			file = File.load("./data/" + filename);
		}
		
		if (window) {			
			finestra = new Window(this);
		}
	}
	
	/**
	 * Costruttore applicazione per avviare la applicazione senza partire da un file gia esistente
	 * @param window specifica se utilizzare o meno l'interfaccia grafica
	 */
	public App(Boolean window) {
		this(null, window);
	}
	
	/**
	 * Costruttore applicazione specificando il file da cui partire
	 * @param filename specifica il file da aprire (null se avviamo la applicazione per creare un nuovo file)
	 */
	public App(String filename) {
		this(filename, true);
	}
	
	/**
	 * Costruttore applicazione senza argomenti (usa interfaccia grafica e non aprire un file esistente)
	 */
	public App() {
		this(true);
	}
	
	/**
	 * Crea un nuvo foglio sul file attuale
	 */
	public void nuovo_foglio() {
		 new Warn("Nuovo foglio");
		 file.nuovo_foglio();
		 if (finestra != null)
			 finestra.aggiungi_foglio();
	}
	
	/**
	 * Lancia nuovo_foglio() per count volte
	 * @param count numero di fogli da creare
	 */
	public void nuovo_foglio(Integer count) {
		for (int i=0; i<count; i++) {
			nuovo_foglio();
		}
	}

	/**
	 * Salva il file attuale
	 */
	public void salva() {
		new Warn("Salva");
	}

	/**
	 * Chiudi applicazione (supponendo sia aperta la finestra)
	 */
	public void chiudi() {
		new Warn("Chiudi");
		finestra.dispose();
	}

	/**
	 * Carica da file
	 * @param path file da aprire
	 */
	public void carica(String path) {
		new Warn("Carica: " + path);
	}

	/**
	 * Elimina un foglio dal file
	 * @param index indice del foglio
	 */
	public void elimina_foglio(int index) {
		new Warn("Elimina foglio : " + index);
		file.elimina_foglio(index);
		if (finestra != null) 
			finestra.elimina_foglio(index);
	}

	/**
	 * Seleziona il foglio da usare
	 * @param i
	 */
	public void usaFoglio(int i) {
		this.file.setSelezionato(i);
	}
	
	/**
	 * Scrivi value nella cella in posizione pos
	 * @param pos dove?
	 * @param value cosa?
	 */
	public void scrivi(Pos pos, String value) {
		file.scrivi(pos, value);
		if (finestra != null)
			finestra.aggiorna(pos);
	}

	public void scrivi(String pos, String string) {
		scrivi(new Pos(pos), string);
	}
	
	public void scrivi(String pos, int i) {
		scrivi(pos, i);
	}
	
	/**
	 * Copia la cella a from nella cella to
	 * @param from copia
	 * @param to incolla
	 */
	public void copia(String from, String to) {
		file.copia(new Pos(from), new Pos(to));
	}

	/**
	 * Lancia il metodo print del voglio i
	 * @param i indice del foglio da stampare
	 */
	public void print(int i) {
		file.getFoglio(i).print();
	}

	/**
	 * Lancia il metodo print di tutti i foglio del file attuale
	 */
	public void print() {
		for (int i=0; i<file.nFogli(); i++)
			print(i);
	}

	/**
	 * Legge e ritorna il contenuto "sopra" della cella a posizione pos
	 * @param pos posizione della cella
	 * @return contenuto della cella
	 */
	public String leggiSopra(Pos pos) {
		return file.leggiSopra(pos);
	}

	/**
	 * Legge e ritorna il contenuto "sotto" della cella a posizione pos
	 * @param pos della cella
	 * @return contenuto della cella
	 */
	public String leggiSotto(Pos p) {
		return file.leggiSotto(p);
	}




}
