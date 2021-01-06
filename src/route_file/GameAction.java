package route_file;

import java.util.List;

import data.Badge;
import data.Item;
import data.Species;
import player.Player;
import utility.RouteThreeStringBuffer;

public abstract class GameAction implements GameActionPerformable {
	
    // candies & boosters
    public static final GameAction eatRareCandy = new GameAction() {
        public void performAction(Player p, RouteThreeStringBuffer out) { p.getFrontPokemon().eatRareCandy(); }
    };
    public static final GameAction eatHPUp = new GameAction() {
    	public void performAction(Player p, RouteThreeStringBuffer out) { p.getFrontPokemon().eatHPUp(); }
    };
    public static final GameAction eatIron = new GameAction() {
    	public void performAction(Player p, RouteThreeStringBuffer out) { p.getFrontPokemon().eatIron(); }
    };
    public static final GameAction eatCarbos = new GameAction() {
    	public void performAction(Player p, RouteThreeStringBuffer out) { p.getFrontPokemon().eatCarbos(); }
    };
    public static final GameAction eatProtein = new GameAction() {
    	public void performAction(Player p, RouteThreeStringBuffer out) { p.getFrontPokemon().eatProtein(); }
    };
    public static final GameAction eatCalcium = new GameAction() {
    	public void performAction(Player p, RouteThreeStringBuffer out) { p.getFrontPokemon().eatCalcium(); }
    };
    public static final GameAction eatZinc = new GameAction() {
    	public void performAction(Player p, RouteThreeStringBuffer out) { p.getFrontPokemon().eatZinc(); }
    };
    
    // badges
    public static final GameAction getStoneBadge = new GameAction() {
        public void performAction(Player p, RouteThreeStringBuffer out) { p.addBadge(Badge.STONEBADGE); }
    };
    public static final GameAction getBalanceBadge = new GameAction() {
        public void performAction(Player p, RouteThreeStringBuffer out) { p.addBadge(Badge.BALANCEBADGE); }
    };
    public static final GameAction getMindBadge = new GameAction() {
        public void performAction(Player p, RouteThreeStringBuffer out) { p.addBadge(Badge.MINDBADGE); }
    };
    public static final GameAction getDynamoBadge = new GameAction() {
        public void performAction(Player p, RouteThreeStringBuffer out) { p.addBadge(Badge.DYNAMOBADGE); }
    };
    
    public static final GameAction getBoulderBadge = new GameAction() {
        public void performAction(Player p, RouteThreeStringBuffer out) { p.addBadge(Badge.BOULDERBADGE); }
    };
    public static final GameAction getSoulBadge = new GameAction() {
        public void performAction(Player p, RouteThreeStringBuffer out) { p.addBadge(Badge.SOULBADGE); }
    };
    public static final GameAction getVolcanoBadge = new GameAction() {
        public void performAction(Player p, RouteThreeStringBuffer out) { p.addBadge(Badge.VOLCANOBADGE); }
    };
    public static final GameAction getThunderBadge = new GameAction() {
        public void performAction(Player p, RouteThreeStringBuffer out) { p.addBadge(Badge.THUNDERBADGE); }
    };
    
    // battle frontier
    public static final GameAction setBattleFrontierFlag = new GameAction() {
        public void performAction(Player p, RouteThreeStringBuffer out) { p.dropBadges(); }
    };
    
    // money
    public static final GameAction money = new GameAction() {
        public void performAction(Player p, RouteThreeStringBuffer out) { out.appendln(p.getInventory().getMoneyString()); }
    };
    
    // inventory
    public static final GameAction inventory = new GameAction() {
        public void performAction(Player p, RouteThreeStringBuffer out) { out.appendln(p.getInventory().toString()); }
    };
    
    
    // amulet coin
    public static final GameAction setAmuletCoin = new GameAction() {
        public void performAction(Player p, RouteThreeStringBuffer out) { p.setAmuletCoin(true); }
    };
    public static final GameAction unsetAmuletCoin = new GameAction() {
        public void performAction(Player p, RouteThreeStringBuffer out) { p.setAmuletCoin(false); }
    };
    
    // display
    public static final GameAction party = new GameAction() {
        public void performAction(Player p, RouteThreeStringBuffer out) { out.appendln(p.getParty().toString()); }
    };
    
}