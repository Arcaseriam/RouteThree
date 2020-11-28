package data_struct;

import data.Nature;
import data.Stat;
import data.StatMode;

public class Stats extends StatContainer {
	
	protected class StatsException extends StatException {
		private static final long serialVersionUID = 1L;
		
	}
	
	
	public static final int SHEDINJA_BASE_HP = 1;
	
	public static final int MIN_STAT = 0;
	public static final int MAX_STAT = Integer.MAX_VALUE;
	
	
	// Main constructor - contains the init logic
	public Stats(Integer[] statArray) throws StatsException {
		super(StatMode.POKEMON, MIN_STAT, MAX_STAT, statArray);
		this.validate();
	}
	
	public Stats(int hp, int atk, int def, int spe, int spa, int spd) throws StatsException {
		this(new Integer[] {hp, atk, def, spe, spa, spd});
	}
	

	// Copy constructor - contains the copy logic
	public Stats(Stats stats) {
		super(stats);
	}
	

	// Overrides
	@Override
	protected void validate() throws StatsException {
		super.validate(StatsException.class);
	}

	
	// Utility
		// Returns a new Stats object with calculated stats
	public static Stats calculateStats(int level, Stats bases, IVs ivs, EVs evs, Nature nature) {
		Stats calculatedStats = new Stats(bases);
		
		for(Stat stat : calculatedStats.getStatMode()) {
			int calculatedStat = calculate(stat, level, bases, ivs, evs, nature);
			calculatedStats.put(stat, calculatedStat);
		}
		
		return calculatedStats;
	}
		// ... without EVs
	public static Stats calculateStats(int level, Stats bases, IVs ivs, Nature nature) {
		return calculateStats(level, bases, ivs, null, nature);
	}
	

	
	
		// Calculates a single stat from `stat`
	public static int calculate(Stat stat, int level, Stats bases, IVs ivs, EVs evs, Nature nature) {
		int base = bases.get(stat);
		int iv = ( ivs != null ) ? ivs.get(stat) : IVs.DEFAULT_IV;
		int ev = ( evs != null ) ? evs.get(stat) : EVs.DEFAULT_EV;
		
		return calculate(stat, level, base, iv, ev, nature);
	}
	
		// ... without EVs
	public static int calculate(Stat stat, int level, Stats bases, IVs ivs, Nature nature) {
		return calculate(stat, level, bases, ivs, null, nature);
	}
	
	public static int calculate(Stat stat, int level, int base, int iv, int ev, Nature nature) {
		int core = coreStatValue(level, base, iv, ev);
		if(stat == Stat.HP) {
			return (base == SHEDINJA_BASE_HP) ? base : core + level + 10;
		}
		
		return (core + 5) * nature.getMultiplier(stat) / Nature.DIVISOR;
		
	}
	
		// Calculates the core value common to all stats
	public static int coreStatValue(int level, int base, int iv, int ev) {
		return ((2 * base) + iv + (ev / 4)) * level / 100;
	}
}
