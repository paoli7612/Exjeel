package core;

import java.util.ArrayList;
import java.util.List;

public class File {

	private List<Foglio> fogli;
	private Integer selezionato;
	
	public File() {
		fogli = new ArrayList<Foglio>();
		// creiamo il primo foglio
		add(new Foglio());
		setSelezionato(0);
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
	
}
