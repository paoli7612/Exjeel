package core;

import java.util.ArrayList;
import java.util.List;

import logging.Info;

/**
 * Ogni sheet del documento è un istanza su questa classe
 * 
 * @author Tommaso Paoli
 */
public class Foglio {
	
	public ArrayList<List<Cella>> celle; 
	
	public Foglio() {
		new Info("Avvio costruttore Foglio");
	
		celle = new ArrayList<List<Cella>>(25);
		for (int y=0; y<25; y++) {
			celle.add(new ArrayList<Cella>(25));
			for (int x=0; x<25; x++) {
				celle.get(y).add(new Cella());
			}
		}
		
		new Info("Foglio creato " + celle.size() + " x " + celle.get(0).size());
				
	}	
	
	public void print() {
		System.out.println(this.toString());
	}
	
	@Override
	public String toString() {
				
		String str = "\t  ";
		
		for (int x=0; x<celle.get(0).size(); x++) {
			str += Character.toString((char) x + 65 ) + "   ";
		}
		str += "\n";
		
		for (int y=0; y<celle.size(); y++) {
			str += y+1 + "\t";
			List<Cella> riga = celle.get(y);
			for (int x=0; x<riga.size(); x++) {
				Cella cella = riga.get(x);
				str += "|";
				str += cella.toString();
			}
			str += "\n";
		}
		
		return str;
	}

	public void write(int x, int y, float f) {
		this.celle.get(y).get(x).setValue(f);
		
	}
}
