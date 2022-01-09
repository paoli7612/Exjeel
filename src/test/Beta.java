package test;

import App.App;
import core.Pos;
import logging.Log;

public class Beta {

	public static void main(String[] args) {
		Log.start(Log.WARN, true);
		App app = new App();
		
		app.write(new Pos("A1"), "5");
		app.write("A1", "5");
		app.write("B1", "+");
		app.write("C1", "4");
		app.write("D1", "->");
		app.write("E1", "=A1+C1");
		app.print();		
		app.write("A1", "6");
		app.print();

	}

}
