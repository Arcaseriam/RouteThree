package player;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import data.Item;
import utility.RouteThreeStringBuffer;

// Pocket voluntarily doesn't implement multiple stacks of the same item
// to keep the advantage of the lookup in O(1) 
public class Pocket {
	private LinkedHashMap<Item, Integer> items;
	
	public Pocket() {
		this.items = new LinkedHashMap<>();
	}
	
	public Integer get(Item item) {
		return items.get(item);
	}
	
	// checks in inventory
	public void addItem(Item item, int quantity) {
//		if(quantity <= 0 || item == null || item == Item.NONE)
//			return;
		
		if(!items.containsKey(item)) {
			items.put(item, quantity);
			return;
		}
		
		// Item exists, updating
		int oldCount = items.get(item);
		int newCount = Math.min(Constants.MAX_ITEM_PER_STACK, oldCount + quantity);
		
		if(newCount > oldCount)
			items.replace(item, newCount);
		
		return;
	}
	
	// checks in inventory
	public void useItem(Item item, int quantity) {
//		if(quantity <= 0 || item == null || item == Item.NONE)
//			return;
		
		if(!items.containsKey(item)) {
			return;
		}
		
		// Item exists, updating
		int oldCount = items.get(item);
		int newCount = Math.max(0, oldCount - quantity);
		
		if(newCount <= 0)
			items.remove(item);
		else
			items.replace(item, newCount);
			
		return;
	}
	
	@Override
	public String toString() {
		RouteThreeStringBuffer sb = new RouteThreeStringBuffer();
		
		for(Entry<Item,Integer> entry : this.items.entrySet()) {
			Item item = entry.getKey();
			int quantity = entry.getValue();
			sb.appendln(String.format("%3dx %s", quantity, item.toString()));
		}
		
		return sb.toString();
	}
}
