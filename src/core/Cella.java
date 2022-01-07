package core;

import utils.Parse;

/**
 * @author Tommaso Paoli
 * 
 * Classe padre delle celle del foglio
 */
public abstract class Cella implements Cloneable {
	abstract public String leggiSotto();
	abstract public String leggiSopra();
	abstract public Float leggiValore() throws Exception;
	
	@Override
	public String toString() {
		return Parse.maxStr(leggiSopra(), 5);
	}

}
