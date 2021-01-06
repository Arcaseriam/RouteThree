package route_file.configurable_actions;

import data.Species;
import player.Player;
import route_file.ArgumentNecessity;
import route_file.GameActionConfigurable;
import route_file.GameActionPerformable;
import route_file.ArgumentFormat;
import route_file.ParsableList;
import route_file.UtilityGameAction;
import utility.RouteThreeStringBuffer;

public class Evolve implements GameActionConfigurable, GameActionPerformable {
	private static final ParsableList<ArgumentFormat> args = new ParsableList<ArgumentFormat>(
		new ArgumentFormat(Integer.class, ArgumentNecessity.OPTIONAL, "partySlot", 1),
		new ArgumentFormat(Species.class, ArgumentNecessity.MANDATORY, "target")
	);
	
	private Integer partySlot;
    private Species target;
    
    @Override
    public GameActionPerformable configureWith(ParsableList<String> line) throws Exception {
    	UtilityGameAction.parseLine(this, line, args);
    	return this;
    }
    
    @Override
    public void performAction(Player p, RouteThreeStringBuffer out) {
    	p.getPokemon(partySlot).setSpecies(target);
    	p.getPokemon(partySlot).update(); //TODO : not enough ?
    }
    
    @Override
    public String toString() {
    	if(partySlot == null || target == null) 
    		return String.format("%s (uninitialised)", Evolve.class.getName());
    	return String.format("%s (%d)->%s", Evolve.class.getSimpleName(), partySlot+1, target.getName());
    }
}