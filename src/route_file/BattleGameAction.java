package route_file;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import player.Player;

public enum BattleGameAction implements GameActionPerformable {
	// the last enum can be left blank, and will be considered the default
	WILD_ENCOUNTER_BATTLE("^L(100|[1-9]\\d?)"),
	TRAINER_BATTLE("");//("(0x[0-9A-F]+|[A-KM-Za-km-z][\\dA-Za-z]*)"),
	
	private Pattern regexPattern;
	
	private BattleGameAction(String regex) {
		this.setRegexPattern(regex);
	}

	public Pattern getRegexPattern() {
		return regexPattern;
	}

	private void setRegexPattern(String regex) {
		this.regexPattern = Pattern.compile(regex);
	}
	
	public static BattleGameAction getGameActionByName(String str) {
		Matcher matcher;
		for(int i = 0; i < BattleGameAction.values().length - 2; i++) {
			BattleGameAction rga = BattleGameAction.values()[i];
			matcher = rga.regexPattern.matcher(str);
			if(matcher.find())
				return //idk tbh
		}
	}

	@Override
	public void performAction(Player p) {
		// TODO Auto-generated method stub
		
	}
}
