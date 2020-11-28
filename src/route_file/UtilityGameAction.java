package route_file;

import java.util.ArrayList;
import java.util.List;

import player.Player;
import utility.LookupTable;

public enum UtilityGameAction implements GameActionPerformable {
//	EVOLVE("evolve", "e"),
//	LEARN_MOVE("learnmove", "lm"),
//	UNLEARN_MOVE("unlearnmove", "um"),
//	MONEY("money"), 
//	ADD_MONEY("addmoney"),
//	SPEND_MONEY("spendmoney"),
//	BUY("buy"),
//	SELL("sell"),
	
//	RETURN_POWER("returnpower"),
//	SET_HAPPINESS("sethappiness"),
//	
//	EQUIP("equip"),

	;
	
	private static LookupTable<UtilityGameAction> aliasTable = new LookupTable<>();
	static {
		for(UtilityGameAction gameAction : UtilityGameAction.values()) {
			for(Alias alias : gameAction.getAliases()) {
				aliasTable.put(alias, gameAction);
			}
		}
	}	
	public static UtilityGameAction getGameActionByString(String str) {
		return aliasTable.get(str); 
	}
	
	
	private GameActionPerformable performMethod;
	private List<Alias> aliases;
	
	private UtilityGameAction(GameActionPerformable performMethod, String... aliasesArr) {
		this.setPerformMethod(performMethod);
		this.setAliases(aliasesArr);
	}
	
	private List<Alias> getAliases() {
		return aliases;
	}
	
	private void setAliases(String... aliasesArr) {
		this.aliases = new ArrayList<Alias>(aliasesArr.length);
		for(String alias : aliasesArr) {
			this.aliases.add(new Alias(alias));
		}
	}

	public GameActionPerformable getPerformMethod() {
		return performMethod;
	}

	private void setPerformMethod(GameActionPerformable performMethod) {
		this.performMethod = performMethod;
	}

	@Override
	public void performAction(Player p) {
		performMethod.performAction(p);
	}

}
