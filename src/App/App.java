package App;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import core.File;
import core.Pos;
import logging.Warn;

/*! Applicazione Exjeel che permette di leggere creare
 * e salvare un foglio elettronico composto di celle
 * rappresentanti numeri, testo o formule */
public class App {
	
	/**
	 * Dimensione della matrice della applicazione
	 */
	public final static int RIGHE = 40;
	public final static int COLONNE = 26;
	
	/**
	 * Breve descrizione che fornisce su richiesta la applicazione
	 */
	public final String info = "Clone minimale di un editor di fogli elettronici";
	
	public File file;
	
	/**
	 * Primo costruttore, se non viene specificato diversamente viene creato un nuovo file vuoto
	 */
	public App() {
		file = new File();
	}
	
	/**
	 * Si decide che la applicazione venga avviata
	 */
	public void start() {
		new Warn("App.start();");
	}
	
	/**
	 * Si decide che la applicazione venga terminata
	 */
	public void quit() {
		new Warn("App.quit();");
	}
	
	/**
	 * Si vuole aggiungere un nuovo foglio al file attuale
	 */
	public void newFoglio() {
		new Warn("Nuovo foglio");
		file.newFoglio();
	}
	
	/**
	 * Si vuole eliminare il foglio attualmente selezionato (se unico rimasto si vorrà terminare l'applicazione)
	 */
	public void remFoglio() {
		new Warn("Rimuovi foglio");
		file.remFoglio();
	}
	
	/**
	 * Si vuole stampare su stdout lo stato completo del file attuale
	 */
	public void print() {
		new Warn("Print");
		file.print();
	}
	
	/**
	 * Si vuole salvare il file attuale usando il nome specificato
	 * @param filename percorso/nome del file da scrivere
	 * @throws Exception Se il file non è raggiungibile verrà sollevata un'eccezione
	 */
	public void save(String filename) throws Exception {
		new Warn("Save");
		FileOutputStream f = new FileOutputStream(new java.io.File(filename));
		ObjectOutputStream o = new ObjectOutputStream(f);
		o.writeObject(file);
		o.close();
		file.save();
	}
	
	/**
	 * Si vuole salvare il file attuale (Se non è gia presente un file da utilizzare solleveremo un eccezione) 
	 */
	public void save() throws Exception {
		
	}
	
	/**
	 * Si vuole caricare un file specificando il percorso/nome. Il file attuale verrà sovrascritto
	 * @param filename
	 */
	public void load(String filename) {
		new Warn("Load file %d".formatted(filename));
	}
	
	/**
	 * Si vuole scrivere la stringa v sulla cella a posizione pos
	 * @param pos posizione in coordinate della cella
	 * @param v stringa (numero/testo/formula) da scrivere
	 */
	public void write(Pos pos, String v) {
		new Warn("Write a %s: %s".formatted(pos.coord(), v));
		file.getFoglioSelezionato().scrivi(pos, v);
	}
	
	public void write(String pos, String v) {
		write(new Pos(pos), v);
	}

}
