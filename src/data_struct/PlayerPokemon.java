package data_struct;

import data.Stat;
import data_struct.EVs.EVsException;
import player.Player;
import utility.RouteThreeStringBuffer;

// This class should only be used for the player Pokémon.
// Allows to track earned experience, EVs, etc. TODO
public class PlayerPokemon extends BattlePokemon {
	private Player master;
	private EVs evs;
	private int experience;
    
    public PlayerPokemon(Player master, Pokemon pokemon, EVs evs) {
		super(master.getGame(), pokemon, evs);
		this.setEvs(evs);
		this.master = master;
	}
    
    public PlayerPokemon(Player master, Pokemon pokemon) {
    	this(master, pokemon, new EVs());
    }
    
    public boolean hasBadgeBoost(Stat stat) {
    	return master.hasBadgeBoost(stat);
    }
    
	// Getters
	public EVs getEvs() {
		return evs;
	}

	public BadgeBoosts getBadgeBoosts() {
		return master.getBadgeBoosts();
	}

	public int getExperience() {
		return experience;
	}

	public Player getMaster() {
		return master;
	}
	
	public void setEvs(EVs evs) {
		if(evs == null)
			evs = new EVs();
		this.evs = evs;
	}
	
	// Utility
	@Override
	public String toString() {
		RouteThreeStringBuffer sb = new RouteThreeStringBuffer();
		
		sb.append(super.toString());
		sb.append(" EVs:");
		sb.append(this.evs.toString());
		
		return sb.toString();
	}

	public void updateEVs() {		
		for(Stat stat : this.evs.getStatMode()) {
			this.getEvsUsed().put(stat, this.evs.get(stat));
		}
	}
	
	public void update() {
		this.updateEVs();
		super.calculateStats();
	}
	
	public void setExperienceFromLevel(int level) {
		int exp = getSpecies().getGrowthRate().getExperienceFromLevel(level);
		this.experience = exp;
	}

	public void eatRareCandy() {
		int level = this.getLevel();
		if(level >= Pokemon.MAX_LEVEL)
			return;
		
		level++;
		this.setLevel(level);
		this.setExperienceFromLevel(level);
		this.update();
	}

	private void eatStatVitamin(Stat stat) {
		final int EVS_PER_VITAMIN = 10; //TODO : find better place for these
		final int MAX_EVS_IN_STAT = 100;
		
		int ev = this.evs.get(stat);
		int maxYield = Math.max(0, Math.min(MAX_EVS_IN_STAT, MAX_EVS_IN_STAT-ev));
		int yield = Math.min(EVS_PER_VITAMIN, maxYield);
		
		if(yield > 0) {
			try {
				EVs yields = new EVs(stat, yield);
				this.evs.add(yields);
				this.calculateStats();
			} catch (EVsException e) {
				e.printStackTrace();
			}
		}
	}
	public void eatHPUp() { this.eatStatVitamin(Stat.HP); }
	public void eatProtein() { this.eatStatVitamin(Stat.ATK); }
	public void eatIron() { this.eatStatVitamin(Stat.DEF); }
	public void eatCarbos() { this.eatStatVitamin(Stat.SPE); }
	public void eatCalcium() { this.eatStatVitamin(Stat.SPA); }
	public void eatZinc() { this.eatStatVitamin(Stat.SPD); }
}
