package core;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class File implements Serializable {

	private List<Foglio> fogli;
	private Integer selezionato;
	private int tFogli;
	
	public File() {
		fogli = new ArrayList<Foglio>();
		// creiamo il primo foglio
		nuovo_foglio();
		setSelezionato(0);
	}

	public void save(String path) throws IOException {
		FileOutputStream fout = new FileOutputStream(path);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(this);
		oos.close();
	}
	
	
	public static File load(String filename) {
		return null;
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
	
	public Foglio getFoglioSelezionato() {
		return getFoglio(getSelezionato());
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

	public String leggiSopra(Pos pos) {
		return getFoglioSelezionato().leggiSopra(pos);
	}
	
	public String leggiSotto(Pos pos) {
		return getFoglioSelezionato().leggiSotto(pos);
	}

	public void elimina_foglio(int index) {
		fogli.remove(index);
		if (selezionato == index)
			selezionato = 0;
	}
	
	public String prossimo_nome() {
		return "Foglio %d".formatted(tFogli++);
	}
	
}
