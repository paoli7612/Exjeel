package App;

/**
 * Estensione della App per permettere un'interfaccia a linea di comando
 */
public class CLIApp extends App {

	public static void print(String s) {
		System.out.println(s);
	}
	
	@Override
	public void start() {
		super.start();
		
		Boolean running = true;
		
		while (running) {
			showMenu();
			
		}
	}

	private void showMenu() {
		print("___Exjeel___");
		print("1. New file");
		print("2. Load file");
		print("3. Info app");
		print("4. Exit");
	}
	
	private void showFile() {
		print("File: " + file.fname);
		file.printSelezionato();
	}
	
	private void showTools() {
		print("1. Write");
		print("2. Select Foglio");
		print("3. New Foglio");
		print("4. Rem Foglio");
		print("5. Main menu");
	}
	
}
