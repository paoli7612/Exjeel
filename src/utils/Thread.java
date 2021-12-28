package utils;

import logging.Critical;
import logging.Info;

public class Thread {
	public static void setTimeout(Runnable runnable, int delay){
	    new java.lang.Thread(() -> {
	        try {
	        	Thread.sleep(delay);
	            runnable.run();
	            new Info("Runnato");
	        }
	        catch (Exception e){
	            new Critical(e);
	        }
	    }).start();
	}

	private static void sleep(int delay) {
		try {			
			java.lang.Thread.sleep(delay);
		} catch (Exception e) {
			new Critical(e);
		}
	}
}
