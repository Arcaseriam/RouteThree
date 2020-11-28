package data;

public enum MoveFlag {
	// see : https://github.com/pret/pokeruby/blob/d63e99c418de98005eac31ba3e6c1abdd6e3ecaf/include/constants/battle.h#L290
	MAKES_CONTACT          (1 << 0),
	AFFECTED_BY_PROTECT    (1 << 1),
	AFFECTED_BY_MAGIC_COAT (1 << 2),
	AFFECTED_BY_SNATCH     (1 << 3),
	MIRROR_MOVE_COMPATIBLE (1 << 4),
	AFFECTED_BY_KINGS_ROCK (1 << 5),
	NONE                   (1 << 6); // custom
	
	private int flag;
	
	private MoveFlag(int flag) {
		this.setFlag(flag);
	}

	public int getFlag() {
		return flag;
	}

	private void setFlag(int flag) {
		this.flag = flag;
	}
}
