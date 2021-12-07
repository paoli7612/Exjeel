package core;

/**
 * Ogni celletta del foglio è un oggetto istanziato su questa classe
 * 
 * @author Tommaso Paoli
 */
public class Cella {

	public Float value;
	public Formula formula;
	
	@Override
	public String toString() {
	
		if (this.value != null) {
			if (this.value < 10)
				return "%.1f ".formatted(this.value);	
			else
				return "%.1f".formatted(this.value);
		} else {
			return "    "; 
		}
	}

	public void setValue(float f) {
		this.value = f;
	}
	
	public float getValue() {
		return this.value;
	}
	
	public boolean empty() {
		return this.value == null;
	}
	
	
}
