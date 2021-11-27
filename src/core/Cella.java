package core;

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
