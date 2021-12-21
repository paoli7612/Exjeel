package core;

import logging.Critical;
import logging.Info;
import utils.Parse;

public class Cella implements Cloneable {

	private Float valore;
	private Formula formula;
	private String testo;
	
	private Foglio foglio;
	
	public Cella(Foglio foglio) {
		this.foglio = foglio;
	}
	
	public String getSopra() {
		if (formula != null)
			return Parse.str(formula.getValue());
		if (testo != null)
			return testo;
		if (valore != null)
			return Parse.str(valore);
		return null;
	}
	
	public void scrivi(Float value) {
		this.valore = value;
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
		String str = "";
		if (testo != null) {
			str = this.getTesto();
		} else {			
			float v = Float.parseFloat(getSopra());
			if (v >= 0) str += " ";
			if (v < 10 && v >= -10) str += " ";
			str += "%.1f".formatted(v);
		}
		return Parse.maxStr(str, 5);
	}

	public String getTesto() {
		return this.testo;
	}
	
	public Formula getFormula() {
		return this.formula;
	}
	
	public Float getValore() {
		if (getFormula() != null) {
			return this.formula.getValue();
		} else {			
			return this.valore;
		}
	}

	@Override
	protected Cella clone() {
		try {
			return (Cella) super.clone();			
		} catch (Exception e) {
			new Critical("non clonato");
			return null;
		}
	}
	
}
