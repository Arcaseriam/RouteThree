package data;

public enum Type {
	// see : https://github.com/pret/pokeruby/blob/aeeff84462973b267e62031a945603d96afed716/include/constants/pokemon.h#L101
	NORMAL(0), FIGHTING(1), FLYING(2), POISON(3), GROUND(4), ROCK(5), BUG(6), GHOST(7), STEEL(8),
	FIRE(9), WATER(10), GRASS(11), ELECTRIC(12), PSYCHIC(13), ICE(14), DRAGON(15), DARK(16),
	MYSTERY(-2), NONE(-1); // don't count as index
	
	private int id;
	
	private Type(int id) {
		this.setId(id);
	}
	
	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}
	
	public double effectivenessAgainst(Type defType1, Type defType2) {
		return this.effectivenessAgainst(defType1) 
				* this.effectivenessAgainst(defType2);
	}
	
	public double effectivenessAgainst(Type defType) {
		if (defType == NONE || defType == MYSTERY || this == NONE || this == MYSTERY) {
            return 1;
        } else {
            int val = typeTable[this.getId()][defType.getId()];
            return (val == 5) ? 0.5 : val;
        }
	}
	
    // typeTable[i][j] is type i's effectiveness against type j, with 5
    // representing 0.5
    private static final int[][] typeTable = {
    		{1, 1, 1, 1, 1, 5, 1, 0, 5, 1, 1, 1, 1, 1, 1, 1, 1},
    		{2, 1, 5, 5, 1, 2, 5, 0, 2, 1, 1, 1, 1, 5, 2, 1, 2},
    		{1, 2, 1, 1, 1, 5, 2, 1, 5, 1, 1, 2, 5, 1, 1, 1, 1},
    		{1, 1, 1, 5, 5, 5, 1, 5, 0, 1, 1, 2, 1, 1, 1, 1, 1},
    		{1, 1, 0, 2, 1, 2, 5, 1, 2, 2, 0, 5, 2, 1, 1, 1, 1},
    		{1, 5, 2, 1, 5, 1, 2, 1, 5, 2, 1, 1, 1, 1, 2, 1, 1},
    		{1, 5, 5, 5, 1, 1, 1, 5, 5, 5, 1, 2, 1, 2, 1, 1, 2},
    		{0, 1, 1, 1, 1, 1, 1, 2, 5, 1, 1, 1, 1, 2, 1, 1, 5},
    		{1, 1, 1, 1, 1, 2, 1, 1, 5, 5, 5, 1, 5, 1, 2, 1, 1},
    		{1, 1, 1, 1, 1, 5, 2, 1, 2, 5, 5, 2, 1, 1, 2, 5, 1},
    		{1, 1, 1, 1, 2, 2, 1, 1, 1, 2, 5, 5, 1, 1, 1, 5, 1},
    		{1, 1, 5, 5, 2, 2, 5, 1, 5, 5, 2, 5, 1, 1, 1, 5, 1},
    		{1, 1, 2, 1, 0, 1, 1, 1, 1, 1, 2, 5, 5, 1, 1, 5, 1},
    		{1, 1, 2, 1, 2, 1, 1, 1, 5, 5, 5, 2, 1, 1, 5, 2, 1},
    		{1, 1, 1, 1, 1, 1, 1, 1, 5, 1, 1, 1, 1, 1, 1, 2, 1},
    		{1, 5, 1, 1, 1, 1, 1, 2, 5, 1, 1, 1, 1, 2, 1, 1, 5}
    };

    public static boolean isPhysicalType(Type type) {
        return type.getId() <= STEEL.getId(); // by side effect, since NONE is -1, the formula still holds
    }
    
    public static Type getTypeById(int id) {
    	if(id == -2)
    		return MYSTERY;
    	else if(id == -1)
    		return NONE;
    	else if(id >= 0 && id <=16)
    		return Type.values()[id];
    	else
    		throw new ArrayIndexOutOfBoundsException(id);
    }

}
