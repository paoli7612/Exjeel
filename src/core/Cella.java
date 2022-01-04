package core;
/**
 * Classe per ogni cella, che può contenere una formula/un numero/testo
*/

import logging.Critical;
import utils.Parse;

public class Cella implements Cloneable {
	
	protected Foglio foglio;
	private float v;
	
	public Cella(Foglio foglio) {
		this.foglio = foglio;
	}
		
	public Cella(Foglio foglio, float value) {
		this(foglio);
		this.v = value;
	}

	public String leggiSopra() {
		return Parse.str(v);
	}
	
	public String leggiSotto() {
		return Parse.str(v);
	}
	
	public void scrivi(float v) {
		this.v = v;
	}
	
	public void scrivi(String s) throws Exception {
		scrivi(Parse.cfloat(s));
	}
				 
	// Float (segno)(decine)(unità)(decimi)
	// String 5 caratteri
	@Override
	public String toString() {
		return toString(5);
	}

	public String toString(int len) {
		String str = "";
		
		String s = leggiSopra();
		try {
			float v = Float.parseFloat(s);
			str = Parse.str(v);
		} catch (Exception e) {
			str = s;
		}		
		return Parse.maxStr(str, len);
	}
		
	@Override
	protected Cella clone() {
		try {
			return (Cella) super.clone();			
		} catch (Exception e) {
			new Critical("Cella non clonata");
			return null;
		}
	}
	
	protected Float getValore() {
		return this.v;
	}
}
