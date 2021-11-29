package core;

public final class Pos {

	private Integer x, y;
	
	public Pos(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}
	
	public void setX(Integer x) {
		this.x = x;
	}
	
	public void setY(Integer y) {
		this.y = y;
	}
	
	public Integer getX() {
		return this.x;
	}
	
	public Integer getY() {
		return this.y;
	}
	
	public static Pos parse(String s) {
		Integer x, y;
		
		String ss[] = s.split(",");
		x = Integer.parseInt(Parse.delFirst(ss[0]));
		y = Integer.parseInt(Parse.delLast(ss[1]));
		
		return new Pos(x, y);
	}
	
	@Override
	public String toString() {
		return "(%d, %d)".formatted(x, y);
	}
	
}
