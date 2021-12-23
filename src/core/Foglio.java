package core;

import App.App;
import logging.Info;

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
				else
					str += celle[y][x].toString();
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

	private void setCella(int x, int y, Cella cella) {
		if (celle[y][x] != null) {
			celle[y][x] = null;
		}
		celle[y][x] = cella;
	}
	
	private void setCella(Pos pos, Cella cella) {
		setCella(pos.getX(), pos.getY(), cella);
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

	public void scrivi(Pos pos, String value) {
		new Info("Scrivi " + pos.coord() + ": " + value);
		getCella(pos).scrivi(value);
	}

	public void copia(Pos from, Pos to) {
		setCella(to, getCella(from).clone());
	}

	public String getSopra(int x, int y) {
		if (celle[y][x] == null)
			return "";
		else 
			return celle[y][x].leggiSopra()+"";
	}
	
	public String getSopra(Pos pos) {
		return getSopra(pos.getX(), pos.getY());
	}
	
	public String getSotto(Pos pos) {
		if (getCella(pos).getFormula() == null)
			return getSopra(pos);
		else {
			return getCella(pos).getFormula().toString();
		}
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
