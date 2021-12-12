package core;

public class Pos {

	private Integer x;
	private Integer y;
	
	public Pos(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	} 
	
	public Pos(String string) {
		this.x = string.charAt(0)-64-1;
		this.y = Integer.parseInt(string.charAt(1)+"")-1;
	}

	public static Pos riga_colonna(Integer riga, Integer colonna) {
		return new Pos(colonna, riga);
	}
	
	@Override
	public String toString() {
		return "(%d,%d)".formatted(x,y);
	}
	
	public String coord() {
		return "%c%d".formatted(x+64, y);
	}

	public int getY() {
		return y;
	}
	
	public int getX() {
		return x;
	}
		
}
