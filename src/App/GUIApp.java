package App;

import core.Pos;
import graphic.Finestra;

public class GUIApp extends App {

	public Finestra finestra;
	
	public GUIApp() {		
		finestra = new Finestra(this);
	}
	
	@Override
	public void newFoglio() {
		super.newFoglio();
		finestra.newFoglio();
	}
	
	@Override
	public void quit() {
		finestra.dispose();
		super.quit();
	}
	
	@Override
	public void write(Pos pos, String v) {
		super.write(pos, v);
		finestra.write(pos, v);
	}


}
