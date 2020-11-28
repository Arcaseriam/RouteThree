package data;

public enum MoveTarget {
	SELECTED_POKEMON (0),
	SPECIAL          (1 << 0),
	UNK2             (1 << 1),
	RANDOM           (1 << 2),
	BOTH_ENEMIES     (1 << 3),
	USER             (1 << 4),
	ALL_EXCEPT_USER  (1 << 5),
	ENEMY_SIDE       (1 << 6);
	
	private int flag;
	
	private MoveTarget(int flag) {
		this.setFlag(flag);
	}

	public int getFlag() {
		return flag;
	}

	private void setFlag(int flag) {
		this.flag = flag;
	}
}
