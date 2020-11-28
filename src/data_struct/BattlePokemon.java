package data_struct;

import battle.Battleable;
import data.Game;
import data_struct.Stats.StatsException;
import utility.RouteThreeStringBuffer;

// This class implements a Pokémon with EVs (set to 0 by default)
// Main class for any opponent Pokémon.
public class BattlePokemon extends Pokemon implements Battleable {
	
	public static final boolean IS_DELAY_STAT_CALCULATION = true;
	
	private EVs evs_used;
	
	
    public BattlePokemon(Game game, Pokemon pokemon, EVs evsUsed) {
		super(game, pokemon);
		this.setEvsUsed(evsUsed);
		this.calculateStats();
	}
    
    public BattlePokemon(Game game, Pokemon pokemon) {
    	this(game, pokemon, null);
    }
    
    
	public EVs getEvsUsed() {
		return evs_used;
	}

	public void setEvsUsed(EVs evsUsed) {
		if(evsUsed == null)
			evsUsed = new EVs();
		this.evs_used = evsUsed;
	}
	
	@Override
	protected void calculateStats() {
		try {
			Stats stats = Stats.calculateStats(getLevel(), new Stats(getSpecies().getBaseStats()), getIvs(), getNature());
			this.setStats(stats);
		} catch (StatsException e) {
			// Species enum base stats error
			e.printStackTrace();
		}
	}
    
	// Utility
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append(super.toString());
		sb.append(" UsedEVs:");
		sb.append(this.evs_used.toString());
		
		return sb.toString();
	}
}
