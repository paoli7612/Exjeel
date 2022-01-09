package core;

import utils.Parse;

public class Pos {

	private Integer x;
	private Integer y;
	
	public int riga, colonna;
	
	public Pos(String string) {
		this(Parse.x(string.charAt(0))-1, Parse.y(string.charAt(1))-1);
		
	}
	
	public Pos(Integer x, Integer y) {
		this.x = x;
		this.y = y;
		
		this.riga = y;
		this.colonna = x;
	} 
	
	public static Pos riga_colonna(Integer riga, Integer colonna) {
		return new Pos(colonna, riga);
	}
	
	@Override
	public String toString() {
		return "(%d,%d)".formatted(x,y);
	}
	
	public String coord() {
		return "%c%d".formatted(x+64+1, y+1);
	}

	public int getY() {
		return y;
	}
	
	public int getX() {
		return x;
	}

	public boolean intestazione() {
		return x < 0 || y < 0;
	}
		
}
