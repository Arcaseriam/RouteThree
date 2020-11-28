package battle;

import java.util.ArrayList;
import java.util.List;

import utility.LookupTable;

public enum BattleOption {
	ALL_ITEMS(OptionType.PLAYER_OPPONENT, "items"), // 1, 1, 
		
    ATTACK         (OptionType.PLAYER_OPPONENT, "attack"        , "atk"),
    DEFENSE        (OptionType.PLAYER_OPPONENT, "defense"       , "def"),
    SPEED          (OptionType.PLAYER_OPPONENT, "speed"         , "spe"),
    SPECIAL_ATTACK (OptionType.PLAYER_OPPONENT, "specialattack" , "spa"),
    SPECIAL_DEFENSE(OptionType.PLAYER_OPPONENT, "specialdefense", "spd"),
    ACCURACY       (OptionType.PLAYER_OPPONENT, "accuracy"      , "acc"),
    EVASION        (OptionType.PLAYER_OPPONENT, "evasion"       , "eva"),
    
    ATTACK_MULTIPLE         (OptionType.PLAYER_OPPONENT, "attacks"        , "atks"),
    DEFENSE_MULTIPLE        (OptionType.PLAYER_OPPONENT, "defenses"       , "defs"),
    SPEED_MULTIPLE          (OptionType.PLAYER_OPPONENT, "speeds"         , "spes"), 
    SPECIAL_ATTACK_MULTIPLE (OptionType.PLAYER_OPPONENT, "specialattacks" , "spas"), 
    SPECIAL_DEFENSE_MULTIPLE(OptionType.PLAYER_OPPONENT, "specialdefenses", "spds"),
    ACCURACY_MULTIPLE       (OptionType.PLAYER_OPPONENT, "accuracies"     , "accs"),
    EVASION_MULTIPLE        (OptionType.PLAYER_OPPONENT, "evasions"       , "evas"),
    
    REFLECT(OptionType.PLAYER_OPPONENT, "reflect", "r"),
    LIGHTSCREEN(OptionType.PLAYER_OPPONENT, "lightscreen", "ls"),
    
    REFLECT_MULTIPLE(OptionType.PLAYER_OPPONENT, "reflects", "rs"),
    LIGHTSCREEN_MULTIPLE(OptionType.PLAYER_OPPONENT, "lightscreens", "lss"),
    
    SHARED_EXPERIENCE(OptionType.PLAYER_ONLY, "sharedexperience", "sxp"),
    SHARED_EXPERIENCE_MULTIPLE(OptionType.PLAYER_ONLY, "sharedexperiences", "sxps"),
    
    ORDER(OptionType.OPPONENT_ONLY, "order", "o"),
    
    WEATHER(OptionType.COMMON, "weather", "w"),
    VERBOSE(OptionType.COMMON, "verbose", "v");
	
	
	public static final String PLAYER_PREFIX = "-x";
	public static final String OPPONENT_PREFIX = "-y";
	public static final String COMMON_PREFIX = "";
	private static LookupTable<BattleOption> playerOptionTable = new LookupTable<>();
	private static LookupTable<BattleOption> opponentOptionTable = new LookupTable<>();
	private static LookupTable<BattleOption> commonOptionTable = new LookupTable<>();
	private static List<LookupTable<BattleOption>> tableList = new ArrayList<>();
	static {
		tableList.add(playerOptionTable);
		tableList.add(opponentOptionTable);
		tableList.add(commonOptionTable);
		
		for(BattleOption battleOption : BattleOption.values()) {
			OptionType optionType = battleOption.optionType;
			for(String option : battleOption.options) {
				switch(optionType) {
				case PLAYER_OPPONENT:
					playerOptionTable.put(PLAYER_PREFIX+option, battleOption);
					opponentOptionTable.put(OPPONENT_PREFIX+option, battleOption);
					break;
				case PLAYER_ONLY:
					playerOptionTable.put(PLAYER_PREFIX+option, battleOption);
					break;
				case OPPONENT_ONLY:
					opponentOptionTable.put(OPPONENT_PREFIX+option, battleOption);
					break;
				case COMMON:
					commonOptionTable.put(COMMON_PREFIX+option, battleOption);
					break;
				}
			}
		}
	}
	
	public static BattleOption getBattleOptionFromString(String string) {
		BattleOption battleOption = null;
		
		for(LookupTable<BattleOption> map : tableList) {
			battleOption = map.get(string);
			
			if(battleOption != null)
				return battleOption;
		}
		
		return battleOption;
	}
	
	
	private OptionType optionType;
	private String[] options;
	
	private BattleOption(OptionType optionType, String... options) {
		this.optionType = optionType;
		this.options = options;
	}
	
	
	private enum OptionType {
		PLAYER_OPPONENT,
		PLAYER_ONLY,
		OPPONENT_ONLY,
		COMMON;
	}
}
