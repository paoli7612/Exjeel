package core;

import java.util.ArrayList;
import java.util.List;

import logging.Info;
import utils.Parse;

public class Formula {

	private String espressione;
	
	List<Pos> operandi;
	List<Character> operazioni;
	Foglio foglio;
	
	public Formula(String espressione, Foglio foglio) {
		this.foglio = foglio;
		this.espressione = Parse.delFirst(espressione);
		
		operandi = new ArrayList<Pos>();
		operazioni = new ArrayList<Character>();
		
		String[] somme = this.espressione.split("\\+");
		
		for (String somma : somme) {
			String[] sottrazioni = somma.split("\\-");
			if (sottrazioni.length == 1) {
				operazioni.add('+');
				operandi.add(new Pos(somma));
			} else {
				operazioni.add('+');
				operandi.add(new Pos(sottrazioni[0]));
				for (int i=1; i<sottrazioni.length; i++) {
					operandi.add(new Pos(sottrazioni[i]));
					operazioni.add('-');
				}
			}
		}
	}
	
	public Float getValue() {
		
		Float v = 0f;
		
		for (int i=0; i<this.operandi.size(); i++) {

			if (this.operazioni.get(i) == '+') {
				v += foglio.getCella(operandi.get(i)).getValore();				
			} else if (this.operazioni.get(i) == '-') {
				v -= foglio.getCella(operandi.get(i)).getValore();
			}
		}
		
		return v;
	}
	
	@Override
	public String toString() {
		return this.espressione;
	}

}
