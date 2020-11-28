package data_struct;
import battle.BattleOptions;
import battle.Battleable;
import data.Ability;
import data.Game;
import data.Item;
import data.Nature;
import data.Species;
import data_struct.Stats.StatsException;

// This class implements a Pokémon without EVs.
// This is enough for vanilla RSE/FRLG battles, aside from Battle Tower.
// This class will probably not be instantiated, in order for the tool
//   to be usable will custom ROMs and Battle Tower by default,
//   without having to change the instantiated objects.
public class Pokemon implements Battleable {
	
	public static final Species DEFAULT_SPECIES = Species.BULBASAUR;
	public static final int DEFAULT_LEVEL = 5;
	public static final int MIN_LEVEL = 1;
	public static final int MAX_LEVEL = 100;
	public static final Nature DEFAULT_NATURE = Nature.HARDY;
	public static final boolean DEFAULT_ISNOTWILD = false;
	public static final Item DEFAULT_ITEM = Item.NONE; 

	private Species species;
    private Nature nature;
    private Ability ability;
    private int level;
    private Stats stats;
    private IVs ivs;
    private Moveset moves;
    private Boolean isWild;
    private Item item;
    
    public Pokemon(Game game, Species species, Nature nature, Ability ability, int level, IVs ivs, 
    		Moveset moves, Boolean isWild, Item item, boolean isDelayStatCalculation) {
    	// all setters handle default cases, if objects are null or out of ranges
    	// stats shouldn't be set, but calculated
    	this.setSpecies(species);
    	this.setNature(nature);
    	this.setAbility(ability);
    	this.setLevel(level);
    	this.setIvs(ivs);
    	this.setMoves(moves, game);
    	this.setWild(isWild);
    	this.setItem(item);
    	
    	if(!isDelayStatCalculation)
    		this.calculateStats();
    }
    
    public Pokemon(Game game, Species species, Nature nature, Ability ability, int level, IVs ivs) {
    	this(game, species, nature, ability, level, ivs, 
    			null, null, null, true);
    }
    
    ///TODO : not a copy constructor, used as a wrapper for subclasses
    // This doesn't calculate stats, as it's called by subclasses which implement EVs.
    public Pokemon(Game game, Pokemon pokemon) {
    	this(game, pokemon.species, pokemon.nature, pokemon.ability, pokemon.level, pokemon.ivs, 
    			pokemon.moves, pokemon.isWild, pokemon.item, true);
    }
    

	@Override
	public void battle(PlayerPokemon p, BattleOptions options) {
		// TODO Auto-generated method stub
		
	}

    
    public int getExperience() {
    	return getExperience(1);
    }
    
    /* TODO
    public int getExperience(int participants) {
    	return getExperience(participants, false, false);
    }
    */
    
    public int getExperience(int participants) { //, boolean isBoosted, boolean isLuckyEgg) {
    	int exp = getSpecies().getExpYield() * getLevel() / 7;
    	
    	if(!isWild())
    		exp = exp * 3 / 2;
    	
    	/* TODO
    	if(isBoosted)
    		exp *= 2;
    	
    	if(isLuckyEgg)
    		exp *= 3 / 2;
    	*/
    	
    	return exp / participants;
    }
    
	protected void calculateStats() {
		try {
			Stats stats = Stats.calculateStats(getLevel(), new Stats(getSpecies().getBaseStats()), getIvs(), getNature());
			this.setStats(stats);
		} catch (StatsException e) {
			// Species enum base stats error
			e.printStackTrace();
		}
	}

	public Species getSpecies() {
		return species;
	}

	public void setSpecies(Species species) {
		if(species == null)
			species = DEFAULT_SPECIES;
		this.species = species;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		if(level < MIN_LEVEL || level > MAX_LEVEL)
			level = DEFAULT_LEVEL;
		this.level = level;
	}

	public StatContainer getStats() {
		return stats;
	}

	
	protected void setStats(Stats stats) {
		this.stats = stats;
	}
	

	public IVs getIvs() {
		return ivs;
	}

	public void setIvs(IVs ivs) {
		if(ivs == null)
			ivs = new IVs();
		this.ivs = ivs;
	}

	public Moveset getMoves() {
		return moves;
	}

	public void setMoves(Moveset moves, Game game) {
		if(moves == null)
			moves = Moveset.defaultMoveset(species, level, game);
		this.moves = moves;
	}

	public boolean isWild() {
		return isWild;
	}

	public void setWild(Boolean isWild) {
		if(isWild == null)
			isWild = DEFAULT_ISNOTWILD;
		this.isWild = isWild;
	}

	public Nature getNature() {
		return nature;
	}

	public void setNature(Nature nature) {
		if(nature == null)
			nature = DEFAULT_NATURE;
		this.nature = nature;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		if(item == null)
			item = DEFAULT_ITEM;
		this.item = item;
	}

	public Ability getAbility() {
		return ability;
	}

	public void setAbility(Ability ability) {
		if(ability == null)
			ability = getSpecies().getAbility1();
		this.ability = ability;
	}
	
	// Utility
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		/*
		private Species species;
	    private Nature nature;
	    private Ability ability;
	    private int level;
	    private Stats stats;
	    private IVs ivs;
	    private Moveset moves;
	    private Boolean isWild;
	    private Item item;
		*/
		
		sb.append(this.species.getName());
		sb.append(" ");
		sb.append(this.nature.name());
		sb.append(" ");
		sb.append(this.ability.name());
		sb.append(" L");
		sb.append(this.level);
		sb.append(" Stats:");
		sb.append(this.stats.toString());
		sb.append(" IVs:");
		sb.append(this.ivs.toString());		
		sb.append(" Moves:");
		sb.append(this.moves.toString());
		sb.append(" Item:");
		sb.append(this.item.getDisplayName());
		
		return sb.toString();
	}
}
