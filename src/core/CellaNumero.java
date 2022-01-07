package core;

import utils.Parse;

public class CellaNumero extends Cella {

	private float valore;
	
	public CellaNumero(Float valore) {
		super();
		setValore(valore); 
	}

	@Override
	public String leggiSopra() {
		return Parse.str(valore);
	}
	
	@Override
	public String leggiSotto() {
		return Parse.str(valore);
	}
	
	private void setValore(Float valore) {
		this.valore = valore;	
	}

	@Override
	public Float leggiValore() throws Exception {
		try {
			return Float.valueOf(leggiSopra());			
		} catch (Exception e) {
			throw new Exception("CellaNumero non contiene un numero");
		}
	}

	
}
