package player;

import java.util.ArrayList;

import data_struct.PlayerPokemon;
import utility.RouteThreeStringBuffer;

public class Party extends ArrayList<PlayerPokemon> {
	private static final long serialVersionUID = 1L;
	
	@Override
	public String toString() {
		RouteThreeStringBuffer sb = new RouteThreeStringBuffer();
		
		sb.appendln("Party : ");
		for(int i = 0; i < this.size(); i++) {
			PlayerPokemon pokemon = this.get(i);
			sb.appendln(String.format("%d) %s", i+1, pokemon.toString()));
		}
		
		return sb.toString();
	}
}
