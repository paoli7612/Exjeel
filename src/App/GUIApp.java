package App;

import graphic.Finestra;
import logging.Info;
import logging.Log;

public class GUIApp extends App {

	public Finestra finestra;
	
	public GUIApp() {		
		finestra = new Finestra(this);
	}
	
	public void chiudi() {
		new Info("CUIApp.chiudi()");
	}

}
