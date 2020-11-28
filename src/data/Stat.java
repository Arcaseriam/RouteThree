package data;

public enum Stat {
	HP, ATK, DEF, SPE, SPA, SPD, ACC, EVA, 
	NONE;
	
	public int getId() {
		return this.ordinal();
	}
}
