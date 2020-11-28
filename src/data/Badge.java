package data;

import java.util.EnumMap;

public enum Badge {
	// RSE                  
	STONEBADGE   (Stat.ATK),  
	BALANCEBADGE (Stat.DEF), 
	MINDBADGE    (Stat.SPA, Stat.SPD),
	DYNAMOBADGE  (Stat.SPE),
	
	// FRLG
	BOULDERBADGE (Stat.ATK),
	SOULBADGE    (Stat.DEF),
	VOLCANOBADGE (Stat.SPA, Stat.SPD),
	THUNDERBADGE (Stat.SPE);
	
	
	public static final int STAT_MULTIPLIER = 11;
	public static final int DIVISOR = 10;

	private Stat[] boostedStats;
	
	private Badge(Stat... stats){
		setBoostedStats(stats);
	}

	public Stat[] getBoostedStats() {
		return boostedStats;
	}

	public void setBoostedStats(Stat[] boostedStats) {
		this.boostedStats = boostedStats;
	}
}
