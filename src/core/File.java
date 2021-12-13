package core;

import java.util.ArrayList;
import java.util.List;

public class File {

	private List<Foglio> fogli;
	private Integer selezionato;
	
	public File() {
		fogli = new ArrayList<Foglio>();
		// creiamo il primo foglio
		nuovo_foglio();
		setSelezionato(0);
	}

	public File(String filename) {
		// TODO Auto-generated constructor stub
	}

	public Foglio getFoglio(int i) {
		return fogli.get(i);
	}
	
	public void add(Foglio foglio) {
		fogli.add(foglio);
	}

	public int nFogli() {
		return fogli.size();
	}

	public void setSelezionato(Integer i) {
		selezionato = i;
	}
	
	public Integer getSelezionato() {
		return selezionato;
	}

	public void scrivi(Pos pos, Float value) {
		getFoglio(getSelezionato()).scrivi(pos, value);
	}
	
	public void scrivi(Pos pos, String txt) {
		getFoglio(getSelezionato()).scrivi(pos, txt);
	}

	public void copia(Pos from, Pos to) {
		getFoglio(getSelezionato()).copia(from, to);
		
	}

	public void nuovo_foglio() {
		add(new Foglio());
	}

	public String leggi(Pos pos) {
		return getFoglio(getSelezionato()).leggi(pos);
	}
	
}
