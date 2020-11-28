package data_struct;

import data.Stat;
import data.StatMode;

public class StatStages extends StatContainer implements Iterable<Integer> {
	
	protected class StatStagesException extends StatException {
		private static final long serialVersionUID = 1L;

	}
	
	
	private static final int[] acc_eva_multipliers = new int[] {33, 36, 43, 50, 60, 75, 100, 133, 166, 200, 250, 266, 300};
	
	public static final int DEFAULT_STAGE = 0;
	
	public static final int MIN_STAGE = -6;
	public static final int MAX_STAGE = 6;
	
	
	// Main constructor - contains the init logic
	public StatStages(Integer[] statArray) throws StatStagesException {
		super(StatMode.BATTLE, MIN_STAGE, MAX_STAGE, statArray);
		this.validate();
	}
	
	public StatStages(int hp, int atk, int def, int spe, int spa, int spd) throws StatStagesException {
		this(new Integer[] {hp, atk, def, spe, spa, spd});
	}
	
		// totally controlled, no Exceptions
	public StatStages() {
		super(StatMode.BATTLE, MIN_STAGE, MAX_STAGE, new Integer[] {
				DEFAULT_STAGE, DEFAULT_STAGE, DEFAULT_STAGE, 
				DEFAULT_STAGE, DEFAULT_STAGE, DEFAULT_STAGE
		});
	}
	

	// Copy constructor - contains the copy logic
	public StatStages(StatContainer statContainer) throws StatStagesException {
		super(statContainer);
		this.validate();
	}
	
	
	// Overrides
	@Override
	protected void validate() throws StatStagesException {
		super.validate(StatStagesException.class);
	}
	
	
	// Utility
	public int getStagedStat(Stat stat, int value) {
		int stage = this.get(stat);
		
		switch(stat) {
		case ATK:
		case DEF:
		case SPE:
		case SPA:
		case SPD:
			return (stage >= 0) ? value * (2 + stage) / 2 : value * 2 / (2 + stage);
		case ACC:
		case EVA:
			return value * acc_eva_multipliers[stage + MAX_STAGE] / 100;
		default:
			// should never be called
			return -1;
		}
	}
}
