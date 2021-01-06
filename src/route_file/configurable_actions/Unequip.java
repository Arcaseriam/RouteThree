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

public class Unequip implements GameActionConfigurable, GameActionPerformable {
	private static final ParsableList<ArgumentFormat> args = new ParsableList<ArgumentFormat>(
		new ArgumentFormat(Integer.class, ArgumentNecessity.OPTIONAL, "partySlot", 1)
	);
	
	private int partySlot;
    
    @Override
    public GameActionPerformable configureWith(ParsableList<String> line) throws Exception {
    	UtilityGameAction.parseLine(this, line, args);
    	return this;
    }
    
    @Override
    public void performAction(Player p, RouteThreeStringBuffer out) {
    	p.getPokemon(partySlot).setItem(Item.NONE);
    }
    
    @Override
    public String toString() {
    	return String.format("%s (%d)", Unequip.class.getSimpleName(), partySlot+1);
    }
}
