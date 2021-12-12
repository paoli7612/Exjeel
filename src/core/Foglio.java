package core;

import App.App;

public class Foglio {
	
	private Cella[][] celle;
	
	public Foglio() {
		celle = new Cella[App.RIGHE][App.COLONNE];
		
		for (int y=0; y<App.RIGHE; y++)
			for (int x=0; x<App.COLONNE; x++)
				celle[y][x] = new Cella();
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
		return celle[y][x];
	}
	
	public Cella getCella(Pos pos) {
		return celle[pos.getY()][pos.getX()];
	}

	public void scrivi(Pos pos, Float value) {
		getCella(pos).scrivi(value);
	}
	
	
}
