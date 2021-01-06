package route_file.configurable_actions;

import data.Item;
import player.Player;
import route_file.ArgumentNecessity;
import route_file.GameActionConfigurable;
import route_file.GameActionPerformable;
import route_file.ArgumentFormat;
import route_file.ParsableList;
import route_file.UtilityGameAction;
import utility.RouteThreeStringBuffer;

public class Buy implements GameActionConfigurable, GameActionPerformable {
	private static final ParsableList<ArgumentFormat> args = new ParsableList<ArgumentFormat>(
		new ArgumentFormat(Integer.class, ArgumentNecessity.OPTIONAL, "quantity", 1),
		new ArgumentFormat(Item.class, ArgumentNecessity.MANDATORY, "item")
	);
	
	private int quantity;
	private Item item;
    
    @Override
    public GameActionPerformable configureWith(ParsableList<String> line) throws Exception {
    	UtilityGameAction.parseLine(this, line, args);
    	return this;
    }
    
    @Override
    public void performAction(Player p, RouteThreeStringBuffer out) {
    	p.buyItem(item, quantity);
    }
    
    @Override
    public String toString() {
    	return String.format("%s %d %s", Buy.class.getSimpleName(), this.quantity, this.item);
    }
}
