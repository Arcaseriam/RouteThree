package route_file;

import data.Badge;
import data.Item;
import player.Player;

public abstract class GameAction implements GameActionPerformable {
	
    // candies & boosters
    public static final GameAction eatRareCandy = new GameAction() {
        public void performAction(Player p) { p.getFrontPokemon().eatRareCandy(); }
    };
    public static final GameAction eatHPUp = new GameAction() {
    	public void performAction(Player p) { p.getFrontPokemon().eatHPUp(); }
    };
    public static final GameAction eatIron = new GameAction() {
    	public void performAction(Player p) { p.getFrontPokemon().eatIron(); }
    };
    public static final GameAction eatCarbos = new GameAction() {
    	public void performAction(Player p) { p.getFrontPokemon().eatCarbos(); }
    };
    public static final GameAction eatProtein = new GameAction() {
    	public void performAction(Player p) { p.getFrontPokemon().eatProtein(); }
    };
    public static final GameAction eatCalcium = new GameAction() {
    	public void performAction(Player p) { p.getFrontPokemon().eatCalcium(); }
    };
    public static final GameAction eatZinc = new GameAction() {
    	public void performAction(Player p) { p.getFrontPokemon().eatZinc(); }
    };
    
    // badges
    public static final GameAction getStoneBadge = new GameAction() {
        public void performAction(Player p) { p.addBadge(Badge.STONEBADGE); }
    };
    public static final GameAction getBalanceBadge = new GameAction() {
        public void performAction(Player p) { p.addBadge(Badge.BALANCEBADGE); }
    };
    public static final GameAction getMindBadge = new GameAction() {
        public void performAction(Player p) { p.addBadge(Badge.MINDBADGE); }
    };
    public static final GameAction getDynamoBadge = new GameAction() {
        public void performAction(Player p) { p.addBadge(Badge.DYNAMOBADGE); }
    };
    
    public static final GameAction getBoulderBadge = new GameAction() {
        public void performAction(Player p) { p.addBadge(Badge.BOULDERBADGE); }
    };
    public static final GameAction getSoulBadge = new GameAction() {
        public void performAction(Player p) { p.addBadge(Badge.SOULBADGE); }
    };
    public static final GameAction getVolcanoBadge = new GameAction() {
        public void performAction(Player p) { p.addBadge(Badge.VOLCANOBADGE); }
    };
    public static final GameAction getThunderBadge = new GameAction() {
        public void performAction(Player p) { p.addBadge(Badge.THUNDERBADGE); }
    };
    
    // battle frontier
    public static final GameAction setBattleFrontierFlag = new GameAction() {
        public void performAction(Player p) { p.dropBadges(); }
    };
    
    // item
    public static final GameAction unequip = new GameAction() {
        public void performAction(Player p) { p.getFrontPokemon().setItem(Item.NONE); }
    };
    
    
    // amulet coin
    public static final GameAction setAmuletCoin = new GameAction() {
        public void performAction(Player p) { p.setAmuletCoin(true); }
    };
    public static final GameAction unsetAmuletCoin = new GameAction() {
        public void performAction(Player p) { p.setAmuletCoin(false); }
    };
}
