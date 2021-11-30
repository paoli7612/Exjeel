package core;

import java.util.ArrayList;
import java.util.List;

import logging.Info;
import logging.Log;

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

	public Cella getCella(int x, int y) {
		return this.celle.get(y).get(x);
	}
	 
	public Cella getCella(Pos pos) {
		return getCella(pos.getX(), pos.getY());
	}
	
	public Cella getCella(String p) {
		return getCella(Pos.parse(p));
	}
	
	public float getValue(Pos pos) {
		return getCella(pos).getValue();
	}
	
	public float getValue(String p) {
		return getCella(p).getValue();
	}
	
	public void write(int x, int y, float f) {
		new Info("write %d %d %f".formatted(x, y, f));
		getCella(x, y).setValue(f);
		
	}
	
	public void write(int x, int y, String f) {
		if (f.charAt(0) == '=') {
			new Info("Write " +  f);
			f = Parse.delFirst(f);
			
			char cc[] = {'+', '-', '*', '/'};
			
			for (int i=0; i<cc.length; i++) {
				char c = cc[i];
				String v[] = f.split("\\"+c);
				if (v.length > 1) {
					Float c1 = getValue(Pos.parse(v[0]));
					Float c2 = getValue(Pos.parse(v[1]));
					float ret = 0;
					switch (c) {
						case '+': { ret = c1 + c2; break; }
						case '-': { ret = c1 - c2; break; }
						case '*': { ret = c1 * c2; break; }
						case '/': { ret = c1 / c2; break; }					
					}
					new Info("Write %f %c %f = %f ".formatted(c1, c, c2, ret));
					write(x, y, ret);
					break;
				} else {
					continue;
				}
			}
		} else {
			write(x, y, Float.parseFloat(f));
		}
	}
	
	public void write(Pos pos, float f) {
		write(pos.getX(), pos.getY(), f);
	}
	
	public void write(Pos pos, String f) {
		write(pos.getX(), pos.getY(), f);
	}
	
	public void write(String p, String f) {
		write(Pos.parse(p), f);
	}
		
	public void write(String p, float f) {
		write(Pos.parse(p), f);
	}
	
}
