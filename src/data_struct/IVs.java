package data_struct;

import data.Stat;
import data.StatMode;
import data.Type;

public class IVs extends StatContainer implements Iterable<Integer> {
	
	protected class IVsException extends StatException {
		private static final long serialVersionUID = 1L;

	}
	
	
	public static final int DEFAULT_IV = 30;
	
	public static final int MIN_IV = 0;
	public static final int MAX_IV = 31;
	
	
	// Main constructor - contains the init logic
	public IVs(Integer[] statArray) throws IVsException {
		super(StatMode.POKEMON, MIN_IV, MAX_IV, statArray);
		this.validate(IVsException.class);
	}
	
	public IVs(int hp, int atk, int def, int spe, int spa, int spd) throws IVsException {
		this(new Integer[] {hp, atk, def, spe, spa, spd});	
	}

		// totally controlled, no Exceptions
	public IVs() {
		super(StatMode.POKEMON, MIN_IV, MAX_IV,
				new Integer[] {DEFAULT_IV, DEFAULT_IV, DEFAULT_IV, DEFAULT_IV, DEFAULT_IV, DEFAULT_IV}
		);

	}
	

	// Copy constructor - contains the copy logic
	public IVs(IVs ivs) {
		super(ivs);
	}
		
	
	// Overrides
	@Override
	protected void validate() throws IVsException {
		super.validate(IVsException.class);
	}
	
	
	// Utility
	public Type getHiddenPowerType() {
		// floor ((a+2b+4c+8d+16e+32f)*15/63)
		int a = this.get(Stat.HP)  & 1;
		int b = this.get(Stat.ATK) & 1;
		int c = this.get(Stat.DEF) & 1;
		int d = this.get(Stat.SPE) & 1;
		int e = this.get(Stat.SPA) & 1;
		int f = this.get(Stat.SPD) & 1;
		
		int typeIndex = (a + 2*b + 4*c + 8*d + 16*e + 32*f)*15/63 + 1;
		
		return Type.getTypeById(typeIndex);		
	}
	
	public int getHiddenPowerBasePower() {
		// floor ((u+2v+4w+8x+16y+32z)*40/63)+30
		int u = (this.get(Stat.HP)  >> 1) & 1;
		int v = (this.get(Stat.ATK) >> 1) & 1;
		int w = (this.get(Stat.DEF) >> 1) & 1;
		int x = (this.get(Stat.SPE) >> 1) & 1;
		int y = (this.get(Stat.SPA) >> 1) & 1;
		int z = (this.get(Stat.SPD) >> 1) & 1;
		
		int basePower = (u + 2*v + 4*w + 8*x + 16*y + 32*z)*40/63 + 30;
		
		return basePower;
	}
}
