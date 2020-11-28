package data;

import java.util.HashMap;

import utility.LookupTable;

public enum Nature {
	// see : https://github.com/pret/pokeruby/blob/f839afb24aa2c7b70e9c28a5c069aacc46993099/constants/pokemon_data_constants.inc#L1
	HARDY   (Stat.NONE, Stat.NONE),
	LONELY  (Stat.ATK , Stat.DEF),
	BRAVE   (Stat.ATK , Stat.SPE),
	ADAMANT (Stat.ATK , Stat.SPA),
	NAUGHTY (Stat.ATK , Stat.SPD),
	BOLD    (Stat.DEF , Stat.ATK),
	DOCILE  (Stat.NONE, Stat.NONE),
	RELAXED (Stat.DEF , Stat.SPE),
	IMPISH  (Stat.DEF , Stat.SPA),
	LAX     (Stat.DEF , Stat.SPD),
	TIMID   (Stat.SPE , Stat.ATK),
	HASTY   (Stat.SPE , Stat.DEF),
	SERIOUS (Stat.NONE, Stat.NONE),
	JOLLY   (Stat.SPE , Stat.SPA),
	NAIVE   (Stat.SPE , Stat.SPD),
	MODEST  (Stat.SPA , Stat.ATK),
	MILD    (Stat.SPA , Stat.DEF),
	QUIET   (Stat.SPA , Stat.SPE),
	BASHFUL (Stat.NONE, Stat.NONE),
	RASH    (Stat.SPA , Stat.SPD),
	CALM    (Stat.SPD , Stat.ATK),
	GENTLE  (Stat.SPD , Stat.DEF),
	SASSY   (Stat.SPD , Stat.SPE),
	CAREFUL (Stat.SPD , Stat.SPA),
	QUIRKY  (Stat.NONE, Stat.NONE);
	
	private static LookupTable<Nature> naturesTable = new LookupTable<>();
	static {
		for(Nature nature : Nature.values()) {
			naturesTable.put(nature.name(), nature);
		}
	}
	public static Nature getNatureFromString(String name) {
		return naturesTable.get(name);
	}
	
	
	public static final int INCREASED_MULTIPLIER = 11;
	public static final int NEUTRAL_MULTIPLIER   = 10;
	public static final int DECREASED_MULTIPLIER =  9;
	public static final int DIVISOR = NEUTRAL_MULTIPLIER;
	
	private Stat increased;
	private Stat decreased;
	
	private Nature(Stat increased, Stat decreased) {
		this.setIncreased(increased);
		this.setDecreased(decreased);
	}
	
	public int getMultiplier(Stat stat) {
		if(this.getIncreased() == stat)
			return INCREASED_MULTIPLIER;
		else if (this.getDecreased() == stat)
			return DECREASED_MULTIPLIER;
		
		return NEUTRAL_MULTIPLIER;
	}
	
	public Stat getIncreased() {
		return increased;
	}
	public Stat getDecreased() {
		return decreased;
	}
	private void setIncreased(Stat increased) {
		this.increased = increased;
	}
	private void setDecreased(Stat decreased) {
		this.decreased = decreased;
	}
}
