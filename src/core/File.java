package core;

import java.util.ArrayList;
import java.util.List;

public class File {

	public List<Foglio> fogli;
	
	public File() {
		this.fogli = new ArrayList<Foglio>();
	}
	
	public void add(Foglio foglio) {
		fogli.add(foglio);
	}
	
}
