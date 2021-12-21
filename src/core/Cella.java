package core;

import logging.Critical;
import logging.Info;

public class Cella implements Cloneable {

	private Float value = 0f;
	private Formula formula;
	private String text;
	private Foglio foglio;
	
	public Cella(Foglio foglio) {
		this.foglio = foglio;
	}

	public Float getValue() {
		if (formula == null)
			return value;
		else {
			return formula.getValue();
		}
	}
	
	
	// ogni cella 4 caratteri (segno)(decine)(unità)(decimi)
	@Override
	public String toString() {
		if (text != null) {
			String r = text;
			while (r.length() < 5) {
				r = " " + r;
			};
			r = r.substring(0, 5);
			return r;
			
		}
		
		Float v = getValue();

		String str = "";
		if (v >= 0) str += " ";
		if (v < 10 && v >= -10) str += " ";
		str += "%.1f".formatted(v);

		return str;
	}

	public void scrivi(Float value) {
		this.value = value;
	}

	public void scrivi(String txt) {
		if (txt.length() < 1)
			return;
		if (txt.charAt(0) == '=')
			this.formula = new Formula(txt, foglio);
		else 
			this.text = txt;
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
