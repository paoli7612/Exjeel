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
		
		String str = "   ";
		
		for (int x=0; x<App.COLONNE; x++) {
			str += "___" + Character.toString((char) x + 65 ) + "__";
		}
		str += "\n";
		
		for (int y=0; y<App.RIGHE; y++) {
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
		str += "   ";
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

	public void scrivi(Pos pos, Float value) {
		new Info("Scrivi " + pos.coord() + ": " + value);
		getCella(pos).scrivi(value);
	}

	public void scrivi(Pos pos, String txt) {
		new Info("Scrivi txt " + pos.coord() + ": " + txt);
		getCella(pos).scrivi(txt);
		
	}
		
}
