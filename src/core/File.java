package core;

import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;  
import java.io.IOException;  

public class File {

	public List<Foglio> fogli;
	
	public File() {
		this.fogli = new ArrayList<Foglio>();
	}
	
	public void add(Foglio foglio) {
		fogli.add(foglio);
	}
	
	public static File carica(String filename) {
		File f = new File();

		return f;
	}
}
