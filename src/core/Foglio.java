package core;

import App.App;
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

	public void scrivi(Pos pos, String v) {
		try {
			Float f = Parse.cfloat(v);
			setCella(pos, new CellaNumero(f));		
		} catch (Exception e) { // se non ci riesco
			if (v.charAt(0) == '=') { // guardo se è una formula
				try {	
					setCella(pos, new CellaFormula(this, v));
				} catch (Exception e2) {
					setCella(pos, new CellaTesto(CellaFormula.ERR));
				}
			} else { // altrimenti è un testo normale
				setCella(pos, new CellaTesto(v));
			}
		}		
	}

	private void setCella(int riga, int colonna, Cella cella) {
		new Info(riga + " " + colonna);
		this.celle[riga][colonna] = cella;
	}
	
	private void setCella(Pos pos, Cella cella) {
		setCella(pos.riga, pos.colonna, cella);
	}

	public String leggiSopra(Pos pos){
		return getCella(pos).leggiSopra();
	}
	
	public Float leggiValore(Pos pos) throws Exception {
		return getCella(pos).leggiValore();
	}

	private Cella getCella(Pos pos) {
		return celle[pos.riga][pos.colonna];
	}

}
