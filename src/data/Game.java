package data;

import utility.LookupTable;

public enum Game {
	RUBY     ("RUBY"), 
	SAPPHIRE ("SAPPHIRE"), 
	EMERALD  ("EMERALD"), 
	FIRERED  ("FIRERED"), 
	LEAFGREEN("LEAFGREEN");
	
	public static LookupTable<Game> gameTable = new LookupTable<>();
	static {
		for(Game game : Game.values()) {
			gameTable.put(game.getName(), game);
		}
	}
	
	public static Game getGameFromString(String gameStr) {
		return gameTable.get(gameStr);
	}
	
	
	private String name;
	
	private Game(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
