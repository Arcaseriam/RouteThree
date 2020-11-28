package utility;

import java.util.HashMap;

import route_file.Alias;

public class LookupTable<T extends Enum<T>> {	
	private HashMap<Alias, T> map;

	public LookupTable() {
		this.map = new HashMap<Alias, T>();
	}
	
	// Contains logic
	public T put(Alias alias, T enumm) {
		return map.put(alias, enumm);
	}
	
	public T put(String aliasStr, T enumm) {
		return this.put(new Alias(aliasStr), enumm);
	}
	
	// Contains logic
	public T get(String aliasStr) {
		return map.get(new Alias(aliasStr));
	}
}
