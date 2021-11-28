package core;

import java.util.ArrayList;
import java.util.List;

import graphic.Info;

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

	public void new_sheet() {
		new logging.Info("new sheet");
		
	}

	public void del_sheet(int i) {
		new logging.Info("Elimina foglio " + i);
		
	}
}
