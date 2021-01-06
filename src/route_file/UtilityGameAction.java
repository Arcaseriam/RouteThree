package route_file;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

import data.Item;
import data.Move;
import data.Species;
import player.Player;
import route_file.configurable_actions.*;
import utility.Alias;
import utility.LookupTable;

public enum UtilityGameAction implements GameActionConfigurable {
//	LEARN_MOVE("learnmove", "lm"),
//	UNLEARN_MOVE("unlearnmove", "um"),
//	ADD_MONEY("addmoney"),
	
//	RETURN_POWER("returnpower"),
//	SET_HAPPINESS("sethappiness"),
//	

	EVOLVE(Evolve.class, "evolve", "e"),
	
	BUY(Buy.class, "buy"),
	SELL(Sell.class, "sell"),
	ADD_MONEY(AddMoney.class, "addmoney"),
	SPEND_MONEY(SpendMoney.class, "spendmoney"),

	EQUIP(Equip.class, "equip"),
	UNEQUIP(Unequip.class, "unequip");
	
	private static LookupTable<UtilityGameAction> aliasTable = new LookupTable<>();
	static {
		for(UtilityGameAction gameAction : UtilityGameAction.values()) {
			for(Alias alias : gameAction.getAliases()) {
				aliasTable.put(alias, gameAction);
			}
		}
	}	
	private static UtilityGameAction getGameActionByString(String str) {
		return aliasTable.get(str); 
	}
	
	public static GameActionPerformable getGameActionFromLine(ParsableList<String> line) throws Exception {
		// Check if the action is valid.
		String str = line.peek();
		UtilityGameAction action = getGameActionByString(str);
		if(action == null)
			return null;
	
		// Action was found, we consume it.
		line.poll();
		GameActionPerformable gameAction = action.configureWith(line);
		return gameAction;
	}
	
	
	private Class<? extends GameActionConfigurable> actionClass;
	private List<Alias> aliases;
	
	private UtilityGameAction(Class<? extends GameActionConfigurable> actionClass, String... aliasesArr) {
		this.setActionClass(actionClass);
		this.setAliases(aliasesArr);
	}
	
	private List<Alias> getAliases() {
		return aliases;
	}
	
	private void setAliases(String... aliasesArr) {
		this.aliases = new ArrayList<Alias>(aliasesArr.length);
		for(String alias : aliasesArr) {
			this.aliases.add(new Alias(alias));
		}
	}

	public Class<? extends GameActionConfigurable> getActionClass() {
		return this.actionClass;
	}

	private void setActionClass(Class<? extends GameActionConfigurable> actionClass) {
		this.actionClass = actionClass;
	}

	@Override
	public GameActionPerformable configureWith(ParsableList<String> line) throws Exception {
		GameActionConfigurable configurableAction = null;
		GameActionPerformable performableAction = null;
		try {
			configurableAction = this.getActionClass().newInstance();
			performableAction = configurableAction.configureWith(line);
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return performableAction;
	}
	
	
	/* *********/
	/* UTILITY */
	/* ******* */
	
	private static final HashMap<Class<?>, Function<String, Object>> parseMethodsLookupTable;
	static {
		parseMethodsLookupTable = new HashMap<>();
		parseMethodsLookupTable.put(Integer.class, Integer::parseInt);
		parseMethodsLookupTable.put(Species.class, Species::getSpeciesFromString);
		parseMethodsLookupTable.put(Item.class, Item::getItemFromString);
		parseMethodsLookupTable.put(Move.class, Move::getMoveFromString);
	}
	
	public static void parseLine(GameActionConfigurable action, ParsableList<String> line, ParsableList<ArgumentFormat> expectedArgs) 
				throws NoSuchFieldException, IllegalAccessException, Exception {
	while(true) {
		// Poll expected argument, return if none are to be expected anymore
		ArgumentFormat expectedArg = expectedArgs.poll();
		if(expectedArg == null)
			return;
		
		// Extract the expected argument class
		Class<?> cls = expectedArg.getArgClass();
		
		// Determine the parsing function based on the expected argument class
		Function<String, Object> parseMethod = parseMethodsLookupTable.get(cls);
		
		// Parse the next String argument and consume it if it's correctly parsed
		String lineArg = line.peek();
		boolean shouldBeConsumed = applyParseToAction(action, parseMethod, lineArg, expectedArg);
		if(shouldBeConsumed)
			line.poll();
		}
	}

	/***
	* Modifies a field within the Action from a String to be parsed, or from the default value if the type is optional and the parsing fails.
	* @param action The action which field is to be modified.
	* @param parseMethod The method to parse the String input.
	* @param lineArg The String input to be parsed into the action field.
	* @param argFormat The format for the String to be recognized.
	* @return true if the argument must be consumed, ie is correctly parsed.
	* @throws Exception If the parsing happens to fail when the type is mandatory.
	*/
	private static boolean applyParseToAction(GameActionConfigurable action, Function<String, Object> parseMethod, 
			String lineArg, ArgumentFormat argFormat) 
					throws Exception {
		boolean shouldBeConsumed = false;
		
		// Extract argument format
		ArgumentNecessity argType = argFormat.getType();
		String fieldName = argFormat.getFieldName();
		Object defaultValue = argFormat.getDefaultValue();
	
		// Get action field to be modified
		Class<? extends GameActionConfigurable> actionClass = action.getClass();
		Field field = actionClass.getDeclaredField(fieldName);
		field.setAccessible(true); // required for private fields
		
		// Apply the parsing
		Object convertedLineArg;
		try {
			convertedLineArg = parseMethod.apply(lineArg);
			field.set(action,convertedLineArg);
			shouldBeConsumed = true;
		} catch(Exception e) {
			switch(argType) {
			case MANDATORY: // For a mandatory argument missing or of the wrong format, propagate the exception.
				throw e;
			case OPTIONAL: //  For a optional argument, set the field to the default value
			default:
	   		field.set(action, defaultValue);
			}
		}
		
		return shouldBeConsumed;
	}
}
