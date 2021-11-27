package core;

/**
 * Ogni celletta del foglio è un oggetto istanziato su questa classe
 * 
 * @author Tommaso Paoli
 */
public class Cella {

	public Float value;
	
	@Override
	public String toString() {
	
		if (this.value != null) {
			return "%.1f".formatted(this.value);			
		} else {
			return "   "; 
		}
	}
	
	
}
