package App;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import core.File;
import core.Pos;
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
		new Warn("App.start();");
	}
	
	public void quit() {
		new Warn("App.quit();");
	}
		
	public void newFoglio() {
		new Warn("Nuovo foglio");
		file.newFoglio();
	}
	
	public void remFoglio() {
		new Warn("Rimuovi foglio");
		file.remFoglio();
	}
	
	public void print() {
		new Warn("Print");
		file.print();
	}
	
	public void save(String filename) throws Exception {
		new Warn("Save");
		FileOutputStream f = new FileOutputStream(new java.io.File(filename));
		ObjectOutputStream o = new ObjectOutputStream(f);
		o.writeObject(file);
		o.close();
		file.save();
	}
	
	public void save() {
		
	}
	
	public void load(String filename) {
		new Warn("Load file %d".formatted(filename));
	}
	
	public void write(Pos pos, String v) {
		new Warn("Write a %s: %s".formatted(pos.coord(), v));
		file.getFoglioSelezionato().scrivi(pos, v);
	}
	
	public void scrivi(String pos, String v) {
		write(new Pos(pos), v);
	}
	

}
