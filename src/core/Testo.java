package core;

public class Testo extends Cella {
	
	private String t;
	
	public Testo(Foglio foglio, String t) {
		super(foglio);
		this.t = t;
	}
	
	public String getT() {
		return this.t;
	}

}
