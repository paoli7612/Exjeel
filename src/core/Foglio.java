package core;

import App.App;
import logging.Critical;
import logging.Info;
import utils.Parse;

public class Foglio {
	
	private Cella[][] celle;
	
	public Foglio() {
		celle = new Cella[App.RIGHE][App.COLONNE];
	}
	
	public void print() {
		System.out.println(this.toString());
	}
	
	@Override
	public String toString() {
		
		String str = "    ";
		
		for (int x=0; x<App.COLONNE; x++) {
			str += "___" + Character.toString((char) x + 65 ) + "__";
		}
		str += "\n";
		
		for (int y=0; y<App.RIGHE; y++) {
			if (y < 9)
				str += " ";
			str += y+1 + "  ";
			for (int x=0; x<App.COLONNE; x++) {
				str += "|";
				if (celle[y][x] == null)
					str += "     ";
				else {
					str += celle[y][x].toString();
				}
			}
			str += "|";
			str += "\n";
		}
		str += "    ";
		for (int x=0; x<App.COLONNE; x++) {
			str += "______";
		}
		
		return str;
	}
	
	public Cella getCella(int x, int y) {
		if (celle[y][x] == null) {
			celle[y][x] = new Cella(this);
		}
		return celle[y][x];
	}
	
	public Cella getCella(Pos pos) {
		return getCella(pos.getX(), pos.getY());
	}

	public void scrivi(Pos pos, String value) throws Exception {
		try {
			setCella(pos, new Cella(this, Parse.cfloat(value)));
		} catch (Exception e) {
			if (value.charAt(0) == '=')
				setCella(pos, new Formula(this, value));
			else 
				setCella(pos, new Testo(this, value));
		}
	}
	
	private void setCella(Pos pos, Cella c) {
		celle[pos.getY()][pos.getX()] = c;
	}

	public void copia(Pos from, Pos to) {
		setCella(to, getCella(from).clone());
	}
		
	public String leggiSotto(Pos pos) {
		Cella c = getCella(pos);
		if (c == null)
			return "";
		else
			return c.leggiSotto();
	}

	public String leggiSopra(Pos pos) {
		Cella c = getCella(pos);
		if (c == null)
			return "";
		else 
			return c.leggiSopra();
	}

	public String leggiSopra(int x, int y) {
		return leggiSopra(new Pos(x, y));
	}		
}
