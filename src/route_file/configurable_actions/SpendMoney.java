package route_file.configurable_actions;

import player.Player;
import route_file.ArgumentNecessity;
import route_file.GameActionConfigurable;
import route_file.GameActionPerformable;
import route_file.ArgumentFormat;
import route_file.ParsableList;
import route_file.UtilityGameAction;
import utility.RouteThreeStringBuffer;

public class SpendMoney implements GameActionConfigurable, GameActionPerformable {
	private static final ParsableList<ArgumentFormat> args = new ParsableList<ArgumentFormat>(
		new ArgumentFormat(Integer.class, ArgumentNecessity.MANDATORY, "money")
	);
	
	private int money;
	
    @Override
    public GameActionPerformable configureWith(ParsableList<String> line) throws Exception{
    	UtilityGameAction.parseLine(this, line, args);
    	return this;
    }
    
    @Override
    public void performAction(Player p, RouteThreeStringBuffer out) {
    	p.spendMoney(this.money);
    }
    
    @Override
    public String toString() {
    	return String.format("%s %d", SpendMoney.class.getSimpleName(), this.money);
    }
}
