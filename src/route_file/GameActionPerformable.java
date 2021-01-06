package route_file;

import player.Player;
import utility.RouteThreeStringBuffer;

public interface GameActionPerformable {
	public void performAction(Player p, RouteThreeStringBuffer outputBuffer);
}
