package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class File implements Serializable {

	private List<Foglio> fogli;
	private Integer selezionato;
	private int tot;
	public String fname;
	
	public File() {
		fogli = new ArrayList<Foglio>();
		newFoglio();
		setSelezionato(0);
	}
	
	public void setSelezionato(Integer selezionato) {
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
	
	public void printSelezionato() {
		getFoglioSelezionato().print();
	}

	public void remFoglio() {
		fogli.remove((int)getSelezionato());
	}

	public void save() {
		// TODO Auto-generated method stub
		
	}

	public String nextNome() {
		return "Foglio %d".formatted(++tot);
	}

	public Foglio getFoglio(int i) {
		return fogli.get(i);
	}



}
