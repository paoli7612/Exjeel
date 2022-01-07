package core;

import java.util.ArrayList;
import java.util.List;

public class File {

	private List<Foglio> fogli;
	private Integer selezionato;
	
	public File() {
		fogli = new ArrayList<Foglio>();
		newFoglio();
		setSelezionato(0);
	}
	
	private void setSelezionato(Integer selezionato) {
		this.selezionato = selezionato;
	}
	
	public Integer getSelezionato() {
		return this.selezionato;
	}
	
	public Foglio getFoglioSelezionato() {
		return fogli.get(getSelezionato());
	}

	public void newFoglio() {
		addFoglio(new Foglio());
		setSelezionato(countFogli()-1);
	}
	
	public Integer countFogli() {
		return fogli.size();
	}

	public void addFoglio(Foglio foglio) {
		fogli.add(foglio);
	}
	
	public void print() {
		for (Foglio foglio : fogli) {
			foglio.print();
		}
	}

	public void remFoglio() {
		fogli.remove((int)getSelezionato());
	}

}
