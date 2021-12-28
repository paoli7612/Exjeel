package core;

import logging.Critical;
import logging.Info;
import utils.Parse;

public class Cella implements Cloneable {

	private Formula formula;
	private String testo;
	
	private Foglio foglio;
	
	public Cella(Foglio foglio) {
		this.foglio = foglio;
		testo = "";
	}
	
	public String leggiSopra() {
		if (formula != null) {
			try {
				return Parse.str(formula.getValue());
			} catch (Exception e) {
				return "###";
			}
		}
		return testo;
	}
	
	public String leggiSotto() {
		if (formula != null)
			return formula.leggiSotto();
		return testo;
	}
		
	public void scrivi(Formula formula) {
		this.formula = formula;
	}
	
	public void scrivi(String txt) {
		if (txt.length() == 0)
			return;
		if (txt.charAt(0) == '=')
			scrivi(new Formula(txt, foglio));
		else 
			this.testo = txt;
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
	
	public String getTesto() {
		return this.testo;
	}
	
	public Formula getFormula() {
		return this.formula;
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

	public Float getValore() throws Exception {
		if (formula != null) {
			return formula.getValue();
		} else {
			return Parse.cfloat(testo);
		}
	}


}
