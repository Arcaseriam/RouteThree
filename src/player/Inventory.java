package player;

import java.util.EnumMap;

import data.Item;
import data.PocketType;

public class Inventory {
	private int money;
	private EnumMap<PocketType, Pocket> pockets;
	
	public Inventory() {
		this.money = Constants.MONEY_START;
		
		pockets = new EnumMap<PocketType, Pocket>(PocketType.class);
		for(PocketType pocketType : PocketType.values()) {
			pockets.put(pocketType, new Pocket());
		}
	}

	public int getMoney() {
		return money;
	}
	
	public void addMoney(int money) {
		if(money <= 0)
			return;
		
		int newMoney = Math.min(Constants.MAX_MONEY, this.money + money);	
		this.money = newMoney;
	}
	
	public void subtractMoney(int money) {
		if(money <= 0)
			return;
		
		int newMoney = Math.max(0, this.money - money);	
		this.money = newMoney;
	}
	
	public void addItem(Item item, int quantity) {
		if(quantity <= 0 || item == null || item == Item.NONE)
			return;
		
		Pocket pocket = pockets.get(item.getPocketType());
		pocket.addItem(item, quantity);
	}
	
	public void useItem(Item item, int quantity) {
		if(quantity <= 0 || item == null || item == Item.NONE)
			return;
		
		Pocket pocket = pockets.get(item.getPocketType());
		pocket.useItem(item, quantity);
	}
	
	public void buyItem(Item item, int quantity)
	{
		this.addItem(item, quantity);
		this.subtractMoney(quantity * item.getCost());
	}
	
	public void sellItem(Item item, int quantity) {
		this.useItem(item, quantity);
		this.addMoney(quantity * (item.getCost() / 2));
	}
}
