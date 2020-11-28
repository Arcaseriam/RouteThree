package config;

public class Config {
	private String game;
	
	private String[] species;
	private String[] natures;
	private String[] abilities;
	private int[] levels;
	private int[] hps;
	private int[] atks;
	private int[] defs;
	private int[] spes;
	private int[] spas;
	private int[] spds;

	private String routeFilename;
	private String outputFilename;

	//TODO : more ?
	
	public Config(String game, String[] speciesArr, String[] natures, String[] abilities, int[] levels, 
			int[] hpIVs, int[] atkIVs, int[] defIVs, int[] speIVs, int[] spaIVs, int[] spdIVs, 
			String routeFilename, String outputFilename) {
		this.game = game;
		
		this.species = speciesArr;
		this.natures = natures;
		this.abilities = abilities;
		this.levels = levels;
		this.hps = hpIVs;
		this.atks = atkIVs;
		this.defs = defIVs;
		this.spes = speIVs;
		this.spas = spaIVs;
		this.spds = spdIVs;
		
		this.routeFilename = routeFilename;
		this.outputFilename = outputFilename;
	}

	public String getGame() {
		return game;
	}

	public String[] getSpeciesArr() {
		return species;
	}

	public String[] getNatures() {
		return natures;
	}

	public int[] getLevels() {
		return levels;
	}

	public int[] getHpIVs() {
		return hps;
	}

	public int[] getAtkIVs() {
		return atks;
	}

	public int[] getDefIVs() {
		return defs;
	}

	public int[] getSpeIVs() {
		return spes;
	}

	public int[] getSpaIVs() {
		return spas;
	}

	public int[] getSpdIVs() {
		return spds;
	}

	public String getRouteFilename() {
		return routeFilename;
	}

	public String getOutputFilename() {
		return outputFilename;
	}

	public String[] getAbilities() {
		return abilities;
	}

}
