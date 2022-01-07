package core;

import java.util.ArrayList;
import java.util.List;

import logging.Info;
import utils.Parse;

public class CellaFormula extends Cella {
	
	public static final String ERR = "###";
	private String espressione;
	List<Pos> operandi;
	List<Character> operazioni;
	private Float valore;
	private Foglio foglio;
	
	public CellaFormula(Foglio foglio, String espressione) throws Exception {
		super();
		this.foglio = foglio;
		setEspressione(espressione);
	}
		
	public Float getValore() {
		return this.valore;
	}
	
	@Override
	public String leggiSopra() {
		return Parse.str(getValore());
	}
	
	@Override
	public String leggiSotto() {
		return this.espressione;
	}
	
	public void setEspressione(String espressione) throws Exception {
		espressione = Parse.delFirst(espressione);
		this.espressione = espressione;
	
		operandi = new ArrayList<Pos>();
		operazioni = new ArrayList<Character>();
		
		String[] somme = espressione.split("\\+");
		for (String somma : somme) {
			String[] sottrazioni = somma.split("\\-");
			operandi.add(new Pos(sottrazioni[0]));
			operazioni.add('+');
			if (sottrazioni.length > 1) {
				for (int i=1; i<sottrazioni.length; i++) {
					operandi.add(new Pos(sottrazioni[i]));
					operazioni.add('-');
				}
			}
		} 
		
		update();
	}
	
	public void update() throws Exception {
		valore = 0f;
		for (int i=0; i<this.operandi.size(); i++) {
			new Info(operazioni.get(i) + " " + operandi.get(i));
			if (this.operazioni.get(i) == '+') {
				valore += foglio.leggiValore(operandi.get(i));				
			} else if (this.operazioni.get(i) == '-') {
				valore -= foglio.leggiValore(operandi.get(i));
			}
		}
	}

	@Override
	public Float leggiValore() throws Exception {
		return getValore();
	}
	
}
