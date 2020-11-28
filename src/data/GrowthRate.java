package data;

import java.util.function.IntUnaryOperator;

public enum GrowthRate {
	// see : https://github.com/pret/pokeruby/blob/f839afb24aa2c7b70e9c28a5c069aacc46993099/constants/pokemon_data_constants.inc#L27
	MEDIUM_FAST(n -> n * n * n),
	
	ERRATIC(n -> (n <= 50) ? n*n*n*(100 - n) / 50 : 
		         (n <= 68) ? n*n*n*(150 - n) / 100 : 
		         (n <= 98) ? n*n*n*((1911-10*n)/3) / 500 : 
		         n*n*n*(160 - n) / 100),
	
	FLUCTUATING(n -> (n <= 15) ? n*n*n*((n + 1)/3 + 24) / 50 :
					 (n <= 36) ? n*n*n*(n + 14)/50 :
					 n*n*n*((n/2)+32)/50),
	
	MEDIUM_SLOW(n -> 6*n*n*n/5 - 15*n*n + 100*n - 140),
	
	FAST(n -> 4*n*n*n / 5),
	
	SLOW(n -> 5*n*n*n / 4);

	
	public static final int MIN_LEVEL = 2;
	public static final int MAX_LEVEL = 100;
	
	private IntUnaryOperator experienceOperator;

	
	private GrowthRate(IntUnaryOperator operator) {
		this.experienceOperator = operator;
	}
	
	// Returns minimal experience from level
	public int getExperienceFromLevel(int level) {
		return experienceOperator.applyAsInt(level);
	}
	
	// Returns level from experience
	public int getLevelFromExperience(int exp) {
		int maxExp = getExperienceFromLevel(MAX_LEVEL);
		if(exp >= maxExp)
			return MAX_LEVEL;
		
		int minExp = getExperienceFromLevel(MIN_LEVEL);
		
		return dichotomySearch(exp, MIN_LEVEL, MAX_LEVEL, minExp, maxExp);
	}
	
	// Used for retrieving level from experience "faster"
	// Faster for L10+ compared to linear search from level 2
	private int dichotomySearch(int targetExp, int leftLevel, int rightLevel, int leftExp, int rightExp) {
		if(leftLevel == rightLevel - 1) 
			return leftLevel;
		
		int middleLevel = (leftLevel + rightLevel) / 2;
		int middleExperience = getExperienceFromLevel(middleLevel);
		
		if(targetExp >= middleExperience) {
			leftLevel = middleLevel;
			leftExp = middleExperience;
		}
		else {
			rightLevel = middleLevel;
			rightExp = middleExperience;
		}
		
		return dichotomySearch(targetExp, leftLevel, rightLevel, leftExp, rightExp);
	}
	
	public static void main(String[] args) {
		
		System.out.println(FLUCTUATING.getLevelFromExperience(1640000));
	}
	
}
