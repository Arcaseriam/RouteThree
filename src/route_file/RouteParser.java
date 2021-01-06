package route_file;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class RouteParser {
	public static final Charset CHARSET = StandardCharsets.UTF_8;
	public static final String SPLIT_SEPARATOR = " ";
	public static final String COMMENT_SEPARATOR = "//";
	
	public static List<GameActionPerformable> parseRouteFile(String filename) {
		List<GameActionPerformable> actionList = new ArrayList<>();
		
		Path path = FileSystems.getDefault().getPath(filename);
		try(BufferedReader reader = Files.newBufferedReader(path, CHARSET)){
			String line = null;
			while ((line = reader.readLine()) != null) {
				actionList.add(parseLine(line));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return actionList;
	}
	
	private static GameActionPerformable parseLine(String line) throws Exception {
		// Getting rid of comments, either full line or at the end of the line
		String[] splits = line.split(COMMENT_SEPARATOR);
		String commandStr = splits[0];
		if(commandStr.length() <= 0) {
			return null;
		}
		
		ParsableList<String> parsableLine = new ParsableList<>(commandStr.split(SPLIT_SEPARATOR));
		
		GameActionPerformable performable = null;

		// Checking for a simple action
		performable = SimpleGameAction.getGameActionFromLine(parsableLine);
		
		if(performable != null)
			return performable;

		// Checking for a utility action
		performable = UtilityGameAction.getGameActionFromLine(parsableLine);
		
		if(performable != null)
			return performable;
		
		/*
		// Finally, we have a battle action
		performable = BattleGameAction.getGameActionFromLine(parsableLine);
		*/
		
		return performable;
	}
}
