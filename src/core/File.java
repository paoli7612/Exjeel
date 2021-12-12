package core;

import java.util.ArrayList;
import java.util.List;

import logging.Info;

public class File {

	private List<Foglio> fogli;
	
	public File() {
		this.fogli = new ArrayList<Foglio>();
		nuovo_foglio();
	}
		
	public void add(Foglio foglio) {
		fogli.add(foglio);
	}
	
	public static File carica(String filename) {
		File f = new File();
		return f;
	}

	public void nuovo_foglio() {
		new Info("Nuovo foglio");
		add(new Foglio());
	}

	public void elimina_foglio(int i) {
		new Info("Elimina foglio " + i);
		this.fogli.remove(i); 
	}
	
	public Foglio getFoglio(Integer index) {
		return fogli.get(index);
	}

	public Integer nFogli() {
		return fogli.size();
	}


}
