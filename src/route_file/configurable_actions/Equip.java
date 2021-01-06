package route_file.configurable_actions;

import data.Item;
import player.Player;
import route_file.ArgumentFormat;
import route_file.ArgumentNecessity;
import route_file.GameActionConfigurable;
import route_file.GameActionPerformable;
import route_file.ParsableList;
import route_file.UtilityGameAction;
import utility.RouteThreeStringBuffer;

public class Equip implements GameActionConfigurable, GameActionPerformable {
	private static final ParsableList<ArgumentFormat> args = new ParsableList<ArgumentFormat>(
		new ArgumentFormat(Item.class, ArgumentNecessity.MANDATORY, "item"), 
		new ArgumentFormat(Integer.class, ArgumentNecessity.OPTIONAL, "partySlot", 1)
	);
	
    private Item item;
	private Integer partySlot;
    
    @Override
    public GameActionPerformable configureWith(ParsableList<String> line) throws Exception {
    	UtilityGameAction.parseLine(this, line, args);
    	return this;
    }
    
    @Override
    public void performAction(Player p, RouteThreeStringBuffer out) {
    	p.getPokemon(partySlot).setItem(item);
    }
    
    @Override
    public String toString() {
    	if(partySlot == null || item == null) 
    		return String.format("%s (uninitialised)", Evolve.class.getName());
    	return String.format("%s (%d)->%s", Equip.class.getSimpleName(), partySlot+1, item);
    }
}