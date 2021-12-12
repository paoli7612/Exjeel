package core;

public class Cella {

	private Float value = 0f;
	private Formula formula;

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
		String str = "";
		Float v = getValue();
		if (v >= 0) // se è positivo metto uno spazio al posto del -
			str += " ";
		if (v < 10 && v > -10) // se la parte intera ha una cifra mette uno spazio
			str += " ";
		if (value == 0f) // se è vuota metto 3 spazi al posto di Y,X e ritorno
			return str + "   ";
		if (v % 1 == 0) // se è intero metto due spazi al posto di ,X e il valore
			str += v.intValue() + "  ";
		else // altrimen
			str += String.format("%.1f", v);
		return str;
	}

	public void scrivi(Float value) {
		this.value = value;
	}
}
