package core;

import logging.Critical;
import logging.Info;

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
		
		ss[0] = Parse.delFirst(ss[0]);
		ss[1] = Parse.delLast(ss[1]);
		
		x = (int)ss[0].charAt(0) - 64;
		y = (int)ss[1].charAt(0) - 49;
		
		return new Pos(x, y);
	}
	
	@Override
	public String toString() {
		return "(%d, %d)".formatted(x, y);
	}
	
}
