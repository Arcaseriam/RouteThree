package data;

public enum GenderRatio {
	MALE        (0),
	FEMALE_12_5 (31),
	FEMALE_25   (63),
	FEMALE_50   (127),
	FEMALE_75   (191),
	FEMALE      (254),
	GENDERLESS  (255);
	
	private int value;
	
	private GenderRatio(int value) {
		this.setValue(value);
	}

	public int getValue() {
		return value;
	}

	private void setValue(int value) {
		this.value = value;
	}
	
}
