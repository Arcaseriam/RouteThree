package data_struct;
import java.util.EnumMap;
import java.util.Iterator;

import data.Stat;
import data.StatMode;

public abstract class StatContainer implements Iterable<Integer> {
	public static final String STATS_SEPARATOR = "/";
	//public static final StatMode DEFAULT_STATMODE = StatMode.POKEMON;
	
	public static final int MIN_STAT = -Integer.MAX_VALUE - 1;
	public static final int MAX_STAT = Integer.MAX_VALUE;
	public static final int MAX_TOTAL = Integer.MAX_VALUE;
	
	private int minStat;
	private int maxStat;
	private int maxTotal;
	private StatMode statMode;
	
	private EnumMap<Stat, Integer> stats;
	
	
	// Main constructor - contains the init logic
	public StatContainer(StatMode statMode, int minStat, int maxStat, int maxTotal, Integer... stats) {
		this.setStatMode(statMode);
		this.setMinStat(minStat);
		this.setMaxStat(maxStat);
		this.setMaxTotal(maxTotal);
		this.setStats(stats);
	}
	
	public StatContainer(StatMode statMode, int minStat, int maxStat, Integer... stats) {
		this(statMode, minStat, maxStat, MAX_TOTAL, stats);
	}
	
	public StatContainer(StatMode statMode, Integer... stats) {
		this(statMode, MIN_STAT, MAX_STAT, stats);
	}
	
	/*
	public StatContainer(Integer... stats) {
		this(DEFAULT_STATMODE, stats);
	}
	*/
	
	// Copy constructor
	public StatContainer(StatContainer statContainer) {
		this(statContainer.getStatMode(),
			 statContainer.getMinStat(),
			 statContainer.getMaxStat(),
			 statContainer.getMaxTotal(),
			 statContainer.stats.values().toArray(new Integer[] {})
		);
	}
	
	// Accessors
	/*
	public int get(Stat stat) throws StatException {
		if (!statMode.isInStatMode(stat))
			throw new StatException();
		
		return stats.get(stat);
	}
	*/
	public int get(Stat stat) {
		return stats.get(stat);
	}
	
	public int put(Stat stat, Integer value) {
		return stats.put(stat, value);
	}
	
	public int getStatNb() {
		return this.statMode.getStatNb();
	}
	

	// Validity
	protected <T extends StatException> void validate(Class<T> exception) throws T {
		int total = 0;
		boolean isValid = true;
		
		try {
			for(int ev : this.stats.values()) {
				isValid &= (ev >= this.minStat && ev <= this.maxStat);
				
				total += ev;
				isValid &= (total <= this.maxTotal);
				
				if(!isValid) throw exception.newInstance();
			}
		} catch (StatException e) {
			throw e;
		} catch (InstantiationException | IllegalAccessException e) {
			// Should never happen
			e.printStackTrace();
		}	
	}
	
		// Each subclass needs to implement a custom validate method
	protected abstract <T extends StatException> void validate() throws T;
	
	// Overrides
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		for(Integer stat : stats.values()) {
			sb.append(stat);
			sb.append(STATS_SEPARATOR);
		}
		
		int len = sb.toString().length();
		return (sb.toString()).substring(0, len - 1);
	}
	
	@Override
	public Iterator<Integer> iterator() {
		return stats.values().iterator();
	}
	
	
	// Setters and Getters
	protected EnumMap<Stat, Integer> getStats() {
		return this.stats;
	}	
	protected void setStats(EnumMap<Stat, Integer> stats){
		this.stats = stats;
	}
	
	protected void setStats(Integer... stats) {
		this.stats = new EnumMap<Stat, Integer>(Stat.class);
		int i = 0;
		for(Stat s : this.statMode) {
			this.stats.put(s, stats[i++]);
		}
	}
	
	public int getMinStat() {
		return minStat;
	}
	protected void setMinStat(int minStat) {
		this.minStat = minStat;
	}

	public int getMaxStat() {
		return maxStat;
	}
	protected void setMaxStat(int maxStat) {
		this.maxStat = maxStat;
	}

	public int getMaxTotal() {
		return maxTotal;
	}

	public void setMaxTotal(int maxTotal) {
		this.maxTotal = maxTotal;
	}

	public StatMode getStatMode() {
		return statMode;
	}
	public void setStatMode(StatMode statMode) {
		this.statMode = statMode;
	}
}
