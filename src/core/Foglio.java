package core;

import java.util.ArrayList;
import java.util.List;

import App.App;
import logging.Info;
import logging.Log;

/**
 * Ogni sheet del documento è un istanza su questa classe
 * 
 * @author Tommaso Paoli
 */
public class Foglio {
	
	public Cella[][] celle; 
	private int COLONNE;
	private int RIGHE;
	
	
	public Foglio(int righe, int colonne) {
		celle = new Cella[righe][colonne];
		
		this.COLONNE = colonne;
		this.RIGHE = righe;
		
		for (int y=0; y<righe; y++)
			for (int x=0; x<colonne; x++)
				celle[y][x] = new Cella();
		
		new Info("Foglio creato " + righe + " righe, " + colonne + " colonne.");
	}	
	
	public Foglio() {
		this(App.RIGHE, App.COLONNE);
		System.out.println(this.toString());
	}
	
	public void print() {
		System.out.println(this.toString());
	}
	
	@Override
	public String toString() {
				
		String str = "\t  ";
		
		for (int x=0; x<COLONNE; x++) {
			str += " " + Character.toString((char) x + 65 ) + "   ";
		}
		str += "\n";
		
		for (int y=0; y<RIGHE; y++) {
			str += y+1 + "\t";
			for (int x=0; x<COLONNE; x++) {
				str += "|" + celle[y][x].toString();
			}
			str += "\n";
		}
		
		return str;
	}

	public Cella getCella(int x, int y) {
		return this.celle[y][x];
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
		getCella(x, y).setValue(f);
		new Info("write %d %d %f".formatted(x, y, f));
		
	}
	
	public void write(int x, int y, String f) {
		if (f.charAt(0) == '=') {
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
