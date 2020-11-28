package player;

import java.util.List;

import data.Badge;
import data.Game;
import data.Item;
import data.Stat;
import data_struct.BadgeBoosts;
import data_struct.PlayerPokemon;
import utility.RouteThreeStringBuffer;

public class Player {
	private Game game;
	private Party party;
	private BadgeBoosts badgeBoosts;
	private Inventory inventory;
	private boolean hasAmuletCoin;

	public Player(Game game, Party party) {
		this.game = game;
		this.party = party;
		this.badgeBoosts = new BadgeBoosts();
		this.inventory = new Inventory();
		this.hasAmuletCoin = false;
	}
	
	// Use when the party is being built
	public Player(Game game) {
		this.game = game;
		this.badgeBoosts = new BadgeBoosts();
		this.inventory = new Inventory();
	}
	
	public void setParty(Party party) {
		this.party = party;
	}
	
	public PlayerPokemon getFrontPokemon() {
		return party.get(0);
	}
	
	// Badge boosts
	public void addBadge(Badge badge) {
		this.getBadgeBoosts().addBadge(badge);
	}
	
	public boolean hasBadgeBoost(Stat stat) {
		return badgeBoosts.hasBadgeBoost(stat);
	}
	
	public void dropBadges() {
		this.getBadgeBoosts().dropBadges();
	}
	
	// Inventory actions
	public void buyItem(Item item, int quantity) {
		inventory.buyItem(item, quantity);
	}
	
	public void sellItem(Item item, int quantity) {
		inventory.sellItem(item, quantity);
	}
	
	public void useItem(Item item, int quantity) {
		inventory.useItem(item, quantity);
	}
	
	public void tossItem(Item item, int quantity) {
		this.useItem(item, quantity);
	}
	
	public void getItem(Item item, int quantity) {
		inventory.addItem(item, quantity);
	}

	// Getters
	public Game getGame() {
		return game;
	}

	public List<PlayerPokemon> getParty() {
		return party;
	}

	public BadgeBoosts getBadgeBoosts() {
		return badgeBoosts;
	}

	public Inventory getInventory() {
		return inventory;
	}
	
	// Utility
	@Override
	public String toString() {
		RouteThreeStringBuffer sb = new RouteThreeStringBuffer();
		
		sb.appendln(String.format("Game : %s", this.game));
		sb.appendln(party.toString());
		
		return sb.toString();
	}

	public boolean hasAmuletCoin() {
		return hasAmuletCoin;
	}	
	public void setAmuletCoin(boolean hasAmuletCoin) {
		this.hasAmuletCoin = hasAmuletCoin;
	}

}
