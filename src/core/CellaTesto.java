package core;

public class CellaTesto extends Cella{

	private String testo;
	
	public CellaTesto(String testo) {
		setTesto(testo); 
	}

	@Override
	public String leggiSopra() {
		return getTesto();
	}
	
	@Override
	public String leggiSotto() {
		return getTesto();
	}
	
	private void setTesto(String testo) {
		this.testo = testo;	
	}
	
	private String getTesto() {
		return this.testo;
	}

	@Override
	public Float leggiValore() throws Exception {
		throw new Exception("Leggi valore da testo");
	}
	
}
