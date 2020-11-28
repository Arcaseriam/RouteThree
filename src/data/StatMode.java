package data;

import java.util.EnumMap;
import java.util.Iterator;

public enum StatMode implements Iterable<Stat> {
	POKEMON (Stat.HP, Stat.ATK, Stat.DEF, Stat.SPE, Stat.SPA, Stat.SPD),
	BATTLE(Stat.ATK, Stat.DEF, Stat.SPE, Stat.SPA, Stat.SPD, Stat.ACC, Stat.EVA);
	
	private EnumMap<Stat, Stat> stats;
	
	
	// Main constructor
	private StatMode(Stat... stats) {
		this.stats = new EnumMap<Stat, Stat>(Stat.class);
		this.setStats(stats);
	}
	
	
	// Accessors
	public int getStatNb() {
		return this.stats.size();
	}
	
	public boolean isInStatMode(Stat stat) {
		return this.stats.containsKey(stat);
	}
	
	//public int getStatIndex()
	
	
	// Setters and Getters
	private void setStats(Stat[] stats) {
		for(Stat stat : stats)
			this.stats.put(stat, stat);
	}
	
	/*
	public Collection<Stat> getStats() {
		return this.stats.values();
	}
	*/

	@Override
	public Iterator<Stat> iterator() {
		return stats.values().iterator();
	}
}
