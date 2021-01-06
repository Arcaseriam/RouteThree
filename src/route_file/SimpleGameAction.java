package route_file;

import java.util.ArrayList;
import java.util.List;

import player.Player;
import utility.Alias;
import utility.LookupTable;
import utility.RouteThreeStringBuffer;

// These are commands that don't accept any options
public enum SimpleGameAction implements GameActionPerformable {
	RARE_CANDY(GameAction.eatRareCandy, "rarecandy", "rc"),
	HP_UP     (GameAction.eatHPUp     , "hpup"),
	PROTEIN   (GameAction.eatProtein  , "protein"),
	IRON      (GameAction.eatIron     , "iron"),
	CALCIUM   (GameAction.eatCalcium  , "calcium"),
	ZINC      (GameAction.eatZinc     , "zinc"),
	CARBOS    (GameAction.eatCarbos   , "carbos"),
	
	STONEBADGE(GameAction.getStoneBadge, "stonebadge"),
	BALANCEBADGE(GameAction.getBalanceBadge, "balancebadge"),
	MINDBADGE(GameAction.getMindBadge, "mindbadge"),
	DYNAMOBADGE(GameAction.getDynamoBadge, "dynamobadge"),
	
	BOULDERBADGE(GameAction.getBoulderBadge, "boulderbadge"),
	SOULBADGE(GameAction.getSoulBadge, "soulbadge"),
	VOLCANOBADGE(GameAction.getVolcanoBadge, "volcanobadge"),
	THUNDERBADGE(GameAction.getThunderBadge, "thunderbadge"),
	
	BATTLE_FRONTIER_FLAG(GameAction.setBattleFrontierFlag, "battlefrontierflag"),

	SET_AMULET_COIN(GameAction.setAmuletCoin, "setamuletcoin"),
	UNSET_AMULET_COIN(GameAction.unsetAmuletCoin, "unsetamuletcoin"),
	
	MONEY(GameAction.money, "money"),
	INVENTORY(GameAction.inventory, "inventory", "bag"),
	
	PARTY(GameAction.party, "party", "displayparty");

//	STATS(GameAction.stats, "stats"),
//	RANGES(GameAction.ranges, "ranges");
	
	private static LookupTable<SimpleGameAction> aliasTable = new LookupTable<>();
	static {
		for(SimpleGameAction gameAction : SimpleGameAction.values()) {
			for(Alias alias : gameAction.getAliases()) {
				aliasTable.put(alias, gameAction);
			}
		}
	}
	private static SimpleGameAction getGameActionByString(String str) {
		return aliasTable.get(str); 
	}
	
	public static SimpleGameAction getGameActionFromLine(ParsableList<String> line) {
		return getGameActionByString(line.peek());
	}
	
	
	private GameActionPerformable performMethod;
	private List<Alias> aliases;
	
	private SimpleGameAction(GameActionPerformable performMethod, String... aliasesArr) {
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
	public void performAction(Player p, RouteThreeStringBuffer out) {
		performMethod.performAction(p, out);
	}
}
