package data_struct;

import data.Stat;
import data.StatMode;

public class EVs extends StatContainer implements Iterable<Integer> {	
	
	protected class EVsException extends StatException {
		private static final long serialVersionUID = 1L;

	}
	
	
	public static final int DEFAULT_EV = 0;
	public static final int DEFAULT_TOTAL_EVs = 0;
	
	public static final int MIN_EV_IN_STAT = 0;
	public static final int MAX_EV_IN_STAT = 255;
	public static final int MAX_TOTAL_EVS = 510;

	
	private int totalEVs;
	
	
	// Main constructor - contains the init logic
	public EVs(Integer[] statArray) throws EVsException {
		super(StatMode.POKEMON, MIN_EV_IN_STAT, MAX_EV_IN_STAT, MAX_TOTAL_EVS, statArray);
		this.validate();
	}

	public EVs(int hp, int atk, int def, int spe, int spa, int spd) throws EVsException {
		this(new Integer[] {hp, atk, def, spe, spa, spd});	
	}
	
	public EVs(Stat stat, int quantity) throws EVsException {
		this();
		this.put(stat, quantity);
		this.validate();
	}
	
		// totally controlled, no Exceptions
	public EVs() {
		super(StatMode.POKEMON, MIN_EV_IN_STAT, MAX_EV_IN_STAT, MAX_TOTAL_EVS,
				new Integer[] {DEFAULT_EV, DEFAULT_EV, DEFAULT_EV, DEFAULT_EV, DEFAULT_EV, DEFAULT_EV}
		);
	}
	

	// Copy constructor
	public EVs(EVs evs) {
		super(evs);
	}

	
	// Overrides
	@Override
	protected void validate() throws EVsException {
		super.validate(EVsException.class);
		this.calculateTotalEVs();
	}
	
	// Utility
	public void add(EVs yields) {
		for(Stat stat : this.getStatMode()) {
			int ev = this.get(stat);
			int yield = yields.get(stat);
			int maxForStat = Math.max(0, MAX_EV_IN_STAT-ev);
			int maxForTotal = Math.max(0, MAX_TOTAL_EVS-this.totalEVs);
			yield = Math.min(yield, Math.min(maxForStat, maxForTotal));
			
			if(yield <= 0) return;
			
			this.put(stat, ev + yield);
			this.totalEVs += yield;
		}
	}

	private void calculateTotalEVs() {
		int total = 0;
		for(int ev : this)
			total += ev;
		
		this.totalEVs = total;
	}
	
	
	// Getters and Setters
	public int getTotalEVs() {
		return totalEVs;
	}
}
